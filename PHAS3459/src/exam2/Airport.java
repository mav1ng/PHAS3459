package exam2;

public class Airport {

	/**
	 * String code: airport code (e.g. LHR)
	 * String name: full name (e.g. London Heathrow)
	 * String timezone: time zone (e.g. Europe/London)
	 */
	public String code, name, timezone;


	/**
	 * method that defines how to print out the Airport objects.
	 */
	public String toString() {
		String output = "Airport Code: " + code + "\n" +
				"Full Name: " + name + "\n" + 
				"Timezone: " + timezone;
		return output;
	}


}
