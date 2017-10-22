package module3;

public class FallingParticle {
	
	//declaring the used variables
	
	
	double m; //m=mass,
	double d; //d=drag coefficient
	double t; //t=elapsed time
	double z; //z=position
	double h; //h=initial height
	double v; //v=current velocity
	final static double g = 9.80665; //g=earth gravity constant
	
	//constructor
	public FallingParticle(double m, double d) throws Exception {
		//exception for unphysical values of m and d (less than zero)
		if (m < 0 || d < 0) {
			throw new Exception("The mass and the drag coefficient of an object "
					+ "cannot be less than zero!");
		}
		this.m = m;
		this.d = d;
	}
	
	//method to set the height of the falling particle
	public void setH(double h) throws Exception {
		//The initial height of the object has to be higher or equal to zero
		if (h < 0) {
			throw new Exception("The object has to be inside the vessel! The height has to be bigger or equal to zero!");
		}
		this.h = h;
	}
	
	//method to get the current position of the particle
	public double getZ() {
		//calculation of the current position of the object where t is the time elapsed
		//and g is the gravity constant and h is the initial height
		this.z = -(1/2)*g*t*t + h;
		return this.z;
	}
	
	//method to set the velocity of the particle
	public void setV(double v) throws Exception {
		//inital velocity has to be equal or greater than 0
		if (v < 0) {
			throw new Exception("There is no negative velocity.");
		}
		this.v = v;
	}
	
	//method to get the velocity of the particle
	public double getV() {
		//calculating the velocity after an elapsed time of t
		this.v = g * t + this.v;
		return this.v;
	}
	
	//method to get the time elapsed since the particle was dropped
	public double getT() {
		return t;
	}

	//method to update velocity and position of the particle 
	public void doTimeStep(double deltaT) throws Exception {
		//deltaT needs to be greater than zero
		if (deltaT <= 0) {
			throw new Exception("DeltaT has to be greater than 0!");
		}
		//calculating the current acceleration of the particle
		double a = ((this.d*this.v*this.v)/m)-g;
		//updating the current speed
		this.v = this.v + a*deltaT;
		//updating the current position
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
			try {
				doTimeStep(deltaT);
				t = t + deltaT;
			}
			catch (Exception e) {
				System.out.println(e);
				break;
			}
		}
	}

}
