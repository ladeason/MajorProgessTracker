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
    
    Database data;
    
    public ScheduleGenerator(String majorName) {
        switch (majorName) {
            case "Computer Science": 
                data = new Database(majorName, "compSciCourses.txt");
                break;
            case "Bioengineering": 
                data = new Database(majorName, "bioengCourses.txt");
                break;
            case "Computer Engineering": 
                data = new Database(majorName, "compEngCourses.txt");
                break;
            case "Electrical Engineering": 
                data = new Database(majorName, "elecEngCourses.txt");
                break;
            case "Engineering Chemistry": 
                data = new Database(majorName, "engChemCourses.txt");
                break;
            case "Engineering Physics": 
                data = new Database(majorName, "engPhyCourses.txt");
                break;
            case "Industrial and Systems Engineering": 
                data = new Database(majorName, "engPhyCourses.txt");
                break;
            case "Information Technology": 
                data = new Database(majorName, "infoTechCourses.txt");
                break;
            case "Mechanical Engineering": 
                data = new Database(majorName, "mechEngCourses.txt");
                break;
            default:
                data = new Database(majorName, "compSciCourses.txt");
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
