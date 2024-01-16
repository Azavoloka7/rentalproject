package com.zavoloka.rental;

import ch.qos.logback.core.joran.event.BodyEvent;
import com.mysql.cj.BindValue;
import com.zavoloka.rental.model.Property;
import com.zavoloka.rental.model.RentalTransaction;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class RentalProjectGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Rental Project");

        // ... (Existing code)

        // Create TextFields for Name and Duration
        TextField nameField = new TextField();
        TextField durationField = new TextField();
        TextField rentalTypeField = new TextField();  // Assuming this is the correct control

        // Create a button to submit the rental request
        Button submitButton = new Button("Submit Request");
        BindValue propertyComboBox=null;
        submitButton.setOnAction(e -> submitRequest(nameField.getText(), durationField.getText(),
                rentalTypeField.getText(), (Property) propertyComboBox.getValue()));

        // ... (Existing code)
    }
    private void submitRequest(String clientName, String rentalDuration, String rentalType, Property selectedProperty) {
        // Validate input
        if (clientName.isEmpty() || rentalDuration.isEmpty() || rentalType.isEmpty()) {
            showError("Please fill in all fields.");
            return;
        }

        // Process rental request
        // Create a RentalRequest object using the input data
        RentalTransaction rentalTransaction = new RentalTransaction(clientName, rentalDuration, rentalType, selectedProperty);

        // For now, just display a message
        String message = "Rental request submitted:\n" + rentalTransaction.toString();
        showInfo("Success", message);
    }

    private void showError(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }

    private void showInfo(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void loadProperties(ComboBox<Property> propertyComboBox) {
        // ... (Existing code)
    }

    // ... (Existing code)
}
