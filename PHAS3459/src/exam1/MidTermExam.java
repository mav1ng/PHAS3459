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
			System.out.println();
			System.out.println();
			
			System.out.println("Measurement with the lowest total ice extent of the entire period: ");
			System.out.println(Measurement.compareExtent(list));
			System.out.println();
			System.out.println();
			
			System.out.println("Measurement with the lowest total ice area of the entire period: ");
			System.out.println(Measurement.compareArea(list));
			System.out.println();
			System.out.println();
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}
