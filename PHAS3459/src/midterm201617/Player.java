package midterm201617;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class Player {
	
	public String name = "";
	public String team = "";
	public String pos = "";
	public int g = 0;
	public int ab = 0;
	public int r = 0;
	public int h = 0;
	public int twoB = 0;
	public int threeB = 0;
	public int hr = 0;
	public int rbi = 0;
	public double avg = 0;
	public double obp = 0;
	
	
	public String toString() {
		String output = "Name of the Player : " + name + "\n" + "Team of the Player: " + team + "\n" +
	"Position of the Player: " + pos + "\n" + "Number of games the Player played: " + g + "\n" +
				"AB of the Player: " + ab + "\n" + "R of the Player: " + r + "\n" +"blablabla";
		
		return output;
	
	}
	
	
	public static Player createPlayer(String line) throws Exception {
		
		Scanner sc = new Scanner(line);
		Scanner scD = sc.useDelimiter("\t");
		Scanner scE = scD.useLocale(Locale.ENGLISH);
		
		Player p = new Player();
		
		if (scE.hasNext()) {
			p.name = scE.next();
		}
		
		if (scE.hasNext()) {
			p.team = scE.next();
		}
		
		if (scE.hasNext()) {
			p.pos = scE.next();
		}
		
		if (scE.hasNextInt()) {
			p.g = scE.nextInt();
		}
		
		if (scE.hasNextInt()) {
			p.ab = scE.nextInt();
		}
		
		if (scE.hasNextInt()) {
			p.r = scE.nextInt();
		}
		
		if (scE.hasNextInt()) {
			p.h = scE.nextInt();
		}
		
		
		if (scE.hasNextInt()) {
			p.twoB = scE.nextInt();
		}
		
		
		if (scE.hasNextInt()) {
			p.threeB = scE.nextInt();
		}
		
		
		if (scE.hasNextInt()) {
			p.hr = scE.nextInt();
		}
		
		
		if (scE.hasNextInt()) {
			p.rbi = scE.nextInt();
		}
		
		
		if (scE.hasNextDouble()) {
			p.avg = scE.nextDouble();
		}
		
		
		if (scE.hasNextDouble()) {
			p.obp = scE.nextDouble();
		}
		else {
			p.obp = -1;
		}
		
		sc.close();

		return p;
		
	}
	
	
	
	public static ArrayList<Player> getFromURL(String url) throws Exception {
		
		String line;
		ArrayList<Player> playerList = new ArrayList<Player>();
		Player currentPlayer = new Player();
		
		URL website = new URL(url);
		InputStream is = website.openStream();
		InputStreamReader ir = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(ir);
		
		br.readLine();
		br.readLine();
		
		while ((line = br.readLine()) != null ) {
			
			currentPlayer = createPlayer(line);
			
			playerList.add(currentPlayer);
			
		}
		
		is.close();
		
		return playerList;
		
	}
	
	
	public static HashMap<String, ArrayList<Player>> getTeamList(ArrayList<Player> mainList) throws Exception {
		
		Player currentPlayer = new Player();
		String currentTeam;
		HashMap<String, ArrayList<Player>> teamList = new HashMap<String, ArrayList<Player>>();
		//ArrayList<Player> cT = new ArrayList<Player>();
		
		for (int i = 0; i < mainList.size(); i++) {
			
			currentPlayer = mainList.get(i);
			currentTeam = currentPlayer.team;
			ArrayList<Player> cT = teamList.get(currentTeam);
			
			if (cT == null) {
				teamList.put(currentTeam, new ArrayList<Player>());
			}
			
			teamList.get(currentTeam).add(currentPlayer);
			
		}
		
		return teamList;
		
	}
	
	
	public static Player compareHR(ArrayList<Player> list) throws Exception {
		
		Player currentP = new Player();
		Player maxHRPlayer = new Player();
		
		for (int i = 0; i < list.size(); i++) {
			
			currentP = list.get(i);
			
			if (maxHRPlayer.hr < currentP.hr) {
				maxHRPlayer = currentP;
			}
			
			
		}
		
		return maxHRPlayer;
		
	}
	
	
	

}
