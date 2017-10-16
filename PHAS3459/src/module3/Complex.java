package module3;


//represents a Complex Number
public class Complex {
	
	//declaring the variables
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
		//calculation of the modulus by using pythagoras
		modvar = Math.sqrt((this.x*this.x + this.y*this.y));
		return modvar;
	}
	
	//get the angle of the complex number
	public double angle() {
		//calculating the angle
		double anglevar = Math.atan(this.y/this.x);
		return anglevar;
	}
	
	//returns the complex conjugate of the current complex number
	public Complex conjugate() {
		Complex z = new Complex();
		//calculating the complex conjugate
		z.y = (-1)*this.y;
		return z;
	}
	
	//returns the normalized current complex number
	public Complex normalised() {
		Complex z = new Complex();
		//normalising the complex number: dividing by the modulus of it
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
		//setting the real parts of the complex variable
		this.x = mag * Math.cos(ang);
		//setting the imaginary parts of the complex variable
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
		//calculating the complex multiplication
		//(a + bi)(c + di) ==> (ac - bd) + (bc + ad)i 
		Complex z = new Complex((z1.x*z2.x - z1.y*z2.y), (z1.y*z2.x + z1.x*z2.y));
		return z;
	}
	
	public static Complex divide(Complex z1, Complex z2) throws Exception {
		//adding the Exception
		if (z2 == ZERO) {
			throw new Exception("You cannot divide by zero!");
		}
		//calculating the complex division
		//(a + bi)/(c + di) ==> ((ac + bd)/(c² + d²)) + ((bc - ad)/(c² + d²))i 
		Complex z = new Complex((z1.x*z2.x + z1.y*z2.y)/(z2.modulus()*z2.modulus()), ((z1.y*z2.x - z1.x*z2.y)/(z2.modulus()*z2.modulus())));
		return z;
	}
	
	//defining the static variables
	static Complex ONE = new Complex(1, 0);
	static Complex ZERO = new Complex(0, 0);
	static Complex I = new Complex(0, -1);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
