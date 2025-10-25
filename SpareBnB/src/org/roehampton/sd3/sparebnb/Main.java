package org.roehampton.sd3.sparebnb;
import java.util.Scanner; // This Java module allow users to input data.

public class Main {
    public static void main(String[] args) {
        // The scanner is used to get user input. ---------------------------------------------
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to SpareBnB.");
        System.out.println("Please enter your name: ");
        String name = scan.nextLine();
        System.out.println("Please enter your email: ");
        String email = scan.nextLine();
        System.out.println("Please enter your password: ");
        String password = scan.nextLine();
        User user = new User(1, name, email, password);
        user.getUserInfo();

        System.out.println("Here is the accommodation information.");

        System.out.println("\n");

        // -----------------------------------------------------------------------------------------------------------
        // The code below creates accommodation objects and displays their information.
        // -----------------------------------------------------------------------------------------------------------

        System.out.println("-------------Hotel info--------------");

        // Create a hotel object and display its information.
        Hotel hotel = new Hotel(1,"Hotel",100.00,"123 Main St", 5, "Single", true, "Hotel Chain" );
        hotel.showAccommodationInfo();
        System.out.println(hotel.showHotelInfo());
        System.out.println("\n");

        System.out.println("-------------Hotel Facilities-------------");

        // The code below adds facilities to the hotel.
        hotel.addFacility(new Facility(1, "Living Room", "TV"));
        hotel.addFacility(new Facility(2, "Wifi", "Internet"));
        hotel.addFacility(new Facility(3, "Gym", "Gym equipment"));

        Facility facility = hotel.getFacilities().getFirst(); // The first facility is retrieved from the hotel.
        System.out.println(facility.viewFacilityInfo()); // The method viewFacilityInfo() is called to display the facility information.

        System.out.println("\n");
        System.out.println("-------------Flat info--------------");

        // Create a flat object and display its information.
        Flat flat = new Flat(2,"Flat",30.00,"456 Elm St", 2, 2, 5, true, true );
        flat.showAccommodationInfo();
        System.out.println(flat.showFlatInfo());
        System.out.println("\n");

        System.out.println("-------------Flat Facilities-------------");

        // This code below add facilities to the flat.
        flat.addFacility(new Facility(1, "Living Room", "TV"));
        flat.addFacility(new Facility(2, "Bedroom", "Air condition"));
        flat.addFacility(new Facility(3, "Kitchen", "Dishwasher"));
        flat.addFacility(new Facility(4, "Kitchen", "Washing Machine"));

        Facility facility2 = flat.getFacilities().getFirst();
        System.out.println(facility2.viewFacilityInfo());

        System.out.println("\n");
        System.out.println("------------Cabin Info------------");

        Cabin cabin = new Cabin(3,"Cabin",250.00,"789 Oak St", "Mountain", true, 100.0, "Close to trail", "Mountain View" );
        cabin.showAccommodationInfo();
        System.out.println(cabin.showCabinInfo()); // Here the cabin information is displayed.

        System.out.println("-------------Cabin Facilities-------------");

        // This code below add facilities to the cabin.
        cabin.addFacility(new Facility(1, "Living Room", "TV"));
        cabin.addFacility(new Facility(2, "Bedroom", "Air condition"));
        cabin.addFacility(new Facility(3, "Kitchen", "Dishwasher"));
        cabin.addFacility(new Facility(4, "Kitchen", "Washing Machine"));

        Facility facility3 = cabin.getFacilities().getFirst();
        System.out.println(facility3.viewFacilityInfo());

        System.out.println("\n");
        System.out.println("------------Luxury Villa info--------------");

        // The data for the luxury villa is created then displayed.
        LuxuryVilla luxuryVilla = new LuxuryVilla(4,"Luxury Villa",400.0,"101 Pine St", 5, true, true, 3);
        luxuryVilla.showAccommodationInfo();
        System.out.println(luxuryVilla.showLuxuryVillaInfo()); // Here the luxury villa information is displayed.

        System.out.println("-------------Luxury Villa Facilities-------------");

        luxuryVilla.addFacility(new Facility(1, "Living Room", "TV"));
        luxuryVilla.addFacility(new Facility(2, "Bedroom", "Air condition"));
        luxuryVilla.addFacility(new Facility(3, "Kitchen", "Dishwasher"));
        luxuryVilla.addFacility(new Facility(4, "Kitchen", "Washing Machine"));

        // This code below add facilities to the luxury villa.
        Facility facility4 = luxuryVilla.getFacilities().getFirst();
        System.out.println(facility4.viewFacilityInfo()); // Here the facility information is displayed.

        System.out.println("-----------------------------------------------");

        System.out.println("\n");
        // ------------------------------------------------------------------------------------
        // The code below asks the user their booking details.
        System.out.println("Enter the accommodation ID you would like to book: ");
        int AccommodationID = scan.nextInt();
        scan.nextLine(); // Consume newline, which allows the next string input to work.
        
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

        // The IF-Else statement below checks the accommodation ID and creates a booking.
        // It also calculates the total price and creates a booking object.
        // Then the booking information is then displayed.

        if (AccommodationID == 1) {
            double TotalPrice = hotel.calculateTotalPrice(NumberOfNights);

            Booking booking = new Booking(1, hotel, user, CheckInDate, CheckOutDate, NumberOfNights, NumberOfGuests, TotalPrice);
            booking.showBookingInfo();
        } else if (AccommodationID == 2) {
            double TotalPrice = flat.calculateTotalPrice(NumberOfNights);

            Booking booking = new Booking(1, flat, user, CheckInDate, CheckOutDate, NumberOfNights, NumberOfGuests, TotalPrice);
            booking.showBookingInfo();
        } else if (AccommodationID == 3) {
            double TotalPrice = cabin.calculateTotalPrice(NumberOfNights);
            Booking booking = new Booking(1, cabin, user, CheckInDate, CheckOutDate, NumberOfNights, NumberOfGuests, TotalPrice);
            booking.showBookingInfo();
        } else if (AccommodationID == 4) {
            double TotalPrice = luxuryVilla.calculateTotalPrice(NumberOfNights);
            Booking booking = new Booking(1, luxuryVilla, user, CheckInDate, CheckOutDate, NumberOfNights, NumberOfGuests, TotalPrice);
            booking.showBookingInfo();
        } else {
            System.out.println("Invalid accommodation ID");
        }









    }
}
