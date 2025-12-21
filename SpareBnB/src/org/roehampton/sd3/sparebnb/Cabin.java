package org.roehampton.sd3.sparebnb;
// The Cabin class extends the Accommodation class and implements the CabinFeatures interface.
public class Cabin extends Accommodation {
    private String settingType;
    private boolean isSecluded;
    private double lotSize;
    private String proximityToTrail;
    private String viewType;

    // Constructor for setting properties for each attribute of the cabin class.

    public Cabin(int accommodationID, String accommodationType, double pricePerNight, String address, String settingType, boolean isSecluded, double lotSize, String proximityToTrail, String viewType) {
        super(accommodationID, accommodationType, pricePerNight, address);
        this.settingType = settingType;
        this.isSecluded = isSecluded;
        this.lotSize = lotSize;
        this.proximityToTrail = proximityToTrail;
        this.viewType = viewType;
    }

    // The method below is used to display the cabin information.
    @Override
    public String showSpecificInfo() {
        return "Setting type: " + settingType +
                "\n" + "Is secluded: " + isSecluded +
                "\n" + "Lot size: " + lotSize +
                "\n" + "Proximity to trail: " + proximityToTrail +
                "\n" + "View type: " + viewType;
    }

    public String getsettingType() {
        return settingType;
    }

    public boolean getisSecluded() {
        return isSecluded;
    }

    public double getlotSize() {
        return lotSize;
    }

    public String getproximityToTrail() {
        return proximityToTrail;
    }

    public String getviewType() {
        return viewType;
    }

}
