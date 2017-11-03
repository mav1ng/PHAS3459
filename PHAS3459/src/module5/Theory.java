package module5;

public class Theory {
	
	private int n; //n is the power of x
	
	//constructor setting the value of n
	public Theory(int n) {
		this.n = n;
	}
	
	//method that calculates y by calling the function y = x^n
	public double y(double x) throws Exception {
		if (this.n < 0 && x == 0) {
			throw new Exception ("You are dividing by zero. Y diverges for x against 0.");
		}
		//calling the java.math.pow method to calculate y
		return Math.pow(x, n);	
	}

}
