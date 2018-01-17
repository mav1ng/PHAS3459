package exam2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;

public class ExamPart3 {


	/**
	 * method that returns the cheapest flight within a list of flights
	 * @param al	arraylist that stores all the flights that should be considered
	 * @return	Flight returns Flight object with the lowest price
	 * @throws Exception ---
	 */
	public static Flight getCheapestFlight(ArrayList<Flight> al) throws Exception{

		double minCost = 0;
		Flight cheapestFlight = new Flight();

		//looping over the list of flights to find the cheapest flight
		for (Flight f : al) {
			if(minCost == 0 || minCost > f.cost) {
				minCost = f.cost;
				cheapestFlight = f;
			}
		}

		return cheapestFlight;

	}

	/**
	 * method that returns the cheapest journey within a list of pairs of flights
	 * @param al	arraylist that stores all the pairs of flights that should be considered
	 * @return	Pair<Flight, Flight> returns Pair object with the lowest price
	 * @throws Exception ---
	 */
	public static Pair<Flight, Flight> getMultiCheapestFlight(ArrayList<Pair<Flight, Flight>> al) throws Exception{

		double minCost = 0;
		Pair<Flight, Flight> cheapestJourney = new Pair<Flight, Flight>(null, null);

		//looping over the list of flights to find the cheapest flight
		for (Pair<Flight, Flight> p : al) {
			double totalcost = p.getKey().cost + p.getValue().cost;
			if(minCost == 0 || minCost > totalcost) {
				minCost = totalcost;
				cheapestJourney = p;
			}
		}

		return cheapestJourney;

	}

	/**
	 * method that returns all flights ending in CPT
	 * @param al ArrayList of flights
	 * @return ArrayList of flights ending in CPT
	 * @throws Exception throws exception if data structure doesn't work correctly
	 */
	public static ArrayList<Flight> getSecondFlights(ArrayList<Flight> al) throws Exception {

		ArrayList<Flight> secondFlights = new ArrayList<Flight>();

		//looping over the flights and picking out the ones ending in CPT
		for (Flight f: al) {
			if(f.dCode.equals("CPT")) {
				secondFlights.add(f);
			}
		}

		return secondFlights;

	}

	/**
	 * method that returns all flights ending in an airport that has a flight to CPT
	 * @param al ArrayList of flights
	 * @return ArrayList of flights ending in an airport that has a flight to CPT
	 * @throws Exception throws exception if data structure doesn't work correctly
	 */
	public static ArrayList<Flight> getFirstFlights(ArrayList<Flight> al, ArrayList<Flight> secondFlights) throws Exception {

		ArrayList<Flight> firstFlights = new ArrayList<Flight>();
		boolean tester = false;

		//looping over the flights and picking out the ones ending in an airport 
		//that has a flight to CPT
		for (Flight f: al) {
			for (Flight secondF: secondFlights) {
				if (f.dCode.equals(secondF.oCode)) {
					tester = true;
					break;
				}
			}
			if(tester) {
				firstFlights.add(f);
			}
			tester = false;
		}

		return firstFlights;

	}

	/**
	 * method that prints out flight details of flight pairs
	 * @param p pair of two flights
	 * @param hm hashmap<String, Airport> of airport codes and according to them the airports
	 * @throws Exception throws exception when data structures aren't processable
	 */
	public static void printMultiFlightDetails(Pair<Flight, Flight> p, HashMap<String, Airport> hm) throws Exception {

		System.out.println("The Journey consists of two flights in that order:\n");

		ExamPart1.printFlightDetails(p.getKey(), hm);
		ExamPart1.printFlightDetails(p.getValue(), hm);

	}

	/**
	 * method that compares a Flight and a Journey of two flights regarding the cost and
	 * prints out the details from the lower price choice
	 * @param f Flight Fligth to be compared
	 * @param p Pair<Flight, Flight> journey to be compared
	 * @param hm hashmap<String, Airport> of airport codes and according to them the airports
	 * @throws Exception throws exception when data structures aren't processable
	 */
	public static void compareSingleMulti(Flight f, Pair<Flight, Flight> p, HashMap<String, Airport> hm) throws Exception {
		if (f.cost <= (p.getKey().cost + p.getValue().cost)) {
			ExamPart1.printFlightDetails(f, hm);
		}
		else if (f.cost >= (p.getKey().cost + p.getValue().cost)) {
			printMultiFlightDetails(p, hm);
		}

	}




	public static void main(String[] args) {

		System.out.println("\n\n--------------------------PART3-------------------------\n");

		//storing the files in appropriate data structures
		try {
			HashMap<String, Airport> airports = ExamPart1.getAirports("http://www.hep.ucl.ac.uk/undergrad/3459/"
					+ "exam-data/2017-18/airports.txt");
			ArrayList<Flight> flights = ExamPart1.getFlights("http://www.hep.ucl.ac.uk/undergrad/3459/"
					+ "exam-data/2017-18/flights.txt");


			System.out.println("\nPrinting the details of the cheapest one or two flight journey from \n" 
					+ "LHR to CPT with a total duration of less than 24 hours:\n\n");

			//creating the implementation objects 
			AirportFilter aFilter = new AirportFilter("LHR", "CPT");
			DurationFilter dFilter = new DurationFilter(24 * 60); 

			//creating the filtered ArrayList<FLight>
			ArrayList<Flight> filteredFlights = dFilter.filter(aFilter.filter(flights));

			//storing the cheapest one flight journey
			Flight cheapestFlight = getCheapestFlight(filteredFlights);

			//storing all the journeys in pairs that go from LHR to CPT and are under 
			//a total duration of 24hours
			ArrayList<Pair<Flight, Flight>> filteredMultiFlights = dFilter.multiFilter(
					getFirstFlights(flights, getSecondFlights(flights)), getSecondFlights(flights));

			//storing the cheapest two flight journey
			Pair<Flight, Flight> cheapestJourney = getMultiCheapestFlight(filteredMultiFlights);

			//comparing the two possibilities and printing out the cheapest choice
			compareSingleMulti(cheapestFlight, cheapestJourney, airports);

			System.out.println("In that case arrival time and date of the first flight fit with \n"
					+ "the departure date and time of the second flight. Thus this journey is possible and\n"
					+ "the cheapest choice");



		}
		catch (IOException e) {
			//specified error message for IOException
			System.out.println("The data on the website might not be suited for the specified scanner. \n"
					+ "check if the scanner is working correctly!");
			e.printStackTrace();
		} catch (Exception e) {
			//specified error message for Exception
			System.out.println("Something with the correct storage of the Data has gone wrong. Check if \n"
					+ "there is some mistake regarding the data structures!");
			e.printStackTrace();
		}

	}
}

