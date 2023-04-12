/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MajorProgressTracker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author ladea
 */
public class MajorRequirements {
    
    private ArrayList<Course> majorReq;
    private String fileName;
    
    public MajorRequirements(String fileName) {
        this.fileName = fileName;
        majorReq = new ArrayList<>();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            
            String line;
            String[] courseNumName;
            String courseNum;
            String courseName;
            while ((line = reader.readLine()) != null) {
                courseNumName = line.split(" - ");
                courseNum = courseNumName[0];
                if (courseNumName.length <= 1) {
                    majorReq.add(new Course(courseNum));
                }
                else {
                    courseName = courseNumName[1];
                    majorReq.add(new Course(courseNum, courseName));
                }
            }
            
            reader.close();
        }
        catch (IOException e) {
            System.out.println("File not found");
        }
    }
    
    public boolean addCourse(Course course) {
        boolean contains;
        
        contains = majorReq.contains(course);
        
        if (!contains) {
            majorReq.add(course);
            Collections.sort(majorReq, Comparator.comparing(Course::getCourseNum));
            
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

                for (int i = 0; i < majorReq.size(); i++) {
                    writer.write(majorReq.get(i) + "\n");
                }

                writer.close();      
            }
            catch (IOException e) {
                System.out.println("File not found");
            }
        }
        
        return contains;
    }
    
    public boolean modifyCourse(Course course) {
        boolean contains;
        
        contains = majorReq.contains(course);
        
        if (contains) {
            majorReq.get(majorReq.indexOf(course)).setCourseName(course.getCourseName());
            Collections.sort(majorReq, Comparator.comparing(Course::getCourseNum));
            
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

                for (int i = 0; i < majorReq.size(); i++) {
                    writer.write(majorReq.get(i) + "\n");
                }

                writer.close();      
            }
            catch (IOException e) {
                System.out.println("File not found");
            }
        }
        
        return contains;
    }
    
    public boolean removeCourse(Course course) { 
        boolean found;
        
        found = majorReq.remove(course);
        
        if(found) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

                for (int i = 0; i < majorReq.size(); i++) {
                    writer.write(majorReq.get(i) + "\n");
                }

                writer.close();
            }
            catch (IOException e) {
                System.out.println("File not found");
            }
        }
        
        return found;
    }
    
    public ArrayList<Course> getMajorReq() {
        return majorReq;
    }
    
//    public void printCourses() {
//        for (int i = 0; i < major.getSize(); i++) {
//            System.out.println(major.getCourse(i).getCourseNum());
//        }
//        System.out.println();
//    }
//    
//    @Override
//    public String toString() {
//        String string = "";
//        for (int i = 0; i < major.getSize(); i++) {
//            string = string.concat(major.getCourse(i).getCourseNum() + "\n");
//        }
//        return string;
//    }
}
