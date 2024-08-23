package com.ignite.transformation;

import com.ignite.constants.Constants;
import org.apache.beam.sdk.schemas.Schema;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class RowSchemaBuilder {

    /**
     * To hide public constructor
     */
    private RowSchemaBuilder() {
    }

    /**
     * Add fields with the help of builder class
     * This will handle below types:
     * 1. STRING
     * 2. DOUBLE
     * 3. DATE
     * 4. INTEGER
     *
     * @param builder   Schema builder
     * @param fieldName String name
     * @param type      Column type
     */
    public static void addFields(Schema.Builder builder, String fieldName, String type) throws IOException {
        switch (type) {
            case Constants.TYPE_STRING:
                builder.addNullableField(fieldName, Schema.FieldType.STRING);
                break;
            case Constants.TYPE_DOUBLE:
                builder.addNullableField(fieldName, Schema.FieldType.DOUBLE);
                break;
            case Constants.TYPE_DATE:
                builder.addNullableField(fieldName, Schema.FieldType.DATETIME);
                break;
            case Constants.TYPE_INTEGER:
                builder.addNullableField(fieldName, Schema.FieldType.INT64);
                break;
            case Constants.TYPE_BYTES:
                builder.addNullableField(fieldName, Schema.FieldType.BYTES);
                break;
            case Constants.TYPE_BOOLEAN:
                builder.addNullableField(fieldName, Schema.FieldType.BOOLEAN);
                break;
            default:
                break;
        }
    }

    /**
     * Create schema object from table config
     *
     * @param dataSetConfigDetails table config
     * @return schema object
     */
    public static Schema getSchema(DataSetConfigDetails dataSetConfigDetails) {
        Schema.Builder sBuilder = new Schema.Builder();
       List<ColumnMapping> columnMapping = dataSetConfigDetails.getColumnMapping();
        columnMapping.sort(Comparator.comparing(ColumnMapping::getPosition));
        columnMapping.forEach(mapping ->
        {
            try {
                addFields(sBuilder, mapping.getSource(), mapping.getType());
            } catch (IOException e) {
            }
        });
        return sBuilder.build();
    }


}

