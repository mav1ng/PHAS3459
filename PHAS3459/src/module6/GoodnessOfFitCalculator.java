package module6;

import java.util.Collection;

public interface GoodnessOfFitCalculator {
	
	//method that calculates the chiSquaredValue taking a certain
	//function and the datalist as an input
	public double goodnessOfFit(Collection<DataPoint> data, Theory theo);
		
}
