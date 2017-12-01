package module8;

import java.util.ArrayList;

public class PrimeNumberTask implements Runnable{

	@Override
	public void run() {
		
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		int largestInt = 0, largestPrime = 0, primeCount = 0;
		
		while (true) {
			
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("Largest Number checked: " + largestInt);
				System.out.println("Largest Prime found: " + largestPrime);			
				System.out.println("Number of Primes found: " + primeCount);
				break;
			}
			
			for(int i = 0; true && !Thread.currentThread().isInterrupted(); i++) {
				
				largestInt = i;
				boolean test = true;
				
				for(int k = 2; k < i; k++) {
					
					if(i % k == 0) {
						test = false;
						break;
					}
					
					}
				
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
