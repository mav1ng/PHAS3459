package module5;


public class TestSquareMatrix {

	public static void main(String[] args) {
		
		//defining the arrays that describe the matrices
		double[][] arrayA = {{1, 2, 0}, {0, 2, 0 }, {-2, 0, 1}};
		double[][] arrayB = {{2, 1, 0}, {0, 1, 0 }, {-1, 0, 1}};
		double[][] arrayC = {{4, 2}, {3, 2}};
		double[][] arrayD = {{-2, 3}, {3, -4}};
		double[][] arrayI = {{1, 0}, {0, 1}};
		
		//creating the SqareMatrix objects
		try {
			SquareMatrix A = new SquareMatrix(arrayA);
			SquareMatrix B = new SquareMatrix(arrayB);
			SquareMatrix C = new SquareMatrix(arrayC);
			SquareMatrix D = new SquareMatrix(arrayD);
			SquareMatrix I = new SquareMatrix(arrayI);
			
			
			System.out.println("Printing the the sum A+B:");
			System.out.println();
			
			System.out.println(SquareMatrix.add(A, B));
		}
		catch (Exception e) {
			System.out.println(e);
		}

		
		
	}
		
}
	

