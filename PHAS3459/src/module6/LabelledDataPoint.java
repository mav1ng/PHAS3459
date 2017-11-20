package module6;

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
		String output = "data_point_label: " + this.toString();
		return output;
	}
	
	
	
	

}
