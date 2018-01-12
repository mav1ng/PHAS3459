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



	public static double getAmp(ArrayList<Double> al) throws Exception {
		
		double maxVolt = 0;
		
		for (Double sig : al) {
			if (sig > maxVolt) {
				maxVolt = sig;
			}
		}
		
		return maxVolt;
	}
	
	
	public static double getMeanAmp(ArrayList<ArrayList<Double>> al) throws Exception {

		double sumAmp = 0;
		double meanAmp;
		
		for (ArrayList<Double> pulse : al) {
			sumAmp = sumAmp + getAmp(pulse);
		}
		
		meanAmp = sumAmp/al.size();
		
		return meanAmp;
	}
	

	public static double getArrivalTime(ArrayList<Double> pulse) throws Exception {
		double maxVol = getAmp(pulse);
		return pulse.indexOf(maxVol);
	}
	
	
	public static double getMeanAT(ArrayList<ArrayList<Double>> al) throws Exception {
		
		double sumAT = 0;
		
		for (ArrayList<Double> pulse : al) {
			sumAT = sumAT + getArrivalTime(pulse);
		}
		
		return sumAT/al.size();
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
			
			System.out.println("The total number of pulses is: ");
			numberofPulses(hm2);
			
			System.out.println("\n \n \n Number of signals for each detector:");
			for (String det: hm2.keySet()) {
				System.out.println("detector: " + det);
				System.out.println("number of pulses: " + hm2.get(det).size());
			} 
			
			System.out.println("\n \n \n");
			
			System.out.println("Mean Amplitude for each detector:");
			for (String det: hm2.keySet()) {
				System.out.println("detector: " + det);
				System.out.println("mean amplitude: " + getMeanAmp(hm2.get(det)));
			}
			
			
			System.out.println("\n \n \n Mean Arrival Time");
			for (String det: hm2.keySet()) {
				System.out.println("detector: " + det);
				System.out.println("mean arrival time: " + getMeanAT(hm2.get(det)) + "ns");
			}
			
			
			System.out.println("\n \n \n Speed of the Particles");
			for (String det: hm2.keySet()) {
				
				double distance = hm.get(det);
				double speed = distance / (getMeanAT(hm2.get(det)) * Math.pow(10, -9));
				
				System.out.println("detector: " + det);
				System.out.println("distance from source: " + distance + " m");
				System.out.println("particle speed: " + speed + " m/s");
			}
			
			
			
			
		}
		catch (Exception e) {
			System.out.println(e);
		}



	}

}
