package module9;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


/**Class that is representing a animated version of the solar system
 * @author zcapmvs
 *
 * @param delay delay describes the delay in ms between the steps
 * @param animationTimer controls the framerate of the animation
 * @param delta int that describes the degrees the planet will be rotatet
 *around the sun
 */

public class AnimatedPlanets extends planetsPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//variables described above
	private final int delay = 25;
	private Timer animationTimer;
	private final int delta = 1;
	
	
	/**Modified Constructor that varies the angle of the panel planetsPanel so that 
	 * the planets are painted at the right position*/
	AnimatedPlanets(int width, int height, double angle) {
		super(width, height, angle);
		animationTimer = new Timer(delay, this);
		animationTimer.start();
	}
	
	 /** Paint shape at appropriate angle. */
	 protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	 }

	
	/**
	 * Called by the animation Timer object at regular intervals to
	 * rotate the planets around the sun and repaint the planet in the
	 * new position. Additionally, counting the time that is elapse after
	 * the initialisation of the object in seconds
	 */
	public void actionPerformed(ActionEvent event) {
		angle += delta;
		timeElapsed = (System.currentTimeMillis() - startingTime) / 1000;
		repaint();
	}
	
	
	/**Start the animation */
	public void start() {animationTimer.start();}
	
	/**Stop the animation*/
	public void stop() {animationTimer.stop();}
	

}


