package org.roehampton.sd3.sparebnb;

public class Facility {
    private int facilityID;
    private String facilityName;
    private String applianceName;

    // Constructor for setting properties for each attribute of the facility class.
    public Facility(int facilityID, String facilityName, String applianceName) {
        this.facilityID = facilityID;
        this.facilityName = facilityName;
        this.applianceName = applianceName;
    }

    // The method below is used to display the facility information.

    public String viewFacilityInfo() {
        return "Facility ID: " + facilityID + "\n" +
                "Facility Name: " + facilityName + "\n" +
                "Appliance Name: " + applianceName;
    }



}
