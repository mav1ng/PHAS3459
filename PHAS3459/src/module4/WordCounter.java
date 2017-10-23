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
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			return in;
			
		}
		catch (Exception e) {
			throw (e);
		}
	}
	
	
	
	public static int countWordsinResource(BufferedReader dataAsBR) throws Exception {
		//defining the needed variables
		int blankCount = 0, wordsCount = 0, lineCount = 1;
		
		String line = dataAsBR.readLine();
		
		try {
			
			while (line != null) {
				
				
				for (int i = 0; i < line.length(); i++) {
					if (line.charAt(i) == ' ') {
						blankCount++;
					}
				}
				
				
				//read the next line
				line = dataAsBR.readLine();
				lineCount++;
				
			}
			
			//setting the wordsCount
			wordsCount = blankCount + lineCount;
			return wordsCount;
		}
		catch (Exception e) {
			throw (e);
		}
	}
	
	public static void main(String[] args) {
		
		//testing the defined methods with an URL
		try	{
			brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
