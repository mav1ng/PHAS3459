package module2;


//represents a Complex Number
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
	
	//returns the complex conjugate of the current complex number
	public Complex conjugate() {
		Complex z = new Complex();
		z.y = (-1)*this.y;
		return z;
	}
	
	//returns the normalized current complex number
	public Complex normalised() {
		Complex z = new Complex();
		z.x = z.x/modulus();
		z.y = z.y/modulus();
		return z; 
	}
	
	//checks if entered complex number and current complex number are the same
	public boolean equals(Complex c) {
		if(this.x == c.x & this.y == c.y) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//toString method
	public String toString() {
		return "real parts: " + this.x + "  imaginary parts: " + this.y;
	}
	
	//sets the complex number according to entered magnitude and angle
	public void setFromModulusAngle(double mag, double ang) {
		this.x = mag * Math.cos(ang);
		this.y = mag * Math.sin(ang);
	}
	
	//add() subtract() multiply() and divide() methods
	public static Complex add(Complex z1, Complex z2) {
		Complex z = new Complex ();
		z.x = z1.x + z2.x;
		z.y = z1.y + z2.y;
		return z;
	}
	
	public static Complex subtract(Complex z1, Complex z2) {
		Complex z = new Complex ();
		z.x = z1.x - z2.x;
		z.y = z1.y - z2.y;
		return z;
	}
	
	public static Complex multiply(Complex z1, Complex z2) {
		//(a + bi)(c + di) ==> (ac - bd) + (bc + ad)i 
		Complex z = new Complex((z1.x*z2.x - z1.y*z2.y), (z1.y*z2.x + z1.x*z2.y));
		return z;
	}
	
	public static Complex divide(Complex z1, Complex z2) {
		//(a + bi)/(c + di) ==> ((ac + bd)/(c� + d�)) + ((bc - ad)/(c� + d�))i 
		Complex z = new Complex((z1.x*z2.x + z1.y*z2.y)/(z2.modulus()*z2.modulus()), ((z1.y*z2.x - z1.x*z2.y)/(z2.modulus()*z2.modulus())));
		return z;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
