package module1;

public class DataTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double doubVar = 10.0;
		System.out.println(doubVar);
		
		float floatVar = 10;
		int intVar = 10;		// defining different data types
		byte byteVar = 10;
		
		System.out.println(doubVar);
		System.out.println(floatVar);
		System.out.println(intVar);		//printing different "10s"
		System.out.println(byteVar);
		
		System.out.println(doubVar*doubVar);
		System.out.println(floatVar*floatVar);
		System.out.println(intVar*intVar);		//printing different "100s"
		System.out.println(byteVar*byteVar);
		
		char charVar = 'c'+10;
		char charVar2 = 'm' + 12;
		char charVar3 = 'a' +1;					//testing different combinations of data types
		//int intVar2 = floatVar + intVar;
		float floatvar2 = floatVar + intVar;
		
		System.out.println(charVar);
		System.out.println(charVar2);
		System.out.println(charVar3);		//printing the combinations
		//System.out.println(intVar2);
		System.out.println(floatvar2);
		
		System.out.println("Defining a character by adding integer numbers to a letter and printing it out works fine. The system counts down the alphabet "
				+ "from the letter put in. A integer cannot be defined by adding a integer and a float number. A float can be defined by the sum of an integer #"
				+ "and a float, since no information is lost during that process." );
		
		int j=1;
		int i;
		//j=j+i;
		System.out.println("The system gives out an error regarding the variable i. You cannot do operations with variables that have not been initialised.");
		
		double dvar = 4.99; //defining the double variable
		int ivar;
		//ivar = dvar;
		//System.out.println(ivar);
		System.out.println("a double cannot be converted into an int");
		
	
	}

}
