package com.ignite.transformation;

import com.ignite.constants.Constants;
import com.ignite.exception.IgniteTransformationException;
import com.equifax.fabric.commons.dp.domain.WrappedKeyStore;
import com.equifax.fabric.commons.dp.keystore.client.KeystoreClientWriter;
import com.equifax.fabric.commons.dp.keystore.client.file.FileKeystoreClientConfig;
import com.equifax.fabric.commons.dp.keystore.client.file.FileKeystoreClientWriter;
import com.equifax.fabric.commons.dp.keystore.manager.KeystoreBuilder;
import org.apache.beam.sdk.transforms.DoFn;

/**
 * DEKGeneration is the class used for creating data encryption keys for PII
 * Encryption.The keys are generated and stored in the specified location in
 * GCS.Number of keys to be generated, domain name are other important
 * parameters.Once the keys are generated each individual pipeline can take its
 * own key for doing PII Encryption.The key that is getting generated is Wrapped
 * by KEK. so the KEK reference is passed to generate the Key.
 */
public class DEKGeneration extends DoFn<String, Void> {

    private static final String STATUS_FAILED = "DEK Generation Operation Failed";

    private static final long serialVersionUID = 1965860784501453518L;

    private String symmetricKeyUrl;

    private String groupId;

    private String dekKeystoreGroupRoot;

    private int numberOfKeys;

    /**
     * Constructor for DEKGeneration class.It receives three arguments, which is
     * necessary to create the DEKS in the specified location.
     *
     * @param symmetricKeyUrl      is the KEK reference for generating DEKS.
     * @param groupId              is the Domain+SubDomain name for the particular
     *                             Pipeline.
     * @param dekKeystoreGroupRoot is the GCS location where key is getting stored.
     * @param numberOfKeys         is the total number of keys to be generated for
     *                             each flow of the Pipeline.
     */
    public DEKGeneration(String symmetricKeyUrl, String groupId, String dekKeystoreGroupRoot, int numberOfKeys) {
        this.symmetricKeyUrl = symmetricKeyUrl;
        this.groupId = groupId;
        this.dekKeystoreGroupRoot = dekKeystoreGroupRoot;
        this.numberOfKeys = numberOfKeys;
    }

    /**
     * processElement method is the method which will be executed on the worker node
     * to create DEKS. It will not do a parallel processing since the KeyGen should
     * happen on only one machine.This is ensured from the driver
     * Data Processing Executor.This class uses the help of data protection library
     * to create DEKS.by giving symmetric key URL a KeyStoreBuilder is created.Using
     * that builder a Wrapped KeyStore is created.And using the client the keys are
     * getting generated.
     *
     * @param ctx is the processcontext
     */
    @ProcessElement
    public void processElement(ProcessContext ctx) {
        try {
            KeystoreBuilder builder = new KeystoreBuilder(symmetricKeyUrl, "1");
            WrappedKeyStore keystore = builder.createKeyStore(groupId, numberOfKeys);
            KeystoreClientWriter writer = new FileKeystoreClientWriter(
                    new FileKeystoreClientConfig(dekKeystoreGroupRoot));
            writer.writeKeystore(keystore);
        } catch (Exception e) {
            throw new IgniteTransformationException(STATUS_FAILED, Constants.UNRECOVERABLE_ERROR, e);
        }
    }

}