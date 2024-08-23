package com.ignite.util;

import com.google.api.services.bigquery.model.TableRow;
import com.ignite.common.Constants;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.gcp.bigquery.BigQueryIO;
import org.apache.beam.sdk.io.gcp.bigquery.TableRowJsonCoder;
import org.apache.beam.sdk.values.PCollection;
import org.apache.commons.lang3.StringUtils;


public class BigQueryUtil {
    //private static final Logger LOGGER = LogManager.getLogger(BigQueryUtil.class);
    public static PCollection<TableRow> getTableRow(Pipeline pipeline, String project, String dataset,
                                                    String tableName, String partition) {
        if (StringUtils.isNotEmpty(partition)) {
            return pipeline
                    .apply("READ FROM BIGQUERY QUERY",
                            BigQueryIO.readTableRows().from(project + Constants.SEMI_COLON + dataset + Constants.DOT + tableName)
                                    .withMethod(BigQueryIO.TypedRead.Method.DIRECT_READ)
                                    .withRowRestriction("DATE(_PARTITIONTIME) >= \""+partition+"\"")
                                    .withCoder(TableRowJsonCoder.of()));
        } else {
            return pipeline
                    .apply("READ FROM BIGQUERY QUERY",
                            BigQueryIO.readTableRows().from(project + Constants.SEMI_COLON + dataset + Constants.DOT + tableName)
                                    .withMethod(BigQueryIO.TypedRead.Method.DIRECT_READ)
                                    .withCoder(TableRowJsonCoder.of())
                    );
        }

    }

}
