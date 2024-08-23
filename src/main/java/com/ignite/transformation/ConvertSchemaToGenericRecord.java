package com.ignite.transformation;

import com.equifax.fabric.commons.storage.util.StorageUtil;
import com.google.api.services.bigquery.model.TableRow;
import com.ignite.options.CustomPipelineOptions;
import com.ignite.util.BigQueryUtil;
import com.ignite.util.JsonUtil;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.coders.RowCoder;
import org.apache.beam.sdk.extensions.avro.coders.AvroCoder;
import org.apache.beam.sdk.extensions.avro.schemas.utils.AvroUtils;
import org.apache.beam.sdk.extensions.sql.SqlTransform;
import org.apache.beam.sdk.schemas.SchemaCoder;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.PCollectionTuple;
import org.apache.beam.sdk.values.Row;
import org.apache.beam.sdk.values.TupleTag;

import java.io.IOException;

public class ConvertSchemaToGenericRecord {

    public static PCollection<GenericRecord> getGenericRecord(Pipeline pipeline, CustomPipelineOptions options) throws IOException {
        // public static void  getGenericRecord(Pipeline pipeline, CustomPipelineOptions options) throws IOException {

        //company_corporation_uk_int
        String companycor = StorageUtil.readFileAsString("gs://df-dna-plt-poc-data-uk-int/Company_Registered_Legacy/company_corporation_w_protectioninfo.avsc");
        Schema companycorSchema = new Schema.Parser().parse(companycor);

        PCollection<TableRow> companycorTable = BigQueryUtil.getTableRow(pipeline, options.getProject(),
                "commercial_credit_risk_analyst_uk_int", "company_corporation_uk_int",
                "2024-07-01");

        PCollection<GenericRecord> companycorRow = companycorTable.apply(
                        "convert cons_product BQ tableRow to Row",
                        ParDo.of(new TableRowToGenericRecordConverterFn((companycorSchema))))
                .setCoder(org.apache.beam.sdk.coders.AvroCoder.of(companycorSchema));

        PCollection<GenericRecord> companycorpiiDecrypted = companycorRow
                .apply("DECRYPT PII FIELDS", ParDo.of(new PiiDecryptUtil(options.getBqCcorporationPiiDekPath(),
                        options.getBqCcorporationPiiGroupId())))
                .setCoder(AvroCoder.of(companycorSchema));

        DataSetConfigDetails companycorJson = JsonUtil.readDataSetConfig("bq_read/companycorporation.json");
        org.apache.beam.sdk.schemas.Schema companycorJsonSchema = RowSchemaBuilder.getSchema(companycorJson);

        PCollection<Row> companycorJsonRow = companycorpiiDecrypted.
                apply("Generic Record to Row", ParDo.of(new GenericRecordToRowFn(companycorJsonSchema)))
                .setCoder(RowCoder.of(companycorJsonSchema));

//croevent_croevent_uk_int
        String croevent = StorageUtil.readFileAsString("gs://df-dna-plt-poc-data-uk-int/Company_Registered_Legacy/croevent_croevent_w_protectioninfo.avsc");
        Schema croeventSchema = new Schema.Parser().parse(croevent);

        PCollection<TableRow> croeventTable = BigQueryUtil.getTableRow(pipeline, options.getProject(),
                "commercial_credit_risk_analyst_uk_int", "croevent_croevent_uk_int",
                "2024-07-01");


        PCollection<Row> croeventRow = croeventTable.apply(
                        "convert cons_product BQ tableRow to Row",
                        ParDo.of(new ConverterTableRowToRowStringFieldsFn(AvroUtils.toBeamSchema(croeventSchema))))
                .setCoder(SchemaCoder.of(AvroUtils.toBeamSchema(croeventSchema)));


//namechg_namechg_uk_int
        String namechg = StorageUtil.readFileAsString("gs://df-dna-plt-poc-data-uk-int/Company_Registered_Legacy/namechg_namechg_w_protectioninfo.avsc");
        Schema namechgschema = new Schema.Parser().parse(namechg);

        PCollection<TableRow> namechgTable = BigQueryUtil.getTableRow(pipeline, options.getProject(),
                "commercial_credit_risk_analyst_uk_int", "namechg_namechg_uk_int",
                "2024-07-01");


        PCollection<GenericRecord> namechgRow = namechgTable.apply(
                        "convert cons_product BQ tableRow to Row",
                        ParDo.of(new TableRowToGenericRecordConverterFn((namechgschema))))
                .setCoder(org.apache.beam.sdk.coders.AvroCoder.of(namechgschema));

        PCollection<GenericRecord> namechgpiiDecrypted = namechgRow
                .apply("DECRYPT PII FIELDS", ParDo.of(new PiiDecryptUtil(options.getBqNameChgPiiDekPath(),
                        options.getBqNameChgPiiGroupId())))
                .setCoder(AvroCoder.of(namechgschema));

        DataSetConfigDetails namechgJson = JsonUtil.readDataSetConfig("bq_read/namechgnamechg.json");
        org.apache.beam.sdk.schemas.Schema namechgJsonSchema = RowSchemaBuilder.getSchema(namechgJson);

        PCollection<Row> namechgJsonRow = namechgpiiDecrypted.
                apply("Generic Record to Row", ParDo.of(new GenericRecordToRowFn(namechgJsonSchema)))
                .setCoder(RowCoder.of(namechgJsonSchema));


//rohistacsfiled_rohist_uk_int
        String rohistacsifiledrohist = StorageUtil.readFileAsString("gs://df-dna-plt-poc-data-uk-int/Company_Registered_Legacy/rohistacsfiled_rohist_w_protectioninfo.avsc");
        Schema rohistacsifiledrohistSchema = new Schema.Parser().parse(rohistacsifiledrohist);

        PCollection<TableRow> rohistacsifiledrohistTable = BigQueryUtil.getTableRow(pipeline, options.getProject(),
                "commercial_credit_risk_analyst_uk_int", "rohistacsfiled_rohist_uk_int",
                "2024-07-01");


        PCollection<GenericRecord> rohistacsifiledrohistRow = rohistacsifiledrohistTable.apply(
                        "convert cons_product BQ tableRow to Row",
                        ParDo.of(new TableRowToGenericRecordConverterFn((rohistacsifiledrohistSchema))))
                .setCoder(org.apache.beam.sdk.coders.AvroCoder.of(rohistacsifiledrohistSchema));

        PCollection<GenericRecord> rohistacsfiledpiiDecrypted = rohistacsifiledrohistRow
                .apply("DECRYPT PII FIELDS", ParDo.of(new PiiDecryptUtil(options.getBqRohistFieldsPiiDekPath(),
                        options.getBqRohistFieldsPiiGroupId())))
                .setCoder(AvroCoder.of(rohistacsifiledrohistSchema));

        DataSetConfigDetails rohistacsfiledJson = JsonUtil.readDataSetConfig("bq_read/rohistacsfiledrohist.json");
        org.apache.beam.sdk.schemas.Schema rohistacsfiledJsonSchema = RowSchemaBuilder.getSchema(rohistacsfiledJson);

        PCollection<Row> rohistacsfiledJsonRow = rohistacsfiledpiiDecrypted.
                apply("Generic Record to Row", ParDo.of(new GenericRecordToRowFn(rohistacsfiledJsonSchema)))
                .setCoder(RowCoder.of(rohistacsfiledJsonSchema));

        StringBuffer query = new StringBuffer();
        query.append("select  ")
                .append("a.company, a.name, ")
                .append("a.alpha, a.costat, a.repstat, a.add1, a.add2, a.add3, a.add4, a.acrefdate, a.incdate, ")
                .append("a.acmdate, a.anrdate, a.watch, a.watchnote, a.quarterly, a.vatreg, ")
                .append("a.cotype, a.esource, a.ustatdate, a.inspect, a.vtc, ")
                .append("a.ho_post, a.ho_phone, a.acctype, a.postcode, a.town, a.d_date, ")
                .append("a.df_date,a.tapedate, a.taperef, a.tapemtype, a.inspectdate, a.kpostcode, ")
                .append("a.careof, a.pobox, a.jurisdiction, a.countryorigin, a.eurcompany, a.name_hash,")
                .append("b.cdate, b.sdate, b.source, ")
                .append("b.reason, b.stime, b.operatorid, ")
                .append("c.ecode, c.edate, c.transactionid, c.gzeffdate, ")
                .append("d.locality, d.county, ")
                .append("d.ctime,")
                .append("d.add1_hash, d.add2_hash, d.postcode_hash, d.kpostcode_hash ")
                .append("from ")
                .append("`company_corporation_uk_int` a ")
                .append("join ")
                .append("`namechg_namechg_uk_int` b ")
                .append("on a.company = b.company and a.alpha = b.alpha ")
                //.append("and a.name = b.name and a.name_hash = b.name_hash  ")
                .append("join ")
                .append("`croevent_croevent_uk_int` c ")
                .append("on a.company = c.company ")
                .append("join ")
                .append("`rohistacsfiled_rohist_uk_int` d ")
                .append("on a.company = d.company and a.town = d.town and a.pobox = d.pobox ");
        //.append("and a.add1 = d.add1 and a.add2 = d.add2 and a.postcode = d.postcode ");
        //Merged Schema

        String mergedsourceschemas = StorageUtil.readFileAsString("gs://df-dna-plt-poc-data-uk-int/Company_Registered_Legacy/crl-mergedschema.avsc");
        Schema mergedsourceschemasSchema = new Schema.Parser().parse(mergedsourceschemas);

        PCollection<Row> result = PCollectionTuple.of(
                        new TupleTag<>("company_corporation_uk_int"), companycorJsonRow)
                .and(new TupleTag<>("namechg_namechg_uk_int"), namechgJsonRow)
                .and(new TupleTag<>("croevent_croevent_uk_int"), croeventRow)
                .and(new TupleTag<>("rohistacsfiled_rohist_uk_int"), rohistacsfiledJsonRow)
                .apply(SqlTransform.query((query.toString())));

        PCollection<GenericRecord> genericRecordPCollection  = result
                .apply("CONVERT TABLEROW TO GENERIC RECORD",
                        ParDo.of(new RowToGenericRecordConverterFn(mergedsourceschemasSchema)))
                .setCoder(org.apache.beam.sdk.coders.AvroCoder.of(mergedsourceschemasSchema));

        return genericRecordPCollection;
    }
}
