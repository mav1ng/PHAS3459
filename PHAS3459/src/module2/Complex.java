package module2;

public class Complex {
	
	double x;
	double y;
	
	public Complex(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double real() {
		return this.x;
	}
	
	public double imag() {
		return this.y;
	}
	
	public double modulus() {
		double modvar;
		modvar = Math.sqrt((this.x*this.x + this.y*this.y));
		return modvar;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
