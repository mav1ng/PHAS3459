package module2;

public class FallingParticle {
	
	final double m;
	double d;
	static double t;
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
	
	//method to get the current position of the particle
	public double getZ() {
		this.z = -(1/2)*g*t*t + h;
		return this.z;
	}
	
	//method to set the velocity of the particle
	public void setV(double v) {
		this.v = v;
	}
	
	//method to get the velocity of the particle
	public double getV() {
		this.v = g * t + this.v;
		return this.v;
	}
	
	//method to get the time elapsed sind the particle was dropped
	public double getT() {
		return t;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
