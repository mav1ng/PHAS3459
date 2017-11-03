package module4;

//importing the Class BufferedReader into module4
import java.io.* ;
//importing the Class java.net
import java.net.*;
//importing the Class java.util
import java.util.*;

public class WordCounter {

	
	
	//method brFromURL that takes the URL of a 
	//website as an input and returns its contents
	//as a BufferedReader object or throws an exception
	
	public static BufferedReader brFromURL(String urlName) throws Exception {
	
		try {
			//creating a new URL object it will throw an exception when the entered urlName is not a URL
			URL website = new URL(urlName);
			//creating the BufferedReader object 
			BufferedReader in = new BufferedReader(new InputStreamReader(website.openStream()));
			return in;
		}
		catch (Exception e) {
			throw (e);
		}
	}
	
	
	//method brFromFile that takes the fileName as a String input and returns it
	//as a BufferedReader object or throws an exception
	public static BufferedReader brFromFile(String fileName) throws Exception {
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			return in;
			
		}
		catch (Exception e) {
			throw (e);
		}
	}
	
	
	//method that counts the words in the given BufferedReader File
	public static int countWordsInResource(BufferedReader dataAsBR) throws Exception {
		
		int wordsCount = 0; // variable for counting the words
		
		try {
			//instantiating a new Scanner object with the BufferedReader object dataAsBR
			Scanner scline = new Scanner(dataAsBR);
			
			while (scline.hasNext()) {
				scline.next();
				
				//updating the wordsCount
				wordsCount++;
			}
			//closing the scanner
			scline.close();
			return wordsCount;
			
		}
		
		catch (Exception e) {
			throw (e);
		}
	}
	
	
	public static void main(String[] args) {
		
		//trying the defined methods in the main method with the given URL
		try {
			System.out.println("There are " + countWordsInResource(brFromURL
					("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt")) + " words on the website.");
		}
		catch (Exception e) {
			System.out.println(e);
		}

		
	}

}
