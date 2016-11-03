import java.util.TreeMap;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TriangleTest {

	Triangle testTriangle;
	
	@Before
    public void before() {
 
        testTriangle = new Triangle();
    }
	
    @Test
    public void testOneNegativeSideOfTrianlge() {
                		
            // assert statement
            assertEquals(testTriangle.getTriangleType(-2, 2, 3), TriangleType.INVALID);            
    }
    
    @Test
    public void testMultipleNegativeSidesOfTrianlge() {
                		
            // assert statement
            assertEquals(testTriangle.getTriangleType(2, -2, -3), TriangleType.INVALID);            
    }

    @Test
    public void testTriangleInequality() {
                		
            // assert statement - 6 (sideA) > 2 (sideB) + 2 (sideC)
            assertEquals(testTriangle.getTriangleType(6, 2, 2), TriangleType.INVALID);            
    }
    
    @Test
    public void testEquilateralTriangle() {
                		
            // assert statement
            assertEquals(testTriangle.getTriangleType(8, 8, 8), TriangleType.EQUILATERAL);            
    }
    
    @Test
    public void testIsoscelesTriangle() {
                		
            // assert statement
            assertEquals(testTriangle.getTriangleType(8, 4, 8), TriangleType.ISOSCELES);            
    }
    
    @Test
    public void testScaleneTriangle() {
                		
            // assert statement
            assertEquals(testTriangle.getTriangleType(3, 4, 6), TriangleType.SCALENE);            
    }
    
    @Test
    public void testMultipleTriangleTypes() {
            
    		Triangle testTriangleA = new Triangle();
    		Triangle testTriangleB = new Triangle();
    		
    		testTriangleA.setSideA(3);
    		testTriangleA.setSideB(3);
    		testTriangleA.setSideC(5);
    		
    		testTriangleB.setSideA(4);
    		testTriangleB.setSideB(4);
    		testTriangleB.setSideC(4);
    		
    		TreeMap<String, Triangle> triangleMap = new TreeMap<String, Triangle>();
    		
    		triangleMap.put("1", testTriangleA);
    		triangleMap.put("2", testTriangleB);
    		
    		TreeMap<String, Triangle> trianglesWithTypes = testTriangle.getMultipleTriangleTypes(triangleMap);
            // assert statement
    		assertEquals(trianglesWithTypes.get("1").getTriangleType(), TriangleType.ISOSCELES);
            assertEquals(trianglesWithTypes.get("2").getTriangleType(), TriangleType.EQUILATERAL);        
    }
}
