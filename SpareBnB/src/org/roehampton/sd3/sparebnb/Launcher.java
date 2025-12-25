package org.roehampton.sd3.sparebnb;

/**
 * Entry point for the application.
 * This class is used to launch the JavaFX application.
 * It is often required to have a separate main class that doesn't extend Application
 * to avoid issues with JavaFX module loading in some environments.
 */
public class Launcher {
    /**
     * The main method that launches the application.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        // This calls the main method in your JavaFX app class
        SpareBnBApp.main(args);
    }
}
