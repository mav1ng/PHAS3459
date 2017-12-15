package module9;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Main Class that prints out details about the simulation that is created.
 * It creates either a static or the animated version of the Solar System.
 * Currently the static version is commented out and the animated version is
 * calles on.
 * 
 * @author zcapmvs
 *
 */


public class SolarSystem {

	public static void main(String[] args) {
		
		//printing out details about the chosen animation
		System.out.println("The Solar System: \nAdditional Information: Except for the sun the 5 planets\n"
				+ "have the correct relative size to each other. The sun is displayed 25 times smaller\n"
				+ "than it is in reality. The elliptic orbitals around the sun are simplified as circles.\n"
				+ "the velocity of the planets relatively to each other is as it is in reality. Furthermore,\n"
				+ "the size of the planets is not downscaled as much as the distance to the sun is.");
		
		
		//making the swing class thread safe by creating a runnable object
		//and calling the creating method from there
		SwingUtilities.invokeLater(new Runnable() {
		
			@Override
			public void run() {
				//createAndDisplayGUI_static(); 
				createAndDisplayGUI_anim();
			}
			
		});
		

	}
	
//	private static void createAndDisplayGUI_static() {
//		JFrame frame = new JFrame("Solar System");
//		JPanel planets = new planetsPanel(1000, 1000, 0);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.add(planets);
//		frame.getContentPane().setBackground(Color.BLACK);
//		frame.pack();
//		frame.setVisible(true);
//	}
	
	
	//method that creates a frame sets the preferred size and adds the
	//animation panel
	private static void createAndDisplayGUI_anim() {
		JFrame frame = new JFrame("Animation Solar System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		//frame.getContentPane().setBackground(Color.BLACK);
		AnimationGuiPanel panel = new AnimationGuiPanel();
		frame.add(panel);
		frame.setVisible(true);
	}

}
