/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package MajorProgressTracker;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ladea
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) {

        HomePage pane = new HomePage(stage);
        
        Scene scene = new Scene(pane, 300, 250); 
        stage.setTitle("Major Progress Tracker");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
