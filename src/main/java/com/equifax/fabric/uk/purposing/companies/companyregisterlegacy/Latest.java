/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.equifax.fabric.uk.purposing.companies.companyregisterlegacy;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Latest extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Latest\",\"namespace\":\"com.equifax.fabric.uk.purposing.companies.companyregisterlegacy\",\"fields\":[{\"name\":\"purposingHeader\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"PurposingHeader\",\"namespace\":\"com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.purposingheader\",\"fields\":[{\"name\":\"dateReported\",\"type\":[\"null\",\"long\"],\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"recordUuid\",\"type\":[\"null\",\"string\"],\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"matchKey\",\"type\":[\"null\",\"string\"],\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"additionalInfo\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"additionalInfo\",\"fields\":[{\"name\":\"key\",\"type\":\"string\"},{\"name\":\"value\",\"type\":\"string\"}]}}}]}],\"default\":null},{\"name\":\"rawfields\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"RawFields\",\"namespace\":\"com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.rawfields\",\"fields\":[{\"name\":\"COMPANY_REGISTERED_NUMBER\",\"type\":[\"null\",\"string\"],\"doc\":\"Unique number assigned by Companies House to Corporate\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"TRANSACTION_TYPE\",\"type\":[\"null\",\"string\"],\"doc\":\"This field indicate type of a transaction on a Company data\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"CORRECTION_MARKER\",\"type\":[\"null\",\"string\"],\"doc\":\"The data output on an error transaction will be the same as the original transaction except with a new correction marker.  The transaction id is the best identifier if there are multiple transactions.\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"GAZETTE_TYPE\",\"type\":[\"null\",\"string\"],\"doc\":\"This field indicates type of Gazettable document type\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"ORIGINAL_GAZETTE_TYPE\",\"type\":[\"null\",\"string\"],\"doc\":\"Original gazettable document type\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"VOLUNTARY_DISSOLUTION_IND\",\"type\":[\"null\",\"string\"],\"doc\":\"The voluntary dissolution indicator may contain one of a number of values.  When used in update record types 17 and 18 will hold either �V� to indicate a voluntary dissolution or a space of the dissolution is not voluntary\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"DATE_INCORPORATED\",\"type\":[\"null\",\"string\"],\"doc\":\"Date of incorporation in CCYYMMDD format\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"LATEST_ACCOUNT_DATE\",\"type\":[\"null\",\"string\"],\"doc\":\"Latest accounts date\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"LATEST_ANNUAL_RETURN_DATE\",\"type\":[\"null\",\"string\"],\"doc\":\"Annual return made upto date in CCYYMMDD format\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"GAZETTE_PUBLISHED_DATE\",\"type\":[\"null\",\"string\"],\"doc\":\"Gazette effective date\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"ORIGINAL_PUBLISHED_DATE\",\"type\":[\"null\",\"string\"],\"doc\":\"Original date of publication in CCYYMMDD format\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"DOCUMENT_RECEIVED_DATE\",\"type\":[\"null\",\"string\"],\"doc\":\"Document received date\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"COMPANY_TYPE\",\"type\":[\"null\",\"string\"],\"doc\":\"Company Type (as per Companies House lists)\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"ACCOUNTING_REFERENCE_DATE\",\"type\":[\"null\",\"string\"],\"doc\":\"Accounting reference date (month and year)\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"STANDARD_INDUSTRY_CODE_1\",\"type\":[\"null\",\"string\"],\"doc\":\"Standard Industry Codes (SIC) trade classification code\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"STANDARD_INDUSTRY_CODE_2\",\"type\":[\"null\",\"string\"],\"doc\":\"Standard Industry Codes (SIC) trade classification code\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"STANDARD_INDUSTRY_CODE_3\",\"type\":[\"null\",\"string\"],\"doc\":\"Standard Industry Codes (SIC) trade classification code\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"STANDARD_INDUSTRY_CODE_4\",\"type\":[\"null\",\"string\"],\"doc\":\"Standard Industry Codes (SIC) trade classification code\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"EURO_COMPANY_NUMBER\",\"type\":[\"null\",\"string\"],\"doc\":\"European company number\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"ACCOUNTS_TYPE\",\"type\":[\"null\",\"string\"],\"doc\":\"Account Type\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"INSPECTION_MARKER\",\"type\":[\"null\",\"string\"],\"doc\":\"Inspection marker\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"DISSOLVED_MARKER\",\"type\":[\"null\",\"string\"],\"doc\":\"Dissolution marker\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"POSTCODE\",\"type\":[\"null\",\"string\"],\"doc\":\"Postcode\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"POSTCODE_STATUS\",\"type\":[\"null\",\"string\"],\"doc\":\"Postcode status\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"COUNTRY_ORIGIN_CODE\",\"type\":[\"null\",\"string\"],\"doc\":\"Code for country of origin\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"UPDATE_IND\",\"type\":[\"null\",\"string\"],\"doc\":\"Update Indicator (boolean)\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"PRIVATE_FUND_IND\",\"type\":[\"null\",\"string\"],\"doc\":\"Private fund indicator (boolean)\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"TRANSACTION_ID\",\"type\":[\"null\",\"string\"],\"doc\":\"Unique identifier for the transaction\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"JURISDICTION\",\"type\":[\"null\",\"string\"],\"doc\":\"Jurisdiction\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"COMPANY_NAME\",\"type\":[\"null\",\"string\"],\"doc\":\"Company Name registered on Companies House (Primary Business Name)\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"COMPANY_ALPHA_KEY\",\"type\":[\"null\",\"string\"],\"doc\":\"Alpha Key of the Primary Business Name (no spaces, no digits, no special characters)\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"DELIMITED_ADDRESS\",\"type\":[\"null\",\"string\"],\"doc\":\"Full company address\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"FILE_NAME\",\"type\":[\"null\",\"string\"],\"doc\":\"Supplied file name\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"RUN_NUMBER\",\"type\":[\"null\",\"string\"],\"doc\":\"Unique number assigned by Companies House to each supplied file\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"LOAD_DATE\",\"type\":[\"null\",\"string\"],\"doc\":\"Date on which data is loaded on Database\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"TAPEDATE\",\"type\":[\"null\",\"string\"],\"doc\":\"Date on which Tape (file) loaded\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"CARE_OF\",\"type\":[\"null\",\"string\"],\"doc\":\"Address: care of\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"PO_BOX\",\"type\":[\"null\",\"string\"],\"doc\":\"Address: post box\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"ADDRESS_LINE_1\",\"type\":[\"null\",\"string\"],\"doc\":\"Address line1\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"ADDRESS_LINE_2\",\"type\":[\"null\",\"string\"],\"doc\":\"Address line2\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"COUNTY\",\"type\":[\"null\",\"string\"],\"doc\":\"Company Address: County \",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"LOCALITY\",\"type\":[\"null\",\"string\"],\"doc\":\"Company Address: Locality\",\"default\":null,\"dataClassification\":\"3\"}]}],\"default\":null},{\"name\":\"standardised\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"StandardisedFields\",\"namespace\":\"com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.standardisedfields\",\"fields\":[{\"name\":\"COMPANY_NAME\",\"type\":[\"null\",\"string\"],\"doc\":\"Standardised Company Name\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"PROCESSING_DATE\",\"type\":[\"null\",\"string\"],\"doc\":\"Date on which data loaded on Data Fabric\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"ADDRESS_HOUSE_NUMBER\",\"type\":[\"null\",\"string\"],\"doc\":\"Standardised address house number\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"ADDRESS_STREET\",\"type\":[\"null\",\"string\"],\"doc\":\"Standardised address street\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"ADDRESS_AREA\",\"type\":[\"null\",\"string\"],\"doc\":\"Standardised address area\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"ADDRESS_POST_TOWN\",\"type\":[\"null\",\"string\"],\"doc\":\"Standardised address posttown\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"ADDRESS_REGION\",\"type\":[\"null\",\"string\"],\"doc\":\"Standardised address region\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"ADDRESS_COUNTRY\",\"type\":[\"null\",\"string\"],\"do","c\":\"Standardised address country\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"ADDRESS_POSTCODE\",\"type\":[\"null\",\"string\"],\"doc\":\"Standardised address postcode\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"ADDRESS_CARE_OF\",\"type\":[\"null\",\"string\"],\"doc\":\"Standardised address careof\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"ADDRESS_SUPPLIED_COMPANY_NAME\",\"type\":[\"null\",\"string\"],\"doc\":\"Standardised address supplied company name\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"ADDRESS_PO_BOX\",\"type\":[\"null\",\"string\"],\"doc\":\"Standardised address po box\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"FORMAT_OF_SUPPLY\",\"type\":[\"null\",\"string\"],\"doc\":\"Indicates format of supplied file\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"MIGRATION_FLAG\",\"type\":[\"null\",\"string\"],\"doc\":\"Indicates whether data is from live or Historical feed, H Indicates historical and <blank> Indicates live\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"DATE_OF_RESTORE\",\"type\":[\"null\",\"string\"],\"doc\":\"Company restoration date after dissolution\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"TAPE_REFERENCE_NUMBER\",\"type\":[\"null\",\"string\"],\"doc\":\"Unique number assigned by Companies House to each supplied file\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"entity\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"entityFields\",\"namespace\":\"com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.standardisedfields.entity\",\"fields\":[{\"name\":\"commercial\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"commercialFields\",\"namespace\":\"com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.standardisedfields.entity.commercial\",\"fields\":[{\"name\":\"legacyIds\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"legacyIdFields\",\"namespace\":\"com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.standardisedfields.entity.commercial.legacyids\",\"fields\":[{\"name\":\"LEGACY_ID_COMPANY_REGISTERED_NUMBER\",\"type\":[\"null\",\"string\"],\"doc\":\"Supplied Company Number\",\"default\":null,\"dataClassification\":\"3\"}]}],\"default\":null},{\"name\":\"identifiers\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"identifierFields\",\"namespace\":\"com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.standardisedfields.entity.commercial.identifiers\",\"fields\":[{\"name\":\"NAME_BUSINESS_COMPANY_TYPE\",\"type\":[\"null\",\"string\"],\"doc\":\"Type of company - L for Limited\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"IDENTIFIER_BUSINESS_VAT\",\"type\":[\"null\",\"string\"],\"doc\":\"VAT number field\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"IDENTIFIER_BUSINESS_EMAIL\",\"type\":[\"null\",\"string\"],\"doc\":\"EMAIL ID field\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"IDENTIFIER_DISSOLVED_DATE\",\"type\":[\"null\",\"string\"],\"doc\":\"Dissolution Date field\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"IDENTIFIER_INCORPORATION_DATE\",\"type\":[\"null\",\"string\"],\"doc\":\"Date of incorporation in CCYYMMDD format\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"IDENTIFIER_UPDATE_DATE\",\"type\":[\"null\",\"string\"],\"doc\":\"This is load date and will be a system date \",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"IDENTIFIER_DATA_SOURCE\",\"type\":[\"null\",\"string\"],\"doc\":\"Indicates source of data\",\"default\":null,\"dataClassification\":\"3\"}]}],\"default\":null},{\"name\":\"website\",\"type\":[\"null\",{\"type\":\"map\",\"values\":\"string\"}],\"doc\":\"Supplied Websites\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"phones\",\"type\":[\"null\",{\"type\":\"map\",\"values\":\"string\"}],\"doc\":\"Supplied Phone number\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"names\",\"type\":[\"null\",{\"type\":\"map\",\"values\":\"string\"}],\"doc\":\"Standardised Company Names as per Keying & Linking inputs\",\"default\":null,\"dataClassification\":\"3\"},{\"name\":\"addresses\",\"type\":[\"null\",{\"type\":\"map\",\"values\":\"string\"}],\"doc\":\"Standardised postcode as per Keying & Linking inputs\",\"default\":null,\"dataClassification\":\"3\"}]}],\"default\":null}]}],\"default\":null}]}],\"default\":null},{\"name\":\"header\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"HeaderFields\",\"namespace\":\"com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.header\",\"fields\":[{\"name\":\"SUPPLIED_DATE\",\"type\":[\"null\",\"string\"],\"default\":null,\"dataClassification\":\"3\"}]}],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.purposingheader.PurposingHeader purposingHeader;
  @Deprecated public com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.rawfields.RawFields rawfields;
  @Deprecated public com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.standardisedfields.StandardisedFields standardised;
  @Deprecated public com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.header.HeaderFields header;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public Latest() {}

  /**
   * All-args constructor.
   */
  public Latest(com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.purposingheader.PurposingHeader purposingHeader, com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.rawfields.RawFields rawfields, com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.standardisedfields.StandardisedFields standardised, com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.header.HeaderFields header) {
    this.purposingHeader = purposingHeader;
    this.rawfields = rawfields;
    this.standardised = standardised;
    this.header = header;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return purposingHeader;
    case 1: return rawfields;
    case 2: return standardised;
    case 3: return header;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: purposingHeader = (com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.purposingheader.PurposingHeader)value$; break;
    case 1: rawfields = (com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.rawfields.RawFields)value$; break;
    case 2: standardised = (com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.standardisedfields.StandardisedFields)value$; break;
    case 3: header = (com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.header.HeaderFields)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'purposingHeader' field.
   */
  public com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.purposingheader.PurposingHeader getPurposingHeader() {
    return purposingHeader;
  }

  /**
   * Sets the value of the 'purposingHeader' field.
   * @param value the value to set.
   */
  public void setPurposingHeader(com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.purposingheader.PurposingHeader value) {
    this.purposingHeader = value;
  }

  /**
   * Gets the value of the 'rawfields' field.
   */
  public com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.rawfields.RawFields getRawfields() {
    return rawfields;
  }

  /**
   * Sets the value of the 'rawfields' field.
   * @param value the value to set.
   */
  public void setRawfields(com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.rawfields.RawFields value) {
    this.rawfields = value;
  }

  /**
   * Gets the value of the 'standardised' field.
   */
  public com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.standardisedfields.StandardisedFields getStandardised() {
    return standardised;
  }

  /**
   * Sets the value of the 'standardised' field.
   * @param value the value to set.
   */
  public void setStandardised(com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.standardisedfields.StandardisedFields value) {
    this.standardised = value;
  }

  /**
   * Gets the value of the 'header' field.
   */
  public com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.header.HeaderFields getHeader() {
    return header;
  }

  /**
   * Sets the value of the 'header' field.
   * @param value the value to set.
   */
  public void setHeader(com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.header.HeaderFields value) {
    this.header = value;
  }

  /** Creates a new Latest RecordBuilder */
  public static com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.Latest.Builder newBuilder() {
    return new com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.Latest.Builder();
  }
  
  /** Creates a new Latest RecordBuilder by copying an existing Builder */
  public static com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.Latest.Builder newBuilder(com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.Latest.Builder other) {
    return new com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.Latest.Builder(other);
  }
  
  /** Creates a new Latest RecordBuilder by copying an existing Latest instance */
  public static com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.Latest.Builder newBuilder(com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.Latest other) {
    return new com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.Latest.Builder(other);
  }
  
  /**
   * RecordBuilder for Latest instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Latest>
    implements org.apache.avro.data.RecordBuilder<Latest> {

    private com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.purposingheader.PurposingHeader purposingHeader;
    private com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.rawfields.RawFields rawfields;
    private com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.standardisedfields.StandardisedFields standardised;
    private com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.header.HeaderFields header;

    /** Creates a new Builder */
    private Builder() {
      super(com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.Latest.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.Latest.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.purposingHeader)) {
        this.purposingHeader = data().deepCopy(fields()[0].schema(), other.purposingHeader);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.rawfields)) {
        this.rawfields = data().deepCopy(fields()[1].schema(), other.rawfields);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.standardised)) {
        this.standardised = data().deepCopy(fields()[2].schema(), other.standardised);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.header)) {
        this.header = data().deepCopy(fields()[3].schema(), other.header);
        fieldSetFlags()[3] = true;
      }
    }
    
    /** Creates a Builder by copying an existing Latest instance */
    private Builder(com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.Latest other) {
            super(com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.Latest.SCHEMA$);
      if (isValidValue(fields()[0], other.purposingHeader)) {
        this.purposingHeader = data().deepCopy(fields()[0].schema(), other.purposingHeader);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.rawfields)) {
        this.rawfields = data().deepCopy(fields()[1].schema(), other.rawfields);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.standardised)) {
        this.standardised = data().deepCopy(fields()[2].schema(), other.standardised);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.header)) {
        this.header = data().deepCopy(fields()[3].schema(), other.header);
        fieldSetFlags()[3] = true;
      }
    }

    /** Gets the value of the 'purposingHeader' field */
    public com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.purposingheader.PurposingHeader getPurposingHeader() {
      return purposingHeader;
    }
    
    /** Sets the value of the 'purposingHeader' field */
    public com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.Latest.Builder setPurposingHeader(com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.purposingheader.PurposingHeader value) {
      validate(fields()[0], value);
      this.purposingHeader = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'purposingHeader' field has been set */
    public boolean hasPurposingHeader() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'purposingHeader' field */
    public com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.Latest.Builder clearPurposingHeader() {
      purposingHeader = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'rawfields' field */
    public com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.rawfields.RawFields getRawfields() {
      return rawfields;
    }
    
    /** Sets the value of the 'rawfields' field */
    public com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.Latest.Builder setRawfields(com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.rawfields.RawFields value) {
      validate(fields()[1], value);
      this.rawfields = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'rawfields' field has been set */
    public boolean hasRawfields() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'rawfields' field */
    public com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.Latest.Builder clearRawfields() {
      rawfields = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'standardised' field */
    public com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.standardisedfields.StandardisedFields getStandardised() {
      return standardised;
    }
    
    /** Sets the value of the 'standardised' field */
    public com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.Latest.Builder setStandardised(com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.standardisedfields.StandardisedFields value) {
      validate(fields()[2], value);
      this.standardised = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'standardised' field has been set */
    public boolean hasStandardised() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'standardised' field */
    public com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.Latest.Builder clearStandardised() {
      standardised = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'header' field */
    public com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.header.HeaderFields getHeader() {
      return header;
    }
    
    /** Sets the value of the 'header' field */
    public com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.Latest.Builder setHeader(com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.header.HeaderFields value) {
      validate(fields()[3], value);
      this.header = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'header' field has been set */
    public boolean hasHeader() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'header' field */
    public com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.Latest.Builder clearHeader() {
      header = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    public Latest build() {
      try {
        Latest record = new Latest();
        record.purposingHeader = fieldSetFlags()[0] ? this.purposingHeader : (com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.purposingheader.PurposingHeader) defaultValue(fields()[0]);
        record.rawfields = fieldSetFlags()[1] ? this.rawfields : (com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.rawfields.RawFields) defaultValue(fields()[1]);
        record.standardised = fieldSetFlags()[2] ? this.standardised : (com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.standardisedfields.StandardisedFields) defaultValue(fields()[2]);
        record.header = fieldSetFlags()[3] ? this.header : (com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.header.HeaderFields) defaultValue(fields()[3]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
