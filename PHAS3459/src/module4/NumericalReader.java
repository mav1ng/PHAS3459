package module4;


import java.io.*;
import java.net.URL;
import java.lang.Character.*;


public class NumericalReader {
	
	private double minValue, maxValue, nValues, sumOfValues;
	
	//defining the method that promps user to input string and then stores it
	public static String getStringFromKeyboard() throws Exception {
		
		System.out.println("Please enter a String!");
		
		try {
		
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String input = in.readLine();
			return input;
			
		}
		
		catch (Exception e) {
			
			throw (e);
		
		}
	}
	
	public BufferedReader brFromURL(String urlName) throws Exception {
		try {
			//creating a new URL object it will throw an exception when the entered urlName is not a URL
			URL website = new URL(urlName);
			//creating the BufferedReader object 
			BufferedReader in = new BufferedReader(new InputStreamReader(website.openStream()));
			return in;
		}
		catch (Exception e) {
			throw (e);
		}	
	}
	
	public void analysisStart(String dataFileIn) throws Exception {
		
		try {
		
		File dataFile = new File(dataFileIn);
		
		//initializing the private variables
		minValue = 0;
		maxValue = 0;
		nValues = 0;
		sumOfValues = 0;

		}
		catch (Exception e) {
			throw (e);
		}
	}
		
	
	public void analyseData(String line) throws Exception {
		try {
			@SuppressWarnings("deprecation")
			Character first = new Character (line.charAt(0));
			if (line.isEmpty() || Character.isLetter(first)) {
			}
			else {
				
				System.out.println(line.substring(0, 1));
				System.out.println();
				System.out.println(line.substring(1, 2));
				System.out.println();
				System.out.println(line.substring(2, 3));
				
				
			}
		}
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
