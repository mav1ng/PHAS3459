package module4;

import java.io.*;

public class NumericalReader {
	
	//defining the method that promps user to input string and then stores it
	public static String getStringFromKeyboard() throws Exception {
		
		System.out.println("Please enter a String!");
		
		try {
		
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String input = in.readLine();
			return input;
			
		}
		
		catch (Exception e) {
			
			throw (e);
		
		}
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
