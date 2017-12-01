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
		int startTime = (int)(System.currentTimeMillis()/1000);
		boolean timer = true;
		int timeDif;
		
		System.out.println(seconds);
		
			while (timer) {
				timeDif = (int)(System.currentTimeMillis())/1000 - startTime; 
				if (timeDif == 1) {
					seconds--;
					startTime = (int)(System.currentTimeMillis()/1000);
					System.out.println(seconds);
				}
				if (seconds == 0) {
					timer = false;
				}
			}
			
			return;

	}

	
	
	
}
