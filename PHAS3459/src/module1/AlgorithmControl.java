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
	long intValA = timeNow;
	long intValB;
	int w = 0;
	boolean timervar = true;
			
	public void timer() {
		while (timervar) {
			intValB = timeNow;
			timervar = (intValA % intValB)<=10000;
			
		}
	}
		//change


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}
