package com.ignite.transformation;

import com.equifax.fabric.commons.dp.keystore.client.file.FileKeystoreClientConfig;
import com.equifax.fabric.commons.dp.protector.avro.AvroFieldEncryptor;
import com.equifax.fabric.commons.dp.protector.client.KeystoreProtectorClient;
import com.ignite.constants.Constants;
import com.ignite.exception.IgniteTransformationException;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.specific.SpecificData;
import org.apache.beam.sdk.transforms.DoFn;

/**
 * Class that performs PIIEncryption
 * Pipeline which requires PII data
 * encryption will be handled here.
 */
public class PIIEncryption extends DoFn<GenericRecord, GenericRecord> {

    private static final String STATUS_FAILED = "PIIEncryption Failed";

    private static final String INITIALIZATION_FAILED = "PIIEncryption Initialization failed";

    private static final long serialVersionUID = -8792319345127073991L;
    private transient AvroFieldEncryptor fieldEncryptor;
    private String groupId;
    private String secretPath;

    /**
     * Secret path is the path of GCS location where the DEKS are stored groupId is
     * the name of the pipeline domain
     *
     * @param secretPath is the GCS DEK path for key
     * @param groupId    domain name of pipeline
     */
    public PIIEncryption(String secretPath, String groupId) {
        this.secretPath = secretPath;
        this.groupId = groupId;
    }

    /**
     * Initialize method is called for one time creation
     * of FileKeystoreClientConfig,AvroFieldEncryptor and
     * KeystoreProtectorClient which are data protection libraries
     * used for PII Encryption.
     */
    @Setup
    public void initialize() {
        try {
            FileKeystoreClientConfig keystoreClientConfig = new FileKeystoreClientConfig();
            keystoreClientConfig.setKeystoreGroupRoot(secretPath);
            KeystoreProtectorClient client = new KeystoreProtectorClient(groupId, keystoreClientConfig);
            fieldEncryptor = client.buildGroupAvroFieldEncryptor();
        } catch (Exception e) {
            throw new IgniteTransformationException(INITIALIZATION_FAILED, Constants.UNRECOVERABLE_ERROR, e);
        }

    }

    /**
     * PII Encryption is done by calling the data protection library.
     * fieldEncryptor will encrypt the GenericRecord.
     *
     * @param genericrecord  is the GenericRecord being encrypted.
     * @param outputReceiver will emit individual encrypted records out
     *                       from this parallel processing method.
     *                       deep copy is performed since beam requires immutable  data.
     */
    @ProcessElement
    public void process(@Element GenericRecord genericrecord, OutputReceiver<GenericRecord> outputReceiver) {
        try {
            GenericRecord record = genericrecord;
            GenericRecord newRecord = SpecificData.get().deepCopy(record.getSchema(), record);
            fieldEncryptor.encrypt(newRecord);
            outputReceiver.output(newRecord);
        } catch (Exception e) {
            throw new IgniteTransformationException(STATUS_FAILED, Constants.UNRECOVERABLE_ERROR, e);
        }

    }

}
