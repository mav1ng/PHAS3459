package module2;

public class ThreeVector {
	
	double x;
	double y;
	double z;
	
	public ThreeVector() {};
	
	
	//method toString()
	public String toString() {
		return "x-component: " + this.x + ",," + "y-component: " + this.y + ",," + "z-component: " + this.z;
	}
	
	//printing out the components
	
	
	//method setVector
	public void setVector(double val1, double val2, double val3) {
		x = val1;
		y = val2;
		z = val3;
	}
	
	//method getVector
	ThreeVector vec = new ThreeVector();
	public ThreeVector getVector() {
		return vec;
	}
	
	
	//method Unit Vector
	ThreeVector vece = new ThreeVector();
	public ThreeVector unitVector(ThreeVector vec) {
		vece.x = vec.x/vec.x;
		vece.y = vec.y/vec.y;
		vece.z = vec.y/vec.z;
		return vece;
	}
	
	
	
	
	
	double magvar;
	public double magnitude() {
		magvar = Math.sqrt(x*x+y*y+z*z);
		return magvar;
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
