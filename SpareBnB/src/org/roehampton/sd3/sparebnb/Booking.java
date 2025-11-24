package org.roehampton.sd3.sparebnb;



public class Booking {
    private int BookingID;
    protected Accommodation accommodation;
    private User user;
    private String CheckInDate;
    private String CheckOutDate;
    private int NumberOfNights;
    private int NumberOfGuests;
    private double TotalPrice;



    // The constructor are for setting properties for each attribute of the booking class.

    public Booking(int BookingID, Accommodation accommodation, User user, String CheckInDate, String CheckOutDate, int NumberOfNights, int NumberOfGuests, double TotalPrice) {
        this.BookingID = BookingID;
        this.accommodation = accommodation;
        this.user = user;
        this.CheckInDate = CheckInDate;
        this.CheckOutDate = CheckOutDate;
        this.NumberOfNights = NumberOfNights;
        this.NumberOfGuests = NumberOfGuests;
        this.TotalPrice = TotalPrice;
    }






    public void showBookingInfo() {
        System.out.println("Booking ID: " + BookingID);
        System.out.println("User ID: " + user.getUserID());
        System.out.println("Accommodation ID: " + accommodation.getAccommodationID());
        System.out.println("Check-in Date: " + CheckInDate);
        System.out.println("Check-out Date: " + CheckOutDate);
        System.out.println("Number of Nights: " + NumberOfNights);
        System.out.println("Number of Guests: " + NumberOfGuests);
        System.out.println("Price Payed: " + TotalPrice);
    }

    public int getBookingID() {
        return BookingID;
    }

    public User getUser() {
        return user;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }



}
