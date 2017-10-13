package module2;

public class Complex {
	
	double x;
	double y;
	
	//constructor
	public Complex() {};
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
	
	public Complex conjugate() {
		Complex z = new Complex();
		z.y = (-1)*this.y;
		return z;
	}
	
	public Complex normalised() {
		Complex z = new Complex();
		z.x = z.x/modulus();
		z.y = z.y/modulus();
		return z; 
	}
	
	public boolean equals(Complex c) {
		if(this.x == c.x & this.y == c.y) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return "real parts: " + this.x + "  imaginary parts: " + this.y;
	}
	
	
	public void setFromModulusAngle(double mag, double ang) {
		this.x = mag * Math.cos(ang);
		this.y = mag * Math.sin(ang);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
