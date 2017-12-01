package module8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadsTimer {

	
	public static void main(String[] args) {
		
		//number of points that should be used to estimate pi
		long nPoints = 10000000L;
		
		//creating the MonteCarloPiCalculatorTask object with the specified
		//number of points
		MonteCarloPiCalculatorTask single = new MonteCarloPiCalculatorTask(nPoints);
		
		//starting the time measurement
		long startingTime = System.currentTimeMillis();
		
		//calling the method for the singleThread pi calculation
		double pi1 = single.call();
		
		//ending the time measurement and calculation the needed time 
		//and printing out the results.
		long endTime = System.currentTimeMillis();
		System.out.println("The pi calculated within one thread was");
		System.out.println(pi1);
		long timeTaken = endTime - startingTime;
		System.out.println("and it took " + timeTaken + " milliseconds to calculate.");
		
		//starting the time measurement
		startingTime = System.currentTimeMillis();
		
		//creating the needed object for the multi-thread calculation
		ExecutorService threadPool = Executors.newFixedThreadPool(4);
		List<Future<Double>> futures = new ArrayList<Future<Double>>();
		
		//looping over the single threads using the future variable and 
		//the thread pool so the thread can be operated simultaneously
		for (int iThread = 0; iThread < 4; ++iThread) {
			
			MonteCarloPiCalculatorTask task = new MonteCarloPiCalculatorTask(nPoints/4);
			Future<Double> future = threadPool.submit(task);
			futures.add(future);
			
		}
		
		//declaring the variable to sum up the single pi/4 calculations
		double sum = 0.0;
		for (int iThread = 0; iThread < 4; ++iThread) {
			double result;
			//try- and multi-catch block
			try {
				result = futures.get(iThread).get();
				sum += result;
			} catch (InterruptedException | ExecutionException e) {
				System.out.println("An error occured!");
				e.printStackTrace();
			}
		}
		
		//closing the threadPool
		threadPool.shutdown();
		
		//calculating pi as the mean 
		double pi2 = sum/4;
		
		//ending the time measurement
		endTime = System.currentTimeMillis();
		
		//calculating the needed time and printing out all the results 
		System.out.println("The pi calculated within 4 threads was:");
		System.out.println(pi2);
		timeTaken = endTime - startingTime;
		System.out.println("and it took " + timeTaken + " milliseconds to calculate.");
		
		//Short resume of single and multithread calculations
		System.out.println();
		System.out.println("Explanaition:");
		System.out.println("Estimating pi within one thread always takes more time \n"
				+ "than calculating pi within four threads. Nevertheless, the estimated \n"
				+ "value of pi mostly is more accurate when it is calculated within \n"
				+ "one thread. We could assume that the multithread calculations might \n"
				+ "be faster than the single thread calcualtions in general.");
		
	}

}
