package module5;

public class SquareMatrix {
	
	
	//Constructor 
	public SquareMatrix(double[][] elements) throws Exception {
		int length1 = elements[0].length;
		int length2 = elements[1].length;
		double [][] sqMatrix = new double[length1][length1];
		
		//creating the matrix Object and assigning the values from the elements matrix
		//should throw an Exception if length1 != length2
		for (int i = 0; i <= length1; i++) {
			for (int k = 0; k <= length2; k++ ) {
				sqMatrix[i][k] = elements[i][k];
			}
		}
	}

}
