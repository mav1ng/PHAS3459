package exam1;

import java.util.ArrayList;

public class MidTermExam {
	
	public static void main(String[] args) {
		
		System.out.println("Printing the total number of measurements that have been recorded:");
		
		try {
			
			//getting the data from the url into the arraylist and calling it list
			ArrayList<Measurement> list = Measurement.getDataFromURL("http://www.hep.ucl.ac.uk/undergrad/"
					+ "3459/exam-data/N_extent_v3.0.csv");
			
			System.out.println("Total number of measurements: " + list.size());
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}
