package CarlaTest;

import java.io.*;
import java.net.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		try {
			HashMap<String, String> sites = 
					ReadData.readSites("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/sites.txt");
			System.out.println(sites);

			HashMap<Integer, Map<String, ArrayList<Tide>>> tides = 
					new HashMap<Integer, Map<String, ArrayList<Tide>>>();

			tides.put(1999, ReadData.readTides("http://www.hep.ucl.ac.uk/"
					+ "undergrad/3459/exam-data/2014-15/tides-1999.txt", sites));
			tides.put(2000, ReadData.readTides("http://www.hep.ucl.ac.uk/"
					+ "undergrad/3459/exam-data/2014-15/tides-2000.txt", sites));
			tides.put(2001, ReadData.readTides("http://www.hep.ucl.ac.uk/"
					+ "undergrad/3459/exam-data/2014-15/tides-2001.txt", sites));
			//System.out.println(tides);

			HashMap<Integer, Map<String, Double>> highestSeaLevel =
					new HashMap<Integer, Map<String, Double>>();

			for (int year : tides.keySet()) {
				HashMap<String, Double> highestYear = new HashMap<String, Double>();
				highestYear = DataAnalysis.highestSeaLevel(tides.get(year));
				highestSeaLevel.put(year, highestYear);
			}
			System.out.println(highestSeaLevel);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
