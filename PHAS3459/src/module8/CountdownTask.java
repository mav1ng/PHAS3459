package module8;

public class CountdownTask implements Runnable{
	
	private int seconds;
	
	//constructor that creates a CountdownTask object
	//param: number of seconds to count down 
	public CountdownTask (int sec) {
		seconds = sec;
	}
	
	
	//method that further specifies the run() method that
	//is implemented by the Runnable interface
	@Override
	public void run() {
		float startTime = System.nanoTime();
		boolean timer = true;
		float timeDif;
		
		System.out.println(seconds);
		
			while (timer) {
				timeDif = System.nanoTime() - startTime; 
				if (timeDif % 1000000000 == 0.000000000) {
					seconds--;
					startTime = System.nanoTime();
					System.out.println(seconds);
				}
				if (seconds == 0) {
					timer = false;
					System.out.println("Finished");
				}
			}
			
			return;

	}

	
	
	
}
