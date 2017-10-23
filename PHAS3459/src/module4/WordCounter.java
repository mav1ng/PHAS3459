package module4;

//importing the Class BufferedReader into module4
import java.io.* ;

public class WordCounter {

	//method BufferedReader that takes the URL of a 
	//website as an input and returns it as a BufferedReader Object
	public static BufferedReader brFromURL(String urlName) throws Exception {
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(urlName));
			return in;
		}
		catch (Exception e) {
			throw (e);
		}
	}

}
