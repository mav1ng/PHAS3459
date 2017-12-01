package module8;

import java.util.ArrayList;

public class PrimeNumberTask implements Runnable{

	@Override
	public void run() {
		
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		
		while(!Thread.currentThread().isInterrupted()) {
			
			for(int i = 0; true; i++) {
				
				boolean test = true;
				
				for(int k = 2; k < i; k++) {
					
					if(i % k == 0) {
						test = false;
						break;
					}
					
					}
				
				if (test) {
					primeList.add(i);
				}
				
			}
		}
		
		return;
		
	}
	
}
