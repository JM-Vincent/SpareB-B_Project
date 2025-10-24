package org.roehampton.sd3.sparebnb;



public class User {
    private int userID;
    private String name;
    private String email;
    private String password;


    // Constructor for setting properties for each attribute of the user class.
    public User(int userID, String name, String email, String password) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // The method below is used to display the user information.

    public void getUserInfo() {
        System.out.println("User ID: " + userID);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
    }





}
