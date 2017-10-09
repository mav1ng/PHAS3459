package module2;

public class TestThreeVector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreeVector v1 = new ThreeVector(3, 5, 2);
		ThreeVector v2 = new ThreeVector(2, 4, 1);
		ThreeVector v3 = new ThreeVector(0, 0, 0);
		
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

	}

}
