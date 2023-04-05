/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package MajorProgressTracker;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author ladea
 */
public class StudentPage extends GridPane {
    
    private final ArrayList<String> majorNames = new ArrayList<>(Arrays.asList("Bioengineering", "Computer Engineering", "Computer Science", "Engineering Chemistry", "Engineering Physics", "Information Technology", "Industrial and Systems Engineering", "Electrical Engineering", "Mechanical Engineering"));
    
    private ScheduleGenerator sg;
    
    private ComboBox<String> boxSelectMajor;
    private TextField txtCoursesTaken;
    private TextArea txtCoursesRemaining;
    private Label lblSelectMajor;
    private Label lblCoursesTaken;
    private Label lblCoursesRemaining;
    private Button btnCalculate;
    private Button btnBack;
    
    public StudentPage(Stage stage) {
        super();
        
        setAlignment(Pos.CENTER);
        setHgap(25);
        setVgap(25);
        setPadding(new Insets(25, 25, 25, 25));
        
        boxSelectMajor = new ComboBox<>();
        txtCoursesTaken = new TextField();
        txtCoursesRemaining = new TextArea();
        lblSelectMajor = new Label("Select major:");
        lblCoursesTaken = new Label("Enter courses you have taken (comma-separated):");
        lblCoursesRemaining = new Label("Courses Remaining:");
        btnCalculate = new Button("Calculate");
        btnBack = new Button("Back");
        
        boxSelectMajor.getItems().addAll(majorNames);
        boxSelectMajor.setValue(majorNames.get(0));    
        
        txtCoursesRemaining.setEditable(false);
        
        btnCalculate.setOnAction(e -> {   
            String major;
            String[] strEnteredCourses;
            ArrayList<Course> enteredCourses;
            ArrayList<Course> remainingCourses;
            
            major = boxSelectMajor.getValue();
            strEnteredCourses = txtCoursesTaken.getText().split(", ");
            enteredCourses = new ArrayList<>();
            
            for(String course : strEnteredCourses) {
                enteredCourses.add(new Course(course));
            }
            
            sg = new ScheduleGenerator(major);
            remainingCourses = sg.generate(enteredCourses);
            
            txtCoursesRemaining.clear(); 
            for (Course course : remainingCourses) {
                txtCoursesRemaining.appendText(course + "\n");
            }
        });
        
        btnBack.setOnAction(e -> {   
            stage.setScene(new Scene(new HomePage(stage), 300, 250));
        });
        
        add(boxSelectMajor, 1, 0);
        add(txtCoursesTaken, 1, 1);
        add(txtCoursesRemaining, 1, 2);
        add(lblSelectMajor, 0, 0);
        add(lblCoursesTaken, 0, 1);
        add(lblCoursesRemaining, 0, 2);
        add(btnCalculate, 1, 3);
        add(btnBack, 0, 3);
    }
}
