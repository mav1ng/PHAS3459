package exam1617;

public class RangeClassification implements Classification {
	
	public String classify (Sound s) {
		
		String output = "N.A";
		
		double result1;
		double result2;
		double result3;
		
		long[] recordingList = new long[s.recording.size()];
		int counter = 0;
		
		for (long l : s.recording) {
			recordingList[counter] = l;
			counter++;	
		}
				
		result1 = spectralDensity(recordingList, s.duration, 100);
		result2 = spectralDensity(recordingList, s.duration, 400);
		result3 = spectralDensity(recordingList, s.duration, 1000);
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		
		double result4 = Math.max(result1, result2);
		double result = Math.max(result4, result3);
				
		if (result == result1) {
			output = (s.filename + "   Pitch:  " + "low");
		}
		else if (result == result2) {
			output = (s.filename + "   Pitch:  " + "medium");
		}
		else if (result == result3) {
			output = (s.filename + "   Pitch:  " + "high");
		}
		
		return output;
		
	}
	
	
	private static double spectralDensity(long[] samples, double t, double f) {
		int bigN = samples.length;
		double z = 2 * Math.PI * f * t / bigN;
		double sumCos = 0;
		double sumSin = 0;
		for (int n = 0; n < bigN; ++n) {
		sumCos += samples[n]* Math.cos(z*n);
		sumSin += samples[n]* Math.sin(z*n);
		}
		double norm = t / (bigN*bigN);
		return norm * (sumCos*sumCos + sumSin*sumSin);
		}


}

