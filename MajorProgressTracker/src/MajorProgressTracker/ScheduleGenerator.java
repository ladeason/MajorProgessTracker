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
    
    public ScheduleGenerator() {
        
    }
    
    public ArrayList<String> generate(String majorName, String[] coursesTaken) {
        Database data;
        ArrayList<String> remainingCourses;
        
        switch (majorName) {
            case "Computer Science": 
                data = new Database(majorName, "compSciCourses.txt");
                break;
            default:
                data = new Database(majorName, "compSciCourses.txt");
                break;
        }
        
        remainingCourses = data.getMajorReq();
        
        remainingCourses.removeAll(Arrays.asList(coursesTaken));
        
        return remainingCourses;
    }
}
