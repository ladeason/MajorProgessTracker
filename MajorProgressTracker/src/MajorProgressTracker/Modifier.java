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
    
    private MajorRequirements data;
    private String majorName;
    
    public Modifier(String majorName) {
        this.majorName = majorName;
        
        switch (majorName) {
            case "Computer Science": 
                data = new MajorRequirements("compSciCourses.txt");
                break;
            case "Bioengineering": 
                data = new MajorRequirements("bioengCourses.txt");
                break;
            case "Computer Engineering": 
                data = new MajorRequirements("compEngCourses.txt");
                break;
            case "Electrical Engineering": 
                data = new MajorRequirements("elecEngCourses.txt");
                break;
            case "Engineering Chemistry": 
                data = new MajorRequirements("engChemCourses.txt");
                break;
            case "Engineering Physics": 
                data = new MajorRequirements("engPhyCourses.txt");
                break;
            case "Industrial and Systems Engineering": 
                data = new MajorRequirements("engPhyCourses.txt");
                break;
            case "Information Technology": 
                data = new MajorRequirements("infoTechCourses.txt");
                break;
            case "Mechanical Engineering": 
                data = new MajorRequirements("mechEngCourses.txt");
                break;
            default:
                data = new MajorRequirements("testCourses.txt");
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
