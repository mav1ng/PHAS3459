package module8;

import java.util.Random;
import java.util.concurrent.Callable;

public class MonteCarloPiCalculatorTask implements Callable<Double> {

	private double nPoints;
	
	//constructor
	//parameter: number of Points used to estimate pi
	public MonteCarloPiCalculatorTask(double number) {
		nPoints = number;
	}
	
	//took the MonteCarloPiCalculatorTask method from the notes
	public Double call() {
		
		 Random rand = new Random();
		 long nIn = 0;
		 for (long iPoint = 0; iPoint < nPoints; ++iPoint) {
		 double x = rand.nextDouble();
		 double y = rand.nextDouble();
		 double r2 = x*x + y*y;
		 if (r2 < 1.0) ++nIn;
		 }
		 double pi = 4.0 * nIn / nPoints;
		 
		return pi;
		
	}
	
	

}
