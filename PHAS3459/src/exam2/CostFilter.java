package exam2;

import java.util.ArrayList;

import javafx.util.Pair;

public class CostFilter implements Filter {

	private double maxcost; //maximum flight cost
	
	/**
	 * Constructor with sets the maximum cost
	 * @param cost double maximum cost for the flights
	 */
	public CostFilter(double cost) {
		maxcost = cost;
	}


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


	@Override
	public ArrayList<Pair<Flight, Flight>> multiFilter(ArrayList<Flight> al, ArrayList<Flight> al2) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



}
