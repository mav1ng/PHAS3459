package CarlaTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataAnalysis {
	
	public static HashMap<String, Double> highestSeaLevel(Map<String, ArrayList<Tide>> hm) {

		HashMap<String, Double> highestLevel = new HashMap<String, Double>();

		for (String key: hm.keySet()) {
			double maxLevel = 0.;
			//System.out.println(maxLevel);
			for (Tide data : hm.get(key)) {
				if (data.seaLevel  > maxLevel) {
					maxLevel = data.seaLevel;
				}
			}
			highestLevel.put(key, maxLevel);
		}
		
		return highestLevel;
	}
	
	
	public static HashMap<String, Double> lowestSeaLevel(Map<String, ArrayList<Tide>> hm1, HashMap<String, Double> hm2) {

		HashMap<String, Double> lowestLevel = new HashMap<String, Double>();

		for (String key: hm1.keySet()) {
			double minLevel = hm2.get(key);
			for (Tide data : hm1.get(key)) {
				if (data.seaLevel  < minLevel) {
					minLevel = data.seaLevel;
				}
			}
			lowestLevel.put(key, minLevel);
		}
		
		return lowestLevel;
	}
	

}
