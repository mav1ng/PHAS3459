package exam1314;

import java.util.ArrayList;

public class MinMaxSpecifier implements Specifier {
	
	double minLat;
	double maxLat;
	
	/**
	 * constructor sets the min and max latitude member variables
	 * @param min double minimium latitude
	 * @param max double maximum latitude
	 */
	public MinMaxSpecifier(double min, double max) {
		minLat = min;
		maxLat = max;
	}

	/**
	 * method that takes in a list of specimen and returns a list of all the speciment from
	 * that list that fall between the min and max latitude
	 */
	@Override
	public ArrayList<Specimen> specify(ArrayList<Specimen> al) throws Exception {
		
		ArrayList<Specimen> specAl = new ArrayList<Specimen>();
		
		for (Specimen s: al) {
			if (minLat < s.latitude && s.latitude < maxLat) {
				specAl.add(s);
			}
		}
		
		return specAl;
	}

}
