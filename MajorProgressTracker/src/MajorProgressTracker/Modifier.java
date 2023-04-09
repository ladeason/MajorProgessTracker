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
    
    private Database data;
    private String majorName;
    
    public Modifier(String majorName) {
        this.majorName = majorName;
        
        switch (majorName) {
            case "Computer Science": 
                data = new Database("compSciCourses.txt");
                break;
            case "Bioengineering": 
                data = new Database("bioengCourses.txt");
                break;
            case "Computer Engineering": 
                data = new Database("compEngCourses.txt");
                break;
            case "Electrical Engineering": 
                data = new Database("elecEngCourses.txt");
                break;
            case "Engineering Chemistry": 
                data = new Database("engChemCourses.txt");
                break;
            case "Engineering Physics": 
                data = new Database("engPhyCourses.txt");
                break;
            case "Industrial and Systems Engineering": 
                data = new Database("engPhyCourses.txt");
                break;
            case "Information Technology": 
                data = new Database("infoTechCourses.txt");
                break;
            case "Mechanical Engineering": 
                data = new Database("mechEngCourses.txt");
                break;
            default:
                data = new Database("testCourses.txt");
                break;
        }
    }
    
    public boolean addCourse(Course course) {  
        return data.addCourse(course);
    }
    
    public boolean modifyCourse(Course course) {  
        return data.modifyCourse(course);
    }
    
    public boolean removeCourse(Course course) { 
        return data.removeCourse(course);
    }
    
    public ArrayList<Course> getCourses() {
        return data.getMajorReq();
    }
}
