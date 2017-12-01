package module8;


public class CountdownTask implements Runnable {
	
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
		for (int i = seconds; i > 0; i--) {
			try {
				System.out.println(i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return;
	}

	
	
	
}
