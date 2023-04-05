/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MajorProgressTracker;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author ladea
 */
public class LoginPage extends GridPane {
    
    private Login login;
    
    private TextField txtUsername;
    private TextField txtPassword;
    private Label lblLogin;
    private Label lblPassword;
    private Label lblInvalid;
    private Button btnLogin;
    private Button btnBack;
    
    public LoginPage(Stage stage) {
        super();
        
        login = new Login();
        
        setAlignment(Pos.CENTER);
        setHgap(25);
        setVgap(25);
        setPadding(new Insets(25, 25, 25, 25));
        
        txtUsername = new TextField();
        txtPassword = new TextField();
        lblLogin = new Label("Username:");
        lblPassword = new Label("Password:");
        lblInvalid = new Label();
        btnLogin = new Button("Login");
        btnBack = new Button("Back");
        
        lblPassword = new Label("Password:");
        lblPassword.setPadding(new Insets(0, 0, 15 ,0));
        
        btnLogin.setOnAction(e -> {
            String username, password;
            boolean match;
            
            username = txtUsername.getText();
            password = txtPassword.getText();
            match = login.verify(username, password);
            
            if (match) {
                stage.setScene(new Scene(new EmployeePage(stage)));
            }
            else {
                lblInvalid.setText("Invalid login");
            }
        });
        
        btnBack.setOnAction(e -> {
            stage.setScene(new Scene(new HomePage(stage)));
        });
        
        VBox vboxPassword = new VBox();
        vboxPassword.getChildren().addAll(txtPassword, lblInvalid);
        
        add(txtUsername, 1, 0);
        add(vboxPassword, 1, 1);
        add(lblLogin, 0, 0);
        add(lblPassword, 0, 1);
        add(btnLogin, 1, 2);
        add(btnBack, 0, 2);
    }
}
