/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MajorProgressTracker;

import java.util.ArrayList;

/**
 *
 * @author ladea
 */
public class Modifier {
    
    Database data;
    
    public Modifier(String majorName) {
        switch (majorName) {
            case "Computer Science": 
                data = new Database(majorName, "compSciCourses.txt");
                break;
            default:
                data = new Database(majorName, "compSciCourses.txt");;
                break;
        }
    }
    
    public boolean addCourse(String course) {  
        return data.addCourse(course);
    }
    
    public boolean removeCourse(String course) { 
        return data.removeCourse(course);
    }
    
    public ArrayList<String> getCourses() {
        return data.getMajorReq();
    }
}
