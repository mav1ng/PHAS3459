package exam1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;


public class HiggsMain {

	/**
	 * 
	 * @param url url of the website that contains the data
	 * @return returns HashMap of the ids and event energy of the different entries
	 * @throws IOException scanner might throw an exception if the token does not match
	 * as well es the url might be mismatched
	 */
	public static HashMap<String, ArrayList<Double>> getEvents(String url) throws IOException {
		HashMap<String, ArrayList<Double>> hm = new HashMap<String, ArrayList<Double>>();

		URL website = new URL(url);
		InputStream is = website.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line;
		String id = "";
		double energy = 0;

		br.readLine();

		while ((line = br.readLine()) != null) {
			Scanner sc = new Scanner(line);
			sc.useLocale(Locale.ENGLISH);

			id = sc.next(); 

			if (!hm.keySet().contains(id)) {
				hm.put(id, new ArrayList<Double>());
			}

			energy = sc.nextDouble();

			hm.get(id).add(energy);

			sc.close();
		}

		return hm;

	}


	/**
	 * method that takes data of events from the website and parses it
	 * into an arraylist of event objects
	 * @param url url of the website
	 * @return arraylist of the events mentioned in the website
	 * @throws IOException the if the data on the website isn't structured well
	 * IOException might be thrown
	 */
	public static ArrayList<Event> getData(String url, String id) throws IOException {
		ArrayList<Event> al = new ArrayList<Event>();

		URL website = new URL(url);
		InputStream is = website.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line;

		br.readLine();

		while ((line = br.readLine()) != null ) {

			Scanner sc = new Scanner(line);
			sc.useLocale(Locale.ENGLISH);

			Event e = new Event();

			e.id = id;
			e.lEdge = sc.nextDouble();
			e.hEdge = sc.nextDouble();
			e.predicted = sc.nextDouble();

			al.add(e);

			sc.close();

		}

		return al;

	}

	/**
	 * method that returns the number of predicted events in an energy range
	 * @param al	arraylist with predicted backround event data
	 * @param min double lower end of the specified range
	 * @param max double upper end of the specified range
	 * @return double expected events
	 * @throws Exception
	 */
	public static double getNumberOfExpectedEvents(ArrayList<Event> al, double min, double max) throws Exception {

		double counter = 0;

		for (Event e: al) {
			if (e.lEdge >= min && e.hEdge <= max) {
				counter = counter + e.predicted;
			}
		}

		return counter;

	}

	/**
	 * method that returns the number of predicted events in an energy range
	 * @param al	arraylist with predicted backround event data
	 * @param min double lower end of the specified range
	 * @param max double upper end of the specified range
	 * @return double expected events
	 * @throws Exception
	 */
	public static double getNumberOfCandidateEvents(HashMap<Event, Integer> hm, double min, double max) throws Exception {

		double counter = 0;

		for (Event e: hm.keySet()) {
			if (e.lEdge >= min && e.hEdge <= max) {
				counter = counter + hm.get(e);
			}
		}

		return counter;

	}

	/**
	 * method that creates a HashMap and sorts all recorded energy events into the specified event range
	 * @param alD
	 * @param alE
	 * @return
	 * @throws Exception
	 */
	public static HashMap<Event, ArrayList<Double>> getCandidateEvents(ArrayList<Double> alD, ArrayList<Event> alE) throws Exception {

		HashMap<Event, ArrayList<Double>> hm = new HashMap<Event, ArrayList<Double>>();

		for (Double d: alD) {
			for (Event e: alE) {
				if (d >= e.lEdge && d < e.hEdge) {
					if (!hm.keySet().contains(e)) {
						hm.put(e, new ArrayList<Double>());
					}
					hm.get(e).add(d);
				}
			}
		}

		return hm;

	}

	public static HashMap<Event, Integer> getCandidateNumber(HashMap<Event, ArrayList<Double>> hm) throws Exception{

		HashMap<Event, Integer> output = new HashMap<Event, Integer>();

		for (Event e : hm.keySet()) {
			int currentNumber = hm.get(e).size();
			output.put(e, currentNumber);
		}

		return output;

	}
	
	public static HashMap<Double, HashMap<Double,Double>> predictionGauss(double N, double s) throws Exception {
		
		HashMap<Double, HashMap<Double, Double>> hmMain = new HashMap<Double, HashMap<Double, Double>>();
		for (double d = 110.5; d < 179.5; d++) {
			Gaussian gaussian = new Gaussian(N, d, s);
			hmMain.put(d, gaussian.prediction());
		}
		return hmMain;
	}

	/**
	 * method that calculated the log-likelihood
	 * @param hm hashmap of event and the attached number of candidate events
	 * @return double the loglikelihood
	 * @throws Exception
	 */
	public static double getLL(HashMap<Event, Integer> hm) throws Exception {
		
		double ll = 0;
		
		for (Event e: hm.keySet()) {
			ll = ll + (e.predicted - hm.get(e)) + hm.get(e) * Math.log(hm.get(e)/e.predicted);
		}
		
		return ll;
		
	}

	public static void main(String[] args) {

		System.out.println("------------------PART1-----------------\n");

		try {
			HashMap<String, ArrayList<Double>> eventMap = getEvents("http://www.hep.ucl.ac.uk/undergrad/"
					+ "3459/exam-data/2011-12/higgsData.txt");

			ArrayList<Event> eventListGG = getData("http://www.hep.ucl.ac.uk/undergrad/"
					+ "3459/exam-data/2011-12/backgroundGG.txt", "GG");

			ArrayList<Event> eventListZZ = getData("http://www.hep.ucl.ac.uk/undergrad/"
					+ "3459/exam-data/2011-12/backgroundZZ.txt", "ZZ");

			System.out.println("Number of Expected Events for GG: " + 
					getNumberOfExpectedEvents(eventListGG, 120, 140));
			System.out.println("Number of Expected Events for ZZ: " + 
					getNumberOfExpectedEvents(eventListZZ, 120, 140));

			HashMap<Event, Integer> numberGG = getCandidateNumber(getCandidateEvents
					(eventMap.get("GG") ,eventListGG));
			HashMap<Event, Integer> numberZZ = getCandidateNumber(getCandidateEvents
					(eventMap.get("ZZ") ,eventListZZ));

			System.out.println("Number of Candidate Events for GG: " + 
					getNumberOfCandidateEvents(numberGG, 120, 240));
			System.out.println("Number of Candidate Events for ZZ: " + 
					getNumberOfCandidateEvents(numberZZ, 120, 240));

			System.out.println("\nLog-likelihood for GG channel: " + getLL(numberGG));
			System.out.println("Log-likelihood for ZZ channel: " + getLL(numberZZ));

			
			System.out.println("--------------------PART2----------------\n");
			
			HashMap<Double, HashMap<Double,Double>> hmGaussGG = predictionGauss(100, 2);
			HashMap<Double, HashMap<Double,Double>> hmGaussZZ = predictionGauss(6, 1);
			
			System.out.println(hmGaussGG);
			
			System.out.println(hmGaussZZ);
			System.out.println(hmGaussGG.get(165.5));
			
			System.out.println("-------------------PART3-----------------\n");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
