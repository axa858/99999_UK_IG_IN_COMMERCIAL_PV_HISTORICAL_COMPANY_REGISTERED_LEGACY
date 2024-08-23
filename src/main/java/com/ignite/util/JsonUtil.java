package com.ignite.util;

import com.google.gson.Gson;
import com.ignite.constants.Constants;
import com.ignite.transformation.DataSetConfigDetails;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class JsonUtil {

    private JsonUtil() {
    }

    /**
     * Read DataSet Mapping details
     * from Json file in the
     * resource folder
     *
     * @param name name
     * @return of  type DataSetConfigDetails
     * @throws IOException throws IOException
     */
    public static DataSetConfigDetails readDataSetConfig(String name) throws IOException {
        InputStream inputStream = Thread.currentThread()
                .getContextClassLoader().getResourceAsStream(name);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));) {
            return new Gson().fromJson(bufferedReader
                    .lines().collect(Collectors.joining(
                            Constants.NEW_LINE_DELIMITER)), DataSetConfigDetails.class);
        }
    }

}
