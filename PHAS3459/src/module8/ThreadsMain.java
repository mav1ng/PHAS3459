package module8;

public class ThreadsMain {

	public static void main(String[] args) {
		
		//creating the task object
		CountdownTask taskCount = new CountdownTask(10);
		PrimeNumberTask taskPrime = new PrimeNumberTask();
		
		//creating the threads from the task objects
		Thread one = new Thread(taskCount);
		Thread two = new Thread(taskPrime);

		//starting both threads simultaneously
		one.start();
		two.start();
		
		//waiting for the Countdown (thread one) to end
		try {
			one.join();
		}
		catch (InterruptedException e) {
			System.out.println("Error");
		}
		
		//when thread one has ended, interrupting thread two
		two.interrupt();
		
	}

}
