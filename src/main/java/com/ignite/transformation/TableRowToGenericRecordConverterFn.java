package com.ignite.transformation;

import com.equifax.fabric.commons.avro.SchemaUtils;
import com.google.api.services.bigquery.model.TableRow;
import org.apache.avro.Conversions;
import org.apache.avro.LogicalType;
import org.apache.avro.LogicalTypes;
import org.apache.avro.Schema;
import org.apache.avro.data.TimeConversions;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.beam.sdk.transforms.DoFn;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static com.ignite.common.Constants.*;


/**
 * Convert TableRow to GenericRecord
 * Based on the Avro Schema
 */
public class TableRowToGenericRecordConverterFn extends DoFn<TableRow, GenericRecord> {

    Schema schema;
    //private static final Logger LOGGER = LogManager.getLogger(TableRowToGenericRecordConverterFn.class);


    /**
     * Constructor RowToTableRowConverterFn
     */
    public TableRowToGenericRecordConverterFn(Schema schema) {

        this.schema = schema;
    }

    public static GenericRecord rowToGenericrecordFieldType(TableRow tablerow, Schema avroSchema){
        String fieldType;
        Schema digestSourceFieldSchema;
        GenericRecord record = new GenericData.Record(avroSchema);
        for (Schema.Field field : avroSchema.getFields()) {

            if (Schema.Type.UNION==field.schema().getType()){
                digestSourceFieldSchema = SchemaUtils.getNonNullSchema(field.schema());
                if (Objects.equals(digestSourceFieldSchema.getLogicalType(),null))
                {
                    fieldType = digestSourceFieldSchema.getType().getName();

                }
                else
                {
                    fieldType = digestSourceFieldSchema.getLogicalType().getName();

                }
            }else {
                digestSourceFieldSchema = field.schema();
                if (Objects.equals(field.schema().getLogicalType(),null))
                {
                    fieldType = field.schema().getType().getName();

                }
                else
                {
                    fieldType = field.schema().getLogicalType().getName();

                }
            }
            Object castedFieldValue = getCastedParam(tablerow.get(field.name()),fieldType,digestSourceFieldSchema);

            record.put(field.name(),castedFieldValue);
        }
        //LOGGER.error("Record Value "+record);
        return record;
    }
    /**
     * Convert Row to TableRow
     * Beam sql transformation make use and return row object
     * Convert Row object to TableRow for apply transformation
     *
     * @param tableRow       tableRow
     * @param outputReceiver outputReceiver
     */
    @ProcessElement
    public void processElement(@Element TableRow tableRow, OutputReceiver<GenericRecord> outputReceiver) throws
            ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {
    try {

        //LOGGER.error("Line---------------"+tableRow.toString());

        GenericRecord genericRecord = rowToGenericrecordFieldType(tableRow,schema);
        outputReceiver.output(genericRecord);
    }catch (Exception e){
       // LOGGER.error("Error:", e);
        throw new IgniteTransformationException("Exception",e);
    }
    }


    public static Object getCastedParam(Object originalValue, String paramType, Schema fieldSchema) {
        try{
            if (Objects.nonNull(originalValue)) {
                switch (paramType) {
                    case STRING:
                    case CHAR_SEQUENCE:
                        return originalValue.toString();
                    case INTEGER:
                        return Integer.valueOf(String.valueOf(originalValue));
                    case INT:
                        return Integer.parseInt(String.valueOf(originalValue));
                    case FLOAT:
                        return Float.parseFloat(String.valueOf(originalValue));
                    case LONG:
                        return Long.parseLong(String.valueOf(originalValue));
                    case BOOLEAN:
                        return Boolean.valueOf(String.valueOf(originalValue));
                    case DOUBLE:
                        return Double.parseDouble(String.valueOf(originalValue));
                    case BYTES:
    //                    return String.valueOf(originalValue).getBytes(StandardCharsets.UTF_8);
                    case BYTE_BUFFER:
                        return ByteBuffer.wrap(String.valueOf(originalValue)
                                .getBytes(StandardCharsets.UTF_8));
                    case TIMESTAMP: //For BQ datatype - TIMESTAMP
                        String strValue = (String) originalValue;
                        if (strValue.length() <= 23) {
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
                            LocalDateTime dateTime = LocalDateTime.parse(strValue, formatter);
                            ZonedDateTime zdt = dateTime.atZone(ZoneId.of("Europe/London"));
                            Instant instant = zdt.toInstant();
                            long micros = TimeUnit.SECONDS.toMicros(instant.getEpochSecond()) + TimeUnit.NANOSECONDS.toMicros(instant.getNano());
                            return micros;
                        } else {
                            String dateTimeTimezoneFormat = "yyyy-MM-dd HH:mm:ss.SSSSSS XXX";
                            final DateTimeFormatter inputSdf1 = DateTimeFormatter.ofPattern(dateTimeTimezoneFormat);
                            OffsetDateTime offsetDateTime = OffsetDateTime.parse(strValue, inputSdf1);
                            Instant instantOffSet = offsetDateTime.toInstant();
                            long micros = TimeUnit.SECONDS.toMicros(instantOffSet.getEpochSecond()) + TimeUnit.NANOSECONDS.toMicros(instantOffSet.getNano());
                            return micros;
                        }
                    case DATE_TIME: //For BQ datatype - DATETIME ,
                        strValue = (String) originalValue;
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
                        LocalDateTime dateTime = LocalDateTime.parse(strValue, formatter);
                        Instant instant = dateTime.toInstant(ZoneOffset.UTC);
                        return instant.toEpochMilli();
                    case DATE: //For BQ datatype - DATE ,
                        strValue = (String) originalValue;
                        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
                        dateFormatter = dateFormatter.withLocale( Locale.ENGLISH );
                        LocalDate date = LocalDate.parse(strValue);
                        String stringDate = date.format(dateFormatter);
                        date = LocalDate.parse(stringDate,dateFormatter);
                        TimeConversions.DateConversion f = new TimeConversions.DateConversion();
                        Integer intdate =   f.toInt(date,f.getRecommendedSchema(),new LogicalType("date"));
                        return intdate;

                    case RECORD_TYPE:
                        TableRow tableRowRecord = ((TableRow) originalValue);
                        return rowToGenericrecordFieldType(tableRowRecord,fieldSchema);
                    case "decimal":
                        Conversions.DecimalConversion DECIMAL_CONVERTER = new Conversions.DecimalConversion();
                        Integer scale = (Integer) fieldSchema.getObjectProps().get("scale");
                        LogicalTypes.Decimal l = (LogicalTypes.Decimal) fieldSchema.getLogicalType();
                        BigDecimal d = BigDecimal.valueOf(Double.parseDouble(String.valueOf(originalValue))).setScale(scale);
                        ByteBuffer value = DECIMAL_CONVERTER.toBytes(d, null, l);
                        return value;
                    default:
                        return null;
            }
        } else {
            return null;
        }
        }catch (Exception e){
            //LOGGER.error("Error:", e);
            throw new IgniteTransformationException("",e);
        }
    }
    public static class IgniteTransformationException extends RuntimeException {
        public IgniteTransformationException(String message, Throwable cause) {
            super(message, cause);
        }
    }

}