package CarlaTest;

import java.io.*;
import java.net.*;
import java.util.*;

public class ReadData {
	
	public static HashMap<String, String> readSites(String url) throws IOException {
		URL u = new URL(url);
		BufferedReader br = new BufferedReader(new InputStreamReader(u.openStream()));

		HashMap<String, String> hm = new HashMap<String, String>();
		br.readLine();
		String input;

		while((input = br.readLine()) != null ) {
			Scanner s = new Scanner(input);

			String site = s.next();
			String port = s.next();

			s.close();

			hm.put(site, port);
		}
		return hm;
	}

	public static HashMap<String, ArrayList<Tide>> readTides(String url, HashMap<String, String> sites) throws IOException {
		URL u = new URL(url);
		BufferedReader br = new BufferedReader(new InputStreamReader(u.openStream()));
		HashMap<String, ArrayList<Tide>> hm = new HashMap<String, ArrayList<Tide>>();
		for (String key : sites.keySet()) {
			hm.put(key, new ArrayList<Tide>());

			String line;
			while ((line = br.readLine()) != null) {
				Scanner s = new Scanner(line);

				String port = s.next();
				if (port.equals(sites.get(key))) {
					hm.get(key).add(new Tide(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(),s.nextDouble(), s.nextDouble()));
					s.close();
				}
			}

		}
		return hm;
	}



}
