package com.ignite.transformation;

import com.ignite.constants.Constants;
import com.ignite.exception.IgniteTransformationException;
import com.equifax.fabric.commons.dp.keystore.client.file.FileKeystoreClientConfig;
import com.equifax.fabric.commons.dp.protector.avro.AvroFieldDecryptor;
import com.equifax.fabric.commons.dp.protector.client.KeystoreProtectorClient;
import org.apache.avro.generic.GenericRecord;
import org.apache.beam.sdk.transforms.DoFn;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static com.ignite.constants.Constants.*;


public class PiiDecryptUtil extends DoFn<GenericRecord,GenericRecord> {

    private transient AvroFieldDecryptor avroFieldDecryptor;
    private transient KeystoreProtectorClient client;
    private String groupId;
    private String secretPath;
    private static final String STATUS_FAILED = "PIIDecryption Failed";



    /**
     * Secret path is the path of GCS location where the DEKS are stored groupId is
     * the name of the pipeline domain
     * @param secretPath is the GCS DEK path for key
     * @param groupId domain name of pipeline
     */
    public PiiDecryptUtil(String secretPath, String groupId) {
        this.secretPath = secretPath;
        this.groupId = groupId;
    }

    @Setup
    public void initialize() {
        try {
            FileKeystoreClientConfig keystoreClientConfig = new FileKeystoreClientConfig();
            keystoreClientConfig.setKeystoreGroupRoot(secretPath);
            client = new KeystoreProtectorClient(groupId, keystoreClientConfig);
        } catch (Exception e) {
            throw new IgniteTransformationException(STATUS_FAILED, Constants.UNRECOVERABLE_ERROR, e);
        }

    }

    /**
     * PII Decryption is done by calling the data protection library.
     * avroFieldDecryptor will encrypt the GenericRecord.
     * @param outputReceiver will emit individual encrypted records out
     * from this parallel processing method.
     * deep copy is performed since beam requires immutable  data.
     */
    @ProcessElement
    public void process(@Element GenericRecord newGenericRecord, OutputReceiver<GenericRecord> outputReceiver) {
        try {
            GenericRecord protectionInfo = (GenericRecord)newGenericRecord.get(PROTECTION_INFO);
            if(Objects.nonNull(protectionInfo)) {
                protectionInfo.put(ENCRYPTION_META, ByteBuffer.wrap(ENCRYPTION_META_DATA.getBytes(StandardCharsets.UTF_8)));
                newGenericRecord.put(PROTECTION_INFO,protectionInfo);
            }
            if(Objects.isNull(avroFieldDecryptor)) {
                assert protectionInfo != null;
                String keystoreId = String.valueOf(protectionInfo.get(KEYSTORE_ID));
                avroFieldDecryptor = client.buildKeystoreAvroFieldDecryptor(keystoreId);
            }
            avroFieldDecryptor.decrypt(newGenericRecord);
            outputReceiver.output(newGenericRecord);
        } catch (Exception e) {
            throw new IgniteTransformationException(STATUS_FAILED, Constants.UNRECOVERABLE_ERROR, e);
        }

    }

}
