package org.roehampton.sd3.sparebnb;

public class NewAccommodation {

    public static Accommodation CreateAccommodation(String type) {
        if (type.equalsIgnoreCase("Hotel")) {
            return new Hotel(1, "Hotel", 100.00, "123 Main St", 5, "Single", true, "Hotel Chain");
        } else if (type.equalsIgnoreCase("Flat")) {
            return new Flat(2, "Flat", 30.00, "456 Elm St", 2, 2, 5, true, true);
        } else if (type.equalsIgnoreCase("Cabin")) {
            return new Cabin(3, "Cabin", 250.00, "789 Oak St", "Mountain", true, 100.0, "Close to trail", "Mountain View");
        } else if (type.equalsIgnoreCase("LuxuryVilla")) {
            return new LuxuryVilla(4, "Luxury Villa", 400.0, "101 Pine St", 5, true, true, 3);
        } else {
            return null;
        }

    }

}
