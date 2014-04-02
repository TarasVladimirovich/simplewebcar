package org.tarascar.webapp.service;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class CreateDB extends Connect {

    private List<String> loadStatements(String resource) throws IOException {
        InputStream res = this.getClass().getResourceAsStream(resource);
        BufferedReader reader = new BufferedReader(new InputStreamReader(res));
        StringBuilder strb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            if (line.trim().startsWith("--")) {
                continue;
            }
            strb.append(line).append("\n");
        }
        return Arrays.asList(strb.toString().split(";"));
    }

    public void createDB(String resource) {
        java.sql.Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            List<String> statments = loadStatements(resource);
            for (String statement : statments) {
                if (StringUtils.isBlank(statement)) {
                    continue;
                }
                preparedStatement = connection.prepareStatement(statement);
                preparedStatement.execute();
            }
            connection.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
            }
        }
    }
}