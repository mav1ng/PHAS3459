package module9;

import java.awt.geom.Ellipse2D;
import java.awt.*;
import javax.swing.*;

/** Class that creates the planets in the solar system as a 
 * panel and then can be implemented in the main method to display
 * all the planets
 * @author zcapmvs
 *
 * @param distance is normally given in AU in this representation 
 * we consider 1AU to be 100int
 * 
 * The planets will be displayed regarding to their relative real size except for 
 * the sun which is scaled down by a factor of 10 relatively 
 */

public class planetsPanel extends JLabel {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**Constructor sets the size of the panel*/
	public planetsPanel(int width, int height) {
		setPreferredSize(new Dimension(width, height));
	}
	
	
	/**Redefining the paint component method that defines how the panel
	 * is going to look
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = getWidth();
		int height = getHeight();
		int x = width/2;
		int y = height/2;
		
		
		//creating the Sun
		Planet sun = new Planet("Sun", 1391400L, 0, 0, Color.yellow);
		createPlanet(x, y, sun, g);
		
		//creating Mercury
		Planet mercury = new Planet("Mercury", 4879L, 58, 88, Color.CYAN);
		createPlanet(x, y, mercury, g);

		//creating Venus
		Planet venus = new Planet("Venus", 12104L, 108, 225, Color.ORANGE);
		createPlanet(x, y, venus, g);
		
		//creating Earth
		Planet earth = new Planet("Earth", 12742L, 150, 365, Color.blue);
		createPlanet(x, y, earth, g);
		
		//creating Mars
		Planet mars = new Planet("Mars", 6779L, 228, 687, Color.RED);
		createPlanet(x, y, mars, g);
		
	}
	
	/**Method that creates a planet of certain color, certain size and certain position
	 * in the solar system
	 */
	protected static void createPlanet(int posX, int posY, Planet planet, Graphics g) {
		
		//scaling of the numbers
		double scaledDiameter = planet.diameter/1000;
		double scaledDistance = planet.distanceFromSun*2;
		
		//double scaled sun diameter
		if (planet.name.equals("Sun")) {
			scaledDiameter = planet.diameter/10000;
		}
		
		
		Graphics2D g2D= (Graphics2D)g;
		Ellipse2D.Double circle = new Ellipse2D.Double(posX + scaledDistance - 
				(scaledDiameter/2), posY -(scaledDiameter/2),
				scaledDiameter, scaledDiameter);
		g2D.setColor(planet.planetColor);
		g2D.fill(circle);
		
	}
}
