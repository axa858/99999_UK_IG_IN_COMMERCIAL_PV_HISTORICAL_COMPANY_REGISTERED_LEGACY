package com.ignite.options;

import org.apache.beam.runners.dataflow.options.DataflowPipelineOptions;
import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.Validation.Required;
import org.apache.beam.sdk.options.ValueProvider;

import java.util.Map;

/**
 * It has declaration of custom pipeline options
 * This interface extends the DataflowPipelineOptions interface
 */
public interface CustomPipelineOptions extends DataflowPipelineOptions {

    @Description("Config file path")
    @Required
    String getConfigPath();

    void setConfigPath(String value);

    // When creating a template, this flag must be set to false.
    @Description("Wait for pipeline to finish.")
    @Default.Boolean(true)
    boolean getWait();

    void setWait(boolean wait);

    //GBP options starts here
    @Description("topic name")
    String getTopic();

    void setTopic(String value);

    @Description("profile id")
    String getProfileId();

    void setProfileId(String value);

    @Description("job id")
    String getJobId();

    void setJobId(String value);

    @Description("Config file")
    String getConfigFile();

    void setConfigFile(String value);

    @Description("stepId")
    String getStepId();

    void setStepId(String value);

    @Description("airflowRunId")
    String getAirflowRunId();

    void setAirflowRunId(String value);

    @Description("instanceId")
    String getInstanceId();

    void setInstanceId(String value);
    //GBP options ends here

    @Description("subscription")
    String getSubscription();

    void setSubscription(String value);

    @Description("thresholdWait")
    Integer getThresholdWait();

    void setThresholdWait(Integer value);

    @Description("workerMachineType")
    String getWorkerMachineType();

    void setWorkerMachineType(String value);

    @Description("stage ")
    String getStage();

/*    @Description("Path of the file to read from")
    @Required
    String getInputFile();

    void setInputFile(String value);*/

   /* @Description("Path of the file to write to")
    @Required
    String getOutput();

    void setOutput(String value);*/

    @Description("Path of the Secrets")
    String getSecrets();

    void setSecrets(String value);

    @Description("Is PII Enabled")
    @Default.Boolean(false)
    boolean getPIIenabled();

    void setPIIenabled(boolean value);

    @Description("KMS Symmetric key Url")
    @Required
    String getGooglekeyurl();

    void setGooglekeyurl(String value);

    @Description("Number of DEKS")
    @Default.Integer(1)
    int getNumberofkeys();

    void setNumberofkeys(int value);

    @Description("Whether DEK Generation required")
    boolean getKeygenrequired();

    void setKeygenrequired(boolean value);


    @Description("Private Key Location stored in GCS")
    String getGcsprivatekey();

    void setGcsprivatekey(String value);

    @Description("PII DEK Path in GCS")
    String getPiiDekPath();

    void setPiiDekPath(String value);

    void setTempLocation(String value);

    @Description("Hashing DEK Path in GCS")
    String getHashingDekPath();

    void setHashingDekPath(String value);

    @Description("PII GroupId")
    String getPiiGroupId();

    void setPiiGroupId(String value);

    @Description("Hashing GroupId")
    String getHashingGroupId();

    void setHashingGroupId(String value);

    @Description("labels")
    Map<String, String> getLabels();

    void setLabels(Map<String, String> labels);

    @Description("Data Set Name for processing ")
    ValueProvider<String> getDataSetName();

    void setDataSetName(ValueProvider<String> dataSetName);

    @Description("BQ Data Set Name for processing ")
    @Default.String("")
    String getBqdataSetName();

    void setBqdataSetName(String dataSetName);

    @Description("Validation Bucket")
    String getValidationBucket();

    void setValidationBucket(String value);

    @Description("Job type for processing ")
    String getJobType();

    void setJobType(String jobType);

    @Description("Path of the summary file to write")
    @Default.String("")
    String getOutputSummary();

    void setOutputSummary(String value);

    @Description("Job Audit datasetname and tablename")
    String getJobAuditTable();

    void setJobAuditTable(String value);

    @Description("isJobAuditEnabled")
    String getIsJobAuditEnabled();

    void setIsJobAuditEnabled(String value);

    @Description("Job Category")
    String getJobCategory();

    void setJobCategory(String value);

    @Description("Partition")
    @Default.String("")
    String getPartition();

    void setPartition(String value);

    @Description("Pcdstats Partition")
    @Default.String("")
    String getPartitionpcdstats();

    void setPartitionpcdstats(String value);

    @Description("BQ_TABLE")
    @Default.String("")
    String getBqtable();

    void setBqtable(String value);

    @Description("PCDSTATS_BQ_TABLE")
    @Default.String("")
    String getPcdstatsBqtable();

    void setPcdstatsBqtable(String value);

    @Description("BQ Table PII DEK Path")
    @Default.String("")
    String getBqPiiDekPath();

    void setBqPiiDekPath(String value);

    @Description("BQ PII GroupId")
    @Default.String("")
    String getBqPiiGroupId();

    void setBqPiiGroupId(String value);

    @Description("SC year")
    @Default.String("")
    String getScyear();

    void setScyear(String value);

    void setStage(String value);

    String getBqInCommPiiGroupId();

    String getBqInCommPiiDekPath();

    void setBqInCommPiiGroupId(String value);

    void  setBqInCommPiiDekPath(String value);

    String getBqCcorporationPiiDekPath();
    void setBqCcorporationPiiDekPath(String value);

    String getBqCcorporationPiiGroupId();
    void setBqCcorporationPiiGroupId(String value);

    String getBqNameChgPiiDekPath();
    void setBqNameChgPiiDekPath(String value);

    String getBqNameChgPiiGroupId();
    void setBqNameChgPiiGroupId(String value);

    String getBqRohistFieldsPiiDekPath();
    void setBqRohistFieldsPiiDekPath(String value);

    String getBqRohistFieldsPiiGroupId();
    void setBqRohistFieldsPiiGroupId(String value);
}