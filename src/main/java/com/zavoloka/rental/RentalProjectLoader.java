package com.zavoloka.rental;

import com.zavoloka.rental.model.Client;
import com.zavoloka.rental.model.Property;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentalProjectLoader {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3308/rentalproject";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Z@v010ka";

    public static List<Property> loadProperties() {
        List<Property> properties = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String query = "SELECT * FROM Property";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    long propertyId = resultSet.getLong("Id");
                    String name = resultSet.getString("name");
                    String location = resultSet.getString("location");
                    int bedrooms = resultSet.getInt("bedrooms");
                    boolean isAvailable = resultSet.getBoolean("isAvailable");
                    int rentPrice = resultSet.getInt("rentPrice");
                    BigDecimal dailyRate = resultSet.getBigDecimal("dailyRate");
                    BigDecimal rentAmount = resultSet.getBigDecimal("rentAmount");

                    Property property = new Property(propertyId, name, location, bedrooms, isAvailable, rentPrice, dailyRate, rentAmount);
                    properties.add(property);
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }

        return properties;
    }

    public static List<Client> loadClients() {
        List<Client> clients = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String query = "SELECT * FROM Client";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    long clientId = resultSet.getLong("clientId");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String phoneNumber = resultSet.getString("phoneNumber");
                    BigDecimal balance = resultSet.getBigDecimal("balance");

                    Client client = new Client(clientId, name, email, phoneNumber, balance);
                    clients.add(client);
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }

        return clients;
    }

    public static void main(String[] args) {
        List<Property> properties = loadProperties();
        List<Client> clients = loadClients();

        if (!clients.isEmpty()) {
            Client seventhClient = clients.get(6);

            // Set the daily rate and number of days
            BigDecimal dailyRate = BigDecimal.valueOf(10000);
            int numberOfDays = 5; // Adjust the number of days as needed

            // Calculate the total rental cost
            BigDecimal rentalCost = seventhClient.calculateRentalCost(numberOfDays, dailyRate);

            // Rent the item using the calculated cost
            seventhClient.rentItem(rentalCost);

            System.out.println(seventhClient);
        } else {
            System.out.println("No clients loaded.");
        }
    }

    private static void handleSQLException(SQLException e) {
        // Handle the exception based on your application's requirements
        e.printStackTrace();
    }
}
