package org.hospital.dashboard.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final Logger log = LoggerFactory.getLogger(Database.class);

    private static final String url = "jdbc:mariadb://localhost:3306/hospital";
    private static final String user = "root";
    private static final String password = "root";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            log.info("\n✔️ Database connection established");
            return conn;
        } catch (SQLException connection) {
            log.error("\n✖️ Database connection failed, Check this errors {}", connection.getMessage());
        }
        return null;
    }

    public static void closeConnection(Connection conn) {
        try {
            conn.close();
            log.info("\n✔️ Database connection ended");
        } catch (SQLException connection) {
            log.error("\n✖️ Database closure interrupted, Check this errors {}", connection.getMessage());
        }
    }

}
