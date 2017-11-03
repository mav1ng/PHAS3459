package module5;

//Importing the Array class
import java.lang.reflect.Array;
import java.util.Arrays;

public class SquareMatrix {
	
	
	
	private int matrixDim = 0; 	//dimension of the square matrix
	private double [][] matrix; //array representation of the square matrix
	
	
	
	//Constructor 
	public SquareMatrix(double[][] elements) throws Exception {
		
		boolean isSquare = true;
		
		//checks whether the entered array can be used to create a square matrix
		for(int row = 0; row < elements.length; row++) {
			if (elements.length != Array.getLength(elements[row])) {
				isSquare = false;
			}
		}
		
		//throwing the Exception
		if (!isSquare) {
			throw new Exception ("Matrix Creation Error: The entered array cannot be described as a square matrix!");
		}
		
		//defining the dimension of the matrix
		matrixDim = elements.length;
		
		double [][] sqMatrix = new double[matrixDim][matrixDim];
		
		//creating the matrix Object and assigning the values from the elements matrix
		for (int i = 0; i < matrixDim; i++) {
			for (int k = 0; k < matrixDim; k++ ) {
				sqMatrix[i][k] = elements[i][k];
			}
		
			//saving the matrix
		matrix = sqMatrix;	

		}
		
	}
	
	
	
	//toString() method that returns readable representation of the matrix
	public String toString() {
		String matrixOutput = "";
		int i, k;
		//adding the different arguments to a string that will be given out in the end
		for (i = 0; i < matrixDim; i++) {
			for (k = 0; k < matrixDim; k++) {
				matrixOutput =  matrixOutput + matrix[i][k] + "  ";
			}
			matrixOutput = matrixOutput + "\n";
		}
		//final string given out
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
	
	
	
	//hashCode() and equals() method
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(matrix);
		result = prime * result + matrixDim;
		return result;
	}


	//equals() method 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SquareMatrix other = (SquareMatrix) obj;
		if (!Arrays.deepEquals(matrix, other.matrix))
			return false;
		if (matrixDim != other.matrixDim)
			return false;
		return true;
	}
	
	
	//three static methods that carry out calculations for SquareMatrix objects
	//method to add two square matrices
	public static SquareMatrix add(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
	
		//defining the array that will describe the sum of the two matrices
		double [][] smTotalArray = new double[sm1.matrixDim][sm2.matrixDim];
		
		//throws Exception if the dimensions of the matrices are different
		if (sm1.matrixDim != sm2.matrixDim) {
			throw new Exception ("Matrix Addition Error: The dimensions of the matrices have to be the same!");
		}
		//setting each element of the array to the sum of the according elements of both arrays
		for (int i = 0; i < sm1.matrixDim; i++) {
			for (int k = 0; k < sm1.matrixDim; k++) {
				smTotalArray[i][k] = sm1.matrix[i][k] + sm2.matrix[i][k];
			}
		}
		SquareMatrix smTotal = new SquareMatrix (smTotalArray);
		return smTotal;
	}
	
	
	//method to subtract two square matrices
	public static SquareMatrix subtract(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		
		//defining the array that will describe the difference of the two matrices
		double [][] smTotalArray = new double[sm1.matrixDim][sm2.matrixDim];
		
		//throws Exception if the dimensions of the matrices are different
		if (sm1.matrixDim != sm2.matrixDim) {
			throw new Exception ("Matrix Subtraction Error: The dimensions of the matrices have to be the same!");
		}
		//setting each element of the array to the difference of the according elements of both arrays
		for (int i = 0; i < sm1.matrixDim; i++) {
			for (int k = 0; k < sm1.matrixDim; k++) {
				smTotalArray[i][k] = sm1.matrix[i][k] - sm2.matrix[i][k];
			}
		}
		SquareMatrix smTotal = new SquareMatrix (smTotalArray);
		return smTotal;
	}
	
	
	//method to multiply the two matrices whereas the first argument is the matrix to which argument two is multiplied to
	public static SquareMatrix multiply(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		//throwing an Exception if the tow matrices cannot be multiplied
		if (sm1.matrixDim != sm2.matrixDim) {
			throw new Exception ("Matrix Multiplication Error: The number of rows of matrix two has to be equal to the number of columns of the first one!");
		}
		//defining the new Array which will describe the resulting SquareMatrix
		double[][] smTotalArray = new double[sm1.matrixDim][sm2.matrixDim];
		//defining the needed variables
		double newValue;
		double newSum = 0;
		//setting each element to the right value
		for (int i = 0; i < sm1.matrixDim; i++) {
			for (int k = 0; k < sm1.matrixDim; k++) {
				//resetting newSum
				newSum = 0;
				//calculating the entry for the position [i][k] in the new array
				for (int j = 0; j < sm1.matrixDim; j++) {
					newValue = sm2.matrix[i][j] * sm1.matrix[j][k];
					newSum = newSum + newValue;
				}
			//assigning the new value to the corresponding place in the new array	
			smTotalArray[i][k] = newSum;
			}
		}
		SquareMatrix smTotal = new SquareMatrix(smTotalArray);
		return smTotal;
	}
	
	//non-static methods for the three added static methods
	//non-static add() method which adds the called on SquareMatrix two another specified one
	public SquareMatrix add(SquareMatrix sm1) throws Exception {
		return add(this, sm1);
	}
	
	//non-static subtract() method which subtracts the specified matrix from the called-on-one
	public SquareMatrix subtract(SquareMatrix sm1) throws Exception {
		return subtract(this, sm1);
	}
	
	//non-static multiply() method which multiplies the specified matrix(argument) to the called-on-one
	public SquareMatrix multiply(SquareMatrix sm1) throws Exception {
		return multiply(this, sm1);
	}
}


