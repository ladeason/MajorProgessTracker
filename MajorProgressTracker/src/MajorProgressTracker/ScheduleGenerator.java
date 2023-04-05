/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MajorProgressTracker;

import java.util.ArrayList;
import java.util.Arrays;

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
    
    public ArrayList<String> generate(String[] coursesTaken) {
        ArrayList<String> remainingCourses;
 
        remainingCourses = data.getMajorReq();
        remainingCourses.removeAll(Arrays.asList(coursesTaken));
        return remainingCourses;
    }
}
