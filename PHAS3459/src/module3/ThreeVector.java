package module3;


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
	
	//creating zero vector
	ThreeVector ZERO = new ThreeVector(0, 0, 0);
	
	//printing out the components
	//System.out.println(this);
	
	
	//method setVector
	public void setVector(double val1, double val2, double val3) {
		x = val1;
		y = val2;
		z = val3;
	}
	
	//method which gives out the current ThreeVector
	public ThreeVector getVector() {
		ThreeVector vec = new ThreeVector();
		return vec;
	}
	
	
	//method to calculate the magnitude of the current ThreeVector
	public double magnitude(ThreeVector vec) {
		double magvar;
		//calculating the magnitude, its the square root of all the 
		//components squared and added together
		magvar = Math.sqrt(vec.x*vec.x+vec.y*vec.y+vec.z*vec.z);
		return magvar;
	}
	
	//method that gives out the UnitVector of the object that was put in as
	//an argument
	public ThreeVector unitVector(ThreeVector vec) throws Exception {
		//exception
		if (vec == ZERO) {
			throw new Exception("The zero vector has no unitVector!");
		}
		ThreeVector vece = new ThreeVector();
		vece.x = vec.x/vec.x;
		vece.y = vec.y/vec.y;
		vece.z = vec.y/vec.z;
		return vece;
	}
	
	

	//toString() method
	public String toString() {
		return "x-component: " + this.x + "  " + "y-component: " + this.y + "  " + "z-component: " + this.z;
	}
	
	//method that calculated the scalar prodcut between to ThreeVectors
	public static double scalarProduct( ThreeVector vec1, ThreeVector vec2) {
		double scalvar;
		//calculation of the scalarproduct by multiplying the several componets and adding them up
		scalvar = vec1.x*vec2.x + vec1.y*vec2.y + vec1.z*vec2.z;
		return scalvar;
	}
	
	
	
	//method gives you out the vectorProduct between the two ThreeVectors that were put in
	public static ThreeVector vectorProduct( ThreeVector vec1, ThreeVector vec2 ) {
		ThreeVector vpv = new ThreeVector();
		//calculating the first component of the new Vector
		vpv.x = vec1.y*vec2.z - vec1.z*vec2.y;
		//calculating the second component of the new Vector
		vpv.y = (-1)*(vec1.x*vec2.z - vec1.z*vec2.x);
		//calculating the third component of the new Vector
		vpv.z = vec1.x*vec2.y - vec1.y*vec2.x;
		return vpv;
	}
	
	
	
	//method that adds two ThreeVectors and gives out the new one
	public static ThreeVector add( ThreeVector vec1, ThreeVector vec2 ) {
		ThreeVector vpa = new ThreeVector();
		//Adding the different components of the two Vectors together
		vpa.x = vec1.x+vec2.x;
		vpa.y = vec1.y+vec2.y;
		vpa.z = vec1.z+vec2.z;
		return vpa;
	}
	
	
	
	//method that gives you out the angle between to Vectors in degrees
	public static double angle(ThreeVector vec1, ThreeVector vec2) {
		double anglevar;
		double anglevar2;
		//calculating the angle (arccos((vec1*vec2/(mag(vec1)*mag(vec2))) where mag is the magnitude of the Vector
		anglevar = Math.acos(scalarProduct(vec1, vec2)/(vec1.magnitude(vec1)*vec2.magnitude(vec2)));
		//converting from radiant into degrees
		anglevar2 = anglevar * (360/(2*Math.PI));
		return anglevar2;
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
