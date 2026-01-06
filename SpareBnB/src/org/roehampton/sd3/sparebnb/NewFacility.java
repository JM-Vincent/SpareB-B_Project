package org.roehampton.sd3.sparebnb;

public class NewFacility {


    public static Facility createFacility(String type) {
        if (type.equalsIgnoreCase("LivingRoom")) { // if statements for adding facility data to each accommodation.
            return new Facility(1, "Living Room", "TV");
        } else if (type.equalsIgnoreCase("Wifi")) {
            return new Facility(2, "Wifi", "Internet");
        } else if (type.equalsIgnoreCase("Gym")) {
            return new Facility(3, "Gym", "Gym equipment");
        } else if (type.equalsIgnoreCase("Bedroom")) {
            return new Facility(4, "Bedroom", "Air condition");
        } else {
            return null;
        }
    }

}
