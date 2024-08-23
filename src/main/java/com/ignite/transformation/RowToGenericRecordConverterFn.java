package com.ignite.transformation;

import org.apache.avro.generic.GenericData;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.values.Row;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RowToGenericRecordConverterFn extends DoFn<Row, GenericRecord> {
    Schema schema;
    private static final Logger LOGGER = LoggerFactory.getLogger(RowToGenericRecordConverterFn.class);

    public RowToGenericRecordConverterFn(Schema schema) {
        this.schema = schema;
    }

    @ProcessElement
    public void processElement(@Element Row row, OutputReceiver<GenericRecord> outputReceiver) {
        LOGGER.error("RowTOGeneric ::: " + row);
        GenericRecord genericRecord = new GenericData.Record(schema);
        for (org.apache.beam.sdk.schemas.Schema.Field field : row.getSchema().getFields()) {
            LOGGER.error("RowTOGeneric field::: " + field);
            Object value = row.getValue(field.getName());
            genericRecord.put(field.getName(), value);
        }

        outputReceiver.output(genericRecord);
    }
}
