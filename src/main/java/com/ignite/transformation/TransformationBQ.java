package com.ignite.transformation;


import com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.CompanyRegisterLegacy;
import com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.History;
import com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.Latest;
import com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.header.HeaderFields;
import com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.purposingheader.additionalInfo;
import com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.rawfields.RawFields;
import com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.standardisedfields.StandardisedFields;
import com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.standardisedfields.entity.commercial.commercialFields;
import com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.standardisedfields.entity.commercial.identifiers.identifierFields;
import com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.standardisedfields.entity.commercial.legacyids.legacyIdFields;
import com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.standardisedfields.entity.entityFields;
import org.apache.avro.generic.GenericRecord;
import org.apache.beam.sdk.transforms.DoFn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

public class TransformationBQ extends DoFn<GenericRecord, GenericRecord> {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransformationBQ.class);
    @ProcessElement
    public void processElement(@Element GenericRecord genericRecord, ProcessContext processContext) {
        LOGGER.error("genericRecord >>>>> " + genericRecord);
        LOGGER.error("processContext >>>>> " + processContext);
        CompanyRegisterLegacy companyregisteredlegacy = new CompanyRegisterLegacy();
        List<Latest> latest = new ArrayList<>();
        latest.add(getLatest(genericRecord));
        companyregisteredlegacy.setLatest(latest);

        List<History> history = new ArrayList<>();
        history.add(getHistory(genericRecord));
        companyregisteredlegacy.setHistory(history);

        processContext.output(companyregisteredlegacy);
    }

    public Latest getLatest(GenericRecord genericRecord) {
        Latest latest = new Latest();
        latest.setPurposingHeader(getPurposingHeader(genericRecord));
        latest.setRawfields(getRawFields(genericRecord));
        latest.setStandardised(getStandardisedFields(genericRecord));
        latest.setHeader(getHeaderFields(genericRecord));

        return latest;
    }
    public History getHistory(GenericRecord genericRecord) {
        History history = new History();
        history.setPurposingHeader(gethistoryPurposingHeader(genericRecord));
        history.setRawfields(getHistoryRawFields(genericRecord));
        history.setStandardised(getHistoryStandardisedFields(genericRecord));
        history.setHeader(getHistoryHeaderFields(genericRecord));

//        history.setPurposingHeader("NA");
//        history.setRawfields(null);
//        history.setStandardised(null);
        return history;
    }

    public com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.purposingheader.PurposingHeader getPurposingHeader(GenericRecord genericRecord) {
        com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.purposingheader.PurposingHeader purposingHeader = new com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.latest.purposingheader.PurposingHeader();
        List<additionalInfo> additionalInfos = new ArrayList<>();
        purposingHeader.setAdditionalInfo(additionalInfos);
        purposingHeader.setDateReported(null);
        purposingHeader.setMatchKey(null);
        purposingHeader.setRecordUuid(null);
        return purposingHeader;
    }
    public additionalInfo getAdditionalInfo(GenericRecord genericRecord) {
        additionalInfo additionalInfo = new additionalInfo();
        additionalInfo.setKey("NA");
        additionalInfo.setValue("NA");
        return additionalInfo;
    }

        public com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.history.purposingheader.PurposingHeader gethistoryPurposingHeader(GenericRecord genericRecord) {
            com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.history.purposingheader.PurposingHeader purposingHeader = new com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.history.purposingheader.PurposingHeader();
            List<com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.history.purposingheader.additionalInfo> additionalInfos = new ArrayList<>();
            purposingHeader.setAdditionalInfo(additionalInfos);
            purposingHeader.setDateReported(null);
            purposingHeader.setMatchKey(null);
            purposingHeader.setRecordUuid(null);
            return purposingHeader;
        }
        public additionalInfo gethistoryAdditionalInfo(GenericRecord genericRecord) {
            additionalInfo additionalInfo = new additionalInfo();
            additionalInfo.setKey("NA");
            additionalInfo.setValue("NA");
            return additionalInfo;
        }

    public RawFields getRawFields(GenericRecord genericRecord) {
        RawFields rawFields = new RawFields();
        rawFields.setCOMPANYREGISTEREDNUMBER((genericRecord.get("company") != null) ? genericRecord.get("company").toString() : "NA");
        rawFields.setTRANSACTIONTYPE("NA");
        rawFields.setCORRECTIONMARKER("NA");
        rawFields.setGAZETTETYPE("NA");
        rawFields.setORIGINALGAZETTETYPE("NA");
        rawFields.setVOLUNTARYDISSOLUTIONIND("NA");
        rawFields.setDATEINCORPORATED((genericRecord.get("incdate") != null) ? genericRecord.get("incdate").toString() : "NA");
        rawFields.setLATESTACCOUNTDATE((genericRecord.get("acmdate") != null) ? genericRecord.get("acmdate").toString() : "NA");
        rawFields.setLATESTANNUALRETURNDATE((genericRecord.get("anrdate") != null) ? genericRecord.get("anrdate").toString() : "NA");
        rawFields.setGAZETTEPUBLISHEDDATE("NA");
        rawFields.setORIGINALPUBLISHEDDATE("NA");
        rawFields.setDOCUMENTRECEIVEDDATE("NA");
        rawFields.setCOMPANYTYPE((genericRecord.get("cotype") != null) ? genericRecord.get("cotype").toString() : "NA");
        rawFields.setACCOUNTINGREFERENCEDATE((genericRecord.get("acrefdate") != null) ? genericRecord.get("acrefdate").toString() : "NA");
        rawFields.setSTANDARDINDUSTRYCODE1((genericRecord.get("vtc") != null) ? genericRecord.get("vtc").toString() : "NA");
        rawFields.setSTANDARDINDUSTRYCODE2((genericRecord.get("vtc") != null) ? genericRecord.get("vtc").toString() : "NA");
        rawFields.setSTANDARDINDUSTRYCODE3((genericRecord.get("vtc") != null) ? genericRecord.get("vtc").toString() : "NA");
        rawFields.setSTANDARDINDUSTRYCODE4((genericRecord.get("vtc") != null) ? genericRecord.get("vtc").toString() : "NA");
        rawFields.setEUROCOMPANYNUMBER("NA");
        rawFields.setACCOUNTSTYPE((genericRecord.get("acctype") != null) ? genericRecord.get("acctype").toString() : "NA");
        rawFields.setINSPECTIONMARKER((genericRecord.get("inspect") != null) ? genericRecord.get("inspect").toString() : "NA");
        rawFields.setDISSOLVEDMARKER("NA");


        if(genericRecord.get("postcode") != null) {
            rawFields.setPOSTCODE((genericRecord.get("postcode") != "") ? genericRecord.get("postcode").toString() : "NA");
        } else {
            rawFields.setPOSTCODE("NA");
        }

        rawFields.setPOSTCODESTATUS("NA");
        rawFields.setCOUNTRYORIGINCODE((genericRecord.get("countryorigin") != null) ? genericRecord.get("countryorigin").toString() : "NA");
        rawFields.setUPDATEIND("NA");
        rawFields.setPRIVATEFUNDIND("NA");
        rawFields.setTRANSACTIONID("NA");
        rawFields.setJURISDICTION((genericRecord.get("jurisdiction") != null) ? genericRecord.get("jurisdiction").toString() : "NA");


        if(genericRecord.get("name") != null) {
            rawFields.setCOMPANYNAME((genericRecord.get("name") != "") ? genericRecord.get("name").toString() : "NA");
        } else {
            rawFields.setCOMPANYNAME("NA");
        }

        rawFields.setCOMPANYALPHAKEY((genericRecord.get("alpha") != null) ? genericRecord.get("alpha").toString() : "NA");
        rawFields.setDELIMITEDADDRESS("NA");
        rawFields.setFILENAME("NA");
        rawFields.setRUNNUMBER((genericRecord.get("taperef") != null) ? genericRecord.get("taperef").toString() : "NA");
        rawFields.setLOADDATE("NA");
        rawFields.setTAPEDATE((genericRecord.get("tapedate") != null) ? genericRecord.get("tapedate").toString() : "NA");
        rawFields.setCAREOF((genericRecord.get("careof") != null) ? genericRecord.get("careof").toString() : "NA");
        rawFields.setPOBOX((genericRecord.get("pobox") != null) ? genericRecord.get("pobox").toString() : "NA");

        if(genericRecord.get("add1") != null) {
            rawFields.setADDRESSLINE1((genericRecord.get("add1") != "") ? genericRecord.get("add1").toString() : "NA");
        } else {
            rawFields.setADDRESSLINE1("NA");
        }
        if(genericRecord.get("add2") != null) {
            rawFields.setADDRESSLINE2((genericRecord.get("add2") != "") ? genericRecord.get("add2").toString() : "NA");
        } else {
            rawFields.setADDRESSLINE2("NA");
        }

        if(genericRecord.get("add3") != null) {
            rawFields.setCOUNTY((genericRecord.get("add3") != "") ? genericRecord.get("add3").toString() : "NA");
        } else {
            rawFields.setCOUNTY("NA");
        }

        if(genericRecord.get("add4") != null) {
            rawFields.setLOCALITY((genericRecord.get("add4") != "") ? genericRecord.get("add4").toString() : "NA");
        } else {
            rawFields.setLOCALITY("NA");
        }

        return rawFields;
    }

        public com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.history.rawfields.RawFields getHistoryRawFields(GenericRecord genericRecord) {
            com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.history.rawfields.RawFields rawFields = new com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.history.rawfields.RawFields();
            rawFields.setTRANSACTIONTYPE("NA");
            rawFields.setGAZETTEPUBLISHEDDATE((genericRecord.get("edate") != null) ? genericRecord.get("edate").toString() : "NA");
            rawFields.setCORRECTIONMARKER("NA");
            rawFields.setDOCUMENTRECEIVEDDATE("NA");
            return rawFields;

        }

        public StandardisedFields getStandardisedFields(GenericRecord genericRecord) {
        StandardisedFields standardisedFields = new StandardisedFields();
        standardisedFields.setPROCESSINGDATE("NA");
        standardisedFields.setADDRESSHOUSENUMBER("NA");
        standardisedFields.setADDRESSSTREET("NA");
        standardisedFields.setADDRESSAREA("NA");
        standardisedFields.setADDRESSPOSTTOWN("NA");
        standardisedFields.setADDRESSREGION("NA");
        standardisedFields.setADDRESSCOUNTRY("NA");
        standardisedFields.setADDRESSPOSTCODE("NA");
        standardisedFields.setADDRESSCAREOF("NA");
        standardisedFields.setADDRESSSUPPLIEDCOMPANYNAME("NA");
        standardisedFields.setADDRESSPOBOX("NA");
        standardisedFields.setFORMATOFSUPPLY("NA");
        standardisedFields.setMIGRATIONFLAG("NA");
        standardisedFields.setDATEOFRESTORE("NA");
        standardisedFields.setTAPEREFERENCENUMBER("NA");
        return standardisedFields;
    }
        public com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.history.standardisedfields.StandardisedFields getHistoryStandardisedFields(GenericRecord genericRecord) {
            com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.history.standardisedfields.StandardisedFields standardisedFields = new com.equifax.fabric.uk.purposing.companies.companyregisterlegacy.history.standardisedfields.StandardisedFields();

            if(genericRecord.get("name") != null) {
                standardisedFields.setCOMPANYNAME((genericRecord.get("name") != "") ? genericRecord.get("name").toString() : "NA");
            } else {
                standardisedFields.setCOMPANYNAME("NA");
            }

            standardisedFields.setPROCESSINGDATE((genericRecord.get("sdate") != null) ? genericRecord.get("sdate").toString() : "NA");

            if(genericRecord.get("add1") != null) {
                standardisedFields.setADDRESSHOUSENUMBER((genericRecord.get("add1") != "") ? genericRecord.get("add1").toString() : "NA");
            } else {
                standardisedFields.setADDRESSHOUSENUMBER("NA");
            }

            if(genericRecord.get("add2") != null) {
                standardisedFields.setADDRESSSTREET((genericRecord.get("add2") != "") ? genericRecord.get("add2").toString() : "NA");
            } else {
                standardisedFields.setADDRESSSTREET("NA");
            }
            standardisedFields.setADDRESSAREA((genericRecord.get("locality") != null) ? genericRecord.get("locality").toString() : "NA");
            standardisedFields.setADDRESSPOSTTOWN((genericRecord.get("town") != null) ? genericRecord.get("town").toString() : "NA");
            standardisedFields.setADDRESSREGION((genericRecord.get("county") != null) ? genericRecord.get("county").toString() : "NA");
            standardisedFields.setADDRESSCOUNTRY("NA");

            if(genericRecord.get("postcode") != null) {
                standardisedFields.setADDRESSPOSTCODE((genericRecord.get("postcode") != "") ? genericRecord.get("postcode").toString() : "NA");
            } else {
                standardisedFields.setADDRESSPOSTCODE("NA");
            }

            standardisedFields.setADDRESSCAREOF((genericRecord.get("careof") != "") ? genericRecord.get("careof").toString() : "NA");
            standardisedFields.setADDRESSSUPPLIEDCOMPANYNAME("NA");
            standardisedFields.setADDRESSPOBOX((genericRecord.get("pobox") != "") ? genericRecord.get("pobox").toString() : "NA");
            return standardisedFields;
        }

        public entityFields getEntityFields(GenericRecord genericRecord) {
            entityFields entityFields = new entityFields();
            entityFields.setCommercial(getCommercialFields(genericRecord));
            return entityFields;
        }

    public commercialFields getCommercialFields(GenericRecord genericRecord) {
        commercialFields commercialFields = new commercialFields();
        commercialFields.setIdentifiers(getIdentifierFields(genericRecord));
        commercialFields.setLegacyIds(getLegacyIdFields(genericRecord));
        commercialFields.setWebsite(Map.of("NA","NA"));
        commercialFields.setPhones(Map.of("NA","NA"));
        commercialFields.setAddresses(Map.of("NA","NA"));
        commercialFields.setNames(Map.of("NA","NA"));
        return commercialFields;
    }

    public identifierFields getIdentifierFields(GenericRecord genericRecord) {
        identifierFields identifierFields = new identifierFields();
        identifierFields.setNAMEBUSINESSCOMPANYTYPE("NA");
        identifierFields.setIDENTIFIERBUSINESSVAT("NA");
        identifierFields.setIDENTIFIERBUSINESSEMAIL("NA");
        identifierFields.setIDENTIFIERDISSOLVEDDATE("NA");
        identifierFields.setIDENTIFIERINCORPORATIONDATE("NA");
        identifierFields.setIDENTIFIERUPDATEDATE("NA");
        identifierFields.setIDENTIFIERDATASOURCE("NA");
        return identifierFields;
    }

    public legacyIdFields getLegacyIdFields(GenericRecord genericRecord) {
        legacyIdFields legacyIdFields = new legacyIdFields();
        legacyIdFields.setLEGACYIDCOMPANYREGISTEREDNUMBER("NA");
        return legacyIdFields;
    }
    public HeaderFields getHeaderFields(GenericRecord genericRecord) {
        HeaderFields headerFields = new HeaderFields();
        headerFields.setSUPPLIEDDATE("NA");
        return headerFields;
    }
        public HeaderFields getHistoryHeaderFields(GenericRecord genericRecord) {
            HeaderFields headerFields = new HeaderFields();
            headerFields.setSUPPLIEDDATE("NA");
            return headerFields;
        }
    public static class IgniteTransformationException extends RuntimeException {
        public IgniteTransformationException(String message, Throwable cause) {
            super(message, cause);
        }
    }

}





