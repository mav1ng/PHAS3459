package module5;

//Importing the Array class
import java.lang.reflect.Array;

public class SquareMatrix {
	
	
	private int matrixDim = 0; 	//dimension of the square matrix
	private double [][] matrix; //array representation of the square matrix
	
	
	//Constructor 
	public SquareMatrix(double[][] elements) throws Exception {
		
		boolean isSquare = true;
		
		for(int row = 0; row < elements.length; row++) {
			if (elements.length != Array.getLength(elements[row])) {
				isSquare = false;
			}
		}
		
		if (!isSquare) {
			throw new Exception ("The entered array cannot be described as a square matrix!");
		}
		
		//defining the dimension of the matrix
		matrixDim = elements.length;
		
		double [][] sqMatrix = new double[matrixDim][matrixDim];
		
		//creating the matrix Object and assigning the values from the elements matrix
		for (int i = 0; i < matrixDim; i++) {
			for (int k = 0; k < matrixDim; k++ ) {
				sqMatrix[i][k] = elements[i][k];
			}
		
		matrix = sqMatrix;	

		}
		
	}
	
	//toString() method that returns readable representation of the matrix
	public String toString() {
		String matrixOutput = "";
		int i, k;
		for (i = 0; i < matrixDim; i++) {
			for (k = 0; k < matrixDim; k++) {
				matrixOutput = matrixOutput + this.matrix[i][k] + " ";
			}
			matrixOutput = matrixOutput + "\n";
		}
		return matrixOutput;
	}
	
	//method that returns the Unit Matrix of the dimension of the given matrix
	public static SquareMatrix unitMatrix(int size) throws Exception {
		if (size < 1) {
			throw new Exception ("Please enter a dimension bigger than zero!");
		}
		double[][] unitArray = new double[size][size];
		for (int i = 0, k = 0; i < size && k < size; i++, k++) {
			unitArray[i][k] = 1;
		}
		SquareMatrix unitMatrix = new SquareMatrix(unitArray);
		return unitMatrix;
	}

}


