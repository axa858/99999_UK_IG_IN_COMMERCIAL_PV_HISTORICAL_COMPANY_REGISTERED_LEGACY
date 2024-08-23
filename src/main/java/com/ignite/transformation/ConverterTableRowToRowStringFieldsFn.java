package com.ignite.transformation;

import com.google.api.services.bigquery.model.TableRow;
import org.apache.beam.sdk.schemas.Schema;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.values.Row;

import java.io.Serializable;
import java.util.Objects;

public class ConverterTableRowToRowStringFieldsFn extends DoFn<TableRow, Row> {

    private Schema schema;

    /**
     * constructor with schema
     *
     * @param schema Schema object
     */
    public ConverterTableRowToRowStringFieldsFn(Schema schema) {
        this.schema = schema;
    }

    /**
     * Process the elements
     * Iterate over each row and
     * Convert into IDWDataObject
     *
     * @param context ProcessContext
     */
    @ProcessElement
    public void processElement(ProcessContext context) {
        Row.Builder row = Row.withSchema(schema);
        TableRow tableRow = context.element();

        //Schema schema1 = schema.getField("");
        for (String name : schema.getFieldNames()) {

            row.addValue(tableRow.get(name) != null ? tableRow.get(name).toString() : null);
        }
        context.output(row.build());
    }


}
