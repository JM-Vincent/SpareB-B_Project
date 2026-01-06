package org.roehampton.sd3.sparebnb;

import java.util.Scanner; // This Java module allow users to input data.
import java.util.Map;       // Import Map for storing accommodations details.
import java.util.HashMap;   // Import HashMap to create the Map.

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // --- User data that is created.
        User user1 = new User(1, "Kyle Smith", "kyle@example.com", "pass123");
        User user2 = new User(2, "Jessica Johnson", "jessica@example.com", "pass456");
        User user3 = new User(3, "Cody Byron", "cody@example.com", "pass789");

        System.out.println("--- Users Created ---");
        user1.getUserInfo();
        user2.getUserInfo();
        user3.getUserInfo();
        System.out.println("\n--------------------------------------\n");

        // --- Her it selects a User for the booking.
        System.out.println("\n--- Select a User for the Booking ---");
        user1.getUserInfo();
        user2.getUserInfo();
        user3.getUserInfo();

        User selectedUser = null;
        while (selectedUser == null) {
            System.out.print("\nEnter the User ID for the booking: ");
            int userId = scan.nextInt();
            scan.nextLine(); // consume newline

            switch(userId) {
                case 1:
                    selectedUser = user1;
                    break;
                case 2:
                    selectedUser = user2;
                    break;
                case 3:
                    selectedUser = user3;
                    break;
                default:
                    System.out.println("Invalid User ID. Please try again.");
            }
        }

        System.out.println("\n--- Selected User ---");
        selectedUser.getUserInfo();

        System.out.println("\nHere is the accommodation information.");
        System.out.println("\n");

        // -----------------------------------------------------------------------------------------------------------
        // Here the code creates the accommodation objects from the NewAccommodation class.
        // -----------------------------------------------------------------------------------------------------------
        Accommodation hotel = NewAccommodation.createAccommodation("Hotel");
        Accommodation flat = NewAccommodation.createAccommodation("Flat");
        Accommodation cabin = NewAccommodation.createAccommodation("Cabin");
        Accommodation luxuryVilla = NewAccommodation.createAccommodation("LuxuryVilla");

        // Creates a new HashMap that links integer key to accommodation value.
        // This code replaces the big if-else block that is at the end.
        Map<Integer, Accommodation> accommodations = new HashMap<>();
        accommodations.put(hotel.getAccommodationID(), hotel);
        accommodations.put(flat.getAccommodationID(), flat);
        accommodations.put(cabin.getAccommodationID(), cabin);
        accommodations.put(luxuryVilla.getAccommodationID(), luxuryVilla);

        // -----------------------------------------------------------------------------------------------------------
        // This section is outputting the display info & add Facilities data.
        // -----------------------------------------------------------------------------------------------------------

        System.out.println("-------------Hotel info--------------");
        hotel.showAccommodationInfo();
        System.out.println(hotel.showSpecificInfo()); // Cast to call specific method
        System.out.println("\n-------------Hotel Facilities-------------");
        hotel.addFacility(NewFacility.createFacility("LivingRoom")); // Uses NewFactory here.
        hotel.addFacility(NewFacility.createFacility("Wifi"));
        hotel.addFacility(NewFacility.createFacility("Gym"));
        Facility facility = hotel.getFacilities().getFirst();
        System.out.println(facility.viewFacilityInfo());
        System.out.println("\n");

        System.out.println("-------------Flat info--------------");
        flat.showAccommodationInfo();
        System.out.println(flat.showSpecificInfo()); // Cast
        System.out.println("\n-------------Flat Facilities-------------");
        flat.addFacility(NewFacility.createFacility("LivingRoom"));
        flat.addFacility(NewFacility.createFacility("Bedroom"));
        Facility facility2 = flat.getFacilities().getFirst();
        System.out.println(facility2.viewFacilityInfo());
        System.out.println("\n");

        System.out.println("------------Cabin Info------------");
        cabin.showAccommodationInfo();
        System.out.println(cabin.showSpecificInfo());
        System.out.println("\n-------------Cabin Facilities-------------");
        cabin.addFacility(NewFacility.createFacility("LivingRoom"));
        cabin.addFacility(NewFacility.createFacility("Bedroom"));
        Facility facility3 = cabin.getFacilities().getFirst();
        System.out.println(facility3.viewFacilityInfo());
        System.out.println("\n");

        System.out.println("------------Luxury Villa info--------------");
        luxuryVilla.showAccommodationInfo();
        System.out.println(luxuryVilla.showSpecificInfo()); // Cast
        System.out.println("\n-------------Luxury Villa Facilities-------------");
        luxuryVilla.addFacility(NewFacility.createFacility("LivingRoom"));
        luxuryVilla.addFacility(NewFacility.createFacility("Bedroom"));
        Facility facility4 = luxuryVilla.getFacilities().getFirst();
        System.out.println(facility4.viewFacilityInfo());
        System.out.println("\n-----------------------------------------------");

        // ------------------------------------------------------------------------------------
        // The code below is for booking multiple times for testing any conflicts.
        // ------------------------------------------------------------------------------------

        boolean keepBooking = true;

        while (keepBooking) {
            // Select the user by using the 'selectedUser'.

            // 2. Inputs for booking.
            System.out.println("\n-----------------------------------------------");
            System.out.println("Enter the accommodation ID you would like to book (or 0 to exit): ");
            int AccommodationID = scan.nextInt();
            scan.nextLine(); // Consume newline

            if (AccommodationID == 0) {
                keepBooking = false;
                System.out.println("Exiting system. Goodbye!");
                continue; // This skip the rest of the loop.
            }
            // Asks for details of the booking.
            System.out.println("Enter the date you like to check in: ");
            String checkInDate = scan.nextLine();
            System.out.println("Enter the date you like to check out: ");
            String checkOutDate = scan.nextLine();
            System.out.println("Enter the number of guests: ");
            int numberOfGuests = scan.nextInt();
            scan.nextLine();
            System.out.println("Enter the number of nights: ");
            int numberOfNights = scan.nextInt();
            scan.nextLine();

            // If statement for checking any conflict.
            if (accommodations.containsKey(AccommodationID)) {
                Accommodation selectedAcc = accommodations.get(AccommodationID);
                // Check if the accommodation is available.
                if (!selectedAcc.getIsBooked()) {
                    System.out.println("Great! The accommodation is available.");
                    selectedAcc.bookAccommodation(); // Here it's marked as booked.

                    double totalPrice = selectedAcc.calculateTotalPrice(numberOfNights, numberOfGuests);// Calculates the total prices.
                    Booking booking = new Booking(1, selectedAcc, selectedUser, checkInDate, checkOutDate, numberOfNights, numberOfGuests, totalPrice);
                    // Records the booking details ^.
                    System.out.println("\n--- Booking Successful! ---");
                    booking.showBookingInfo();
                } else {
                    // Informs the user that the accommodation is not available.
                    System.out.println("\n[!] Sorry, that accommodation (ID: " + selectedAcc.getAccommodationID() + ") is already booked by another user.");
                }
            } else {
                System.out.println("Invalid accommodation ID");
            }
        }


        // -------------------------------------------------------------------------------------
        // The code above is for the handling booking and any confliction.
        // -------------------------------------------------------------------------------------



        // |-- End of the main class. -|
    }
}
