package midterm1415;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Exoplanet {
	
	String name = "";
	int date = 0;
	String dM = "";
	double mass = 0;
	double sep = 0;
	double dis = 0;
	
	//method that creates Exoplanet object with the given information in the line input
	public static Exoplanet parseData(String line) throws Exception {
		
		//creating Scanner of the input line
		
		Scanner sc = new Scanner(line);
		Scanner scD = sc.useDelimiter(",");
		Scanner scDE = scD.useLocale(Locale.ENGLISH);
		
		//creating the new Exoplanet objecz
		Exoplanet ep = new Exoplanet();
		
		if (scDE.hasNext()) {
			ep.name = scDE.next();
		}
		
		if (scDE.hasNextInt()) {
			ep.date = scDE.nextInt();
		}
		
		if (scDE.hasNext()) {
			ep.dM = scDE.next();
		}
		
		if (scDE.hasNextDouble()) {
			ep.mass = scDE.nextDouble();
		}
		
		if (scDE.hasNextDouble()) {
			ep.sep = scDE.nextDouble();
		}
		
		if (scDE.hasNextDouble()) {
			ep.dis = scDE.nextDouble();
		}
		else {
			ep.dis = -1;
		}
		
		sc.close();
		
		return ep;
		
	}
	
	//method that gets data from url and parses that into an arraylist using the former method
	public static ArrayList<Exoplanet> getData(String url) throws Exception {
		
		URL website = new URL(url);
		InputStream inputS = website.openStream();
		InputStreamReader inReader = new InputStreamReader (inputS);
		BufferedReader buffReader = new BufferedReader(inReader);
		
		String line;
		ArrayList<Exoplanet> dataList = new ArrayList<Exoplanet>();
		Exoplanet currentE = new Exoplanet();
		
		//ignoring the first line
		buffReader.readLine();
		
		while ((line = buffReader.readLine()) != null) {
			
			currentE = parseData(line);
			
			dataList.add(currentE);
			
		}
		
		inputS.close();
		
		return dataList;
		
	}
	
	
	public String toString() {
		
		String output = "Name: " + name + "\n" + "date: " + date + "\n" + "Discovery Method: " +
		dM + "\n" + "Mass: " + mass + "\n" + "Seperation: " + sep + "\n" + "Distance from Earth: " +
				dis;
		
		return output;
		
	}
	
	
	public static Exoplanet compareDistance(ArrayList<Exoplanet> list) throws Exception {
		
		Exoplanet maxDisExo = new Exoplanet();
		Exoplanet currentExo = new Exoplanet();
		
		for (int i = 0; i < list.size(); i++) {
			
			currentExo = list.get(i);
			
			if(maxDisExo.dis == 0 && currentExo.dis != -1) {
				maxDisExo = currentExo;
			}
			
			if(currentExo.dis < maxDisExo.dis && currentExo.dis != -1) {
				
				maxDisExo = currentExo;
				
			}
			
		}
			
			return maxDisExo;
			
	}
	
	

	public static ArrayList<Exoplanet> onlyMethod(ArrayList<Exoplanet> mainList, String method) throws Exception {
		
		ArrayList<Exoplanet> methodList = new ArrayList<Exoplanet>();
		Exoplanet currentE = new Exoplanet();
		
		for (int i = 0; i < mainList.size(); i++) {
			
			currentE = mainList.get(i);
			if (currentE.dM.equals(method)) {
				methodList.add(currentE);
			}
			
		}
		
		return methodList;
		
	}
	
	
public static Exoplanet compareYear(ArrayList<Exoplanet> list) throws Exception {
		
		Exoplanet minYearExo = new Exoplanet();
		Exoplanet currentExo = new Exoplanet();
		
		for (int i = 0; i < list.size(); i++) {
			
			currentExo = list.get(i);
			
			if(minYearExo.dis == 0) {
				minYearExo = currentExo;
			}
			
			if(currentExo.date < minYearExo.date) {
				
				minYearExo = currentExo;
				
			}
			
		}
			
			return minYearExo;
			
	}
	

public static Exoplanet compareWeight(ArrayList<Exoplanet> list) throws Exception {
	
	Exoplanet minWeightExo = new Exoplanet();
	Exoplanet currentExo = new Exoplanet();
	
	for (int i = 0; i < list.size(); i++) {
		
		currentExo = list.get(i);
		
		if(minWeightExo.dis == 0) {
			minWeightExo = currentExo;
		}
		
		if(currentExo.date < minWeightExo.date) {
			
			minWeightExo = currentExo;
			
		}
		
	}
		
		return minWeightExo;
		
}
		


}
