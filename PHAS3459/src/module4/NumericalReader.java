package module4;


import java.io.*;
import java.net.URL;
import java.lang.Character.*;


public class NumericalReader {
	
	private double minValue, maxValue, nValues, sumOfValues; //declaring the private variables
	
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
			if (line.isEmpty() || Character.isLetter(line.charAt(0))) {
			}
			else {
				
				//printing the numbers out to the screen
				for (int i = 0; i <= 2; i++) {
				System.out.println(line.substring(i, i+1));
				}
				
				//storing the numbers in a file
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("numberFile"))));
				for (int i = 0; i<=2; i++) {
					pw.println(line.substring(i, i+1));	
				}	
			}
		}
		catch (Exception e) {
			throw (e);
		}
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
