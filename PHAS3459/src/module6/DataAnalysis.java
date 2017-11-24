package module6;

import java.util.ArrayList;
import java.util.Collection;

public class DataAnalysis {
	
	
	//copied the bestTheory method in
	//method that determines what theory fits the data the best
	//according to one specified goodness of fit calculation
    private static Theory bestTheory(Collection<DataPoint> data,
            Collection<Theory> theories, GoodnessOfFitCalculator gofCalculator) {
        boolean first = true;
        double bestGoodnessOfFit = 0.0;
        Theory bestTheory = null;
        for (Theory theory : theories) {
            double gof = gofCalculator.goodnessOfFit(data, theory);
            if (first) {
                bestTheory = theory;
                bestGoodnessOfFit = gof;
                first = false;
            } else if (gof < bestGoodnessOfFit) {
                bestTheory = theory;
                bestGoodnessOfFit = gof;
            }
        }
        return bestTheory;
    }

    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		try {
			//getting the data points from the website
			ArrayList<DataPoint> dpList = TestDataPoints.dataFromURL("http://www.hep.ucl.ac.uk/undergrad"
					+ "/3459/data/module6/module6-data.txt");
			//creating a collection with the used theories
			ArrayList<Theory> theoList = new ArrayList<Theory>();
			
			//adding the theories to the theories list
			theoList.add(new PowerLawTheory(2));
			theoList.add(new PowerLawTheory(2.05));
			theoList.add(new QuadraticTheory(1, 10, 0));
			
			//setting the kind of method with which we want to test the goodness of the fit
			ChiSquared cS = new ChiSquared();
			
			//using the bestTheory method to find out which ones the best theory
			Theory bestT = bestTheory(dpList, theoList, cS);
			
			System.out.println("Calculating and printing out the function best matching "
					+ "the given data file:");
			System.out.println(bestT);
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		

	}

}
