package com.zavoloka.rental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class DatabaseConnection {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3308/rental_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Z@v010ka";

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error loading MySQL JDBC driver", e);
        }
    }

    private DatabaseConnection() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException("Error connecting to the database", e);
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException("Error closing the database connection", e);
            } finally {
                connection = null;
            }
        }
    }

    // Adding equals, hashCode, and toString methods



    @Override
    public int hashCode() {
        return Objects.hash(connection);
    }

    @Override
    public String toString() {
        return "DatabaseConnection{" +
                "connection=" + connection +
                '}';
    }
}
