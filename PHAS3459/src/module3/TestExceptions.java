package module3;

public class TestExceptions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//testing Error message for Complex class:
		System.out.println("Testing Complex Class");
		Complex z = new Complex(1, 3);
		try {
			Complex.divide(z, Complex.ZERO);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("The Exceptions work just fine!");
		
		//testing Error message fo Complex class:
		System.out.println();
		System.out.println("Testing Complex.normalised:");
		try {
			Complex.ZERO.normalised();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("The Exceptions work just fine!");
		
		//testing Threevector.unitVector()
		System.out.println();
		System.out.println("Testing Threevector.unitVector()");
		try {
			ThreeVector.ZERO.unitVector(ThreeVector.ZERO);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("The Exceptions work just fine!");
		
		//testing ThreeVector.angle()
		System.out.println();
		System.out.println("Testing ThreeVector.angle()");
		//creating random ThreeVector
		ThreeVector v = new ThreeVector(1, 1, 1);
		try {
			ThreeVector.angle(v, ThreeVector.ZERO);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		//changing the vectors
		try {
			ThreeVector.angle(ThreeVector.ZERO, v);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("The Exceptions work just fine!");
	}

}
