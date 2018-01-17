package exam2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ExamPart2 {
	
	/**
	 * method that returns the shortest flight within a list of flights
	 * @param al	arraylist that stores all the flights that should be considered
	 * @return	Flight returns Flight object with the shortest duration
	 * @throws Exception ---
	 */
	public static Flight getQuickestFlight(ArrayList<Flight> al) throws Exception{
		
		
		long minDuration = 0;
		Flight shortestFlight = new Flight();
		
		for (Flight f : al) {
			long duration = ExamPart1.getDuration(f.dDate, f.dTime, f.aDate, f.aTime);
			if(minDuration == 0 || minDuration > duration) {
				minDuration = duration;
				shortestFlight = f;
			}
		}
		
		return shortestFlight;
		
	}

	
	public static void main(String[] args) {

		System.out.println("\n\n--------------------------PART2-------------------------\n");

		//storing the files in appropriate data structures
		try {
			HashMap<String, Airport> airports = ExamPart1.getAirports("http://www.hep.ucl.ac.uk/undergrad/3459/"
					+ "exam-data/2017-18/airports.txt");
			ArrayList<Flight> flights = ExamPart1.getFlights("http://www.hep.ucl.ac.uk/undergrad/3459/"
					+ "exam-data/2017-18/flights.txt");
			
			
			System.out.println("\n\nPrinting the details of all flights from LHR to ATH \n" 
					+ "that cost no more than £200\n\n");
			
			//creating the implementation objects 
			CostFilter cFilter = new CostFilter(200.);
			AirportFilter aFilter = new AirportFilter("LHR", "ATH");
			
			//creating the filtered ArrayList<FLight>
			ArrayList<Flight> filteredFlights = aFilter.filter(cFilter.filter(flights));
			
			//printing out the flight details of the filteredFlights
			for (Flight f: filteredFlights) {
				ExamPart1.printFlightDetails(f, airports);
			}
			
			
			
			System.out.println("\n\nPrinting the details of all flights from LHR to ATH \n" 
					+ "that take no more than four hours in total\n\n");
			
			//creating the next implementation object
			DurationFilter dFilter = new DurationFilter(240L);
			
			//creating the filtered ArrayList<FLight>
			ArrayList<Flight> filteredFlights2 = dFilter.filter(aFilter.filter(flights));
			
			//printing out the flight details of the filteredFlights
			for (Flight f: filteredFlights2) {
				ExamPart1.printFlightDetails(f, airports);
			}
			
			
			
			System.out.println("\n\nPrinting the details of the quickest flight from \n" 
					+ "LHR to ATH that costs no more that 200pounds\n\n");
			
			//creating the filtered ArrayList<FLight>
			ArrayList<Flight> filteredFlights3 = cFilter.filter(aFilter.filter(flights));
			
			//printing out the flight details of the shortest Flight
			ExamPart1.printFlightDetails(getQuickestFlight(filteredFlights3), airports);
			
			
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
