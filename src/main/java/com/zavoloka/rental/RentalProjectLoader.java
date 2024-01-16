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
                    long id = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    String location = resultSet.getString("location");
                    int bedrooms = resultSet.getInt("bedrooms");
                    boolean availableForRent = resultSet.getBoolean("availableForRent");
                    int rentPrice = resultSet.getInt("rentPrice");
                    double rentAmount = resultSet.getDouble("rentAmount");

                    Property property = new Property(id, name, location, bedrooms, availableForRent, rentPrice, rentAmount);
                    properties.add(property);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your project's needs
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
            e.printStackTrace(); // Handle the exception according to your project's needs
        }

        return clients;
    }

    public static void main(String[] args) {
        List<Property> properties = loadProperties();
        List<Client> clients = loadClients();

        System.out.println(properties);
        System.out.println(clients);
        // Use the loaded properties and clients in your project as needed
    }
}
