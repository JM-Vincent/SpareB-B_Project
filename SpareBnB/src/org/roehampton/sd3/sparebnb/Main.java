package org.roehampton.sd3.sparebnb;

import java.util.Scanner; // This Java module allow users to input data.
import java.util.Map;       // Import Map for storing accommodations
import java.util.HashMap;   // Import HashMap to create the Map

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // --- Users Created (Requirement #6) ---
        User user1 = new User(1, "Alice Smith", "alice@example.com", "pass123");
        User user2 = new User(2, "Bob Johnson", "bob@example.com", "pass456");
        User user3 = new User(3, "Charlie Brown", "charlie@example.com", "pass789");

        System.out.println("--- Users Created ---");
        user1.getUserInfo();
        user2.getUserInfo();
        user3.getUserInfo();
        System.out.println("\n--------------------------------------\n");

        // --- Select a User for the Booking (Your code) ---
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
        // Create accommodation objects (Your Factory)
        // -----------------------------------------------------------------------------------------------------------
        Accommodation hotel = NewAccommodation.CreateAccommodation("Hotel");
        Accommodation flat = NewAccommodation.CreateAccommodation("Flat");
        Accommodation cabin = NewAccommodation.CreateAccommodation("Cabin");
        Accommodation luxuryVilla = NewAccommodation.CreateAccommodation("LuxuryVilla");

        // --- NEW: Store accommodations in a Map ---
        // This replaces the big if-else block at the end
        Map<Integer, Accommodation> accommodations = new HashMap<>();
        accommodations.put(hotel.getAccommodationID(), hotel);
        accommodations.put(flat.getAccommodationID(), flat);
        accommodations.put(cabin.getAccommodationID(), cabin);
        accommodations.put(luxuryVilla.getAccommodationID(), luxuryVilla);

        // -----------------------------------------------------------------------------------------------------------
        // Display Info & Add Facilities (Your code)
        // -----------------------------------------------------------------------------------------------------------

        System.out.println("-------------Hotel info--------------");
        hotel.showAccommodationInfo();
        System.out.println(hotel.showSpecificInfo()); // Cast to call specific method
        System.out.println("\n-------------Hotel Facilities-------------");
        hotel.addFacility(new Facility(1, "Living Room", "TV"));
        hotel.addFacility(new Facility(2, "Wifi", "Internet"));
        hotel.addFacility(new Facility(3, "Gym", "Gym equipment"));
        Facility facility = hotel.getFacilities().getFirst();
        System.out.println(facility.viewFacilityInfo());
        System.out.println("\n");

        System.out.println("-------------Flat info--------------");
        flat.showAccommodationInfo();
        System.out.println(flat.showSpecificInfo()); // Cast
        System.out.println("\n-------------Flat Facilities-------------");
        flat.addFacility(new Facility(1, "Living Room", "TV"));
        flat.addFacility(new Facility(2, "Bedroom", "Air condition"));
        Facility facility2 = flat.getFacilities().getFirst();
        System.out.println(facility2.viewFacilityInfo());
        System.out.println("\n");

        System.out.println("------------Cabin Info------------");
        cabin.showAccommodationInfo();
        System.out.println(cabin.showSpecificInfo());
        System.out.println("\n-------------Cabin Facilities-------------");
        cabin.addFacility(new Facility(1, "Living Room", "TV"));
        cabin.addFacility(new Facility(2, "Bedroom", "Air condition"));
        Facility facility3 = cabin.getFacilities().getFirst();
        System.out.println(facility3.viewFacilityInfo());
        System.out.println("\n");

        System.out.println("------------Luxury Villa info--------------");
        luxuryVilla.showAccommodationInfo();
        System.out.println(luxuryVilla.showSpecificInfo()); // Cast
        System.out.println("\n-------------Luxury Villa Facilities-------------");
        luxuryVilla.addFacility(new Facility(1, "Living Room", "TV"));
        luxuryVilla.addFacility(new Facility(2, "Bedroom", "Air condition"));
        Facility facility4 = luxuryVilla.getFacilities().getFirst();
        System.out.println(facility4.viewFacilityInfo());
        System.out.println("\n-----------------------------------------------");

        // ------------------------------------------------------------------------------------
        // Booking Details (Your code)
        // ------------------------------------------------------------------------------------
        System.out.println("\nEnter the accommodation ID you would like to book: ");
        int AccommodationID = scan.nextInt();
        scan.nextLine(); // Consume newline
        System.out.println("Enter the date you like to check in: ");
        String CheckInDate = scan.nextLine();
        System.out.println("Enter the date you like to check out: ");
        String CheckOutDate = scan.nextLine();
        System.out.println("Enter the number of guests: ");
        int NumberOfGuests = scan.nextInt();
        scan.nextLine(); // Consume newline
        System.out.println("Enter the number of nights: ");
        int NumberOfNights = scan.nextInt();
        scan.nextLine(); // Consume newline

        // -------------------------------------------------------------------------------------
        // --- NEW BOOKING LOGIC (replaces if-else) ---
        // This adds the booking conflict check (Requirement #8)
        // -------------------------------------------------------------------------------------

        if (accommodations.containsKey(AccommodationID)) {
            // 1. Get the accommodation the user wants
            Accommodation selectedAcc = accommodations.get(AccommodationID);

            // 2. CHECK IF IT'S ALREADY BOOKED (Requirement #8)
            if (!selectedAcc.getIsBooked()) {
                System.out.println("Great! The accommodation is available.");

                // 3. Mark it as booked
                selectedAcc.bookAccommodation();

                // 4. Calculate price and create the booking
                double TotalPrice = selectedAcc.calculateTotalPrice(NumberOfNights);
                Booking booking = new Booking(1, selectedAcc, selectedUser, CheckInDate, CheckOutDate, NumberOfNights, NumberOfGuests, TotalPrice);

                System.out.println("\n--- Booking Successful! ---");
                booking.showBookingInfo();
            } else {
                // 5. POLITELY INFORM USER IT'S UNAVAILABLE (Requirement #8)
                System.out.println("\nSorry, that accommodation (ID: " + selectedAcc.getAccommodationID() + ") is already booked.");
            }
        } else {
            System.out.println("Invalid accommodation ID");
        }

        // --- End of main ---
    }
}
