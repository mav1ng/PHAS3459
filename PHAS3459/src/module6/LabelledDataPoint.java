package module6;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class LabelledDataPoint extends DataPoint {
	
	//adding the member variable label
	private String label;
	
	//constructor 
	public LabelledDataPoint(double x, double y, double ey, String labelIn) throws Exception {
		super(x, y, ey);
		label = labelIn;
	}
	
	
	//method that defines how the objects of the subclass will be printed out
	public String toString() {
		
		//the doubles should be limited to 5 decimal places
				NumberFormat formatter = new DecimalFormat("#0.00000");
		
		String output = label + ":  x = " + formatter.format(getX()) + ", y = " + formatter.format(getY()) + 
				" +- " + formatter.format(getEY()) + "\n";
		
		return output;
	}
	
	
	
	

}
