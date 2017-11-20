package module6;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class TestDataPoints {
	
	
	//method that gets the data from the url and saves it into an arraylist
	public static ArrayList<DataPoint> dataFromURL(String url) throws Exception {
		
		//creating an url
		URL website = new URL(url);
		
		//opening the inputstream from the url
		InputStream iS= website.openStream();
		
		//creating InputStreamReader from the existing InputStream
		InputStreamReader iSR = new InputStreamReader(iS);
		
		//Creating BufferedReader from the existing InputStreamReader
		BufferedReader br = new BufferedReader(iSR);
		
		//creating needed variables
		String line;
		double xIn, yIn, eyIn;
		String label;
		
		ArrayList<DataPoint> dpList = new ArrayList<DataPoint>();
		
		
		//looping over all the different lines the BufferedReader will give out
		while ((line = br.readLine()) != null) {
			
			//resetting the variables
			xIn = 0;
			yIn = 0;
			eyIn = 0;
			label = "";
			
			//creating a Scanner on the line that is currently read
			Scanner sc = new Scanner(line);
			Scanner scL = sc.useLocale(Locale.ENGLISH);
			
			//parsing the data into the variables
			if (scL.hasNextDouble()) {
				xIn = scL.nextDouble();
			}
			
			if (scL.hasNextDouble()) {
				yIn = scL.nextDouble();
			}
			
			if (scL.hasNextDouble()) {
				eyIn = scL.nextDouble();
			}
			
			//if theres still a token in the line 
			if (scL.hasNext()) {
				label = scL.next();
				LabelledDataPoint lDP = new LabelledDataPoint(xIn, yIn, eyIn, label);
				dpList.add(lDP);
			}
			//if theres no last token in the line
			else {
				DataPoint dP = new DataPoint(xIn, yIn, eyIn);
				dpList.add(dP);
			}
			
			
			sc.close();
			
		}
		
		return dpList;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			ArrayList<DataPoint> list = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/"
				+ "3459/data/module6/module6-data.txt");
			
			for (DataPoint dP : list) {
				System.out.println(dP);
			}
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		

	}

}
