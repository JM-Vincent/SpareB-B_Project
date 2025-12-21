package org.roehampton.sd3.sparebnb;



public class Booking {
    private int bookingID;
    protected Accommodation accommodation;
    private User user;
    private String checkInDate;
    private String checkOutDate;
    private int numberOfNights;
    private int numberOfGuests;
    private double totalPrice;



    // The constructor are for setting properties for each attribute of the booking class.

    public Booking(int bookingID, Accommodation accommodation, User user, String checkInDate, String checkOutDate, int numberOfNights, int numberOfGuests, double totalPrice) {
        this.bookingID = bookingID;
        this.accommodation = accommodation;
        this.user = user;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfNights = numberOfNights;
        this.numberOfGuests = numberOfGuests;
        this.totalPrice = totalPrice;
    }






    public void showBookingInfo() {
        System.out.println("Booking ID: " + bookingID);
        System.out.println("User ID: " + user.getUserID());
        System.out.println("Accommodation ID: " + accommodation.getAccommodationID());
        System.out.println("Check-in Date: " + checkInDate);
        System.out.println("Check-out Date: " + checkOutDate);
        System.out.println("Number of Nights: " + numberOfNights);
        System.out.println("Number of Guests: " + numberOfGuests);
        System.out.println("Price Payed: " + totalPrice);
    }

    public int getBookingID() {
        return bookingID;
    }

    public User getUser() {
        return user;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }



}
