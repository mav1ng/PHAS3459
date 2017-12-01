package midterm1516;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.lang.Character;



//class to get the data from the url
public class Data {
	
	
	public static ArrayList<DataEQ> getDataFromURL(String urlName) throws Exception {
		
		URL inWebsite = new URL(urlName);
		InputStream input = inWebsite.openStream();
		InputStreamReader inputR = new InputStreamReader(input);
		BufferedReader reader = new BufferedReader(inputR);
		
		//ignoring the first two lines of the website
		reader.readLine();
		reader.readLine();
		
		String line;
		DataEQ dq = new DataEQ();
		//creating a new ArrayList where all the Earthquakedata should be stored
		ArrayList<DataEQ> dataList = new ArrayList<DataEQ>();
		
		while ((line = reader.readLine()) != null) {
			dq = new DataEQ();
			dataList.add(dq.storeData(line));
		}
		
		
		input.close();
		return dataList;
		
	}
	
	//method that returns the details of the strongest earthquake
	public static DataEQ analyseMag(ArrayList<DataEQ> list) throws Exception {
		DataEQ deepestEQ = new DataEQ();
		DataEQ currentEQ = new DataEQ();
		
		for (int i = 0; i < list.size(); i++) {
			currentEQ = list.get(i);
			
			if (i == 0) {
				deepestEQ = currentEQ;
			}
			
			if (currentEQ.dep >= 0 && deepestEQ.dep < currentEQ.dep) {
				deepestEQ = currentEQ;
			}
		}
		
		return deepestEQ;
		
	}
	
	
	//method that creates an arrayList for all the earthquake that happened in one specified month 
	public static ArrayList<DataEQ> monthList(int month, ArrayList<DataEQ> mainList) throws Exception {
		
		DataEQ currentEQ = new DataEQ();
		ArrayList<DataEQ> monthList = new ArrayList<DataEQ>();
		String currentDate = "1989/" + month;
		
		for (int i = 0; i < mainList.size(); i++) {
			currentEQ = mainList.get(i);
			Character c = (currentEQ.date).charAt(6);
			
			//Figuring out whether its a single digit month or not
			if (Character.isDigit(c)) {
				//month has two digits

			//	System.out.println((currentEQ.date).substring(0, 7));
				if (currentDate.equals((currentEQ.date).substring(0, 7))) {
					monthList.add(currentEQ);
				}	
			}
			
			if (!Character.isDigit(c)) {
				if (currentDate.equalsIgnoreCase((currentEQ.date).substring(0, 6))) {
					monthList.add(currentEQ);
				}
			}
			
		}
		
		return monthList;
		
	}
	
	
	//method that returns the details of the strongest earthquake
		public static DataEQ analyseErr(ArrayList<DataEQ> list) throws Exception {
			DataEQ accEQ = new DataEQ();
			DataEQ currentEQ = new DataEQ();
			
			for (int i = 0; i < list.size(); i++) {
				currentEQ = list.get(i);
				
				if (i == 0) {
					accEQ = currentEQ;
				}
				
				if (currentEQ.ez >= 0 && accEQ.ez < currentEQ.ez) {
					accEQ = currentEQ;
				}
			}
			
			return accEQ;
			
		}
	
	
	
}
