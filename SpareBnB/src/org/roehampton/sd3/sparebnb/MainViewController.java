package org.roehampton.sd3.sparebnb;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller class for the Main View of the SpareBnB application.
 * This class handles user interactions, initializes data, and updates the UI components.
 */
public class MainViewController {

    // UI components injected from the FXML file
    @FXML private ListView<User> userListView; // List view to display users
    @FXML private ListView<Accommodation> accommodationListView; // List view to display accommodations
    @FXML private TextArea detailsTextArea; // Text area to show details and messages
    @FXML private TextField nightsField; // Input field for number of nights

    // Map to store accommodations using their ID as the key for easy lookup
    private Map<Integer, Accommodation> accommodationsMap = new HashMap<>();

    /**
     * Initializes the controller class.
     * This method is automatically called after the FXML file has been loaded.
     */
    @FXML
    public void initialize() {
        // Initialize a list of Users with dummy data
        ObservableList<User> users = FXCollections.observableArrayList(
                new User(1, "Kyle Smith", "kyle@example.com", "pass123"),
                new User(2, "Jessica Johnson", "jessica@example.com", "pass456"),
                new User(3, "Cody Byron", "cody@example.com", "pass789")
        );
        // Set the items of the userListView to the created list
        userListView.setItems(users);

        // Initialize Accommodations using the Factory pattern
        Accommodation hotel = NewAccommodation.createAccommodation("Hotel");
        Accommodation flat = NewAccommodation.createAccommodation("Flat");
        Accommodation cabin = NewAccommodation.createAccommodation("Cabin");
        Accommodation luxuryVilla = NewAccommodation.createAccommodation("LuxuryVilla");

        // Add the created accommodations to the map
        accommodationsMap.put(hotel.getAccommodationID(), hotel);
        accommodationsMap.put(flat.getAccommodationID(), flat);
        accommodationsMap.put(cabin.getAccommodationID(), cabin);
        accommodationsMap.put(luxuryVilla.getAccommodationID(), luxuryVilla);

        // Add facilities to the Hotel accommodation
        hotel.addFacility(NewFacility.createFacility("LivingRoom"));
        hotel.addFacility(NewFacility.createFacility("Wifi"));
        hotel.addFacility(NewFacility.createFacility("Gym"));

        // Add facilities to the Flat accommodation
        flat.addFacility(NewFacility.createFacility("LivingRoom"));
        flat.addFacility(NewFacility.createFacility("Bedroom"));

        // Add facilities to the Cabin accommodation
        cabin.addFacility(NewFacility.createFacility("LivingRoom"));
        cabin.addFacility(NewFacility.createFacility("Bedroom"));

        // Add facilities to the Luxury Villa accommodation
        luxuryVilla.addFacility(NewFacility.createFacility("LivingRoom"));
        luxuryVilla.addFacility(NewFacility.createFacility("Bedroom"));

        // Populate the accommodationListView with the accommodations from the map
        accommodationListView.setItems(FXCollections.observableArrayList(accommodationsMap.values()));

        // Add a listener to handle selection changes in the accommodationListView
        accommodationListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            // Check if a new item is selected
            if (newVal != null) {
                StringBuilder fullInfo = new StringBuilder();

                // 1. Add General Info about the accommodation
                fullInfo.append(newVal.showAccommodationInfoText()).append("\n\n");

                // 2. Add Specific Info like Star rating, Square footage, etc.
                fullInfo.append("--- Specific Details ---\n");
                fullInfo.append(newVal.showSpecificInfo()).append("\n\n");

                // 3. Add the facilities information
                fullInfo.append("--- Included Facilities ---\n");
                if (newVal.getFacilities().isEmpty()) {
                    fullInfo.append("No facilities listed for this accommodation.");
                } else {
                    // Iterate through facilities and append their info
                    for (Facility f : newVal.getFacilities()) {
                        fullInfo.append(f.viewFacilityInfo()).append("\n");
                        fullInfo.append("--------------------------\n");
                    }
                }

                // Update the detailsTextArea with the constructed information string
                detailsTextArea.setText(fullInfo.toString());
            }
        });

        // Display info when an accommodation is selected.
        // Note: This second listener might overwrite the detailed info set by the previous listener.
        // Consider removing this block if the detailed view above is preferred.
        accommodationListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                // Set text area to show basic accommodation info and specific info
                // detailsTextArea.setText(newVal.showAccommodationInfoText() + "\n" + newVal.showSpecificInfo());
            }
        });
    }

    /**
     * Handles the "Book" button click event.
     * Validates user input and processes the booking.
     */
    @FXML
    protected void onBookButtonClick() {
        // Retrieve the selected user and accommodation from the list views
        User selectedUser = userListView.getSelectionModel().getSelectedItem();
        Accommodation selectedAcc = accommodationListView.getSelectionModel().getSelectedItem();

        // Validate that both a user and an accommodation have been selected
        if (selectedUser == null || selectedAcc == null) {
            detailsTextArea.setText("Error: Please select both a user and an accommodation.");
            return; // Exit the method if validation fails
        }

        // Check if the selected accommodation is already booked
        if (selectedAcc.getIsBooked()) {
            detailsTextArea.setText("Error: Accommodation ID " + selectedAcc.getAccommodationID() + " is already booked.");
            return; // Exit the method if accommodation is not available
        }

        try {
            // Parse the number of nights from the input field
            int nights = Integer.parseInt(nightsField.getText());
            
            // Calculate the total price based on the number of nights
            double total = selectedAcc.calculateTotalPrice(nights);
            
            // Perform the booking operation on the accommodation
            selectedAcc.bookAccommodation();

            // Display a success message with the user's name and total price
            detailsTextArea.setText("Booking Successful!\n" +
                    "User: " + selectedUser.getname() + "\n" +
                    "Total Price: £" + total);
        } catch (NumberFormatException e) {
            // Handle the case where the nights input is not a valid integer
            detailsTextArea.setText("Error: Please enter a valid number of nights.");
        }
    }
}
