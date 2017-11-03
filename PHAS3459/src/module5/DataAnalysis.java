package module5;

import java.util.ArrayList; //importing the ArrayList class
import java.io.*;			//importing the IO class
import java.net.URL; 		//importing the URL class

public class DataAnalysis {
	
	public static ArrayList<DataPoint> dataFromURL(String url) throws Exception {
		
		//creating the new URL
		URL inWebsite = new URL(url);
		//opening the input stream from the URL
		InputStream inStream = inWebsite.openStream();
		//decodes the input stream into characters
		InputStreamReader inReader = new InputStreamReader(inStream);
		//buffering the input stream 
		BufferedReader br = new BufferedReader(inReader);
		
		//creating a new ArrayList object that is supposed to get DataPoint objects
		ArrayList<DataPoint> al = new ArrayList<DataPoint>();
		
		String line;
		
		try {
			while ((line = br.readLine()) != null) {
				al.add(DataPoint.createFromURL(line));
			}
			
		return	al;		
		
		} 
		catch (Exception e) {
			throw e;
		}
		finally {
			//closing all the streams
			br.close();
			inReader.close();
			inStream.close();
		}

	}

}
