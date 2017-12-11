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
	private final double delta;
	private Timer animationTimer;
	private Planet p;
	
	
	/**Modified Constructor that varies the angle of the panel planetsPanel so that 
	 * the */
	AnimatedPlanets(int width, int height, double angle, Planet planet) {
		super(width, height, angle);
		p = planet;
		delta = 2*Math.PI*delay/(p.orbitalPeriod*(8.64e+7));
		animationTimer = new Timer(delay, this);
		animationTimer.start();
	}
	
	/**Modifying the paintComponent() method from the superclass*/
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = getWidth();
		int height = getHeight();
		int x = width/2;
		int y = height/2;
		
		createPlanet(x, y, angle, p, g);
	}

	
	/**
	 * Called by the animation Timer object at regular intervals to
	 * rotate the planets around the sun and repaint the planet in the
	 * new position
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		angle += delta;
		repaint();
	}
	
	
	
	/**Start the animation */
	public void start() {animationTimer.start();}
	
	/**Stop the animation*/
	public void stop() {animationTimer.stop();}
	

}


