package exam1617;

public class DurationClassification implements Classification {
	
	public String classify(Sound s) {
		
		String output;
		
		if (s.duration <= 1) {
			output = "short";
		}
		else {
			output = "long";
		}
		return output;
	}

}
