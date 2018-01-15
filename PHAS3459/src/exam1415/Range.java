package exam1415;

import java.util.ArrayList;

public class Range implements Statistic {

	@Override
	/**
	 * method that calculates the range of the sea levels of one list of sea
	 * level recordings
	 */
	public double calc(ArrayList<Measurement> al) throws Exception {
		
		double maxLevel = 0;
		double minLevel = 0;
		
		for (Measurement m: al) {
			if (maxLevel < m.level) {
				maxLevel = m.level;
			}
			if (minLevel > m.level || minLevel == 0) {
				minLevel = m.level;
			}
		}
		
		return maxLevel - minLevel;
	}

	
	
}
