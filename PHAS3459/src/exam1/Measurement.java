package exam1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Measurement {
	
	
	//declaring the variables as statet in the exam paper
	public int year = 0;
	public int mo = 0;
	public String type = "";
	public String region = "";
	public double extent = 0;
	public double area = 0;
	
	
	//defining the toString method to clarify how the Measurement objects should be printed out
	public String toString() {
		
		String output = "Measurement of Month " + mo + " in the year " + year + " :" + "\n" +
		"data-type: " + "type" + "\n" + "Region of the Measurement" + region + "\n" +
				"extent of the measurement: " + extent + "\n" + "area of the measurement :" + area;
		
		
		return output;
	}
	

	
	//method that takes data from one line and creates a Measurement object with it
	public static Measurement parseData(String line) throws Exception {
		
		//creating that new measurement object where the data should be stored in
		Measurement m = new Measurement();
		
		Scanner sc = new Scanner(line);
		Scanner scD = sc.useDelimiter(",\\s*");
		Scanner scE = scD.useLocale(Locale.ENGLISH);
		
		//setting the year variable
		if (scE.hasNextInt()) {
			m.year = scE.nextInt();
		}
		
		//setting the month variable
		if (scE.hasNextInt()) {
			m.mo = scE.nextInt();
		}
		
		//setting the data-type variable
		if (scE.hasNext()) {
			m.type = scE.next();
		}
		
		//setting the region variable
		if (scE.hasNext()) {
			m.region = scE.next();
		}
		
		//setting the extent variable
		if (scE.hasNextDouble()) {
			m.extent = scE.nextDouble();
		}
		
		//setting the area variable
		if (scE.hasNextDouble()) {
			m.area = scE.nextDouble();
		}
		
		//closing the scanner
		sc.close();
		
		return m;
		
	}

	//method that takes information from a website to parse the information into measurement objects and 
	//then puts them into an arraylist
	public static ArrayList<Measurement> getDataFromURL(String url) throws Exception {
		
		String line;
		Measurement currentM = new Measurement();
		ArrayList<Measurement> mList = new ArrayList<Measurement>();
		
		//creating an URL with given String 
		URL website = new URL(url);
		
		//creating an InputStream with the given URL
		InputStream inputS = website.openStream();
		
		//creating an inputStreamReader with given InputStream
		InputStreamReader inReader = new InputStreamReader(inputS);
		
		//creating bufferedReader with given inputStreamReader
		BufferedReader br = new BufferedReader(inReader);
		
		
		//skipping the first line in the given url
		br.readLine();
		
		while ((line = br.readLine()) != null) {
			
			//creating the object with the given data in the line
			currentM = parseData(line);
			
			//adding it to the arraylist
			mList.add(currentM);
			
		}
		
		//closing all the inputStreams
		inputS.close();
		
		return mList;
		
	}
	
	
	
	//method to compare the measurement objects in an arraylist and giving out the on with te lowest 
	//total ice extend
	public static Measurement compareExtent(ArrayList<Measurement> mList) throws Exception {
		
		Measurement currentM = new Measurement();
		Measurement maxE = new Measurement();
		
		
		//looping over the whole arraylist
		for (int i = 0; i < mList.size(); i++) {
			
			currentM = mList.get(i);
			
			if(maxE.extent == 0 && currentM.extent != -9999) {
				
				maxE = currentM;
				
			}
			
			if(currentM.extent < maxE.extent && currentM.extent != -9999) {
				
				maxE = currentM;
				
			}
			
		}
		
		return maxE;
		
	}
	
	

	

}
