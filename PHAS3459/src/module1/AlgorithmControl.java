package module1;

public class AlgorithmControl {
	
	
	
	int i = 0;
	int imax = 10;
	
	public void loop() {
		for ( i = 0; i <= imax; i++) {
			System.out.println(i);
		}
	}	
		
	boolean stop = true;
	int x = 5;
		
	public void decrement() {
		while (stop) {
			x--;
			stop = (x>(-12));
		}
	}
	
	boolean stop1 = true;
	double y = 2.4;
	
	public void increment() {
		while (stop1) {
			y = y+0.2;
			stop1 = (y <= 8.8);
		}
		
	}
	
	
	long timeNow = System.currentTimeMillis();
	long intValB;
	long intValA;
	int w = 0;
	int iremainder;
	int totalLoops;
	int loopSteps;
	long maxTime;
	boolean timervar = true;
			
	public int timer(long maxTime, int loopSteps) {
		
		timeNow = System.currentTimeMillis();
		intValB = timeNow;
		
		while (timervar) {
			
			long timeNow = System.currentTimeMillis();
			intValA = timeNow;
			iremainder = (int) (intValA % intValB);
			timervar = (iremainder<=maxTime);
			w++;
			
			if (w==loopSteps) {
				w = 0;
				totalLoops = totalLoops + loopSteps;
				System.out.println(totalLoops);	
			}
			
		}
		
		iremainder = 0;
		timervar = true;
		
		return totalLoops;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AlgorithmControl ac = new AlgorithmControl();
		
		int result1 = ac.timer(8000, 1000);
		System.out.println("Total number of loops: " + result1);
		
		int result2 = ac.timer(8000, 40000);
		System.out.println("Total number of loops: " + result2);
		System.out.println(" ");
		
		System.out.println("First go: " + result1 + " Second go: " + result2);
		
		System.out.println("The number of total loops of the second go is significantly larger then the one of the first go. The reason for that is the time the system needs to print out a line. Since, in the first go the System has to print out every 1000th loop, which is a lot more than every 40000th, it needs a lot more time. Since the maxTime is the same for both runs the total number of loops is significantly different.");
	}

}
