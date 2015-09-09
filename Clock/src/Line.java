/**
 * @author Jason Kuo
 * 9/4/2015
 * Line represents a generic line on the clock. This is used for tick marks and
 * clock hands.
 */
public class Line {
	private int angle;//in degrees
	private int radius;
	
	public Line(int angle, int radius) {
		this.angle = angle;
		this.radius = radius;
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
}
