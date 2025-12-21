package org.roehampton.sd3.sparebnb;
// The Hotel class extends the Accommodation class and implements the HotelFeatures interface.
public class Hotel extends Accommodation {
    private int starRating;
    private String roomType;
    private boolean isFoodIncluded;
    private String chainName;

    public Hotel(int accommodationID, String accommodationType, double pricePerNight, String address, int starRating, String roomType, boolean isFoodIncluded, String chainName) {
        super(accommodationID, accommodationType, pricePerNight, address);
        this.starRating = starRating;
        this.roomType = roomType;
        this.isFoodIncluded = isFoodIncluded;
        this.chainName = chainName;
    }

    // The method below is used to display the hotel information.

    @Override
    public String showSpecificInfo() {
        return "HotelStarRating: " + starRating + "\n" + "RoomType: " + roomType + "\n" +
                "isFoodIncluded: " + isFoodIncluded + "\n" + "chainName: " + chainName;

    }

    public int getstarRating() {
        return starRating;
    }

    public String getroomType() {
        return roomType;
    }

    public boolean getisFoodIncluded() {
        return isFoodIncluded;
    }

    public String getchainName() {
        return chainName;
    }
}
