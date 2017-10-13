package module2;


public class TestComplex {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		//defining the complex numbers
		Complex c1 = new Complex(1, 2);
		Complex c2 = new Complex(-2, -1);
		
		//calculating and printing the product
		System.out.println("The Product:");
		System.out.println(Complex.multiply(c1, c2));
		System.out.println();
		
		//calculating and printing out the ratio
		System.out.println("The ratio:");
		System.out.println(Complex.divide(c1,  c2));
		System.out.println();
		
		//calculating and printing out the product c1*I
		System.out.println("The Product c1*I");
		System.out.println(Complex.multiply(c1, Complex.I));
		System.out.println();
		
		//calculating and printing out the ratio c1/ZERO
		System.out.println("The ration c1/ZERO:");
		System.out.println(Complex.divide(c1, Complex.ZERO));
		System.out.println();
		
		//calculating and printing out the product of c1 with the conjugate of c1
		System.out.println("The product of c1 with the conjugate of c1:");
		System.out.println(Complex.multiply(c1, c1.conjugate()));
		System.out.println();
		
		//calculating and printing out the product of c2 with the conjugate of c2
		System.out.println("The product of c2 with the conjugate of c2:");
		System.out.println(Complex.multiply(c2, c2.conjugate()));
		System.out.println();
		
	}

}
