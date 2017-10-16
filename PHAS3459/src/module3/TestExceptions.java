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
		
		//testing Error message fo Complex class:
		System.out.println();
		System.out.println("Testing Complex.normalised:");
		try {
			Complex.ZERO.normalised();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
