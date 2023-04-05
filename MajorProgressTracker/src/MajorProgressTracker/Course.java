/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MajorProgressTracker;

/**
 *
 * @author ladea
 */
public class Course {
    
    private String courseNum;
    private String courseName;
    
    public Course(String courseNum) {
        this.courseNum = courseNum;
        this.courseName = "[no course name]";
    }
    
    public Course(String courseNum, String courseName) {
        this.courseNum = courseNum;
        this.courseName = courseName;
    }
    
    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public String getCourseNum() {
        return this.courseNum;
    }
    
    public String getCourseName() {
        return this.courseName;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        
        if (!(o instanceof Course)) {
            return false;
        }
        
        Course c = (Course) o;
        
        return courseNum.equals(c.getCourseNum());
    }
    
    @Override
    public String toString() {
        return (courseNum + " - " + courseName);
    }
}
