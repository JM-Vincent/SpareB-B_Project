package org.roehampton.sd3.sparebnb;
// The Hotel class extends the Accommodation class and implements the HotelFeatures interface.
public class Hotel extends Accommodation implements Accommodation.HotelFeatures {
    private int StarRating;
    private String RoomType;
    private boolean isFoodIncluded;
    private String chainName;

    public Hotel(int AccommodationID, String AccommodationType, double PricePerNight, String Address, int StarRating, String RoomType, boolean isFoodIncluded, String chainName) {
        super(AccommodationID, AccommodationType, PricePerNight, Address);
        this.StarRating = StarRating;
        this.RoomType = RoomType;
        this.isFoodIncluded = isFoodIncluded;
        this.chainName = chainName;
    }

    // The method below is used to display the hotel information.

    @Override
    public String showHotelInfo() {
        return "HotelStarRating: " + StarRating + "\n" + "RoomType: " + RoomType + "\n" +
                "isFoodIncluded: " + isFoodIncluded + "\n" + "chainName: " + chainName;

    }
}
