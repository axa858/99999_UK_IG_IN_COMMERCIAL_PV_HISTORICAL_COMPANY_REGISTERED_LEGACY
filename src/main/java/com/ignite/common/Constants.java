package com.ignite.common;


import java.time.format.DateTimeFormatter;

public class Constants {


    public static final String DOT_TEXT = ".txt";
    public static final String PREFIX_GS = "gs://";
    public static final String UNDERSCORE = "_";
    public static final String HYPHEN = "-";
    public static final String EMPTY = "";
    public static final String NEW_LINE = "\n";
    public static final String SUMMARY_FILE_NAME = "ComparisonReport";
    public static final String MISSING_SOURCE_RECORDS = "Missing Source Records : ";
    public static final String MISSING_DESTINATION_RECORDS = "Missing Destination Records : ";
    public static final String TOTAL_SOURCE_RECORDS = "Total Source Records : ";
    public static final String TOTAL_DESTINATION_RECORDS = "Total Destination Records : ";
    public static final String SLASH = "/";
    public static final String PROTECTION_INFO = "protectionInfo";
    public static final String ENCRYPTIONMETA = "encryptionMeta";
    public static final String COL_TO_ENCRYPT = "coltoencrypt";
    public static final String COL_TO_ENCRYPT_HASH = "coltoencrypt_hash";
    public static final String NEW_LINE_DELIMITER = "\n";
    public static final String INSIGHT_FILTER = "InsightFilter";
    public static final String NEW_INSIGHT = "newinsight";
    public static final String OLD_INSIGHT = "oldinsight";
    //pii decryption
    public static final String ENCRYPTION_META_DATA = "CAYQAhoFMS4wLjA=";
    public static final String KEYSTORE_ID = "keystoreId";
    public static final String COMMA = ",";
    public static final String Source = "Source";
    public static final String Destination = "Destination";
    public static final String MissingSourceRecord = "MissingSourceRecord";
    public static final String MissingDestinationRecord = "MissingDestinationRecord";
    public static final String APP = "app";
    public static final String JOB_LABELS_NPE = "{ \"version\" : \"1-0-0-ignite-onboarding\", \"tier\": \"dataflow\", \"supportemail\":\"eu_ignite_internal\", \"provisionedby\": \"airflow\", \"projectnumber\": \"189449171414\",\"name\": \"ignite-data-transformation\", \"environment\" :\"nprd\", \"data_class\" : \"5\", \"cost_center\" : \"3315\", \"division\": \"0300\",\"bussinessunit\": \"uk\", \"application\": \"ignite\", \"cmdb_bus_svc_id\": \"asve0033314\", \"cmdb_bus_app_id\": \"bap0008584\",\"app\" : \"ignite-datacompare\"}";
    public static final String JOB_LABELS_UAT = "{ \"version\" : \"1-0-0-ignite-onboarding\", \"tier\": \"dataflow\", \"supportemail\":\"eu_ignite_internal\", \"provisionedby\": \"airflow\", \"projectnumber\": \"232827123206\",\"name\": \"ignite-data-transformation\", \"environment\" :\"uat\", \"data_class\" : \"5\", \"cost_center\" : \"3315\", \"division\": \"0300\",\"bussinessunit\": \"uk\", \"application\": \"ignite\", \"cmdb_bus_svc_id\": \"asve0039910\", \"cmdb_bus_app_id\": \"bap0008584\",\"app\" : \"ignite-datacompare\"}";
    public static final String DESTINATION_QUERY = "SELECT Destination.record FROM Destination " +
            "              WHERE Destination.record NOT IN " +
            "                       (SELECT Source.record " +
            "                                FROM Source INNER JOIN Destination ON" +
            " Source.record = Destination.record )";
    public static final String SOURCE_QUERY = "SELECT Source.record FROM Source " +
            "              WHERE Source.record NOT IN " +
            "                       (SELECT Source.record " +
            "                                FROM Source INNER JOIN Destination ON" +
            " Source.record = Destination.record )";

    public static final String SOURCE_QUERY_RECORD_TYPE = "SELECT Source.record FROM Source";
    public static final String DESTINATION_QUERY_RECORD_TYPE = "SELECT Destination.record FROM Destination";
    public static final String FILTER_QUERY = "SELECT * FROM PCOLLECTION WHERE searchType='SR'";
    public static final int INT_1 = 1;
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
   /* public static final Schema schemaToEncrypt = new Schema.Parser().parse("{\n" + "\"type\": \"record\",\n" + " \"namespace\": \"com.ccds.equifax.gbp.uk\",\n" + " \"name\": \"Apps\",\n" +
            "  \"fields\": [\n" + "  " +
            "     { \"name\": \"" + Constants.COL_TO_ENCRYPT + "\", \"type\": [\"null\",\"string\"],\"protect\":\"true\" , \"doc\": \"any String to encrypt\" },\n" + " " +
            "     { \"name\": \"" + Constants.COL_TO_ENCRYPT_HASH + "\", \"type\":  [\"null\",\"string\"], \"digestSource\":\"" + Constants.COL_TO_ENCRYPT + "\", \"default\":null, \"doc\": \"any String hash to encrypt\" }, \n" +
            "     { \"name\":\"protectionInfo\",\"type\":[\"null\"," + ProtectionInfo.SCHEMA$.toString() + "],\"default\":null}] }\n" +
            "     ]\n"
            + "}");*/


    private Constants() {
        //Private constructor to prevent external instantiation of the class
    }
    public static final String NEXT_LINE_DELIMETER = "\n";

    public static String SEMI_COLON = ":";

    public static String DOT = ".";
    public static final String BYTE_BUFFER = "bytebuffer";

    public static final String RECORD_TYPE = "record";

    public static final String UNION_TYPE = "union";

    public static final String STRING = "string";
    public static final String CHAR_SEQUENCE = "charsequence";
    public static final String INTEGER = "integer";
    public static final String INT = "int";
    public static final String FLOAT = "float";
    public static final String LONG = "long";
    public static final String DOUBLE = "double";
    public static final String BYTES = "bytes";
    public static final String BOOLEAN = "boolean";
    public static final String ARRAY_TYPE = "array";
    public static final String SET = "set";
    public static final String TIMESTAMP = "timestamp";
    public static final String DATE = "date";
    public static final String DATE_TIME = "datetime";
    public static final String DOT_SPLITTER = "\\.";
    public static final String DOT_AVRO = ".avro";

    public static final String TOTAL_AVRO_RECORDS = "Total Avro Records : ";
    public static final String TOTAL_BQ_RECORDS = " Total BQ Records : ";
    public static final String MATCHED_RECORDS = " Valid records: ";
    public static final String UNMATCHED_RECORDS = " Invalid records : ";
    public static final String INVALID_RECORDS_FILE_NAME = "InvalidRecords";

}