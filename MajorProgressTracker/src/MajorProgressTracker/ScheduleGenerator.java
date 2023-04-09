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
public class ScheduleGenerator {
    
    private Database data;
    private String majorName;
    
    public ScheduleGenerator(String majorName) {
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
    
    public ArrayList<Course> generate(ArrayList<Course> coursesTaken) {
        ArrayList<Course> remainingCourses;
 
        remainingCourses = data.getMajorReq();
        remainingCourses.removeAll(coursesTaken);
        return remainingCourses;
    }
}
