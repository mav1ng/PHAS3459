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
	
		
	
	public void analyseData(String line) throws IOException {
		//the system should skip the line if it is blank or a comment, eg. starts with a letter
		if (line.isEmpty() || Character.isLetter(line.charAt(0))) {
			}
		else {
			
			try 
			
				(	
					Scanner lineSc = new Scanner(line); 
					File output = new File("numbers.txt");
					FileWriter fr = new FileWriter(output);
					BufferedWriter bw = new BufferedWriter(fr);
					PrintWriter pw = new PrintWriter(bw);
				)
			
			{
				
				
				while (lineSc.hasNextDouble()) {
					
					//printing to screen
					double currentNo = lineSc.nextDouble();
					System.out.println(currentNo);
					
					//saving it in the file
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
		
	}
	
	//method analysEnd() that print the minimum Value, the maximum Value, 
	//the average Value and the total number of Values read
	public void analysisEnd() {
		//printing out the minimumValue
		System.out.println("The minimum value: " + minValue);
		System.out.println();
		//prinring out the maximum value
		System.out.println("The maximum value: " + maxValue);
		System.out.println();
		//printing out the average value
		System.out.println("The average value: " + sumOfValues/nValues);
		System.out.println();
		//printing out the total number of values read
		System.out.println("The total number of values read: " + nValues);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
