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

/**
 *
 * @author ladea
 */
public class Database {
    
    private ArrayList<String> majorReq;
    private String majorName;
    private String fileName;
    
    public Database(String majorName, String fileName) {
        this.majorName = majorName;
        this.fileName = fileName;
        majorReq = new ArrayList<>();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            
            String line;
            while ((line = reader.readLine()) != null) {
                majorReq.add(line);
            }
            
            reader.close();
        }
        catch (IOException e) {
            System.out.println("File not found");
        }
    }
    
    public void addCourse(String course) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.append(course + "\n");
            writer.close();
            
            majorReq.add(course);
        }
        catch (IOException e) {
            System.out.println("File not found");
        }
    }
    
    public boolean removeCourse(String course) {
        boolean found = false;
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("compSciCourses.txt")); 
            
            String line;
            ArrayList<String> lines = new ArrayList<>();
            
            while ((line = reader.readLine()) != null) {
                if (!line.equals(course)) {
                    lines.add(line);
                }
                else {
                    found = true;
                    majorReq.remove(course);
                }
            }
            
            reader.close();
            
            BufferedWriter writer = new BufferedWriter(new FileWriter("compSciCourses.txt"));
            
            for (int i = 0; i < lines.size(); i++) {
                writer.write(lines.get(i) + "\n");
            }
            
            writer.close();
        }
        catch (IOException e) {
            System.out.println("File not found");
        }
        
        return found;
    }
    
    public ArrayList<String> getMajorReq() {
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
