/**
 * @author Jason Kuo
 * 9/11/2015
 * Complex is a class that represents a complex number.
 * There are methods for multiple operations between complex numbers.
 */
public class Complex {
	
	private double r;//real part
	private double i;//imaginary part
	
	public Complex(double r, double i) {
		this.r = r;
		this.i = i;
	}

	public Complex add(Complex n) {
		return new Complex(this.r + n.r, this.i + n.i);
	}
	
	public Complex subtract(Complex n) {
		return new Complex(this.r - n.r, this.i - n.i);
	}
	
	public Complex times(Complex n) {
		return new Complex(this.r*n.r - this.i*n.i, this.r*n.i + this.i*n.r);
	}
	
	public Complex divide(Complex n) {
		return new Complex((this.r*n.r - this.i*n.i) / Math.pow(n.r, 2)+Math.pow(n.i, 2), (this.r*n.i + this.i*n.r)/Math.pow(n.r, 2)+Math.pow(n.i, 2));
	}
	
	public double abs() {
		return Math.sqrt(Math.pow(this.r, 2) + Math.pow(this.i, 2));
	}
}
