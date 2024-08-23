package com.ignite.transformation;

import org.apache.avro.generic.GenericRecord;
import org.apache.beam.sdk.schemas.Schema;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.values.Row;

public class GenericRecordToRowFn extends DoFn<GenericRecord, Row> {

    private Schema schema;

    /**
     * public constructor
     * @param schema schema
     */
    public GenericRecordToRowFn(Schema schema) {
        this.schema = schema;
    }

    /***
     * convert pcollection of generic records to pcollection of row
     * Processelement for
     * tablerow to row conversion
     * @param c processcontext
     */

    @ProcessElement
    public void processElement(ProcessContext c) {
        // Create a concrete row with that type.
        Row.Builder row = Row.withSchema(schema);
        GenericRecord genericRecord = c.element();
        for (String name : schema.getFieldNames()) {
            row.addValue(genericRecord.get(name));
        }
        c.output(row.build());
    }
}
