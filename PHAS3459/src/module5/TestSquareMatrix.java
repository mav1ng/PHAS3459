package module5;


public class TestSquareMatrix {

	public static void main(String[] args) {
		
		//defining the arrays that describe the matrices
		double[][] arrayA = {{1, 2, 0}, {0, 2, 0 }, {-2, 0, 1}};
		double[][] arrayB = {{2, 1, 0}, {0, 1, 0 }, {-1, 0, 1}};
		double[][] arrayC = {{4, 3}, {3, 2}};
		double[][] arrayD = {{-2, 3}, {3, -4}};
		double[][] arrayI = {{1, 0}, {0, 1}};
		
		//creating the SqareMatrix objects
		try {
			//creating the SquareMatrix objects
			SquareMatrix A = new SquareMatrix(arrayA);
			SquareMatrix B = new SquareMatrix(arrayB);
			SquareMatrix C = new SquareMatrix(arrayC);
			SquareMatrix D = new SquareMatrix(arrayD);
			SquareMatrix I = new SquareMatrix(arrayI);
			
			//printing out all the used matrices
			System.out.println("Matrix A:");
			System.out.println();
			System.out.println(A);
			System.out.println();
			
			System.out.println("Matrix B:");
			System.out.println();
			System.out.println(B);
			System.out.println();
			
			System.out.println("Matrix C");
			System.out.println();
			System.out.println(C);
			System.out.println();
			
			System.out.println("Matrix D:");
			System.out.println();
			System.out.println(D);
			System.out.println();
			
			System.out.println("Unit Matrix:");
			System.out.println();
			System.out.println(I);
			System.out.println();
			
			System.out.println();
			
			//calculating and printing the sum A+B
			System.out.println("Printing the the sum A+B:");
			System.out.println();
			System.out.println(SquareMatrix.add(A, B));
			System.out.println();
			
			//calculating and printing the difference A-B
			System.out.println("Printing the difference A-B:");
			System.out.println();
			System.out.println(SquareMatrix.subtract(A, B));
			System.out.println();
			
			//calculating and printing the product AB and BA
			System.out.println("Printing the product AB:");
			System.out.println();
			System.out.println(SquareMatrix.multiply(B, A));
			System.out.println();
			
			//calculating and printing the product AB and BA
			System.out.println("Printing the product BA:");
			System.out.println();
			System.out.println(SquareMatrix.multiply(A, B));
			System.out.println();
			
			//calculating and printing out the commutator [A,B]
			//the commutator is defined bz (AB - BA)
			//so we call multiply on both AB and BA and then call subtract on both of the results
			System.out.println("Printing the commutator [A,B]:");
			System.out.println();
			System.out.println(SquareMatrix.subtract(SquareMatrix.multiply(B, A), SquareMatrix.multiply(A, B)));
			System.out.println();
			
			//calculating and printing out the product CD
			System.out.println("Printing the product CD:");
			System.out.println();
			System.out.println(SquareMatrix.multiply(D, C));
			System.out.println();
					
			//checking whether it is equal to the unitmatrix of dimension 2
			System.out.println("Checking whether the product CD is equal to the unitMatrix of dimension 2...");
			System.out.println();
			//checking if it is equal
			if (I.equals(SquareMatrix.multiply(D, C))) {
				System.out.println("The product CD is equal to the unit matrix of dimension 2!");
			}
			else {
				System.out.println("The prodcut CD is not equal to the unit matrix of dimension 2!");
			}
			
			
		}
		catch (Exception e) {
			System.out.println(e);
		}

		
		
	}
		
}
	

