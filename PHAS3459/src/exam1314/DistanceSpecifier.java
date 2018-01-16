package exam1314;

import java.util.ArrayList;

public class DistanceSpecifier implements Specifier {
	
	public final int r = 6371; //radius of the earth in kilometers
	double longitude;
	double latitude;
	int dis;
	
	public DistanceSpecifier(double la, double l, int d) {
		latitude = la;
		longitude = l;
		dis = d;
	}

	@Override
	public ArrayList<Specimen> specify(ArrayList<Specimen> al) throws Exception {
		
		ArrayList<Specimen> specAl = new ArrayList<Specimen>();
		double distance = 0;
		double h = 0;
		
		for (Specimen s: al) {
			h = Main.haversin(Math.toRadians(latitude-s.latitude)) + Math.cos(Math.toRadians(s.latitude))
			*Math.cos(Math.toRadians(latitude))*Main.haversin((Math.toRadians(longitude-s.longitude)));
			distance = Math.abs(2*r*Math.asin(Math.sqrt(h)));
			
			if (distance <= dis) {
				specAl.add(s);
			}
		}
		
		return specAl;
		
	}

}
