/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import MajorProgressTracker.Course;
import MajorProgressTracker.Modifier;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author ladea
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ModifierTest {
    
    private Modifier mod;
    
    public ModifierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        mod = new Modifier("Test Major");
    }
    
    @After
    public void tearDown() {
        mod = null;
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //   
    @Test
    public void testAddCourse() {
        ArrayList<Course> expected = new ArrayList<>();
        ArrayList<Course> actual;
        
        expected.add(new Course("CSI 1420", "Introduction to C Programming and Unix (4)"));
        expected.add(new Course("CSI 2300", "Object-Oriented Computing (4)"));
        expected.add(new Course("CSI 2310", "Data Structures (4)"));
        expected.add(new Course("CSI 3000", "Test Course (4)"));
        
        mod.addCourse(new Course("CSI 3000", "Test Course (4)"));
        actual = mod.getCourses();
        
        assertTrue(expected.equals(actual));
    }
    
    @Test
    public void testModifyCourse() {
        ArrayList<Course> expected = new ArrayList<>();
        ArrayList<Course> actual;
        
        expected.add(new Course("CSI 1420", "Introduction to C Programming and Unix (4)"));
        expected.add(new Course("CSI 2300", "Object-Oriented Computing (4)"));
        expected.add(new Course("CSI 2310", "Data Structures (4)"));
        expected.add(new Course("CSI 3000", "New Test Course (4)"));
        
        mod.modifyCourse(new Course("CSI 3000", "New Test Course (4)"));
        actual = mod.getCourses();
        
        assertTrue(expected.equals(actual));
    }
    
    @Test
    public void testRemoveCourse() {
        ArrayList<Course> expected = new ArrayList<>();
        ArrayList<Course> actual;
        
        expected.add(new Course("CSI 1420", "Introduction to C Programming and Unix (4)"));
        expected.add(new Course("CSI 2300", "Object-Oriented Computing (4)"));
        expected.add(new Course("CSI 2310", "Data Structures (4)"));
        
        mod.removeCourse(new Course("CSI 3000"));
        actual = mod.getCourses();
        
        assertTrue(expected.equals(actual));
    }
}
