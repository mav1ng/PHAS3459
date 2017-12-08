package module9;

/**Class that describes all the Features of the different planets
 * 
 * @author zcapmvs
 *
 * @param name of the planet
 * @param diameter diameter of the planet in kilometers
 * @param distanceFromSun in million kilometers
 * @param orbitalPeriod describes the time the planet takes to orbit the sun
 */

public class Planet {
	
	String name;
	double diameter;
	double distanceFromSun;
	double orbitalPeriod;
	
	public Planet(String name, double diameter, double distanceFromSun, 
			double orbitalPeriod) {
		
		this.name = name;
		this.diameter = diameter;
		this.distanceFromSun = distanceFromSun;
		this.orbitalPeriod = orbitalPeriod;
		
	}

}
