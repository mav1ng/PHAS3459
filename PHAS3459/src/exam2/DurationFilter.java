package exam2;

import java.util.ArrayList;

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

}
