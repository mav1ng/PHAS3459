package exam1415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class TidesMain {
	/**
	 * 
	 * @param url url of the website that contains the data
	 * @return returns HashMap of the names and ids of the different sites
	 * @throws IOException scanner might throw an exception if the token does not match
	 * as well es the url might be mismatched
	 */
	public static HashMap<String, String> getSites(String url) throws IOException {
		HashMap<String, String> hm = new HashMap<String, String>();

		URL website = new URL(url);
		InputStream is = website.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line;
		String id = "";
		String name = "";

		br.readLine(); //skipping first line

		while ((line = br.readLine()) != null) {
			Scanner sc = new Scanner(line);
			sc.useLocale(Locale.ENGLISH);

			name = sc.next();
			id = sc.next(); 

			hm.put(id, name);

			sc.close();
		}

		return hm;

	}


	/**
	 * method that modifies ArrayList of measurement objects by adding
	 * the data of measurements on the given url
	 * 
	 * 
	 * @param al ArrayList in which the Measurement object will be stored
	 * @param url website url from which the data will be parsed
	 * @throws IOException exception if scanner throws an error or the url is missmatched
	 */
	public static void getTides(ArrayList<Measurement> al, String url) throws IOException {


		URL website = new URL(url);
		InputStream is = website.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line;

		br.readLine(); //skipping first line

		while ((line = br.readLine()) != null) {
			Scanner sc = new Scanner(line);
			sc.useLocale(Locale.ENGLISH);

			Measurement m = new Measurement();

			m.id = sc.next();
			m.year = sc.nextInt();
			m.month = sc.nextInt();
			m.day = sc.nextInt();
			m.hours = sc.nextInt();
			m.minutes = sc.nextInt();
			m.level = sc.nextDouble();
			m.pLevel = sc.nextDouble();

			al.add(m);

			sc.close();
		}

	}

	/**
	 * method that modifies ArrayList of measurement objects by adding
	 * the data of measurements on the given url
	 * 
	 * 
	 * @param al ArrayList in which the Measurement object will be stored
	 * @param url website url from which the data will be parsed
	 * @throws IOException exception if scanner throws an error or the url is missmatched
	 */
	public static void getTides2(ArrayList<Measurement> al, String url) throws IOException {


		URL website = new URL(url);
		InputStream is = website.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line;

		br.readLine(); //skipping first line

		while ((line = br.readLine()) != null) {
			Scanner sc = new Scanner(line);
			sc.useLocale(Locale.ENGLISH);

			Measurement m = new Measurement();

			m.year = sc.nextInt();
			m.month = sc.nextInt();
			m.day = sc.nextInt();
			m.hours = sc.nextInt();
			m.minutes = sc.nextInt();
			m.id = sc.next();
			m.level = sc.nextDouble();
			m.pLevel = sc.nextDouble();

			al.add(m);

			sc.close();
		}

	}

	/**
	 * Method that returns the Measurement with the highest recorded
	 * sea level above the reference point
	 * 
	 * @param al ArrayList that stores all the different measurement objects
	 * which are about to be compared
	 * @return the measurement with the highest recorded sea level
	 */
	public static Measurement getMaxLevel(ArrayList<Measurement> al) {

		double maxLevel = 0;
		Measurement maxM = new Measurement();

		for (Measurement m: al) {
			if (m.level > maxLevel) {
				maxLevel = m.level;
				maxM = m;
			}
		}

		return maxM;

	}

	public static HashMap<String, ArrayList<Measurement>> getRightList(ArrayList<Measurement> al) throws Exception {

		HashMap<String, ArrayList<Measurement>> hm = new HashMap<String, ArrayList<Measurement>>();

		for (Measurement m: al) {
			if (!hm.keySet().contains(m.id)) {
				hm.put(m.id, new ArrayList<Measurement>());
			}
			hm.get(m.id).add(m);

		}

		return hm;

	}

	public static Measurement getSurge(ArrayList<Measurement> al) throws Exception {

		double currentSurge = 0;
		double maxSurge = 0;
		Measurement maxSur = new Measurement();

		for (Measurement m: al) {
			currentSurge = Math.abs(m.level - m.pLevel);
			if (currentSurge > maxSurge) {
				maxSurge = currentSurge;
				maxSur = m;
			}
		}

		return maxSur;

	}


	public static void main(String[] args) {

		ArrayList<Measurement> tidesList = new ArrayList<Measurement>();
		ArrayList<Measurement> tidesList2 = new ArrayList<Measurement>();

		try {
			HashMap<String, String> sites = getSites("http://www.hep.ucl.ac.uk/undergrad/3459/"
					+ "exam-data/2014-15/sites.txt");
			System.out.println(sites);

			getTides(tidesList, "http://www.hep.ucl.ac.uk/undergrad/3459/"
					+ "exam-data/2014-15/tides-1999.txt");
			getTides(tidesList, "http://www.hep.ucl.ac.uk/undergrad/3459/"
					+ "exam-data/2014-15/tides-2000.txt");
			getTides(tidesList, "http://www.hep.ucl.ac.uk/undergrad/3459/"
					+ "exam-data/2014-15/tides-2001.txt");

			Measurement maxM = getMaxLevel(tidesList);

			System.out.println("The highest observer Level is at " + maxM.level);
			System.out.println("And it was recorded under the id " + maxM.id + " in"
					+ " " + sites.get(maxM.id));
			System.out.println("It was recorded on the " + maxM.day + "/" + maxM.month
					+ "/" + maxM.year + " at " + maxM.hours + ":" + maxM.minutes +" o'clock.");

			System.out.println("------------------PART2-----------------");

			HashMap<String, ArrayList<Measurement>> sitesLevel = getRightList(tidesList);
			Mean mean = new Mean();
			Range range = new Range();


			for (String key : sitesLevel.keySet()) {
				System.out.println("Mean of all sea - level readings for site " + key);
				System.out.println(mean.calc(sitesLevel.get(key)));
				System.out.println("Range of all sea level readings for site " + key);
				System.out.println(range.calc(sitesLevel.get(key)));
				System.out.println();
				System.out.println();
			}

			System.out.println("----------------PART3--------------");
			Measurement maxSur = getSurge(tidesList);

			System.out.println("Details of the largest tidal surge:");
			System.out.println(maxSur);
			System.out.println("surge: " + Math.abs(maxSur.pLevel - maxSur.level));
			System.out.println("Site: " + sites.get(maxSur.id));
			System.out.println();
			System.out.println();
			

			System.out.println("---------------PART3b-------------");
			System.out.println();
			
			HashMap<String, String> sites2 = getSites("http://www.hep.ucl.ac.uk/undergrad/3459/"
					+ "exam-data/2014-15/part3/sites.txt");
			System.out.println(sites2);

			getTides2(tidesList2, "http://www.hep.ucl.ac.uk/undergrad/3459/"
					+ "exam-data/2014-15/part3/tides-2004.txt");
			getTides2(tidesList2, "http://www.hep.ucl.ac.uk/undergrad/3459/"
					+ "exam-data/2014-15/part3/tides-2005.txt");
			getTides2(tidesList2, "http://www.hep.ucl.ac.uk/undergrad/3459/"
					+ "exam-data/2014-15/part3/tides-2006.txt");

			Measurement maxSur2 = getSurge(tidesList2);

			System.out.println("Details of the largest tidal surge:");
			System.out.println(maxSur2);
			System.out.println("surge: " + Math.abs(maxSur2.pLevel - maxSur2.level));
			System.out.println("Site: " + sites2.get(maxSur2.id));


		} catch (IOException e) {
			System.out.println("The Scanner is not working properly. Check"
					+ "\n the format in which the website is structured.");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
