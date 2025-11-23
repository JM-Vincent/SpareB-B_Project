package org.roehampton.sd3.sparebnb;
// The LuxuryVilla class extends the Accommodation class and implements the LuxuryVillaFeatures interface.
public class LuxuryVilla extends Accommodation {
    private double squarefootage;
    private boolean hasPrivatePool;
    private boolean hasGarden;
    private int numberOfFloors;

    // Constructor for setting properties for each attribute of the luxury villa class.

    public LuxuryVilla(int AccommodationID, String AccommodationType, double PricePerNight, String Address, double squarefootage, boolean hasPrivatePool, boolean hasGarden, int numberOfFloors) {
        super(AccommodationID, AccommodationType, PricePerNight, Address);
        this.squarefootage = squarefootage;
        this.hasPrivatePool = hasPrivatePool;
        this.hasGarden = hasGarden;
        this.numberOfFloors = numberOfFloors;
    }

    // The method below is used to display the luxury villa information.

    @Override
    public String showSpecificInfo() {
        return "Square footage: " + squarefootage +
                "\n" + "Has private pool: " + hasPrivatePool +
                "\n" + "Has garden: " + hasGarden +
                "\n" + "Number of floors: " + numberOfFloors;
    }

}
