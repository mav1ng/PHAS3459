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
		
		//filling in the array list
		try {
			while ((line = br.readLine()) != null) {
				//calling on the createFromURL method to scann trough the line and create the 
				//DataPoint object which then gets added to the ArrayList "al" which holds
				//objects from the type DataPoints
				al.add(DataPoint.createFromURL(line));
			}
		//returning the Arraylist	
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
