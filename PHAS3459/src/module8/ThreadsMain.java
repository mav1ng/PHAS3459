package module8;

public class ThreadsMain {

	public static void main(String[] args) {
		
		CountdownTask taskCountdown = new CountdownTask(10);
		PrimeNumberTask taskPrime = new PrimeNumberTask();
		
		Thread one = new Thread(taskCountdown);
		Thread two = new Thread(taskPrime);
		
		try {
			one.start();
			two.start();
		} catch (Exception e) {
			two.interrupt();
		}
	
	}

}
