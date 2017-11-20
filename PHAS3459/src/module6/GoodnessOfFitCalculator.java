package module6;

import java.util.Collection;
import java.util.Iterator;

public interface GoodnessOfFitCalculator {
	
	//method that calculates the chiSquaredValue taking a certain
	//function and the datalist as an input
	public static double goodnessOfFit(Collection<DataPoint> data, Theory theo) {
		

		double chiSqTotal = 0;		//chi squared which defines the goodness of the fit
		double chiSqSingle;			//the single chi squared quantities
		double currentTheoValue;	//the corresponding theoretical value
		
		//Creating the ITerator from the ArrayList
		Iterator<DataPoint> li = data.iterator();
		
		//Looping over the List and calculating the single chisquared values
		while (li.hasNext()) {
			
			DataPoint currentDP = li.next();
			
			currentTheoValue = theo.y(currentDP.getX());
			
			chiSqSingle = (Math.pow(currentDP.getY() - currentTheoValue, 2)) 
					/ Math.pow(currentDP.getEY(), 2);
			
			//adding the single chisquared values to the total chisquared value
			chiSqTotal = chiSqTotal + chiSqSingle;
			
		}
		
		return chiSqTotal;
		
	}

}
