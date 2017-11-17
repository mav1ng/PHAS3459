package exam1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
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
			
			//if maxE has not been set already and measurement is not missing
			if(maxE.extent == 0 && currentM.extent != -9999) {
				
				//set maxE
				maxE = currentM;
				
			}
			
			//if the Ice extend of maxE is bigger than that of the current measurement 
			//and the data is not missing
			if(currentM.extent < maxE.extent && currentM.extent != -9999) {
				
				//set the max Measumrent to the current one
				maxE = currentM;
				
			}
			
		}
		
		return maxE;
		
	}
	
	
	//method to compare the measurement objects in an arraylist and giving out the on with the lowest 
	//total ice area
	public static Measurement compareArea(ArrayList<Measurement> mList) throws Exception {
		
		Measurement currentM = new Measurement();
		Measurement maxA = new Measurement();
		
		
		//looping over the whole arraylist
		for (int i = 0; i < mList.size(); i++) {
			
			currentM = mList.get(i);
			
			//if maxA has not been set already and measurement is not missing
			if(maxA.area == 0 && currentM.area != -9999) {
				
				//set maxA
				maxA = currentM;
				
			}
			
			//if the Ice area of maxA is bigger than that of the current measurement 
			//and the data is not missing
			if(currentM.area < maxA.area && currentM.area != -9999) {
				
				//set maxA
				maxA = currentM;
				
			}
			
		}
		
		return maxA;
		
	}
	
	
	//method that creates a hashmap containing arraylists that contain the measurements of a distinct month
	public static HashMap<Integer, ArrayList<Measurement>> getMonthList(ArrayList<Measurement> mainList) throws Exception {
		
		//creating the needed objects and variables
		Measurement currentM = new Measurement();
		Integer currentMonth;
		HashMap<Integer, ArrayList<Measurement>> monthList = new HashMap<Integer, ArrayList<Measurement>>();
		
		//looping over the mainList
		for (int i = 0; i < mainList.size(); i++) {
			
			//getting the Measurement from the main list
			currentM = mainList.get(i);
			
			//getting the month from the current Measurement and storing it in currentMonth
			currentMonth = currentM.mo;
			
			//getting the distinct list of measurement in one month from the HashMap
			ArrayList<Measurement> cM = monthList.get(currentMonth);
			
			//if theres not an existing arraylist already create a new one
			if (cM == null) {
				monthList.put(currentMonth, new ArrayList<Measurement>());
			}
			
			//adding the player to the arraylist
			monthList.get(currentMonth).add(currentM);
			
		}
		
		return monthList;
		
	}
	
	
	//method that analyses the list reagarding to months and prints out the one with the lowest
	//ice area in the month
	public static void analyseMonthlyIceArea(ArrayList<Measurement> list) throws Exception {
		
	
		//getting the HashMap of the monthlists 
		HashMap<Integer, ArrayList<Measurement>> monthList = Measurement.getMonthList(list);
		
		//creating the needde objects
		ArrayList<Measurement> currentList = new ArrayList<Measurement>();
		Measurement minArea = new Measurement();
		Measurement currentArea = new Measurement();
		
		for (Integer i : monthList.keySet()) {
			
			//getting the current list
			currentList = monthList.get(i);
			
			//resetting
			minArea = new Measurement();
			currentArea = new Measurement();
			
			//looping over the current list
			for (int k = 0; k < currentList.size(); k++ ) {
				
				currentArea = currentList.get(k);
				
				if (minArea.area == 0 && currentArea.area != -9999) {
					
					minArea = currentArea;
					
				}
				
				if (minArea.area > currentArea.area && currentArea.area != -9999) {
					
					minArea = currentArea;
					
				}
				
			}
			
			System.out.println("For the month " + i + " the year " + minArea.year + " had the lowest"
					+ " total area of ice!");
			System.out.println();
			System.out.println();
	
		}
		
	}
		
		
		
		//method that caclulates and prints out the difference in area between each year 
		//and the previous year for each month
		public static void analyseAnualAreaDifference(ArrayList<Measurement> list) throws Exception {
			
			
			//getting the HashMap of the monthlists 
			HashMap<Integer, ArrayList<Measurement>> monthList = Measurement.getMonthList(list);
			
			//creating the needed objects
			ArrayList<Measurement> currentList = new ArrayList<Measurement>();
			Measurement lastYearArea = new Measurement();
			Measurement currentArea = new Measurement();
			double difference = 0;
			String output ="";
			
			for (Integer i : monthList.keySet()) {
				
				//getting the current list
				currentList = monthList.get(i);
				
				//resetting
				lastYearArea = new Measurement();
				currentArea = new Measurement();
				difference = 0;
				
				//looping over the current list but leaving out object one since 
				// there cannot be a difference calculated for the first year
				for (int k = 1; k < currentList.size(); k++ ) {
					
					currentArea = currentList.get(k);
					lastYearArea = currentList.get(k-1);
					
					//calculating the difference
					difference = currentArea.area - lastYearArea.area;
					
					output = output + "\n" + "\n" + "The difference of the area between year " + currentArea.year +
							" and " + lastYearArea.year + " is: "  + difference;
					
				}
					
				
				System.out.println("Month " + i + "\n" + "--------------------------------" + "\n");
				System.out.println(output);
				System.out.println();
				
			}
				

		
		}
	

}
	

