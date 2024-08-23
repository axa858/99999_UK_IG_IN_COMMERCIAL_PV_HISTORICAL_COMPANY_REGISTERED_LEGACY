package com.ignite.transformation;

import com.ignite.options.CustomPipelineOptions;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.coders.AvroCoder;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.Wait;
import org.apache.beam.sdk.values.PCollection;
import org.apache.commons.lang3.StringUtils;

public class SecurityUtil {

    private SecurityUtil() {
    }

    /**
     * PII Encryption and hashing operation are performed only for those pipeline
     * which has PII fields.The first operation on the pipeline is hashing operation
     * and the second operation on the pipeline is PII Encrytpion.For Hashing
     * operation hashing |DEK-path and groupId is passed. Similarly for PII
     * encryption, PII DEK path and groupId is passed. Initial call will be to
     * hashing operation class where the hashing is performed by calling data
     * protection library.Then it will call the PIIEncryption class ,there also the
     * data protection library is called.
     * <p>
     * The DEK Creation Part is Also included here. The arguments passed are google
     * KMS key url,groupId for the Pipeline and the root path in GCS.
     * <p>
     * After the both the operations are performed, the output obtained will be
     * directly written into the output location specified.
     *
     * @param options                    CustomPipelineOptions
     * @param genericRecordPCollection   genericRecordPCollection
     * @param dataPostprocessingPipeline Pipeline
     * @param schema                     schema of the avro file
     * @return
     */
    public static PCollection<GenericRecord> performPiiEncryption(CustomPipelineOptions options,
                                                                  PCollection<GenericRecord> genericRecordPCollection,
                                                                  Pipeline dataPostprocessingPipeline, Schema schema) {
        PCollection<GenericRecord> piiData;
        if (options.getPIIenabled()) {
            String piiDekPath = options.getPiiDekPath();
            String hashingDekPath = options.getHashingDekPath();
            String piiGroupId = options.getPiiGroupId();
            String hashingGroupId = options.getHashingGroupId();
            PCollection<GenericRecord> hashedData;
            if (options.getKeygenrequired()) {
                String googleKeyUrl = options.getGooglekeyurl();
                String rootOutputPath = options.getPiiDekPath();
                String groupId = options.getPiiGroupId();
                int numberOfKeys = options.getNumberofkeys();
                PCollection<Void> writeKeystoreSignal = dataPostprocessingPipeline.apply(Create.of(StringUtils.EMPTY))
                        .apply("WRITE KEYSTORE",
                                ParDo.of(new DEKGeneration(googleKeyUrl, groupId, rootOutputPath, numberOfKeys)));

                hashedData = genericRecordPCollection.apply(Wait.on(writeKeystoreSignal))
                        .setCoder(AvroCoder.of(schema))
                        .apply("HASHING", ParDo.of(new HashingOperation(hashingDekPath, hashingGroupId)));
            } else {

                hashedData = genericRecordPCollection.apply("HASHING",
                        ParDo.of(new HashingOperation(hashingDekPath, hashingGroupId)));
            }

            piiData = hashedData.apply("PII ENCRYPTION",
                    ParDo.of(new PIIEncryption(piiDekPath, piiGroupId)));
        } else {
            piiData = genericRecordPCollection;
        }
        return piiData;
    }
}
