
package com.ignite.launcher;

import com.equifax.fabric.commons.storage.util.StorageUtil;
import com.ignite.options.CustomPipelineOptions;
import com.ignite.transformation.*;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.extensions.avro.io.AvroIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Executor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Executor.class);
    public static void main(String[] args) throws IOException {

        PipelineOptionsFactory.register(CustomPipelineOptions.class);

        CustomPipelineOptions options = PipelineOptionsFactory.fromArgs(args).withValidation()
                .as(CustomPipelineOptions.class);
        Pipeline pipeline = Pipeline.create(options);
        PCollection<GenericRecord> destinationBqRecordPCollection = ConvertSchemaToGenericRecord.getGenericRecord(pipeline,options);

//        ConvertSchemaToGenericRecord.getGenericRecord(pipeline,options);

        String destinationSchemaStr = StorageUtil.readFileAsString("gs://df-dna-plt-poc-data-uk-int/Company_Registered_Legacy/companyRegisterLegacy.avsc");
        Schema destinationSchema = new Schema.Parser().parse(destinationSchemaStr);

        String mergedsourceschema = StorageUtil.readFileAsString("gs://df-dna-plt-poc-data-uk-int/Company_Registered_Legacy/crl-mergedschema.avsc");
        Schema mergedSchema = new Schema.Parser().parse(mergedsourceschema);

        PCollection<GenericRecord> genericRecordPCollectionEncrypt = SecurityUtil
                .performPiiEncryption(options,destinationBqRecordPCollection, pipeline, mergedSchema);

        genericRecordPCollectionEncrypt.apply("Mapping", ParDo.of(new TransformationBQ()))
                .setCoder(org.apache.beam.sdk.coders.AvroCoder.of(destinationSchema))
                .apply("WRITING SUMMARY AVRO FILE",
                        AvroIO.writeGenericRecords(destinationSchema)
                                .to("gs://df-dna-plt-poc-data-uk-int/Company_Registered_Legacy/").withSuffix(".avro"));

        pipeline.run().waitUntilFinish();
    }
}
