package module5;

public class DataPoint {

	private double x, y, ey;	//defining the member variables
	
	public DataPoint(double x, double y, double ey) throws Exception {
		
		//setting the values
		this.x = x;
		this.y = y;
		this.ey = ey;
	}
	
	//defining the methods to get the different member variables

	//method to get the value of x
	public double getX() {
		return this.x;
	}
	
	//method to get the value of x
	public double getY() {
		return this.y;
	}
	
	//method to get the value of ey
	public double getEY() {
		return this.ey;
	}
	
	
}
