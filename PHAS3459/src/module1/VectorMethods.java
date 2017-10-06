package module1;

public class VectorMethods {


	//defining the function dotProduct;
	public double dotProduct (double a, double b, double c, double d, double e, double f) {
		double dotP;
		dotP = a*d+b*e+c*f;
		return dotP;
	}
	//defining the method magnitude
	public double magnitude (double x, double y, double z) {
		double magvar = Math.sqrt(x*x + y*y + z*z);
		return magvar;
	}
	//defining the method angle
	public double angle (double a, double b, double c, double d, double e, double f) {
		double anglevar;
		anglevar = (dotProduct(a,b,c,d,e,f))/(magnitude(a,b,c)*magnitude(d,e,f));
		return anglevar;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VectorMethods vm = new VectorMethods();
		double resvar = vm.angle(2,3,4,1,3,2);
		resvar = Math.acos(resvar);
		System.out.println("The angle between the two vectors is "+resvar*(360/(2*Math.PI)));
		double resvar2 = vm.angle(2,3,4,0,0,0);
		resvar2 = Math.acos(resvar2);
		System.out.println("The angle between the two vectors is " + resvar2 +" /not defined");
		System.out.println("Since you cannot divide by 0");

		}

	}


