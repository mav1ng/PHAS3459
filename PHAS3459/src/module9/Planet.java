package module9;

import java.awt.Color;

/**Class that describes all the Features of the different planets and
 * stores them in this specific planet object
 * 
 * @author zcapmvs
 *
 * @param name of the planet
 * @param diameter diameter of the planet in kilometers
 * @param distanceFromSun in million kilometers
 * @param orbitalPeriod describes the time the planet takes to orbit the sun in days
 * @param planetColor color in which the planet should be represented
 */

public class Planet {
	
	String name;
	long diameter;
	long distanceFromSun;
	double orbitalPeriod;
	Color planetColor;
	
	//constructor, that sets all the variables
	public Planet(String name, long diameter, long distanceFromSun, 
			long orbitalPeriod, Color color) {
		
		this.name = name;
		this.diameter = diameter;
		this.distanceFromSun = distanceFromSun;
		this.orbitalPeriod = orbitalPeriod;
		this.planetColor = color;
		
	}

}
