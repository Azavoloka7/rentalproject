package com.zavoloka.rental;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RentalProjectGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Rental Project");

        // Create labels and text fields for client information
        Label nameLabel = new Label("Client Name:");
        TextField nameField = new TextField();

        Label durationLabel = new Label("Rental Duration (days):");
        TextField durationField = new TextField();

        Label rentalTypeLabel = new Label("Rental Type:");
        TextField rentalTypeField = new TextField();

        // Create a button to submit the rental request
        Button submitButton = new Button("Submit Request");
        submitButton.setOnAction(e -> submitRequest(nameField.getText(), durationField.getText(), rentalTypeField.getText()));

        // Layout setup using VBox
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(nameLabel, nameField, durationLabel, durationField, rentalTypeLabel, rentalTypeField, submitButton);

        // Set up the scene
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    private void submitRequest(String clientName, String rentalDuration, String rentalType) {
        // Validate input (you can add more validation as needed)
        if (clientName.isEmpty() || rentalDuration.isEmpty() || rentalType.isEmpty()) {
            showError("Please fill in all fields.");
            return;
        }

        // Process rental request (you can add your own logic here)
        // For now, just display a message
        String message = String.format("Rental request submitted for %s.%nDuration: %s days%nRental Type: %s", clientName, rentalDuration, rentalType);
        showInfo("Success", message);
    }

    private void showError(String message) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showInfo(String title, String message) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
