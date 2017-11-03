package module5;

import java.util.ArrayList; 	//importing the ArrayList class
import java.util.ListIterator;	//importing the ListIterator class
import java.io.*;				//importing the IO class
import java.net.URL; 			//importing the URL class

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

	
	public static double goodnessOfFit(Theory theoFunction, ArrayList<DataPoint> expArray) {
		
		double chiSqTotal = 0; 			//chi squared which defines the goodness of the fit
		double chiSqSingle;			//the single chi squared quantities
		double currentTheoValue;		//the corresponding theoretical value
		
		
		try {
			
			//creating a ListIterator from the ArrayList
			ListIterator<DataPoint> li = expArray.listIterator();
			
			while (li.hasNext()) {
				
				//accessing the current DataPoint from the list
				DataPoint currentDP = li.next();
				
				//calculating the theoretical value
				currentTheoValue = theoFunction.y(currentDP.getX());
				
				//calculating the single chiSquared quantity
				//its calculated by (y_theo - y_exp)^2 / ey^2
				chiSqSingle = (Math.pow((currentDP.getY() - currentTheoValue), 2)) 
						/ Math.pow(currentDP.getEY(), 2);
				
				//adding it to the total chiSquared
				chiSqTotal = chiSqTotal + chiSqSingle;
				
			}
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return chiSqTotal;
		
	}
	
		
}
