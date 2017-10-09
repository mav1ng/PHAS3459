package module2;

public class ThreeVector {
	
	double x;
	double y;
	double z;
	
	//constructor
	public ThreeVector() {};
	//second constructor
	public ThreeVector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	
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
	
	public double magnitude(ThreeVector vec) {
		double magvar;
		magvar = Math.sqrt(vec.x*vec.x+vec.y*vec.y+vec.z*vec.z);
		return magvar;
	}
	
	//method Unit Vector

	public ThreeVector unitVector(ThreeVector vec) {
		ThreeVector vece = new ThreeVector();
		vece.x = vec.x/vec.x;
		vece.y = vec.y/vec.y;
		vece.z = vec.y/vec.z;
		return vece;
	}
	
	

	//method toString()
	public String toString() {
		return "x-component: " + this.x + "  " + "y-component: " + this.y + "  " + "z-component: " + this.z;
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
	
	
	
	//non static Version scalarProduct
	public double scalarProductns(ThreeVector vec1, ThreeVector vec2) {
		return scalarProduct(vec1, vec2);
		
	}
	
	//non static Version vectorPoduct
	public ThreeVector vectorProductns(ThreeVector vec1, ThreeVector vec2) {
		return vectorProduct(vec1, vec2);
	}
	
	
	//non static Version add
	public ThreeVector addns(ThreeVector vec1, ThreeVector vec2) {
		return add(vec1, vec2);
	}


	
	//non static Version angle
	public double anglens(ThreeVector vec1, ThreeVector vec2) {
		return angle(vec1, vec2);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
