package module6;

public class QuadraticTheory implements Theory {
	
	private double a, b, c; //parameters of the function
	
	//constructor setting the parameters
	public QuadraticTheory(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	//overriding the inherited methoed from the interface
	public double y(double x) {
		
		double y = a * Math.pow(x, 2) + b * x + c;
		
		return y;
		
	}
	
}
