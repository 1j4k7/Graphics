/**
 * @author Jason Kuo
 * 9/2/2015
 * Triangle represents a triangle where the sum of any 2 sides is greater than
 * the other side. It throws an IllegalTriangleException if this rule is violated.
 */
public class Triangle {
	
	private double side1;
	private double side2;
	private double side3;
	
	/**
	 * Default constructor that creates a triangle with sides of length 1.0
	 */
	public Triangle() {
		this.side1 = 1.0;
		this.side2 = 1.0;
		this.side3 = 1.0;
	}
	
	/**
	 * Constructor that creates a triangle with side lengths based on the parameters
	 * @param side1, the length of side 1
	 * @param side2, the length of side 2
	 * @param side3, the length of side 3
	 * @throws IllegalTriangleException is thrown when the sum of the length of 2 sides is greater than the other
	 */
	public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
		if (side1 + side2 <= side3) throw new IllegalTriangleException();
		if (side2 + side3 <= side1) throw new IllegalTriangleException();
		if (side1 + side3 <= side2) throw new IllegalTriangleException();
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
}
