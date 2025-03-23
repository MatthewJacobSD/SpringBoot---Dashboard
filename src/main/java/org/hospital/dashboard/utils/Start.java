package org.hospital.dashboard.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class Start implements ApplicationRunner {

    private final Server server;

    @Autowired
    public Start(Server server) {
        this.server = server;
    }

    @Override
    public void run(ApplicationArguments args) {
        // Start the server when the application runs
        server.startServer();

        // Connection testing
        Connection conn = Database.getConnection();
        if (conn != null) {
            try {
                // Create a statement to execute SQL queries
                Statement stmt = conn.createStatement();

                // Execute the SQL query to show tables
                String sql = "SHOW TABLES";
                ResultSet rs = stmt.executeQuery(sql);

                // Display the tables
                System.out.println("Tables in the 'hospital' database:");
                while (rs.next()) {
                    String tableName = rs.getString(1); // Get the first column (table name)
                    System.out.println(tableName);
                }

                // Close the result set and statement
                rs.close();
                stmt.close();
            } catch (SQLException e) {
                System.err.println("Error fetching tables: " + e.getMessage());
            }
//            finally {
//                // Close the database connection
//                Database.closeConnection(conn);
//            }
        }
    }
}