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

    private final ArrayList<String> majorNames = new ArrayList<>(Arrays.asList("Bioengineering", "Computer Engineering", "Computer Science", "Engineering Chemistry", "Engineering Physics", "Information Technology", "Industrial and Systems Engineering", "Electrical Engineering", "Mechanical Engineering"));
    
    private Modifier mod;
    
    private ComboBox<String> boxSelectMajor;
    private TextField txtCourseModify;
    private Label lblSelectMajor;
    private Label lblCourseModify;
    private Label lblResult;
    private Button btnAdd;
    private Button btnRemove;
    private Button btnBack;
    
    public EmployeePage(Stage stage) {
        super();
        
        mod = new Modifier();
        
        setAlignment(Pos.CENTER);
        setHgap(25);
        setVgap(25);
        setPadding(new Insets(25, 25, 25, 25));
        
        boxSelectMajor = new ComboBox<>();
        txtCourseModify = new TextField();
        lblSelectMajor = new Label("Select Major:");
        lblCourseModify = new Label("Enter course to be modified:");
        lblResult = new Label();
        btnAdd = new Button("Add Course");
        btnRemove = new Button("Remove Course");
        btnBack = new Button("Back");
        
        boxSelectMajor.getItems().addAll(majorNames);
        boxSelectMajor.setValue(majorNames.get(0));   
        
        lblCourseModify.setPadding(new Insets(0, 0, 15, 0));
        
        btnAdd.setOnAction(e -> {   
            String major = boxSelectMajor.getValue();
            String course = txtCourseModify.getText();
            
            mod.addCourse(major, course);
            
            lblResult.setText("Course added to major");
            txtCourseModify.clear();
        });
        
        btnRemove.setOnAction(e -> {   
            String major = boxSelectMajor.getValue();
            String course = txtCourseModify.getText();
            boolean found;
            
            found = mod.removeCourse(major, course);
            
            if (found) {
                lblResult.setText("Course removed from major");
            }
            else {
                lblResult.setText("Course not found in major");
            }
            txtCourseModify.clear();
        });
        
        btnBack.setOnAction(e -> {
            stage.setScene(new Scene(new LoginPage(stage)));
        });
        
        VBox vboxCourseModify = new VBox();
        vboxCourseModify.getChildren().addAll(txtCourseModify, lblResult);
        
        HBox hboxButtons = new HBox();
        hboxButtons.setSpacing(25);
        hboxButtons.getChildren().addAll(btnAdd, btnRemove);
        
        add(boxSelectMajor, 1, 0);
        add(vboxCourseModify, 1, 1);
        add(lblSelectMajor, 0, 0);
        add(lblCourseModify, 0, 1);
        add(hboxButtons, 1, 2);
        add(btnBack, 0, 2);
    }
}
