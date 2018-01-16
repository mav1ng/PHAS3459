package CarlaTest;

public class Tide {
	
	int year;
	int month;
	int day;
	int hour;
	int min;
	double seaLevel;
	double predictedSeaLevel;
	
	public Tide(int year, int month, int day, int hour, int min, double seaLevel, double predictedSeaLevel) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.min = min;
		this.seaLevel = seaLevel;
		this.predictedSeaLevel = predictedSeaLevel;
	}

	public String toString() {
		return "year: " + year + " , month: " + month + " , day: " + day +
				" , hour: " + hour + " , min: " + min + " , Sea Level: " + seaLevel + 
				" , Predicted Sea Level:" + predictedSeaLevel;
	}
}

