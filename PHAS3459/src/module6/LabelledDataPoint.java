package module6;

public class LabelledDataPoint extends DataPoint {
	
	//adding the member variable label
	private String label;
	
	//constructor 
	public LabelledDataPoint(double x, double y, double ey, String label) throws Exception {
		super(x, y, ey);
		this.label = label;
	}
	
	
	

}
