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
