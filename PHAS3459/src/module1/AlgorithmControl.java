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
	long intValB = timeNow;
	long intValA;
	int w = 0;
	int countvar = 0;
	int iremainder;
	boolean timervar = true;
			
	public void timer() {
		while (timervar) {
			
			long timeNow = System.currentTimeMillis();
			intValA = timeNow;
			iremainder = (int) (intValA % intValB);
			timervar = (iremainder<=10000);
			w++;
			
			if (w==100) {
				w = 0;
				countvar = countvar + 100;
				System.out.println(countvar);	
			}
			
		}
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AlgorithmControl ac = new AlgorithmControl();
		ac.timer();
		
	}

}
