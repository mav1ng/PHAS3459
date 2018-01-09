package exam1617;

public class VolumeClassification implements Classification{
	
	public String classify(Sound s) {
		
		String output;
		
		if (s.amplitude <= -20) {
			output = "quiet";
		}
		else {
			output = "loud";
		}
		return output;
	}

}
