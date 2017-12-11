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
 * @param angle angle at which the solar system is positioned at the moment
 * 
 * The planets will be displayed regarding to their relative real size except for 
 * the sun which is scaled down by a factor of 10 relatively 
 */

public class planetsPanel extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected double angle; //the angle regarding its position towards the sun
							//at which the planet is currently


	
	/**Constructor sets the size of the panel*/
	public planetsPanel(int width, int height, double angle) {
		setPreferredSize(new Dimension(width, height));
		this.angle = angle;
	}
	
	
	/**Redefining the paint component method that defines how the panel
	 * is going to look when a planetsPanel object is created
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = getWidth();
		int height = getHeight();
		int x = width/2;
		int y = height/2;
		
		//creating the Sun
		Planet sun = new Planet("Sun", 1391400L, 0, 0, Color.yellow);
		createPlanet(x, y, angle, sun, g);
		
		//creating Mercury
		Planet mercury = new Planet("Mercury", 4879L, 58, 88, Color.CYAN);
		createPlanet(x, y, angle, mercury, g);

		//creating Venus
		Planet venus = new Planet("Venus", 12104L, 108, 225, Color.ORANGE);
		createPlanet(x, y, angle, venus, g);
		
		//creating Earth
		Planet earth = new Planet("Earth", 12742L, 150, 365, Color.blue);
		createPlanet(x, y, angle, earth, g);
		
		//creating Mars
		Planet mars = new Planet("Mars", 6779L, 228, 687, Color.RED);
		createPlanet(x, y, angle, mars, g);
		
	}
	
	/**Method that creates a planet of certain color, certain size and certain position
	 * in the solar system
	 */
	protected static void createPlanet(int posX, int posY, double angle, Planet planet, Graphics g) {
		
		//scaling of the numbers
		double scaledDiameter = planet.diameter/1000;
		double scaledDistance = planet.distanceFromSun*2;
		
		//double scaled sun diameter
		if (planet.name.equals("Sun")) {
			scaledDiameter = planet.diameter/10000;
		}
		
		//describing the different objects on the plane with the different positions 
		//depending on the angle under which the solar system is displayed at the moment
		Graphics2D g2D= (Graphics2D)g;
		Ellipse2D.Double circle = new Ellipse2D.Double(posX - scaledDiameter/2 + Math.cos(Math.toRadians(angle)) * scaledDistance, 
				posY - scaledDiameter/2 - Math.sin(Math.toRadians(angle)) * scaledDistance,
				 scaledDiameter, scaledDiameter);
		g2D.setColor(planet.planetColor);
		g2D.fill(circle);
		
	}


}
