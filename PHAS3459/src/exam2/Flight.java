package exam2;

public class Flight {
	
	
	/**
	 * String fCode: flight code (e.g. AB002)
	String oCode: origin airport code (e.g. LHR for a flight departing from London Heathrow)
	String dCode: destination airport code (e.g. CDG for a flight arriving at Paris Charles de Gaulle)
	String dDate: departure date in the format yyyy-mm-dd, e.g. 2018-01-02
	String dTime: departure time in local time at the origin airport (e.g. 13:10)
	String aDate: arrival date in the format yyyy-mm-dd, e.g. 2018-01-02
	String aTime: arrival time in local time at the destination airport (e.g. 14:55)
	double cost: cost of the flight in pounds
	 */
	String fCode, oCode, dCode, dDate, dTime, aDate, aTime;
	double cost;
	
	/**
	 * method that defines how to print out the Flight objects.
	 */
	public String toString() {
		String output = "Flight code: " + fCode + "\n" + 
				"Origin Airport: " + oCode + "\n" +
				"Destination Airport: " + dCode + "\n" +
				"Date and Local time of Departure: " + dDate + "  " + dTime + "\n" +
				"Date and Local time of Arrival: " + aDate + "  " + aTime + "\n" +
				"Duration of the Flight: " + ExamPart1.getDuration(dDate, dTime, aDate, aTime) 
				+ "min\n" + "Cost of the Flight: " + cost +"pounds\n\n";
		return output;
	}

}
