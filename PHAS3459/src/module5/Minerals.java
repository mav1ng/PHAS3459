package module5;

import java.util.HashMap;
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
	HashMap<String, Double> locCode = new HashMap<String, Double>();
	
	
	//method that gets the information from the website and fills the information into the HashMap
	public HashMap<Double, Double> getDataFromURl(String url) throws Exception {
		
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
	
	public HashMap<String, Double> getDataFromURL2(String url) throws Exception {
		
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
			this.locCode.put(sc.next(), sc.nextDouble());
			scanner.close();
		}
		
		//Closing all the streams
		inStream.close();
		inReader.close();
		br.close();
		
		return locCode;
		
	}
	
	
	
	

}
