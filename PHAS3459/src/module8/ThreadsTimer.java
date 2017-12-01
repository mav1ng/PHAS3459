package module8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadsTimer {

	public static void main(String[] args) {
		
		long nPoints = 10000000L;
		
		MonteCarloPiCalculatorTask single = new MonteCarloPiCalculatorTask(nPoints);
		
		long startingTime = System.currentTimeMillis();
		double pi1 = single.call();
		long endTime = System.currentTimeMillis();
		
		System.out.println("The pi calculated within one thread was");
		System.out.println(pi1);
		
		
		long timeTaken = endTime - startingTime;
		System.out.println("and it took " + timeTaken + " milliseconds to calculate.");
		
		
		startingTime = System.currentTimeMillis();
		 
		ExecutorService threadPool = Executors.newFixedThreadPool(4);
		List<Future<Double>> futures = new ArrayList<Future<Double>>();
		
		for (int iThread = 0; iThread < 4; ++iThread) {
			
			MonteCarloPiCalculatorTask task = new MonteCarloPiCalculatorTask(nPoints/4);
			Future<Double> future = threadPool.submit(task);
			futures.add(future);
			
		}
		
		double sum = 0.0;
		for (int iThread = 0; iThread < 4; ++iThread) {
			double result;
			try {
				result = futures.get(iThread).get();
				sum += result;
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		 
		threadPool.shutdown();
		double pi2 = sum/4;
		endTime = System.currentTimeMillis();
		
		System.out.println("The pi calculated within 4 threads was:");
		System.out.println(pi2);
		
		timeTaken = endTime - startingTime;
		System.out.println("and it took " + timeTaken + " milliseconds to calculate.");
		
		
		System.out.println();
		System.out.println("Explanaition:");
		System.out.println("Estimating pi within one thread always takes more time \n"
				+ "than calculating pi within four threads. Nevertheless, the estimated \n"
				+ "value of pi mostly is more accurate when it is calculated within \n"
				+ "one thread. We coudl assume that the multithread calculations might \n"
				+ "be faster than the single thread calcualtions in general.");
		
	}

}
