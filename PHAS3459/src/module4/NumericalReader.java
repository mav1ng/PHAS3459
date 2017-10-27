package module4;


import java.io.*;
import java.net.URL;
import java.util.Scanner;
import java.lang.Character;
import java.lang.Integer;


public class NumericalReader {
	
	private double minValue, maxValue, nValues, sumOfValues; //declaring the private variables
	
	//defining the method that prompts user to input string and then stores it
	public static String getStringFromKeyboard() throws Exception {
		
		System.out.println("Please enter a String!");
		
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String input = in.readLine();
			return input;
	}
	
	public BufferedReader brFromURL(String urlName) throws Exception {
		
			//creating a new URL object it will throw an exception when the entered urlName is not a URL
			URL website = new URL(urlName);
			//creating the BufferedReader object 
			BufferedReader in = new BufferedReader(new InputStreamReader(website.openStream()));
			return in;
			
	}
	
	
	public void analysisStart(String dataFileIn) throws Exception {
		
		File dataFile = new File(dataFileIn);
		
		//initializing the private variables
		minValue = 0;
		maxValue = 0;
		nValues = 0;
		sumOfValues = 0;

	}
	
		
	
	public void analyseData(String line) throws Exception {
		//the system should skip the line if it is blank or a comment, eg. starts with a letter
		if (line.isEmpty() || Character.isLetter(line.charAt(0))) {
			}
		else {
			Scanner lineSc = new Scanner(line);
			while (lineSc.hasNextDouble()) {
				
				//printing to screen
				double currentNo = lineSc.nextDouble();
				System.out.println(currentNo);
				
				//saving it in a file
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("numbers.txt"))));
				pw.println(currentNo);
				
				//updating minValue
				if (currentNo < minValue) {
					minValue = currentNo;
				}
				
				//updating maxValue
				if (currentNo > maxValue) {
					maxValue = currentNo;
				}
				
				//updating nValues
				nValues++;
				
				//updating sum of values
				sumOfValues = sumOfValues + currentNo;
				
			}
		}
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
