package module5;

public class SquareMatrix {
	
	
	private int matrixDim = 0; 	//dimension of the square matrix
	private double [][] matrix; //array representation of the square matrix
	
	
	//Constructor 
	public SquareMatrix(double[][] elements) throws Exception {
		
		try {
			int length1 = elements[0].length;
			int length2 = elements[1].length;
			double [][] sqMatrix = new double[length1][length2];
			
			//creating the matrix Object and assigning the values from the elements matrix
			//should throw an Exception if length1 != length2
			for (int i = 0; i <= length1; i++) {
				for (int k = 0; k <= length2; k++ ) {
					sqMatrix[i][k] = elements[i][k];
				}
			
			matrix = sqMatrix;	
				
			//defining the dimension of the matrix
			this.matrixDim = sqMatrix[0].length;
			}
			
		}
		catch (Exception e) {
			System.out.println("The entered array is not representable in a square matrix. Eg has");
			System.out.println();
			System.out.println(" not the same number of rows and columns");
			this.matrixDim = 0;
			throw e;
		}
		
	}
	
	//toString() method that returns readable representation of the matrix
	public String toString() {
		String matrixOutput = "";
		int i, k;
		for (i = 0; i <= matrixDim; i++) {
			for (k = 0; k <= matrixDim; k++) {
				matrixOutput = matrixOutput + this.matrix[i][k] + " ";
			}
			matrixOutput = matrixOutput + "\n";
		}
		return matrixOutput;
	}

}
