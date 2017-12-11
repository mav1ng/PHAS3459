package module9;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


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
	private Timer animationTimer;
	
	
	/**Modified Constructor that varies the angle of the panel planetsPanel so that 
	 * the */
	AnimatedPlanets(int width, int height, double angle) {
		super(width, height, angle);
		animationTimer = new Timer(delay, this);
		animationTimer.start();
	}
	
	 /** Paint shape at appropriate angle. */
	 protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println(angle);
	 }

	
	/**
	 * Called by the animation Timer object at regular intervals to
	 * rotate the planets around the sun and repaint the planet in the
	 * new position
	 */
	public void actionPerformed(ActionEvent event) {
		angle += 1.0;
		System.out.println(angle);
		System.out.println("Repaint");
		repaint();
	}
	
	
	/**Start the animation */
	public void start() {animationTimer.start();}
	
	/**Stop the animation*/
	public void stop() {animationTimer.stop();}
	

}


