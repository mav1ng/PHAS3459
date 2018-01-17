package exam2;

import java.util.ArrayList;

public class AirportFilter implements Filter {
	
	private String origin, destination; //origin code of the flight and 
										//destination code of the flight

	/**
	 * method that filters flights with a specified origin and destination airport
	 */
	@Override
	public ArrayList<Flight> filter(ArrayList<Flight> al) throws Exception {
		
		ArrayList<Flight> filteredList = new ArrayList<Flight>();
		
		//looping over the Flight list to check whether destination and origin 
		//code are the same
		for (Flight f : al) {
			if (f.oCode.equals(origin) && f.dCode.equals(destination)) {
				filteredList.add(f);
			}
		}
		
		return filteredList;
	}

}
