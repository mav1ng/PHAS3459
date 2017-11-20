package module6;

import java.util.Collection;
import java.util.Iterator;

public interface GoodnessOfFitCalculator {
	
	public static double goodnessOfFit(Collection<DataPoint> data, Theory theo) {
		
		double chiSqTotal = 0;
		double chiSqSingle;
		double currentTheoValue;
		
		Iterator<DataPoint> li = data.iterator();
		
		while (li.hasNext()) {
			
			DataPoint currentDP = li.next();
			
			currentTheoValue = theo.y(currentDP.getX());
			
			chiSqSingle = (Math.pow(currentDP.getY() - currentTheoValue, 2)) 
					/ Math.pow(currentDP.getEY(), 2);
			
			chiSqTotal = chiSqTotal + chiSqSingle;
			
		}
		
		return chiSqTotal;
		
	}

}
