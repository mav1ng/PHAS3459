package module6;

import java.util.Collection;

public interface GoodnessOfFitCalculator {
	
	//method that calculates the goodness of the fit taking a certain
	//theoretical function and the datalist as an input
	public double goodnessOfFit(Collection<DataPoint> data, Theory theo);
		
}
