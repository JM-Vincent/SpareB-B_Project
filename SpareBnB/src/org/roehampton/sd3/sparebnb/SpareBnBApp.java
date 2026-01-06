package org.roehampton.sd3.sparebnb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main application class for the JavaFX version of SpareBnB.
 * This class extends Application and sets up the primary stage and scene.
 */
public class SpareBnBApp extends Application {
    /**
     * Starts the JavaFX application.
     *
     * @param stage The primary stage for this application.
     * @throws Exception If the FXML file cannot be loaded.
     */
    @Override
    public void start(Stage stage) throws Exception {
        // Here this line tells JavaFX to look for your layout file aka the MainView.fxml file.
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainView.fxml"));

        // This creates the window content, which is the Scene with a size of 800x600 pixels.
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);

        stage.setTitle("SpareBnB Management System");
        stage.setScene(scene);
        stage.show(); // This opens the window of the application.
    }

    /**
     * Main method to launch the application.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        launch(); // This launches the JavaFX lifecycle.
    }
}
