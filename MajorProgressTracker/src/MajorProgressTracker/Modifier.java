/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MajorProgressTracker;

/**
 *
 * @author ladea
 */
public class Modifier {
    
    public Modifier() {
        
    }
    
    public void addCourse(String majorName, String course) {
        Database data;
        
        switch (majorName) {
            case "Computer Science": 
                data = new Database(majorName, "compSciCourses.txt");
                break;
            default:
                data = new Database(majorName, "compSciCourses.txt");;
                break;
        }
        
        data.addCourse(course);
    }
    
    public boolean removeCourse(String majorName, String course) {
        Database data;
        
        switch (majorName) {
            case "Computer Science": 
                data = new Database(majorName, "compSciCourses.txt");
                break;
            default:
                data = new Database(majorName, "compSciCourses.txt");;
                break;
        }
        
        return data.removeCourse(course);
    }
}
