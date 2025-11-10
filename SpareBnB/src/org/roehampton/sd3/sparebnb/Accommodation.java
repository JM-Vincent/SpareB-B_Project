package org.roehampton.sd3.sparebnb;

// These are the imports used in the Accommodation class to create a list of facilities.
import java.util.ArrayList;
import java.util.List;

public abstract class Accommodation {
    protected int AccommodationID;
    protected String AccommodationType;
    protected double PricePerNight;
    protected String Address;

    // --------------------------------------------------------------------------
    // The code below is used to create a list of bookings and facilities.

    private List<Facility> facilities;

    private boolean isBooked;

    public Accommodation(int AccommodationID, String AccommodationType, double PricePerNight, String Address) {
        this.AccommodationID = AccommodationID;
        this.AccommodationType = AccommodationType;
        this.PricePerNight = PricePerNight;
        this.Address = Address;
        this.facilities = new ArrayList<>();
        this.isBooked = false;
    }

    // ------------------------------------------------------------------------------
    // The addFacility method is used to add facilities to the accommodation.

    public void addFacility(Facility facility) {
        this.facilities.add(facility);
    }

    // This is a method that displays the facilities information.

    public List<Facility> getFacilities() {
        return this.facilities;
    }


    // The code below is the link between the super class and the subclasses.

    public interface HotelFeatures {
        String showHotelInfo();
    }

    public interface LuxuryVillaFeatures {
        String showLuxuryVillaInfo();
    }


    public interface FlatFeatures {
        String showFlatInfo();
    }

    public interface CabinFeatures {
        String showCabinInfo();
    }

    public boolean getIsBooked() {
        return this.isBooked;
    }

    public void bookAccommodation() {
        this.isBooked = true;
    }

    public void cancelBooking() {
        this.isBooked = false;
    }
    // --------------------------------------------------------------------------

    // This is a method that displays the accommodation information.
    public void showAccommodationInfo() {
        System.out.println("Accommodation ID: " + AccommodationID);
        System.out.println("Accommodation Type: " + AccommodationType);
        System.out.println("Price per night: " + PricePerNight);
        System.out.println("Address: " + Address);
    }

    public int getAccommodationID() {
        return AccommodationID;
    }


    
    /**
     * Calculates the total price for a given number of nights
     * @param numberOfNights the number of nights to calculate for total price.
     * @return the total price for the specified number of nights
     */
    public double calculateTotalPrice(int numberOfNights) {
        return PricePerNight * numberOfNights;
    }



}