package module2;

public class ThreeVector {
	
	double x;
	double y;
	double z;
	
	//constructior
	public ThreeVector() {};
	
	
	
	//printing out the components
	//System.out.println(this);
	
	
	//method setVector
	public void setVector(double val1, double val2, double val3) {
		x = val1;
		y = val2;
		z = val3;
	}
	
	//method getVector
	public ThreeVector getVector() {
		ThreeVector vec = new ThreeVector();
		return vec;
	}
	
	
	//magnitude method
	double magvar;
	public double magnitude(ThreeVector vec) {
		magvar = Math.sqrt(vec.x*vec.x+vec.y*vec.y+vec.z*vec.z);
		return magvar;
	}
	
	//method Unit Vector
	ThreeVector vece = new ThreeVector();
	public ThreeVector unitVector(ThreeVector vec) {
		vece.x = vec.x/vec.x;
		vece.y = vec.y/vec.y;
		vece.z = vec.y/vec.z;
		return vece;
	}
	
	

	//method toString()
	public String toString() {
		return "x-component: " + this.x + ",," + "y-component: " + this.y + ",," + "z-component: " + this.z;
	}
	
	private static double scalvar;
	public static double scalarProduct( ThreeVector vec1, ThreeVector vec2) {
		scalvar = vec1.x*vec2.x + vec1.y*vec2.y + vec1.z + vec2.z;
		return scalvar;
	}
	
	//Static Method VectorProduct
	public static ThreeVector vectorProduct( ThreeVector vec1, ThreeVector vec2 ) {
		ThreeVector vpv = new ThreeVector();
		vpv.x = vec1.y*vec2.z - vec1.z*vec2.y;
		vpv.y = (-1)*(vec1.x*vec2.z - vec1.z*vec2.x);
		vpv.z = vec1.x*vec2.y - vec1.y*vec2.x;
		return vpv;
	}
	
	//static method add
	public static ThreeVector add( ThreeVector vec1, ThreeVector vec2 ) {
		ThreeVector vpa = new ThreeVector();
		vpa.x = vec1.x+vec2.x;
		vpa.y = vec1.y+vec2.y;
		vpa.z = vec1.z+vec2.z;
		return vpa;
	}
	
	//static method angle
	public static double angle(ThreeVector vec1, ThreeVector vec2) {
		ThreeVector vec = new ThreeVector();
		double anglevar;
		
		//calculating the angle
		anglevar = Math.acos(scalarProduct(vec1, vec2)/vec.magnitude(vec1)*vec.magnitude(vec2));
		return anglevar;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}