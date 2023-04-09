/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author ladea
 */
public class EmployeePage extends GridPane {

    private final ArrayList<String> majorNames = new ArrayList<>(Arrays.asList("Bioengineering", "Computer Engineering", "Computer Science", "Electrical Engineering", "Engineering Chemistry", "Engineering Physics", "Industrial and Systems Engineering", "Information Technology", "Mechanical Engineering"));
    
    private Modifier mod;
    
    private ComboBox<String> boxSelectMajor;
    private TextField txtCourseNum;
    private TextField txtCourseName;
    private TextArea txtCourseListing;
    private Label lblSelectMajor;
    private Label lblCourseNum;
    private Label lblCourseName;
    private Label lblCourseListing;
    private Label lblResult;
    private Button btnAdd;
    private Button btnModify;
    private Button btnRemove;
    private Button btnBack;
    
    public EmployeePage(Stage stage) {
        super();
        
        setAlignment(Pos.CENTER);
        setHgap(25);
        setVgap(25);
        setPadding(new Insets(25, 25, 25, 25));
        
        boxSelectMajor = new ComboBox<>();
        txtCourseNum = new TextField();
        txtCourseName = new TextField();
        txtCourseListing = new TextArea();
        lblSelectMajor = new Label("Select major:");
        lblCourseNum = new Label("Enter course number to be modified:");
        lblCourseName = new Label("Enter course name (optional):");
        lblCourseListing = new Label("Course listing:");
        lblResult = new Label();
        btnAdd = new Button("Add Course");
        btnModify = new Button("Modify Course");
        btnRemove = new Button("Remove Course");
        btnBack = new Button("Back");
        
        boxSelectMajor.getItems().addAll(majorNames);
        boxSelectMajor.setValue(majorNames.get(0));
        boxSelectMajor.setOnAction(e -> {
            String major;
            ArrayList<Course> courses;
            
            major = boxSelectMajor.getValue();
       
            mod = new Modifier(major);
            courses = mod.getCourses();
            
            txtCourseListing.clear(); 
            for (Course course : courses) {
                txtCourseListing.appendText(course + "\n");
            }
        });
        
        ArrayList<Course> initCourses;

        mod = new Modifier(boxSelectMajor.getValue());
        initCourses = mod.getCourses();

        for (Course course : initCourses) {
            txtCourseListing.appendText(course + "\n");
        }
        
        lblCourseNum.setPadding(new Insets(0, 0, 15, 0));
        
        btnAdd.setOnAction(e -> {   
            String major;
            String courseNum, courseName;
            boolean contains;
            ArrayList<Course> courses;
            
            major = boxSelectMajor.getValue();
            courseNum = txtCourseNum.getText();
            courseName = txtCourseName.getText();
            
            mod = new Modifier(major);
            if (courseName.isBlank()) {
                 contains = mod.addCourse(new Course(courseNum));
            }
            else {
                contains = mod.addCourse(new Course(courseNum, courseName));
            }           
            courses = mod.getCourses();
            
            if (!contains) {
                lblResult.setText("Course added to major");
                txtCourseListing.clear(); 
                for (Course course : courses) {
                    txtCourseListing.appendText(course + "\n");
                }
            }
            else {
                lblResult.setText("Course already in major");
            } 
            txtCourseNum.clear();
            txtCourseName.clear();
        });
        
        btnModify.setOnAction(e -> {
            String major;
            String courseNum, courseName;
            boolean found;
            ArrayList<Course> courses;
            
            major = boxSelectMajor.getValue();
            courseNum = txtCourseNum.getText();
            courseName = txtCourseName.getText();
            
            mod = new Modifier(major);
            if (courseName.isBlank()) {
                found = mod.modifyCourse(new Course(courseNum));
            }
            else {
                found = mod.modifyCourse(new Course(courseNum, courseName));
            }           
            courses = mod.getCourses();
            
            if (found) {
                lblResult.setText("Course modified from major");
                txtCourseListing.clear(); 
                for (Course course : courses) {
                    txtCourseListing.appendText(course + "\n");
                }
            }
            else {
                lblResult.setText("Course not found in major");
            }
            
            
            txtCourseNum.clear();
            txtCourseName.clear();
        });
        
        btnRemove.setOnAction(e -> {   
            String major;
            String courseNum;
            boolean found;
            ArrayList<Course> courses;
                  
            major = boxSelectMajor.getValue();
            courseNum = txtCourseNum.getText();
            
            mod = new Modifier(major);
            found = mod.removeCourse(new Course(courseNum));
            courses = mod.getCourses();
            
            if (found) {
                lblResult.setText("Course removed from major");
                txtCourseListing.clear(); 
                for (Course course : courses) {
                    txtCourseListing.appendText(course + "\n");
                }
            }
            else {
                lblResult.setText("Course not found in major");
            }
            txtCourseNum.clear();
            txtCourseName.clear();
        });
        
        btnBack.setOnAction(e -> {
            stage.setScene(new Scene(new LoginPage(stage)));
        });
        
        VBox vboxCourseNum = new VBox();
        vboxCourseNum.getChildren().addAll(txtCourseNum, lblResult);
        
        HBox hboxButtons = new HBox();
        hboxButtons.setSpacing(25);
        hboxButtons.getChildren().addAll(btnAdd, btnModify, btnRemove);
        
        add(boxSelectMajor, 1, 0);
        add(vboxCourseNum, 1, 1);
        add(txtCourseName, 1, 2);
        add(txtCourseListing, 1, 3);
        add(lblSelectMajor, 0, 0);
        add(lblCourseNum, 0, 1);
        add(lblCourseName, 0, 2);
        add(lblCourseListing, 0, 3);
        add(hboxButtons, 1, 4);
        add(btnBack, 0, 4);
    }
}
