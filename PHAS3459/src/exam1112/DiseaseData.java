package exam1112;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class DiseaseData {
	
	Map<String, Map<String, Integer>> occurences;

	public void readOccurences(String url) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = Analysis.brFromURL(url);
		br.readLine(); //Skip header line
		String line;
		while ((line = br.readLine()) != null) { //read lines untin end of file
			Scanner s = new Scanner(line);
			String region = s.next();
			int numA = s.nextInt();
			int numB = s.nextInt();
			s.close();
		}
		
	}

}
