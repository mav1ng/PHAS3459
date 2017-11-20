package module6;

public class PowerLawTheory implements Theory{
	
	private double n;

	//constructor that sets the parameters of the function
	public PowerLawTheory (int n) throws Exception {
		this.n = n;
	}
	
	
	//method inherited from the interface
	public double y(double x) {
		
		double y = Math.pow(x, n);
		
		return y;
	}
	
}
