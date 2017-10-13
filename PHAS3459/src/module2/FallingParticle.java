package module2;

public class FallingParticle {
	
	final double m;
	double d;
	static double t;
	double z;
	double h;
	double v;
	final double g = 9.80665;
	
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
	
	//method to get the time elapsed since the particle was dropped
	public double getT() {
		return t;
	}

	//method to update velocity and position of the particle 
	public void doTimeStep(double deltaT) {
		//calculating the current acceleration of the particle
		double a = ((this.d*this.v*this.v)/m)-g;
		this.v = this.v + a*deltaT;
		this.z = this.z + (this.v*deltaT);
	}
	
	//method to simulate the descent of the particle until it reaches the bottom
	public void drop(double deltaT) {
		//setting object to starting position
		this.z = this.h;
		//resetting time
		t = 0;
		//setting initial velocity to 0
		this.v = 0;
		//simulating the drop
		while (this.z >= 0) {
			doTimeStep(deltaT);
			t = t + deltaT;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
