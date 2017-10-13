package module2;

public class TestThreeVector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//defining the different ThreeVectors
		ThreeVector v1 = new ThreeVector(3, 5, 2);
		ThreeVector v2 = new ThreeVector(2, 4, 1);
		ThreeVector v3 = new ThreeVector(0, 0, 0);
		
		//printing out the magnitude
		System.out.println("The magnitude of the vectors");
		System.out.println(v1.magnitude(v1));
		System.out.println(v2.magnitude(v2));
		System.out.println(v3.magnitude(v3));
		System.out.println();
		
		//printing out the vectors
		System.out.println("The Three Vectors:");
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println();
		
		//printing out the unit vectors
		System.out.println("The Unit Vectors");
		System.out.println(v1.unitVector(v1));
		System.out.println(v2.unitVector(v2));
		System.out.println(v3.unitVector(v3));	
		System.out.println();
		
		//printing the scalar and vector products with static methods
		System.out.println("The Scalar Products");
		System.out.println(ThreeVector.scalarProduct(v1, v2));
		System.out.println(ThreeVector.scalarProduct(v1, v3));
		System.out.println();
		System.out.println("The Vector Products");
		System.out.println(ThreeVector.vectorProduct(v1, v2));
		System.out.println(ThreeVector.vectorProduct(v1, v3));
		System.out.println();
		
		//printing the scalar and the vector products with non-static methods
		System.out.println("The Scalar Products with non-static methods");
		System.out.println(v1.scalarProductns(v1, v2));
		System.out.println(v1.scalarProductns(v1, v3));
		System.out.println();
		System.out.println("The Vector Products with non-static methods");
		System.out.println(v1.vectorProductns(v1, v2));
		System.out.println(v1.vectorProductns(v1, v3));
		System.out.println();
		
		//printing the angle between the two vectors with static methods
		System.out.println("The angle in degrees between the two vectors with static methods");
		System.out.println(ThreeVector.angle(v1, v2));
		System.out.println(ThreeVector.angle(v1, v3));
		System.out.println();
		
		//printing the angle between the two vectors with non-static methods
		System.out.println("The angel in degrees between the two vectors with non-static methods");
		System.out.println(v1.anglens(v1, v2));
		System.out.println(v1.anglens(v1, v3));
		System.out.println();
		
		//what happens when trying to print an object without having declared the toString() method
		System.out.println();
		//System.out.println(v1);
		System.out.println("What happens when trying to print an object without having declared the toString() method?");
		System.out.println("If there is no toString() method defined the system just gives out");
		System.out.println("some kind of id of the object and where it is located. No information");
		System.out.println("that the object has actually stored is given out. It looks like this:");
		System.out.println("The Three Vectors:\r\n" + 
				"module2.ThreeVector@7852e922\r\n" + 
				"module2.ThreeVector@4e25154f\r\n" + 
				"module2.ThreeVector@70dea4e");

	}

}
