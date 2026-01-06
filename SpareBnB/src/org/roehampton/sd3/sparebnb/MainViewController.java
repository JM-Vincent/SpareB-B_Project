package org.roehampton.sd3.sparebnb;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;



/**
 * Controller class for the Main View of the SpareBnB application.
 * This class handles user interactions, initializes data, and updates the UI components.
 */
public class MainViewController {

    // UI components injected from the FXML file
    @FXML private ListView<User> userListView; // List for viewing to display users.
    @FXML private ListView<Accommodation> accommodationListView; // List view to display accommodations
    @FXML private TextArea detailsTextArea; // Text area is used to show details and messages.
    @FXML private TextField nightsField; // The input field is used for number of nights.
    @FXML private TextField guestsField; // The input field is for getting n.o. guests.
    @FXML private DatePicker checkInPicker; // Show date options.



    // The map is used to store accommodations using their ID as the key for easy lookup.
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

        // This adds facilities to the Hotel accommodation.
        hotel.addFacility(NewFacility.createFacility("LivingRoom"));
        hotel.addFacility(NewFacility.createFacility("Wifi"));
        hotel.addFacility(NewFacility.createFacility("Gym"));

        // This adds facilities to the Flat accommodation.
        flat.addFacility(NewFacility.createFacility("LivingRoom"));
        flat.addFacility(NewFacility.createFacility("Bedroom"));

        // This adds facilities to the Cabin accommodation.
        cabin.addFacility(NewFacility.createFacility("LivingRoom"));
        cabin.addFacility(NewFacility.createFacility("Bedroom"));

        // This adds facilities to the Luxury Villa accommodation.
        luxuryVilla.addFacility(NewFacility.createFacility("LivingRoom"));
        luxuryVilla.addFacility(NewFacility.createFacility("Bedroom"));

        // Populate the accommodationListView with the accommodations from the map
        accommodationListView.setItems(FXCollections.observableArrayList(accommodationsMap.values()));

        // Add a listener to handle selection changes in the accommodationListView
        accommodationListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            // Check if a new item is selected.
            if (newVal != null) {
                StringBuilder fullInfo = new StringBuilder();

                // Add General Info about the accommodation.
                fullInfo.append(newVal.showAccommodationInfoText()).append("\n\n");

                // Adds the facility information.
                fullInfo.append("--- Included Facilities ---\n");

                // Use Java Streams to process the facilities list
                String facilitiesInfo = newVal.getFacilities().stream()
                        .map(f -> f.viewFacilityInfo() + "\n--------------------------")
                        .collect(java.util.stream.Collectors.joining("\n"));

                if (facilitiesInfo.isEmpty()) {
                    fullInfo.append("No facilities listed for this accommodation.");
                } else {
                    fullInfo.append(facilitiesInfo);
                }


                // Update the detailsTextArea with the constructed information string
                detailsTextArea.setText(fullInfo.toString());
            }
        });

        // Display info when accommodation is selected.

        accommodationListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                // Set text area to show basic accommodation info and specific info
                // detailsTextArea.setText(newVal.showAccommodationInfoText() + "\n" + newVal.showSpecificInfo());
            }
        });
    }

    /**
     * Handles the "Book" button click event. +
     * Validates user input and processes the booking.
     */
    @FXML
    protected void onBookButtonClick() {
        // Retrieve the selected user and accommodation from the list views
        User selectedUser = userListView.getSelectionModel().getSelectedItem();
        Accommodation selectedAcc = accommodationListView.getSelectionModel().getSelectedItem();

        // The IF statement validates that both a user and an accommodation have been selected.
        if (selectedUser == null || selectedAcc == null) {
            detailsTextArea.setText("Error: Please select both a user and an accommodation.");
            return; // Exit the method if validation fails
        }

        // Here it checks if the selected accommodation is already booked.
        if (selectedAcc.getIsBooked()) {
            detailsTextArea.setText("Error: Accommodation ID " + selectedAcc.getAccommodationID() + " is already booked.");
            return; // Here is exits the method if accommodation is not available.
        }

        try {
            // Parse the number of nights from the input field
            int nights = Integer.parseInt(nightsField.getText());
            int guests = Integer.parseInt(guestsField.getText());
            
            // Here it calculates the total price based on the number of nights.
            double total = selectedAcc.calculateTotalPrice(nights, guests);
            selectedAcc.bookAccommodation();
            
            // This line performs the booking operation on the accommodation.
            selectedAcc.bookAccommodation();

            LocalDate checkInDate = checkInPicker.getValue();
            LocalDate checkOutDate = (checkInDate != null) ? checkInDate.plusDays(nights) : null;

            // This line of code displays a success message with the user's name and total price.
            detailsTextArea.setText("Booking Successful!\n" +
                    "User: " + selectedUser.getName() + "\n" +
                    "Dates: " + (checkInDate != null ? checkInDate : "Not selected") + " to " + (checkOutDate != null ? checkOutDate : "N/A") + "\n" +
                    "Guests: " + guests + "\n" +
                    "Nights: " + nights + "\n" +
                    "Total Price: £" + total);

        } catch (NumberFormatException e) {
            // This handles the case where the nights input is not a valid integer.
            detailsTextArea.setText("Error: Please enter a valid number for nights and guests.");
        }
    }
}
