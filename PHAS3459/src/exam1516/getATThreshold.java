package exam1516;

import java.util.ArrayList;

public class getATThreshold implements CalculationOfAT {
	
	public double threshold;
	
	
	public getATThreshold(double t) {
		threshold = t;
	}
	

	@Override
	public double getArrivalTime(ArrayList<Double> al) throws Exception {
		double output = 0;
		for (int i = 0; i < al.size(); i++) {
			if (al.get(i) >= threshold) {
				output = (double)(i);
				break;
			}
		}
		return output;
	}
	

}
