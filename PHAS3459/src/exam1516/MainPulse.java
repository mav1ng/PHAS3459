package exam1516;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MainPulse {

	/**
	 * method to parse the data from the URL into a HashMap
	 * 
	 * @param URL string that represents the url of the webiste 
	 * the data should be retrieved from
	 */
	public static HashMap<String, Double> getDataDetector(String url) throws Exception {

		URL website = new URL(url);
		InputStream is = website.openStream();
		InputStreamReader isr = new InputStreamReader(is); 
		BufferedReader br = new BufferedReader(isr);

		String line;
		
		HashMap<String, Double> hm = new HashMap<String, Double>();

		while ((line = br.readLine()) != null) {
			
			Scanner sc = new Scanner(line);

			String currentID = "";
			Double currentDis = 0.0 ;

			if (sc.hasNext()) {
				currentID = sc.next();
			}
			if (sc.hasNextDouble()) {
				currentDis = sc.nextDouble();
			}

			hm.put(currentID, currentDis);
			
			sc.close();

		}
		
		return hm;

	}

	public static HashMap<String, ArrayList<ArrayList<Double>>> getDataSignal(String url) throws Exception {

		URL website = new URL(url);
		InputStream is = website.openStream();
		InputStreamReader isr = new InputStreamReader(is); 
		BufferedReader br = new BufferedReader(isr);

		String line;

		HashMap<String, ArrayList<ArrayList<Double>>> hm = new HashMap<String,ArrayList<ArrayList<Double>>>();
		
		while ((line = br.readLine()) != null) {

			Scanner sc = new Scanner(line);
			
			String currentID = "N.A";
			
			if (sc.hasNext()) {
				currentID = sc.next();
			}

			ArrayList<Double> currentAL = new ArrayList<Double>();
			if (!hm.containsKey(currentID)) {
				hm.put(currentID, new ArrayList<ArrayList<Double>>());
			}
			
			while (sc.hasNext()) {
				currentAL.add(sc.nextDouble());
			}
			
			ArrayList<ArrayList<Double>> al2 = new ArrayList<ArrayList<Double>>();
			al2 = hm.get(currentID);
			al2.add(currentAL);
			
			hm.put(currentID, al2);
			
			sc.close();
		}
		
		return hm;
		
	}
	
	public static void numberofPulses(HashMap<String, ArrayList<ArrayList<Double>>> hm) {
		
		int totalNumber = 0;
		
		for (String k : hm.keySet()) {
			totalNumber += hm.get(k).size();
		}
		
		System.out.println(totalNumber);
		
	}





	public static void main(String[] args) {

		try {
			HashMap<String, Double> hm = (getDataDetector("http://www.hep.ucl.ac.uk/undergrad/3459"
					+ "/exam-data/2015-16/detectors.txt"));
			System.out.println(hm);
			
			System.out.println("\n \n \n \n \n --------------------------------------------------");
			
			HashMap<String, ArrayList<ArrayList<Double>>> hm2 = (getDataSignal("http://www.hep.ucl.ac.uk/"
					+ "undergrad/3459/exam-data/2015-16/signals.txt"));
			System.out.println(hm2);
			
			numberofPulses(hm2);
			
		}
		catch (Exception e) {
			System.out.println(e);
		}



	}

}
