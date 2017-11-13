package midterm1516;

import java.util.ArrayList;

public class midtermexam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayList<DataEQ> al = new ArrayList<DataEQ>();
		ArrayList<DataEQ> alMonth = new ArrayList<DataEQ>();
		
		try {
		
			//getting the data and storing the data in the arraylist
			al = Data.getDataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/earthquakesCA1989.txt");
		
			System.out.println("Total number of earthquakes recorded in the file:");
			System.out.println(al.size());
			
			
			System.out.println();
			System.out.println();
		
			
			//printing the details of the deepest earthquake
			System.out.println("The details of the deepest Earthquake:");
			System.out.println(Data.analyseMag(al));
			
			System.out.println();
			System.out.println();
			
			for (int i = 1; i < 13; i++) {
				alMonth = Data.monthList(i, al);
				System.out.println("Number of Earthquakes for month " + i +": " + alMonth.size());
				
			}
			
			System.out.println();
			System.out.println();
			
			for (int i = 1; i < 13; i++) {
				alMonth = Data.monthList(i, al);
				DataEQ deepestEarthq = new DataEQ();
				deepestEarthq = Data.analyseMag(alMonth);
				
				System.out.println();
				System.out.println("Deepest earthquake of month " + i +": " + deepestEarthq);

				
			}
			
			for (int i = 1; i < 13; i++) {
				alMonth = Data.monthList(i, al);
				DataEQ accEarthq = new DataEQ();
				accEarthq = Data.analyseErr(alMonth);
				
				System.out.println();
				System.out.println("Earthquake with most accurate depth measurement of month " + i +": " + accEarthq);
			
			}
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}
