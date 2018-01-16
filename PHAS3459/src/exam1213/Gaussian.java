package exam1213;

import java.util.HashMap;

public class Gaussian implements PredictionDistribution {
	
	double normalisation, higgsmass, width, maxH, minH, stepsize;

	public Gaussian(double n, double h, double w) {
		normalisation = n;
		higgsmass = h;
		width = w;
	}
	
	private double gauss(double E) throws Exception{
		return (normalisation/(width)*Math.sqrt(2*Math.PI))*
				Math.exp(-(Math.pow((E-higgsmass), 2)/(2*Math.pow(width, 2))));
	}
	
	private double trapesium(double eH, double eL) throws Exception {
	
		return (0.5 * (gauss(eH)+gauss(eL))*(eH-eL));
		
	}
	
	@Override
	public HashMap<Double, Double> prediction() throws Exception {
		HashMap<Double, Double> hm = new HashMap<Double, Double>();
		
		for (double i = 100; i < 200; i++) {
			double number = trapesium(i+1, i);
			hm.put(i, number);
		}
		
		return hm;
	}

}
