package module5;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Minerals {
	
	//creating the HashMap for the minerals with its mass
	static HashMap<Double, Double> codeMass = new HashMap<Double, Double>();
	//Location and Code of the minerals
	static HashMap<Double, String> locCode = new HashMap<Double, String>();
	
	
	//method that gets the information from the website and fills the information into the HashMap
	public static HashMap<Double, Double> getDataFromURL(String url) throws Exception {
		
		//creating the BuffereReader from with the Stream from the URL
		URL inWebsite1 = new URL(url);
		InputStream inStream = inWebsite1.openStream();
		InputStreamReader inReader = new InputStreamReader(inStream);
		BufferedReader br = new BufferedReader(inReader);
		
		String line; //declaring the String variable line
		
		//filling in the HashMap
		while ((line = br.readLine()) != null) {
			Scanner scanner = new Scanner(line);
			Scanner sc = scanner.useLocale(Locale.ENGLISH);
			codeMass.put(sc.nextDouble(), sc.nextDouble());
			scanner.close();
		}
		
		//Closing all the streams
		inStream.close();
		inReader.close();
		br.close();
		
		return codeMass;
		
	}
	
	//method that gets the information from the website and fills in the information into the second HashMap
	public static HashMap<Double, String> getDataFromURL2(String url) throws Exception {
		
		//creating the BuffereReader from with the Stream from the URL
		URL inWebsite1 = new URL(url);
		InputStream inStream = inWebsite1.openStream();
		InputStreamReader inReader = new InputStreamReader(inStream);
		BufferedReader br = new BufferedReader(inReader);
		
		String line; //declaring the String variable line
		String location; //variable for the location of a mineral
		
		//filling in the HashMap
		while ((line = br.readLine()) != null) {
			Scanner scanner = new Scanner(line);
			Scanner sc = scanner.useLocale(Locale.ENGLISH);
			location = sc.next();
			locCode.put(sc.nextDouble(), location);
			scanner.close();
		}
		
		//Closing all the streams
		inStream.close();
		inReader.close();
		br.close();
		
		return locCode;
		
	}
	
	//method to compare and print out the maximum Mass and according code and location and 
	//same with the minimum Mass
	public static void analyseData(HashMap<Double, Double> hpMass, 
			HashMap<Double, String> hmLoc) throws Exception {
		
		//creating a collection with the different mass values of the minerals
		Collection<Double> massValues = hpMass.values();
		//creating a iteration with the different mass values of the minerals
		Iterator<Double> mV = massValues.iterator();
		
		//declaring the needed variables
		double maxMass = 0;
		double minMass = 0;
		double nextMass = 0;
		
		//finding the maximum and the minimum mass in the iteration
		while (mV.hasNext()) {
			if (maxMass < (nextMass = mV.next())) {
				maxMass = nextMass;
			}
			if (minMass == 0 || minMass > nextMass ) {
				minMass = nextMass;
			}
		}
		
		//defining the needed variables 
		double maxCode = 0, minCode = 0;
		String maxLoc = "", minLoc = "";

		//getting the code for the mineral with the maximum mass and minimum mass
		if (codeMass.containsValue(maxMass)) {
			for (Map.Entry<Double, Double> entry : codeMass.entrySet()) {
				if (entry.getValue() == maxMass) {
					maxCode = entry.getKey();
				}
				if (entry.getValue() == minMass) {
					minCode = entry.getKey();
				}
			}
			
			//getting the location for the mineral with the maximum mass and minimum mass
			for(Map.Entry<Double, String> entry2 : locCode.entrySet()) {
				if (entry2.getKey() == maxCode) {
					maxLoc = entry2.getValue();
				}
				if (entry2.getKey() == minCode) {
					minLoc = entry2.getValue();
				}
			}
			
		}
		
		//printing out the results
		System.out.println("The mineral with the maximum mass " + maxMass 
								+ "g has the code " + (int)(maxCode) +".");
		
		System.out.println("It has been found in the location " + maxLoc + ".");
		System.out.println();
		System.out.println("The mineral with the minimum mass " + minMass
								+ "g has the code " + (int)(minCode) +".");
		
		System.out.println("It has been found in the location " + minLoc + ".");
		
		
	}
	
	
	public static void main(String[] args) {
		
		//getting the data from the website with the getDataFromURL methods and analysing the data with
		//the analyseData() method
		try {
			getDataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt");
			getDataFromURL2("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-locations.txt");
			analyseData(codeMass, locCode);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
		
	
}
