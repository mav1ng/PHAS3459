package exam1415;

import java.util.ArrayList;

public class Mean implements Statistic {


	/**
	 * method that calculates the mean of all the given sea-level readings
	 * and gives out the mean of all of those
	 */
	@Override
	public double calc(ArrayList<Measurement> al) throws Exception {

		double sum = 0;

		for(Measurement m: al) {
			sum = sum + m.level;
		}

		return sum/al.size();

	}



}
