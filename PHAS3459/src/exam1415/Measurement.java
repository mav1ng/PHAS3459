package exam1415;

public class Measurement {
	
	public String id;
	public int year, month, day, hours, minutes;
	public double level, pLevel;

	
	public String toString() {
		String output = "id: " + id + "\ndate: " + day +"/"+ month +"/" + year + "\n"
				+ "time: " + hours +":" + minutes + "\nlevel: " + level + "\n"
						+ "predicted level: " + pLevel;
		return output;
	}
	
}
