import java.util.Map;
import java.util.TreeMap;

public class Triangle {
	
	private double sideA;
	private double sideB;
	private double sideC;
	private TriangleType triangleType;
	
	public Triangle() {

	}
	
	public Triangle(double sideA, double sideB, double sideC) {

		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
		this.setTriangleType(getTriangleType(sideA, sideB, sideC));
	}
	
	public double getSideA() {
		return sideA;
	}

	public void setSideA(double sideA) {
		this.sideA = sideA;
	}

	public double getSideB() {
		return sideB;
	}

	public void setSideB(double sideB) {
		this.sideB = sideB;
	}

	public double getSideC() {
		return sideC;
	}

	public void setSideC(double sideC) {
		this.sideC = sideC;
	}

    /**
     * Method to get triangle types for single triangle
     * @param sideA first side of a triangle
     * @param sideB second side of a triangle
     * @param sideC third side of a triangle
     * @return TriangleType returns type of a triangle based on
     * 		   three sides of a triangle
     */
	public TriangleType getTriangleType(double sideA, double sideB, double sideC) {
						
	    if (sideA <= 0 || sideB <= 0 || sideC <= 0) 
	    	return TriangleType.INVALID;
	     
	    else if(sideA >= sideB + sideC || sideC >= sideB + sideA ||
	    		sideB >= sideA + sideC)			
	    	return TriangleType.INVALID;				
	    
	    else if(sideA == sideB && sideB == sideC)	
	    	return TriangleType.EQUILATERAL;
	     
	    else if(sideA == sideB || sideB == sideC ||
	    		sideC == sideA)				
	    	return TriangleType.ISOSCELES;
	
		return TriangleType.SCALENE;
	}
	
	public TriangleType getTriangleType() {
		return this.triangleType;
	}
	
	public void setTriangleType(TriangleType triangleType) {
		this.triangleType = triangleType;
	}
	
    /**
     * Method to get triangle types for multiple triangles in one shot / call
     * @param triangleSet Map containing triangle id as key and triangle as value
     * @return TreeMap<String, TriangleType> returns map of triangle id as key 
     * 		   and TriangleType as a value 
     */
	public TreeMap<String, Triangle> getMultipleTriangleTypes(TreeMap<String, Triangle> triangleSet) {
		
		TreeMap<String, Triangle> trianglesWithTypes = new TreeMap<String, Triangle>();
		
		if(triangleSet != null) {
			for(Map.Entry<String,Triangle> entry : triangleSet.entrySet()) {
				  String key = entry.getKey();
				  Triangle value = entry.getValue();
				  value.setTriangleType(getTriangleType(value.getSideA(), value.getSideB(), value.getSideC()));
				  trianglesWithTypes.put(key, value);
				}
		}
		return trianglesWithTypes;
	}
}
