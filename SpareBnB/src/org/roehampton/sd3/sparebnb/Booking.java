package org.roehampton.sd3.sparebnb;



public class Booking {
    private int BookingID;
    private int AccommodationID;
    private String CheckInDate;
    private String CheckOutDate;
    private int NumberOfNights;
    private int NumberOfGuests;
    private double TotalPrice;



    // Constructor for setting properties for each attribute of the booking class.

    public Booking(int BookingID, int AccommodationID, String CheckInDate, String CheckOutDate, int NumberOfNights, int NumberOfGuests, double TotalPrice) {
        this.BookingID = BookingID;
        this.AccommodationID = AccommodationID;
        this.CheckInDate = CheckInDate;
        this.CheckOutDate = CheckOutDate;
        this.NumberOfNights = NumberOfNights;
        this.NumberOfGuests = NumberOfGuests;
        this.TotalPrice = TotalPrice;
    }



    public void showBookingInfo() {
        System.out.println("Booking ID: " + BookingID);
        System.out.println("Accommodation ID: " + AccommodationID);
        System.out.println("Check-in Date: " + CheckInDate);
        System.out.println("Check-out Date: " + CheckOutDate);
        System.out.println("Number of Nights: " + NumberOfNights);
        System.out.println("Number of Guests: " + NumberOfGuests);
        System.out.println("Price Payed: " + TotalPrice);
    }



}
