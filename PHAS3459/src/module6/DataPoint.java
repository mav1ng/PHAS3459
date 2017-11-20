package module6;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;		//importing the Scanner class of java

public class DataPoint {

	private double x, y, ey;	//defining the member variables
	
	public DataPoint(double x, double y, double ey) throws Exception {
		
		//setting the values
		this.x = x;		//parameter set by the experimenter
		this.y = y;		//measurement
		this.ey = ey;	//measurement error on y
	}
	
	
	//method to define how the object DataPoint should be printed out
	public String toString() {
		
		NumberFormat formatter = new DecimalFormat("#0.00000");
		
		String output = "x = " + formatter.format(x) + ", y = " + formatter.format(y) + 
				"+- " + formatter.format(ey);
		
		return output;
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
	
	
	
	//method that takes in a data line and returns the corresponding DataPoint Object
	public static DataPoint createFromURL(String line) throws Exception {
		
		
		try ( //defining the new scanner
		Scanner sc = new Scanner(line).useLocale(Locale.ENGLISH); )
		
		
		{	
			DataPoint dp = new DataPoint(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
			return dp; //returning the DataPoint object here
		}
		catch (Exception e) {
			throw e;
		}

	}
	

}
