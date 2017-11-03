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
			
			
			
		}
		catch (Exception e) {
			System.out.println(e);
		}

		
		
	}
		
}
	

