package module4;

//importing the Class BufferedReader into module4
import java.io.* ;

public class WordCounter {

	
	
	//method brFromURL that takes the URL of a 
	//website as an input and returns it as a BufferedReader object or throws an exception
	public static BufferedReader brFromURL(String urlName) throws Exception {
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(urlName));
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

}
