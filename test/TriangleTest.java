import static org.junit.Assert.*;
import java.util.TreeMap;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void testOneNegativeSideOfTrianlge() {
            
    		Triangle tester = new Triangle();
    		
            // assert statement
            assertEquals(tester.getTriangleType(-2, 2, 3), TriangleType.INVALID);            
    }
    
    @Test
    public void testMultipleNegativeSidesOfTrianlge() {
            
    		Triangle tester = new Triangle();
    		
            // assert statement
            assertEquals(tester.getTriangleType(2, -2, -3), TriangleType.INVALID);            
    }

    @Test
    public void testTriangleInequality() {
            
    		Triangle tester = new Triangle();
    		
            // assert statement - 6 (sideA) > 2 (sideB) + 2 (sideC)
            assertEquals(tester.getTriangleType(6, 2, 2), TriangleType.INVALID);            
    }
    
    @Test
    public void testEquilateralTriangle() {
            
    		Triangle tester = new Triangle();
    		
            // assert statement
            assertEquals(tester.getTriangleType(8, 8, 8), TriangleType.EQUILATERAL);            
    }
    
    @Test
    public void testIsoscelesTriangle() {
            
    		Triangle tester = new Triangle();
    		
            // assert statement
            assertEquals(tester.getTriangleType(8, 4, 8), TriangleType.ISOSCELES);            
    }
    
    @Test
    public void testScaleneTriangle() {
            
    		Triangle tester = new Triangle();
    		
            // assert statement
            assertEquals(tester.getTriangleType(3, 4, 6), TriangleType.SCALENE);            
    }
    
    @Test
    public void testMultipleTriangleTypes() {
            
    		Triangle testTriangle = new Triangle();
    		Triangle testTriangleA = new Triangle();
    		Triangle testTriangleB = new Triangle();
    		
    		testTriangleA.setSideA(3);
    		testTriangleA.setSideB(3);
    		testTriangleA.setSideC(5);
    		
    		testTriangleB.setSideA(4);
    		testTriangleB.setSideB(4);
    		testTriangleB.setSideC(4);
    		
    		TreeMap<String, Triangle> triangleSet = new TreeMap<String, Triangle>();
    		
    		triangleSet.put("1", testTriangleA);
    		triangleSet.put("2", testTriangleB);
    		
    		TreeMap<String, Triangle> trianglesWithTypes = testTriangle.getMultipleTriangleTypes(triangleSet);
            // assert statement
    		assertEquals(trianglesWithTypes.get("1").getTriangleType(), TriangleType.ISOSCELES);
            assertEquals(trianglesWithTypes.get("2").getTriangleType(), TriangleType.EQUILATERAL);        
    }
}
