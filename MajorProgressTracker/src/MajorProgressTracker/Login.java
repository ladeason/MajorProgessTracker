/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MajorProgressTracker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ladea
 */
public class Login {
    
    private String username;
    private String password;
    
    public Login() {
        
    }
    
    public boolean verify(String loginUsername, String loginPassword) {
        boolean match = false;
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("employeeLogins.txt"));
            
            String line;
            String[] usernamePassword;
            while ((line = reader.readLine()) != null) {
                usernamePassword = line.split(", ");
                
                if (usernamePassword[0].equals(loginUsername) 
                        && usernamePassword[1].equals(loginPassword)) {
                    match = true;
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return match;
    }
}
