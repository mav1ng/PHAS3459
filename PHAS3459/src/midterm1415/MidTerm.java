package midterm1415;

import java.util.ArrayList;

public class MidTerm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			ArrayList<Exoplanet> dataList = Exoplanet.getData("http://www.hep.ucl.ac.uk"
					+ "/undergrad/3459/exam_data/2014-15/exoplanets.txt");
			
			Exoplanet maxExo = Exoplanet.compareDistance(dataList);
			
			
			System.out.println("The details of the exoplanet that is closest to the earth:");
			System.out.println(maxExo);
			
			
			System.out.println();
			System.out.println();
			System.out.println();
			
			
			ArrayList<Exoplanet> transitList = Exoplanet.onlyMethod(dataList, "Transit");
			System.out.println("Number of Exoplanets discovered by the Transit method: " + transitList.size());
			
			ArrayList<Exoplanet> rvList = Exoplanet.onlyMethod(dataList, "RV");
			System.out.println("Number of Exoplanets discovered by the RV method: " + rvList.size());
			
			ArrayList<Exoplanet> microList = Exoplanet.onlyMethod(dataList, "Microlensing");
			System.out.println("Number of Exoplanets discovered by the Microlensing method: " + microList.size());
			System.out.println();
			System.out.println();
			
			
			Exoplanet earlyTransit = Exoplanet.compareYear(transitList);
			System.out.println("The earliest year for Transit method: " + earlyTransit.date);
			System.out.println();
			
			Exoplanet earlyRV = Exoplanet.compareYear(rvList);
			System.out.println("The earliest year for RV method: " + earlyRV.date);
			System.out.println();
			
			Exoplanet earlyMicro = Exoplanet.compareYear(microList);
			System.out.println("The earliest year for Micro method: " + earlyMicro.date);
			System.out.println();
			
			Exoplanet lightestTransit = Exoplanet.compareWeight(transitList);
			System.out.println("The details of the lightest planet discovered with Transit method: ");
			System.out.println(lightestTransit);
			System.out.println();
			
			Exoplanet lightestRV = Exoplanet.compareWeight(rvList);
			System.out.println("The details of the lightest planet discovered with RV method: ");
			System.out.println(lightestRV);
			System.out.println();
			
			Exoplanet lightestMicro = Exoplanet.compareWeight(microList);
			System.out.println("The details of the lightest planet discovered with Microlensing method: ");
			System.out.println(lightestMicro);
			System.out.println();
			
			
			
			
			
			
			
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}

	
}
