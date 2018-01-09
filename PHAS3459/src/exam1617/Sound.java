package exam1617;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;


public class Sound {

	public String filename;
	public String instrument;
	public long frequency;
	public long samples;
	public long maxAmp;

	ArrayList<Long> recording = new ArrayList<Long>();

	/**
	 * 
	 * @param url
	 */
	public void dataFromLine(String url) throws Exception {

		URL website = new URL(url);
		InputStream in = website.openStream();
		InputStreamReader inR = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(inR);

		String line;
		int counter = 0;

		while ((line = br.readLine()) != null) {
			if (counter == 0) {
				this.firstLineScanner(line);
				counter = 1;
			}
			else {
				lineScanner(line);
			}
		}
	}

	public void firstLineScanner(String line) {
		Scanner sc = new Scanner(line);

		if (sc.hasNext()) {
			this.frequency = sc.nextLong();
		}
		if (sc.hasNext()) {
			this.samples = sc.nextLong();
		}
		if (sc.hasNext()) {
			this.maxAmp = sc.nextLong();
		}

		sc.close();
	}


	public void lineScanner(String line) {
		Scanner sc = new Scanner(line);

		if (sc.hasNext()) {
			this.recording.add(sc.nextLong());
		}

		sc.close();
	}


}
