package module9;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SolarSystem {

	public static void main(String[] args) {
		
		System.out.println("The Solar System: \nAdditional Information: Except for the sun the 5 planets\n"
				+ "have the correct relative size to each other. The sun is displayed 25 times smaller\n"
				+ "than it is in reality. The elliptic orbitals around the sun are simplified as circles.\n"
				+ "the velocity of the planets relatively to each other is as it is in reality. Furthermore,\n"
				+ "the size of the planets is not downscaled as much as the distance to the sun is.");
		
		
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
