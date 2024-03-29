package module6;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;		//importing the Scanner class of java

public class DataPoint {

	protected double x;	//defining the member variables
	protected double y;
	protected double ey;
	
	public DataPoint(double x, double y, double ey) throws Exception {
		
		//setting the values
		this.x = x;		//parameter set by the experimenter
		this.y = y;		//measurement
		this.ey = ey;	//measurement error on y
	}
	
	
	//method to define how the object DataPoint should be printed out
	public String toString() {
		
		//the doubles should be limited to 5 decimal places
		NumberFormat formatter = new DecimalFormat("#0.00000");
		
		//defining the way that the should be printed to the screen
		String output = "x = " + formatter.format(x) + ", y = " + formatter.format(y) + 
				" +- " + formatter.format(ey) +"\n";
		
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
		
		
		 //defining the new scanner
		Scanner sc = new Scanner(line);
		Scanner scE = sc.useLocale(Locale.ENGLISH); 
		
		//getting the data from the line that is input
		DataPoint dp = new DataPoint(scE.nextDouble(), scE.nextDouble(), scE.nextDouble());
		
		sc.close();
		
		return dp; //returning the DataPoint object here

	}
	

}
