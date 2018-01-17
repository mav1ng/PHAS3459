package exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class ExamPart1 {

	/**method that gets the airports data and parses it into an hashmap
	 * 
	 * @param url url of the website that contains the data
	 * @return returns HashMap of the code and according airport
	 * @throws IOException scanner might throw an exception if the token does not match
	 * as well es the url might be mismatched
	 */
	public static HashMap<String, Airport> getAirports(String url) throws IOException {
		HashMap<String, Airport> hm = new HashMap<String, Airport>();

		URL website = new URL(url);
		InputStream is = website.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line;
		String code = "";

		while ((line = br.readLine()) != null) {
			Scanner sc = new Scanner(line);
			sc.useLocale(Locale.ENGLISH);
			sc.useDelimiter(", ");

			Airport a = new Airport();

			code = sc.next(); 
			a.code = code;
			a.name = sc.next();
			a.timezone = sc.next();

			hm.put(code, a);

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
	public static ArrayList<Flight> getFlights(String url) throws IOException {

		ArrayList<Flight> al = new ArrayList<Flight>();

		URL website = new URL(url);
		InputStream is = website.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line;

		while ((line = br.readLine()) != null ) {

			Scanner sc = new Scanner(line);
			sc.useLocale(Locale.ENGLISH);
			sc.useDelimiter(", ");

			Flight f = new Flight();

			f.fCode = sc.next();
			f.oCode = sc.next();
			f.dCode = sc.next();
			f.dDate = sc.next();
			f.dTime = sc.next();
			f.aDate = sc.next();
			f.aTime = sc.next();
			f.cost = sc.nextDouble();

			al.add(f);

			sc.close();

		}

		return al;

	}

	/**
	 * method that calculates the duration of a flight
	 * @param dDate string departure date
	 * @param dTime string departure time
	 * @param aDate string arrival date
	 * @param aTime string arrival time
	 * @return long duration of the flight
	 */
	public static long getDuration(String dDate, String dTime, String aDate, String aTime) {

		String input = dDate + "T" + dTime;
		String input2 = aDate + "T" + aTime;
		
		LocalDateTime lt1 = LocalDateTime.parse(input);
		ZoneId z1 = ZoneId.of("Europe/London");
		ZonedDateTime zt1 = ZonedDateTime.of(lt1, z1);
		LocalDateTime lt2 = LocalDateTime.parse(input2);
		ZoneId z2 = ZoneId.of("Europe/Paris");
		ZonedDateTime zt2 = ZonedDateTime.of(lt2, z2);
		long duration = zt1.until(zt2, ChronoUnit.MINUTES);
		
		return duration;


	}

	/**
	 * method that gives out the flight details of a flight that has been input 
	 * @param f flight to be displayed
	 * @param hm hashmap of airport codes and their full airport names
	 * @throws Exception  ---
	 */
	public static void printFlightDetails(Flight f, HashMap<String, Airport> hm) throws Exception {
		
		long duration = getDuration(f.dDate, f.dTime, f.aDate, f.aTime);
		
		System.out.println("Flight code: " + f.fCode + "\n" + 
				"Origin Airport: " + hm.get(f.oCode).name + "\n" +
				"Destination Airport: " + hm.get(f.dCode).name + "\n" +
				"Date and Local time of Departure: " + f.dDate + "  " + f.dTime + "\n" +
				"Date and Local time of Arrival: " + f.aDate + "  " + f.aTime + "\n" +
				"Duration of the Flight: " + duration + "min\n" +
				"Cost of the Flight: " + f.cost +"pounds\n\n");

	}



	public static void main(String[] args) {

		System.out.println("--------------------------PART1-------------------------\n");

		//storing the files in appropiate data structures)

		try {
			HashMap<String, Airport> airports = getAirports("http://www.hep.ucl.ac.uk/undergrad/3459/"
					+ "exam-data/2017-18/airports.txt");
			ArrayList<Flight> flights = getFlights("http://www.hep.ucl.ac.uk/undergrad/3459/"
					+ "exam-data/2017-18/flights.txt");

			for (Flight f: flights) {
				printFlightDetails(f, airports);
			}


		} catch (IOException e) {
			System.out.println("The data on the website might not be suited for the specified scanner. \n"
					+ "check if the scanner is working correctly!");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Something with the correct storage of the Data has gone wrong. Check if \n"
					+ "there is some mistake regarding the data structures!");
			e.printStackTrace();
		}


	}

}
