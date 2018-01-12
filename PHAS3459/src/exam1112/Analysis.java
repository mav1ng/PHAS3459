package exam1112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Analysis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Map<String, String> regionNames = readRegions("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/final/regions.txt");
					System.out.println(regionNames);
					DiseaseData data = new DiseaseData();
					data.readOccurences("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/final/occurrencesAB.txt");
//					data.readOccurences("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/final/occurrencesXYZ.txt");
					
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	private static Map<String, String> readRegions(String url) throws IOException {
		Map<String, String> regions = new HashMap<String, String>();
		BufferedReader br = brFromURL(url);
		br.readLine(); //Skip header line
		String line;
		while ((line = br.readLine()) != null) { //read lines untin end of file
			Scanner s = new Scanner(line);
			s.useDelimiter(",");
			String id = s.next();
			String name = s.next();
			regions.put(id, name);
			s.close();
		}
		return regions;
	}
	
	public static BufferedReader brFromURL(String url) throws IOException {
		URL u = new URL(url);
		InputStreamReader isr = new InputStreamReader(u.openStream());
		return new BufferedReader(isr);
	}
}
