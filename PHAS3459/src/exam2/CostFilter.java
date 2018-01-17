package exam2;

import java.util.ArrayList;

public class CostFilter implements Filter {

	private double maxcost; //maximum flight cost


	/**
	 * method that filters a lift of Flights on the cost
	 * @param al ArrayList of Flights that should be filtered
	 * @return ArrayList filtered ArrayList of FLights
	 */
	@Override
	public ArrayList<Flight> filter(ArrayList<Flight> al) throws Exception {
		
		ArrayList<Flight> filteredFlights = new ArrayList<Flight>();
		
		//filtering the flights on whether their cost is low enough
		for (Flight f : al) {
			if (f.cost <= maxcost) {
				filteredFlights.add(f);
			}
		}
		return filteredFlights;
	}

}
