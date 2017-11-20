package module6;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class TestDataPoints {
	
	public static ArrayList<DataPoint> dataFromURL(String url) throws Exception {
		
		URL website = new URL(url);
		InputStream iS= website.openStream();
		InputStreamReader iSR = new InputStreamReader(iS);
		BufferedReader br = new BufferedReader(iSR);
		
		String line;
		double xIn, yIn, eyIn;
		String label;
		
		ArrayList<DataPoint> dpList = new ArrayList<DataPoint>();
		
		while ((line = br.readLine()) != null) {
			
			//resetting the variables
			xIn = 0;
			yIn = 0;
			eyIn = 0;
			label = "";
			
			Scanner sc = new Scanner(line);
			Scanner scL = sc.useLocale(Locale.ENGLISH);
			
			if (scL.hasNextDouble()) {
				xIn = scL.nextDouble();
			}
			
			if (scL.hasNextDouble()) {
				yIn = scL.nextDouble();
			}
			
			if (scL.hasNextDouble()) {
				eyIn = scL.nextDouble();
			}
			
			if (scL.hasNext()) {
				label = scL.next();
				LabelledDataPoint lDP = new LabelledDataPoint(xIn, yIn, eyIn, label);
				dpList.add(lDP);
			}
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
