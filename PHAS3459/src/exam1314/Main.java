package exam1314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	/**
	 * 
	 * @param url url of the website that contains the data
	 * @return returns HashMap of the names and ids of the different species
	 * @throws IOException scanner might throw an exception if the token does not match
	 * as well es the url might be mismatched
	 */
	public static HashMap<String, String> getSpecies(String url) throws IOException {
		HashMap<String, String> hm = new HashMap<String, String>();

		URL website = new URL(url);
		InputStream is = website.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line;
		String id = "";
		String name = "";

		while ((line = br.readLine()) != null) {
			Scanner sc = new Scanner(line);
			sc.useLocale(Locale.ENGLISH);

			id = sc.next(); 
			name = sc.next();
			name = name + " " + sc.next();

			hm.put(id, name);

			sc.close();
		}

		return hm;

	}

	/**
	 * method that takes data of specimen from the website and parses it
	 * into an arraylist of specimen objects
	 * @param url url of the webiste
	 * @return arraylist of the specimen mentioned in the website
	 * @throws IOException the if the data on the website isn't structured well
	 * IOException might be thrown
	 */
	public static ArrayList<Specimen> getData(String url) throws IOException {

		ArrayList<Specimen> al = new ArrayList<Specimen>();

		URL website = new URL(url);
		InputStream is = website.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line;

		while ((line = br.readLine()) != null ) {

			Scanner sc = new Scanner(line);
			sc.useLocale(Locale.ENGLISH);

			Specimen sp = new Specimen();

			sp.latitude = sc.nextDouble();
			sp.longitude = sc.nextDouble();
			sp.id = sc.next();
			if (sc.hasNextInt()) {
				sp.height = sc.nextInt(); 
			}

			al.add(sp);

			sc.close();

		}

		return al;

	}

	/**
	 * method that seperates the list of recordings into several lists of recordings of
	 * the same species
	 * @param al list of all recordings
	 * @return hashmap of species id and lists of severl recodings of each species
	 * @throws Exception
	 */
	public static HashMap<String, ArrayList<Specimen>> getRightList(ArrayList<Specimen> al) throws Exception {

		HashMap<String, ArrayList<Specimen>> hm = new HashMap<String, ArrayList<Specimen>>();

		for (Specimen m: al) {
			if (!hm.keySet().contains(m.id)) {
				hm.put(m.id, new ArrayList<Specimen>());
			}
			hm.get(m.id).add(m);

		}

		return hm;

	}

	/**
	 * method that calculates the mean height of a list of specimen
	 * @param al arraylist list of specimen
	 * @return double mean height
	 * @throws Exception
	 */
	public static double getMeanHeight(ArrayList<Specimen> al) throws Exception {

		double sum = 0;

		for (Specimen s: al) {
			sum = sum + s.height;
		}

		return sum/al.size();

	}

	public static double haversin(double theta) {
		return (1-Math.cos(theta))/2;
	}


	public static void main(String[] args) {

		System.out.println("------------------PART1-----------------\n");

		try {
			HashMap<String, String> idMap = getSpecies("http://www.hep.ucl.ac.uk/undergrad/3459/"
					+ "exam-data/2013-14/species-plants.txt");

			ArrayList<Specimen> plantList = getData("http://www.hep.ucl.ac.uk/undergrad/3459/"
					+ "exam-data/2013-14/survey-plants.txt");

			HashMap<String, ArrayList<Specimen>> speciesMap = getRightList(plantList);

			for (String key: speciesMap.keySet()) {
				System.out.println("Species Id: " + key + "\nSpecies Name: " + 
						idMap.get(key) + "\nSpecies Mean Height: " + getMeanHeight(speciesMap.get(key)) + "\n");
			}

			double maxMean = 0;
			String maxMeanN = "";
			double minMean = 0;
			String minMeanN = "";

			for (String key: speciesMap.keySet()) {

				if (getMeanHeight(speciesMap.get(key)) > maxMean) {
					maxMean = getMeanHeight(speciesMap.get(key));
					maxMeanN = idMap.get(key).toString();
				}
				if (getMeanHeight(speciesMap.get(key)) < minMean || minMean == 0 ) {
					minMean = getMeanHeight(speciesMap.get(key));
					minMeanN = idMap.get(key).toString();
				}
			}
			System.out.println("Species with the highest Mean: " + maxMeanN);
			System.out.println("Species with the lowest Mean: " + minMeanN);

			System.out.println("------------------PART2----------------\n");

			MinMaxSpecifier mmS = new MinMaxSpecifier(-30, 30);
			ArrayList<Specimen> udList = new ArrayList<Specimen>();

			for (String key: speciesMap.keySet()) {
				if (idMap.get(key).equals("Urtica dioica")) {
					udList = mmS.specify(speciesMap.get(key));
					break;
				}
			}

			System.out.println("Mean height of Urtica dioica in specified region: "
					+ "\n" + getMeanHeight(udList) + "\n\n");

			System.out.println("------------------PART2b----------------\n");

			DistanceSpecifier dS = new DistanceSpecifier(-30.967, 75.430, 50);
			ArrayList<Specimen> dSList = new ArrayList<Specimen>();

			for (String key: idMap.keySet()) {
				if (idMap.get(key).equals("Solanum carolinense")) {
					dSList = dS.specify(speciesMap.get(key));
					break;
				}
			}
			

			System.out.println("Mean height of Solanum carolinense in specified region: "
					+ "\n" + getMeanHeight(dSList) + "\n\n");
			
			
			System.out.println("------------------PART3------------------\n");
			
			
			HashMap<String, String> idMap2 = getSpecies("http://www.hep.ucl.ac.uk/undergrad/3459/"
					+ "exam-data/2013-14/species-animals.txt");

			ArrayList<Specimen> animalList = getData("http://www.hep.ucl.ac.uk/undergrad/3459/"
					+ "exam-data/2013-14/survey-animals.txt");
			
			HashMap<String, ArrayList<Specimen>> animalMap = getRightList(animalList);
			
			DistanceSpecifier dS2 = new DistanceSpecifier(-30.967, 75.430, 100);
			ArrayList<Specimen> dSList2 = dS2.specify(animalList);

			HashMap<String, ArrayList<Specimen>> animalMap2 = getRightList(dSList2);
			
			System.out.println("All the animal species in the specified region: \n");
			
			for (String key:animalMap2.keySet()) {
				if (animalMap2.get(key).size() == animalMap.get(key).size()) {
					System.out.println(idMap2.get(key));
				}
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
