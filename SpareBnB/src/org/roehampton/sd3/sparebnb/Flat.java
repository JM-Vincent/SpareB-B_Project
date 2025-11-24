package org.roehampton.sd3.sparebnb;

// The Flat class extends the Accommodation class and implements the FlatFeatures interface.
public class Flat extends Accommodation {
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private int floorNumber;
    private boolean hasElevator;
    private boolean isFurnished;

    // The constructor is for setting properties for each attribute of the flat class.
    public Flat(int AccommodationID, String AccommodationType, double PricePerNight, String Address, int numberOfBedrooms, int numberOfBathrooms, int floorNumber, boolean hasElevator, boolean isFurnished) {
        super(AccommodationID, AccommodationType, PricePerNight, Address);
        this.numberOfBedrooms = numberOfBedrooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.floorNumber = floorNumber;
        this.hasElevator = hasElevator;
        this.isFurnished = isFurnished;
    }



    // The method below is used to display the flat information.
    @Override
    public String showSpecificInfo() {
        return "Number of bedrooms: " + numberOfBedrooms + "\n" +
                ", numberOfBathrooms: " + numberOfBathrooms + "\n" +
                ", floorNumber=" + floorNumber + "\n" +
                ", hasElevator: " + hasElevator + "\n" +
                ", isFurnished: " + isFurnished;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public boolean getHasElevator() {
        return hasElevator;
    }

    public boolean getIsFurnished() {
        return isFurnished;
    }
}
