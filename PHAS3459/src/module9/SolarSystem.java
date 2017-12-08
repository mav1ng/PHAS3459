package module9;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class SolarSystem {

	public static void main(String[] args) {
		
		
		SwingUtilities.invokeLater(new Runnable() {
		
			@Override
			public void run() {
				createAndDisplayGUI(); 
			}
			
		});
		

	}

	private static void createAndDisplayGUI() {
		JFrame frame = new JFrame("Solar System");
		JLabel planets = new planetsPanel(10000, 10000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(planets);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.pack();
		frame.setVisible(true);
	}

}
