package module6;

public class PowerLawTheory implements Theory{
	
	private double n;

	//constructor that sets the parameters of the function
	public PowerLawTheory (double n) throws Exception {
		this.n = n;
	}
	
	
	//method inherited from the interface
	public double y(double x) {
		
		double y = Math.pow(x, n);
		
		return y;
	}
	
	//method that tells the system how to print out the objects belonging to that class
	public String toString() {
		String output = "The current function is: " + "x^" + n;
		return output;
		
	}
	
}
