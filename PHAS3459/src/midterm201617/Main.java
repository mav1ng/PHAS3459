package midterm201617;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		
		
		try {
			
			ArrayList<Player> playerList = Player.getFromURL("http://www.hep.ucl.ac.uk/undergr"
					+ "ad/3459/exam_data/2016-17/MLB2001Hitting.txt");
			
			System.out.println("Number of players in the List: " + playerList.size());
			
			
			System.out.println();
			System.out.println();
			
			System.out.println("Player with the most homeruns in 2001: ");
			Player mostHRP = Player.compareHR(playerList);
			System.out.println(mostHRP);
			
			
			HashMap<String, ArrayList<Player>> teamList = Player.getTeamList(playerList);
			Player currentP = new Player();
			int counter = 0;
			double currentSlug = 0;
			double maxSlug = 0;
			Player maxSlugP = new Player();
			
			for (String s : teamList.keySet()) {
				ArrayList<Player> currentList = teamList.get(s);
				counter = 0;
				currentSlug = 0;
				maxSlug = 0;
				maxSlugP = new Player();
				
				for (int i = 0; i < currentList.size(); i++) {
					
					currentP = currentList.get(i);
					
					if (currentP.ab >= 10) {
						counter++;
					}
					
					if (currentP.ab == 0) {
						currentSlug = 0;
					}
					else {
						
						currentSlug = ((currentP.h + 2*currentP.twoB + 3*currentP.threeB + 4*currentP.hr)/currentP.ab);
						
						if (maxSlug == 0  || maxSlug < currentSlug) {
							
							maxSlug = currentSlug;
							maxSlugP = currentP;
							
						}
						
					
						
					
					}
						
				}
				
				System.out.println("Team " + s + " has " + counter  + " Players with more than 10 ATs");
				System.out.println("Team's " + s + "Player with the highest Slug is: " + maxSlugP);
				System.out.println();
			}
			
			
			
			
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}

	
}
