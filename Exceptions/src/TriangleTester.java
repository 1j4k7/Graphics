/**
 * @author Jason Kuo
 * 9/2/2015
 * TriangleTester tests the triangle class with some test values.
 */
public class TriangleTester {

	public static void main(String[] args) {
		System.out.println("Jason Kuo, Graphics, Period 1");
		Triangle testTri = null;
		try {
			System.out.println("Creating triangle (12, 12, 12)...");
			testTri = new Triangle(12, 12, 12);
			System.out.println("Triangle creation (12, 12, 12) was successful");
			System.out.println("Creating triangle (1, 1, 3)...");
			testTri = new Triangle(1, 1, 3);
			System.out.println("Triangle creation (1, 1, 3) was successful");
		}
		catch (IllegalTriangleException ex) {
			ex.printStackTrace();
		}
	}

}
