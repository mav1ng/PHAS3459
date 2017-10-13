package module2;

public class Complex {
	
	double x;
	double y;
	
	//constructor
	public Complex(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	//get the real parts of the complex number
	public double real() {
		return this.x;
	}
	
	//get the imaginary parts of the complex number
	public double imag() {
		return this.y;
	}
	
	//get the modulus of the complex number
	public double modulus() {
		double modvar;
		modvar = Math.sqrt((this.x*this.x + this.y*this.y));
		return modvar;
	}
	
	//get the angle of the complex number
	public double angle() {
		double anglevar = Math.atan(this.y/this.x);
		return anglevar;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
