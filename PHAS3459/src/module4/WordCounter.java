package module4;

//importing the Class BufferedReader into module4
import java.io.* ;
//importing the Class java.net
import java.net.*;

public class WordCounter {

	
	
	//method brFromURL that takes the URL of a 
	//website as an input and returns its contents
	//as a BufferedReader object or throws an exception
	public static BufferedReader brFromURL(String urlName) throws Exception {
	
		try {
			URL website = new URL(urlName);
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
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			return in;
			
		}
		catch (Exception e) {
			throw (e);
		}
	}
	
	
	public static int countWordsinResource(BufferedReader dataAsBR) throws Exception {
		try {
			
		}
	}

}
