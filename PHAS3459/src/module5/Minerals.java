package module5;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Minerals {
	
	//creating the HashMap for the minerals with its mass
	HashMap<Double, Double> codeMass = new HashMap<Double, Double>();
	//Location and Code of the minerals
	HashMap<Double, String> locCode = new HashMap<Double, String>();
	
	
	//method that gets the information from the website and fills the information into the HashMap
	public HashMap<Double, Double> getDataFromURL(String url) throws Exception {
		
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
			this.codeMass.put(sc.nextDouble(), sc.nextDouble());
			scanner.close();
		}
		
		//Closing all the streams
		inStream.close();
		inReader.close();
		br.close();
		
		return codeMass;
		
	}
	
	//method that gets the information from the website and fills in the information into the second HashMap
	public HashMap<Double, String> getDataFromURL2(String url) throws Exception {
		
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
			this.locCode.put(sc.nextDouble(), location);
			scanner.close();
		}
		
		//Closing all the streams
		inStream.close();
		inReader.close();
		br.close();
		
		return locCode;
		
	}
	
	public static void analyseData(HashMap<Double, Double> hpMass, 
			HashMap<Double, String> hmLoc) throws Exception {
		
		//creating a collection with the different mass values of the minerals
		Collection<Double> massValues = hpMass.values();
		Iterator<Double> mV = massValues.iterator();
		
		double maxMass = 0;
		double minMass = 0;
		double nextMass = 0;
		
		while (mV.hasNext()) {
			if (maxMass < (nextMass = mV.next())) {
				maxMass = nextMass;
			}
			if (minMass == 0 || minMass > nextMass ) {
				minMass = nextMass;
			}
		}
		
		
		System.out.println("The maximum Mass is: " + maxMass);
		System.out.println("The minimum Mass is: " + minMass);
		
		
	}
	
	
	public static void main(String[] args) {
		
		Minerals min = new Minerals();
		
		try {
			analyseData(min.getDataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459"
										+ "/data/module5/module5-samples.txt"), 
						min.getDataFromURL2("http://www.hep.ucl.ac.uk/undergrad/3459"
										+ "/data/module5/module5-locations.txt"));
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	

}
