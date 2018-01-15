package exam1415;

import java.util.ArrayList;

public interface Statistic {
	/**
	 * method that takes in several sea level data points and gives out a real number
	 * @param al list of sea level data points
	 * @return return a real number
	 * @throws Exception 
	 */
	public double calc(ArrayList<Measurement> al) throws Exception;

}
