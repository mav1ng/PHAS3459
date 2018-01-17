package exam2;

import java.util.ArrayList;

import javafx.util.Pair;

public class DurationFilter implements Filter {

	long duration;

	/**
	 * Constructor with sets the duration limit
	 * @param durationLimit long maximum duration for the flights in min
	 */
	public DurationFilter(long durationLimit) {
		duration = durationLimit;
	}


	/**
	 * method that filter flights with a duration no more than than some specified limit
	 * @param al arrayList of flights that should be filtered
	 */
	@Override
	public ArrayList<Flight> filter(ArrayList<Flight> al) throws Exception {
		ArrayList<Flight> filteredFlights = new ArrayList<Flight>();

		//filtering the flights on whether their duration is short enough
		for (Flight f : al) {
			if (ExamPart1.getDuration(f.dDate, f.dTime, f.aDate, f.aTime) <= duration) {
				filteredFlights.add(f);
			}
		}
		return filteredFlights;
	}


	/**
	 * method that returns a list of all the pairs of flights that can be flown after each other
	 * and are shorter than the specified duration in total
	 * @param first Arraylist of the Flights that have a Fligth in the second list
	 * @param second ArrayList of the Flights that go to the airport CPT
	 * @return ArrayList of A pair of Flight that work together and are under the total specified duration
	 * @exception throws excpetion when the data structures aren't known
	 */
	@Override
	public ArrayList<Pair<Flight, Flight>> multiFilter(ArrayList<Flight> first, ArrayList<Flight> second) throws Exception {

		ArrayList<Pair<Flight, Flight>> output = new ArrayList<Pair<Flight, Flight>>(); 
		boolean tester = false;

		for (Flight f: first) {
			long duration1 = ExamPart1.getDuration(f.dDate, f.dTime, f.aDate, f.aTime);
			for (Flight s: second) {
				long duration2 = ExamPart1.getDuration(s.dDate, s.dTime, s.aDate, s.aTime);
				if (f.dCode.equals(s.oCode)) {
					tester = true;
					if(tester) {
						if ((duration1 + duration2) <= duration) {
							Pair<Flight, Flight> currentPair = new Pair<Flight, Flight>(f, s);
							output.add(currentPair);
						}
					}
					tester = false;
				}
			}
		}
		
		return output;
	}

}


