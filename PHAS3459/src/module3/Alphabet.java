package module3;

import java.util.* ;

public class Alphabet {

	static char randomCharacter() {
		//creating new random number generator
		Random Rvar = new Random();
		//creates random int between 0 and 127
		int randomint = Rvar.nextInt(128);
		//converting in to type char
		char rc = (char)(randomint);
		return rc;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int runningTotal = 0; //var for counting the total sum of the added numbers
		int excCount = 0; //var for counting the number of exceptions being thrown
		
		StringBuilder str = new StringBuilder();
		
		for (int i = 0; i <= 250; i++) {
			
			char randomchar = randomCharacter();
			
			//testing if randomchar is a Letter or a Digit
			if (Character.isLetter(randomchar) || Character.isDigit(randomchar)) {
				str.append(randomchar);
				
				//if randomchar is a number
				try {
					int runningVar = Integer.parseInt(Character.toString(randomchar));
					runningTotal = runningTotal + runningVar;
				}
				
				//if parseInt throws an exception (randomchar is a letter)
				catch (Exception e) {
					System.out.println(e);
					excCount++;
				}
				
			}
			
		}
		
		System.out.println("Contents of the StringBuilder: str ");
		System.out.println(str);
		System.out.println("Lenght of str: " + str.length());
		System.out.println("Sum of all the Numbers: " + runningTotal);
		System.out.println("Number of all exceptions " + excCount);
		
	}

}
