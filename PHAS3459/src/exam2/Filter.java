package exam2;

import java.util.ArrayList;

import javafx.util.Pair;

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
	
	/**
	 * method that takes two lists of flights and returns a new list with the combination of
	 * the two flights that meet some criterion
	 * 
	 * @param al arraylists of flight objects
	 * @return arraylist of flight objects
	 * @throws Exception throws exception if some of the data structures are not working
	 */
	public ArrayList<Pair<Flight, Flight>> multiFilter(ArrayList<Flight> al, ArrayList<Flight> al2) throws Exception;

}
