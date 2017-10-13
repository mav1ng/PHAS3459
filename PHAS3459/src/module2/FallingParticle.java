package module2;

public class FallingParticle {
	
	final double m;
	double d;
	double t;
	double z;
	double h;
	double v;
	final double g = 9.81;
	
	//constructor
	public FallingParticle(double m, double d) {
		this.m = m;
		this.d = d;
	}
	
	//method to set the height of the falling particle
	public void setH(double h) {
		this.h = h;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
