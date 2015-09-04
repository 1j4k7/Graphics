/**
 * @author Jason Kuo
 * 9/2/2015
 * IllegalTriangleException is thrown any time a triangle with illegal dimensions
 * is created. This exception is used by the Triangle class
 */
public class IllegalTriangleException extends RuntimeException {
	public IllegalTriangleException() {
		super("Illegal Triangle");
	}
}
