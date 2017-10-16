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
		
		
		
		//testing the FallingParticle constructor
		System.out.println();
		System.out.println("Testing the FallingParticle constructor");
		//testing the constructor
		try {
			FallingParticle par = new FallingParticle(-1, 5);
			System.out.println(par);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		//testing setH
		System.out.println();
		System.out.println("Testing the FallingParticle setH() method:");
		try {
			//creating random object
			FallingParticle p = new FallingParticle (1, 1);
			//calling on setH()
			p.setH(-1);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		//testing setV() method
		System.out.println();
		System.out.println("Testing the setV() method:");
		try {
			//creating random object (has to be ok)
			FallingParticle p = new FallingParticle (1, 1);
			//calling on setV()
			p.setV(-1);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		
		//testing doTimeStep() method
		System.out.println();
		System.out.println("Testing doTimeStep() method:");
		try {
			//creating random object (has to be ok)
			FallingParticle p = new FallingParticle (1, 1);
			//calling on doTimeStep()
			p.doTimeStep(0);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		
		//testing drop() method (should be the same)
		System.out.println();
		System.out.println("Testing drop() method:");
		try {
			//creating random object (has to be ok)
			FallingParticle p = new FallingParticle (1, 1);
			//calling on drop()
			p.drop(0);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("The Exceptions work just fine!");
		System.out.println("ALL EXCEPTIONS WORK FINE!");
		
	}

}
