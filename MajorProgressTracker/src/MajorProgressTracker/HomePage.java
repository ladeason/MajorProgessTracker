/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package MajorProgressTracker;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author ladea
 */
public class HomePage extends GridPane {
    
    private Label lblTitle;
    private Button btnStudent;
    private Button btnEmployee;
    private Button btnExit;
    
    public HomePage(Stage stage) {
        super();
        
        setAlignment(Pos.CENTER);
        setHgap(25);
        setVgap(25);
        setPadding(new Insets(25, 25, 25, 25));
        
        lblTitle = new Label("Major Progress Tracker");
        btnStudent = new Button("Student");
        btnEmployee = new Button("Employee");
        btnExit = new Button("Exit");
        
        btnStudent.setOnAction(e -> {
            stage.setScene(new Scene(new StudentPage(stage)));
        });
        
        btnEmployee.setOnAction(e -> {
            stage.setScene(new Scene(new LoginPage(stage)));
        });
        
        btnExit.setOnAction(e -> {
            stage.close();
        });
        
        add(lblTitle, 0, 0);
        add(btnStudent, 0, 1);
        add(btnEmployee, 0, 2);
        add(btnExit, 0, 3);
    }
}
