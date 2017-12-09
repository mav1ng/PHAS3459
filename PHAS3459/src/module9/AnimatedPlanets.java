package module9;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

/**Class that describes the animated Planets in the frame
 * @author zcapmvs
 *
 * @param delay delay describes the ms between the steps
 * @param delta angle to rotate the planet around the sun
 * @param angle current angle of the shape on screen
 *@param animationTimer controls the framerate of the animation
 */

public class AnimatedPlanets extends planetsPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int delay = 50;
	private final double delta;
	private Timer animationTimer;
	
	
	/**Modified Constructor that varies the angle of the panel planetsPanel so that 
	 * the */
	AnimatedPlanets(int width, int height, double angle, Planet planet) {
		super(width, height, angle);
		delta = 2*Math.PI*delay/(planet.orbitalPeriod*(8.64e+7));
		//animationTimer.start();
		//animationTimer.start();
	}
	
	/**Modifying the paintComponent() method from the superclass*/
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		angle += delta;
		
	}
	

}


