package module4;


import java.io.*;
import java.net.URL;
import java.lang.Character.*;
import java.lang.Integer;


public class NumericalReader {
	
	private int minValue, maxValue, nValues, sumOfValues; //declaring the private variables
	
	//defining the method that promps user to input string and then stores it
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
				
			//printing the numbers out to the screen
			for (int i = 0; i <= 2; i++) {
			System.out.println(line.substring(i, i+1));
			}
			
			//storing the numbers in a file
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("numberFile"))));
			for (int i = 0; i<=2; i++) {
				pw.println(line.substring(i, i+1));	
			}	
			pw.close();
			
			//updating the variables minValue, maxValue, nValues, sumOfValues
			for (int i = 0; i <= 2; i++) {
				int no = Integer.parseInt(line.substring(i, i+1));
				if (no < minValue) {
					minValue = no;
				}
				if (no > maxValue) {
					maxValue = no;
				}
				nValues++;
				sumOfValues = sumOfValues + no;
			}
		}
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
