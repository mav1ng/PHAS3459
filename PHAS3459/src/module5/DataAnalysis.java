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
				//calling on the createFromURL method to scan trough the line and create the 
				//DataPoint object which then gets added to the ArrayList "al" which holds
				//objects from the type DataPoints
				al.add(DataPoint.createFromURL(line));
			}
		//returning the ArrayList	
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
	
	
	public static void main(String[] args) {
		
		//defining the two theory objects first
		Theory t1 = new Theory(2);
		Theory t2 = new Theory(4);
		
		
		try {
			//getting the Data from the URL and creating the expData ArrayList
			ArrayList<DataPoint> expData = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data"
					+ "/module5/module5-xy.txt");
			
			
			//trying the first function first y = x^2	
			double resultT1 = goodnessOfFit(t1, expData);
			//second function
			double resultT2 = goodnessOfFit(t2, expData);
			
			//printing out the results
			System.out.println("Chi squared results of the two different functions with the one dataset:");
			System.out.println();
			System.out.println("ChiSquared 1: " + resultT1);
			System.out.println();
			System.out.println("ChiSquared 2: " + resultT2);
			
			System.out.println();
			System.out.println("The second function 'y = x^4' describes the data far better ");
			System.out.println("than the first one since a chi squared value of 2.77 is far more");
			System.out.println("convenient than a chi squared value of 5759.31.");
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
			
	}
	
		
}
