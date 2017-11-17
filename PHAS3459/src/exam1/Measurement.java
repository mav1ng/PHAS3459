package exam1;

import java.util.Locale;
import java.util.Scanner;

public class Measurement {
	
	
	//declaring the variables as statet in the exam paper
	public int year = 0;
	public int mo = 0;
	public String type = "";
	public String region = "";
	public double extent = 0;
	public double area = 0;
	

	
	//method that dakes data from one line and creates a Measurement object with it
	public static Measurement parseData(String line) throws Exception {
		
		//creating that new measurement object where the data should be stored in
		Measurement m = new Measurement();
		
		Scanner sc = new Scanner(line);
		Scanner scD = sc.useDelimiter(",\\s*");
		Scanner scE = scD.useLocale(Locale.ENGLISH);
		
		//setting the year variable
		if (scE.hasNextInt()) {
			m.year = scE.nextInt();
		}
		
		//setting the month variable
		if (scE.hasNext()) {
			m.mo = scE.nextInt();
		}
		
		//setting the data-type variable
		if (scE.hasNext()) {
			m.type = scE.next();
		}
		
		//setting the region variable
		if (scE.hasNext()) {
			m.region = scE.next();
		}
		
		//setting the extent variable
		if (scE.hasNextDouble()) {
			m.extent = scE.nextDouble();
		}
		
		//setting the area variable
		if (scE.hasNextDouble()) {
			m.area = scE.nextDouble();
		}
		
		//closing the scanner
		sc.close();
		
		return m;
		
	}

	
	
	

	

}
