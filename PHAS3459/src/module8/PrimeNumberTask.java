package module8;

import java.util.ArrayList;

public class PrimeNumberTask implements Runnable{

	//method that further specifies the run() method that
	//is implemented from the Runnable interface
	@Override
	public void run() {
		
		//getting the ArrayList that is not really neccesary but
		//asked for in the exercise
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		
		//declaring the needed variables
		int largestInt = 0, largestPrime = 0, primeCount = 0;
		
		//looping to find the prime numbers as long as the run() method is not 
		//interrupted by the main mehtod
		while (true) {
			
			//printing out the results if interrupted
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("Largest Number checked: " + largestInt);
				System.out.println("Largest Prime found: " + largestPrime);			
				System.out.println("Number of Primes found: " + primeCount);
				break;
			}
			
			//looping through all integers to find prime numbers
			for(int i = 0; true && !Thread.currentThread().isInterrupted(); i++) {
				
				largestInt = i;
				boolean test = true;
				
				for(int k = 2; k < i; k++) {
					
					//simplest algorithm to find prime numbers
					//speed could be improved by using another one
					if(i % k == 0) {
						test = false;
						break;
					}
					
				}
				
				//if prime number add to the list and increment the prime
				//counter
				if (test) {
					primeList.add(i);
					primeCount++;
					largestPrime = i;
				}
				
			}
			
		}
		
		return;
		
	}
	
}
