package module8;

import java.util.Random;

public class MonteCarloPiCalculatorTask implements Runnable {

	private long nPoints;
	
	//constructor
	//parameter: number of Points used to estimate pi
	public MonteCarloPiCalculatorTask(int number) {
		nPoints = number;
	}
	
	//took the MonteCarloPiCalculatorTask method from the notes
	@Override
	public void run() {
		
		 Random rand = new Random();
		 long nIn = 0;
		 for (long iPoint = 0; iPoint < nPoints; ++iPoint) {
		 double x = rand.nextDouble();
		 double y = rand.nextDouble();
		 double r2 = x*x + y*y;
		 if (r2 < 1.0) ++nIn;
		 }
		 double pi = 4.0 * nIn / nPoints;
		 
		 System.out.println(pi);
	}
	
	

}
