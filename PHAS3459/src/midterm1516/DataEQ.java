package midterm1516;

import java.util.Locale;
import java.util.Scanner;

public class DataEQ {
	
	public String date = "";
	public String time = "";
	public double lat, lon, dep, eh1, eh2, ez, mag;
	public int az, ID;

	
	public String toString() {
		String output = "Date: " + date + "\n" + "time: " + time + "\n" + "Latitude: " + lat + "\n" 
						+ "Longitude: " + lon + "\n" + "Depth: " + dep + "\n" 
						+ "Error of Depth: " + ez + "\n" + "Magnitude: " + mag + "\n" + "ID: " + ID;
		return output;
		
	}
	
	
	//method takes input line of data and returns the DataEQ object
	public DataEQ storeData(String line) throws Exception {
		
		
		//creating a scanner that takes in the line as an argument
		Scanner sc = new Scanner(line);
		Scanner scE = sc.useLocale(Locale.ENGLISH);
		
		//setting the variable date
		for (int i = 0; i < 3 && scE.hasNext(); i++) {
			if(i < 2) {
				date = date + scE.next() + "/";
			}
			else {
				date = date + scE.next();
			}
		}
		
		
		//setting the time variable 
		for (int k = 0; k < 3 && scE.hasNext(); k++ ) {
			if(k < 2) {
				time = time + scE.next() + ":";
			}
			else {
				time = time + scE.next();
			}
		}
		
		
		//setting the Latitude Variable
		if (scE.hasNextDouble()) {
			lat = scE.nextDouble();
		}
		
		
		//setting the Longitude Variable
		if (scE.hasNextDouble()) {
			lon = scE.nextDouble();
		}
		
		
		//setting the depth Variable
		if (scE.hasNextDouble()) {
			dep = scE.nextDouble();
		}		
		
		
		//setting the EH1 variable
		if (scE.hasNextDouble()) {
			eh1 = scE.nextDouble();
		}
		
		
		//setting the EH2 variable
		if (scE.hasNextDouble()) {
			eh2 = scE.nextDouble();
		}
		
		
		//setting the az variable
		if (scE.hasNextInt()) {
			az = scE.nextInt();
		}
		
		
		//setting the ez variable 
		if (scE.hasNextDouble()) {
			ez = scE.nextDouble();
		}
		
		
		//setting the magnitude
		if (scE.hasNextDouble()) {
			mag = scE.nextDouble();	
		}
		
		
		//setting the id
		if (scE.hasNextInt()) {
			ID = scE.nextInt();
		}
		
		scE.close();
		sc.close();
		
		return this;
		
	}	
	
	
}
