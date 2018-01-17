package exam2;

import java.util.ArrayList;

public interface Filter {
	
	/**
	 * method that takes a list of flights and returns a new list 
	 * of the flights that meet some criterion
	 * 
	 * @param al arraylist of flight objects
	 * @return arraylist of flight objects
	 * @throws Exception throws exception if some of the data structures are not working
	 */
	public ArrayList<Flight> filter(ArrayList<Flight> al) throws Exception;

}
