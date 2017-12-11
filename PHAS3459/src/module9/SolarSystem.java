package module9;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SolarSystem {

	public static void main(String[] args) {
		
		
		SwingUtilities.invokeLater(new Runnable() {
		
			@Override
			public void run() {
				//createAndDisplayGUI_static(); 
				createAndDisplayGUI_anim();
			}
			
		});
		

	}
	
	private static void createAndDisplayGUI_static() {
		JFrame frame = new JFrame("Solar System");
		JLabel planets = new planetsPanel(1000, 1000, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(planets);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.pack();
		frame.setVisible(true);
	}
	
	private static void createAndDisplayGUI_anim() {
		JFrame frame = new JFrame("Animation Solar System");
		JPanel panel = new AnimationGuiPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		//frame.setSize(1000, 1000);
		frame.pack();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
	}

}
