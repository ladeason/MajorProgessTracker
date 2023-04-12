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
    
    private MajorRequirements data;
    private String majorName;
    
    public ScheduleGenerator(String majorName) {
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
    
    public ArrayList<Course> generate(ArrayList<Course> coursesTaken) {
        ArrayList<Course> remainingCourses;
 
        remainingCourses = data.getMajorReq();
        remainingCourses.removeAll(coursesTaken);
        return remainingCourses;
    }
}
