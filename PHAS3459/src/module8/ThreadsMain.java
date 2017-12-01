package module8;

public class ThreadsMain {

	public static void main(String[] args) {
		
		CountdownTask taskCount = new CountdownTask(10);
		PrimeNumberTask taskPrime = new PrimeNumberTask();
		
		Thread one = new Thread(taskCount);
		Thread two = new Thread(taskPrime);

		one.start();
		two.start();
		
		try {
			one.join();
		}
		catch (InterruptedException e) {
			System.out.println("Error");
		}

		two.interrupt();
		
	}

}
