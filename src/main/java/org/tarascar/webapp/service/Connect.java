package org.tarascar.webapp.service;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class Connect {

    public static Connection getConnection() {
        java.sql.Connection connection = null;
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection("jdbc:derby:d:/temp/db/simplewebcar;");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

}
