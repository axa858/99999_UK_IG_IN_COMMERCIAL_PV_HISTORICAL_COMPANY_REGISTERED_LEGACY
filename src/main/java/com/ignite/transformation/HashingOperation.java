package com.ignite.transformation;

import com.equifax.fabric.commons.dp.keystore.client.file.FileKeystoreClientConfig;
import com.equifax.fabric.commons.dp.protector.avro.AvroFieldDigestor;
import com.equifax.fabric.commons.dp.protector.client.KeystoreDigestorClient;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.specific.SpecificData;
import org.apache.beam.sdk.transforms.DoFn;


/**
 * Class that performs HashingOperation.
 * Hashing Operation is done by calling the
 * data-protection library.
 * fieldDigestor will hash the GenericRecord.
 */
public class HashingOperation extends DoFn<GenericRecord, GenericRecord> {

    private static final long serialVersionUID = -7042898996719884874L;
    private String digestorId;
    private String secretPath;
    private transient AvroFieldDigestor fieldDigestor;

    /**
     * Secret path is the path of GCS location
     * where the DEKS are stored groupId is
     * the name of the pipeline domain
     *
     * @Param SecretPath DEK path in GCS
     * @Param digestorId Domain Name.
     */
    public HashingOperation(String secretPath, String digestorId) {
        this.secretPath = secretPath;
        this.digestorId = digestorId;
    }

    @Setup
    public void initialize() {
        FileKeystoreClientConfig keystoreClientConfig = new FileKeystoreClientConfig();
        keystoreClientConfig.setKeystoreGroupRoot(secretPath);
        KeystoreDigestorClient keystoredigestorclient = new KeystoreDigestorClient(digestorId, keystoreClientConfig);
        fieldDigestor = keystoredigestorclient.buildAvroFieldDigestor();
    }

    /**
     * Hashing Operation is done by calling the data-protection library.
     * fieldDigestor will hash the GenericRecord.
     *
     * @param genericrecord  is the GenericRecord being encrypted.
     * @param outputReceiver will emit Individual encrypted records
     *                       out from this parallel processing method.
     *                       <p>
     *                       deepcopy is performed since beam has to ensure the Immutable of data.
     */
    @ProcessElement
    public void process(@Element GenericRecord genericrecord, OutputReceiver<GenericRecord> outputReceiver) {
        GenericRecord record = genericrecord;
        GenericRecord newRecord = SpecificData.get().deepCopy(record.getSchema(), record);
        fieldDigestor.digest(newRecord);
        outputReceiver.output(newRecord);
    }
}
