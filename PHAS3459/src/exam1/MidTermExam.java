package exam1;

//importing the needed packages
import java.util.ArrayList;

public class MidTermExam {
	
	public static void main(String[] args) {
		
		System.out.println("Printing the total number of measurements that have been recorded:");
		
		//writing in a try catch block since there might be methods that throw exceptions 
		try {
			
			//getting the data from the url into the arraylist and calling it list
			ArrayList<Measurement> list = Measurement.getDataFromURL("http://www.hep.ucl.ac.uk/undergrad/"
					+ "3459/exam-data/N_extent_v3.0.csv");
			
			//printing out results
			System.out.println("Total number of measurements: " + list.size());
			System.out.println();
			System.out.println();
			
			//printing out results
			System.out.println("Measurement with the lowest total ice extent of the entire period: ");
			System.out.println(Measurement.compareExtent(list));
			System.out.println();
			System.out.println();
			
			//printing out results
			System.out.println("Measurement with the lowest total ice area of the entire period: ");
			System.out.println(Measurement.compareArea(list));
			System.out.println();
			System.out.println();
			
			//printing out the year with the lowest area of ice in each month
			Measurement.analyseMonthlyIceArea(list);
				
			System.out.println();
			System.out.println();
			
			//printing out the difference in area between each year and the previous year. 
			Measurement.analyseAnualAreaDifference(list);
			
			//printing the 5 years with the hieghest drop rate for every month:
			Measurement.analyseLargestDrop(list);
			
			//finding the month with the highest and lowest ice average area
			Measurement.analyseAverage(list);
			
			System.out.println("Approximately, when there will be no ice left in the Arcic?");
			//analysing when there will probably be no ice left in the arctic
			Measurement.extrapolation(list);
			
			System.out.println();
			System.out.println();
			
			System.out.println("Approximately, when there will be no ice left in the Arcic?");
			//analysing pessimisticly when there will probably be no ice left in the arctic
			Measurement.extrapolationPessimistic(list);
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}
