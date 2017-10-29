package module4;


import java.io.*;
import java.net.URL;
import java.util.Locale;
import java.util.Scanner;
import java.lang.Character;


public class NumericalReader {
	
		private double minValue, maxValue, nValues, sumOfValues, currentNo; //declaring the private variables
		private String fileName; //the filename the user is prompt to enter

	
	//defining the method that prompts user to input string and then stores it
	public static String getStringFromKeyboard() throws IOException {
		
		System.out.println("Please enter the directory in which the file should be created!");
		
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String input = in.readLine();
			return input;
	}
	
	public BufferedReader brFromURL(String urlName) throws IOException {
		
			//creating a new URL object it will throw an exception when the entered urlName is not a URL
			URL website = new URL(urlName);
			//creating the BufferedReader object 
			BufferedReader in = new BufferedReader(new InputStreamReader(website.openStream()));
			return in;
			
	}
	
	
	public void analysisStart(String dataFile) throws IOException {
		
		fileName = dataFile;
		File outputfile = new File(dataFile);
		FileWriter fw = new FileWriter(outputfile);
		
		//initializing the private variables
		this.minValue = 0;
		this.maxValue = 0;
		this.nValues = 0;
		this.sumOfValues = 0;

	}
	
		
	
	public void analyseData(String line) throws IOException {
		
		
		//the system should skip the line if it is blank or a comment, eg. starts with a letter
		if (line.isEmpty() || Character.isLetter(line.charAt(0))) {
			}
		
		
		else {
						
			try 
			
				(	
					Scanner lineSc = new Scanner(line).useLocale(Locale.ENGLISH); 
					FileWriter fr = new FileWriter(fileName);
					BufferedWriter bw = new BufferedWriter(fr);
					PrintWriter pw = new PrintWriter(bw);
				)
			
			{
				
				while (lineSc.hasNext()) {
					if (lineSc.hasNextDouble()) {	
						
						
						//printing to screen
						currentNo = lineSc.nextDouble();
						System.out.println(currentNo);
						
						//saving it in the file
						pw.println(currentNo);
						
						//setting the first minimalValue
						if(minValue == 0) {
							minValue = currentNo;
						}
					
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
					else {
					lineSc.next();
					}
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
		//printing out the maximum value
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
		
		String userInput;
		String homeDirectory = System.getProperty("user.home");
		System.out.println("Your home directory is: " + homeDirectory);
		
		//asking the user to specify the directory. if no input is made the system will 
		//use the home directory location
		try {
			userInput = getStringFromKeyboard();
		}
		catch (IOException e) {
			userInput = homeDirectory;
		}
	
		System.out.println("That is directory the file should be in: " + userInput + "/mywork");
		System.out.println();
		System.out.println("Results of the first file:");
		System.out.println();
		
		//testing with URL1 and saving it in the file numbers1.txt
		NumericalReader nr = new NumericalReader();
		
		
		//initializing the filename
		nr.fileName = "numbers1.txt";
		
		
		//concenating all the stings together to have the complete and correct 
		//directory with the filename
		String directoryFile = (userInput + File.separator + "mywork" + File.separator + nr.fileName);
		
		String line;
		
		
		//getting the BufferedReader Object from the website
		try	{
			//defining the variable line
			BufferedReader reader = nr.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt");
			
			//initializing the necessary variables
			nr.analysisStart(directoryFile);
			
			
			while ((line = reader.readLine()) != null) {
			

				//starting the analysis
				nr.analyseData(line);
				
			}	
			
			//printing out the values and ending the analysis
			nr.analysisEnd();
			
		}
		catch (IOException e) {
			System.out.println(e);
		}
		
		
		System.out.println();
		System.out.println("Second File:");
		System.out.println();
		
		
	}

}
