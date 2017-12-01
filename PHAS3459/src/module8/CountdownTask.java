package module8;

public class CountdownTask implements Runnable{
	
	private int seconds;
	
	//constructor that creates a CountdownTask object
	//param: number of seconds to count down 
	public CountdownTask (int sec) {
		seconds = sec;
	}
	
	
	//method that further specifies the run() method that
	//is implemented bz the Runnable interface
	@Override
	public void run() {
		System.out.println(seconds);
	}

	
	
	
}
