package exam1617;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class Index {


	HashMap<String,String> hm = new HashMap<String,String>();


	public void dataFromLine(String url) throws Exception {

		URL website = new URL(url);
		InputStream in = website.openStream();
		InputStreamReader inR = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(inR);

		String line;

		while ((line = br.readLine()) != null) {
			scanLine(line);
		}
	}


	public void scanLine(String line) throws Exception {

		String currentName = "";
		String currentInstrument = "";

		Scanner sc = new Scanner(line);
		
		
		if (sc.hasNext()) {
			currentName = sc.next();
		}
		if (sc.hasNext()) {
			currentInstrument = sc.next();
		}
		
		hm.put(currentName, currentInstrument); 

		sc.close();

	}


}
