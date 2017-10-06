package module1;

public class DataTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double doubVar = 10.0;
		System.out.println(doubVar);
		
		float floatVar = 10;
		int intVar = 10;		// defining different data types
		long longVar = 10;
		byte byteVar = 10;
		
		System.out.println(" ");
		
		System.out.println(doubVar);
		System.out.println(floatVar);
		System.out.println(intVar);		//printing different "10s"
		System.out.println(longVar);
		System.out.println(byteVar);
		
		System.out.println(" ");
		System.out.println(doubVar*doubVar);
		System.out.println(floatVar*floatVar);
		System.out.println(intVar*intVar);		//printing different "100s"
		System.out.println(longVar*longVar);
		System.out.println(byteVar*byteVar);
		
		System.out.println(" ");
		char charVar = 'c'+10;
		char charVar2 = 'm' + 12;
		char charVar3 = 'a' +1;					//testing different combinations of data types
		//int intVar2 = floatVar + intVar;		commented the line out because it was creating an error not allowing the system to compile the code
		float floatvar2 = floatVar + intVar;
		
		System.out.println(charVar);
		System.out.println(charVar2);
		System.out.println(charVar3);		//printing the combinations
		//System.out.println(intVar2);		commented the line out because it was creating an error not allowing the system to compile the code
		System.out.println(floatvar2);
		
		System.out.println("Defining a character by adding integer numbers to a letter and printing it out works fine. The system counts down the alphabet "
				+ "from the letter put in. A integer cannot be defined by adding a integer and a float number (at least without calling a cast). A float can be defined by the sum of an integer #"
				+ "and a float, since no information is lost during that process." );
		System.out.println(" ");
		
		//int j=1;			if using a variable is has to be initialised beforehand
		//int i;			commenting out the unnecessary lines
		//j=j+i; 			this line does not work. see next line
		
		System.out.println("The system gives out an error regarding the variable i and does not compile the code. 'You cannot do operations with variables that have not been initialised.'");
		
		//investigation casts
		double dvar = 4.99; //defining the double variable
		int ivar;
		ivar = (int)dvar;
		System.out.println(" ");
		System.out.println(ivar);
		System.out.println("By converting a double into an int all the information about decimal places is lost. Only the whole numbers are kept.");
		
	
	}

}
