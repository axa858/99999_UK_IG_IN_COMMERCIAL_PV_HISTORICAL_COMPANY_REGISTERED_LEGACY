package com.ignite.transformation;



import java.io.Serializable;
import java.util.List;

public class DataSetConfigDetails implements Serializable {

    private String name;
    private String className;
    private String schema;
    private String loadType;
    private List<ColumnMapping> columnMapping;
    private String headerCheck;


    /**
     * getter for columnMapping
     *
     * @return -returns column mapping
     */
    public List<ColumnMapping> getColumnMapping() {
        return columnMapping;
    }

    /**
     * setter for columnMapping
     *
     * @param columnMapping - column mapping
     */
    public void setColumnMapping(List<ColumnMapping> columnMapping) {
        this.columnMapping = columnMapping;
    }

    /**
     * getter for Name
     *
     * @return -returns name
     */
    public String getName() {
        return name;
    }

    /**
     * setter for fileNames
     *
     * @param name -name of the file
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for schema
     *
     * @return -returns schema
     */
    public String getSchema() {
        return schema;
    }

    /**
     * setter for schema
     *
     * @param schema - schema for the dataset
     */
    public void setSchema(String schema) {
        this.schema = schema;
    }

    /**
     * getter for className
     *
     * @return -returns className
     */
    public String getClassName() {
        return className;
    }

    /**
     * setter for className
     *
     * @param className -name of the pojo class
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * getter for loadType
     *
     * @return -returns loadType
     */
    public String getLoadType() {
        return loadType;
    }

    /**
     * setter for loadType
     *
     * @param loadType - MONTHLY/DAILY
     */
    public void setLoadType(String loadType) {
        this.loadType = loadType;
    }

    /***
     * getter for header check
     * @return haedercheck value
     */
    public String getHeaderCheck() {
        return headerCheck;
    }

    /***
     * setter for header check
     * @param headerCheck value of haeder
     */
    public void setHeaderCheck(String headerCheck) {
        this.headerCheck = headerCheck;
    }
}
