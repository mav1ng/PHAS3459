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
 * @param timeElapsed describes the time that has been elapsed since the
 * animation has been started
 * 
 * The planets will be displayed regarding to their relative real size except for 
 * the sun which is scaled down by a factor of 25 relatively 
 */

public class planetsPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	protected double angle; //the angle regarding its position towards the sun
							//at which the planet is currently
	protected double timeElapsed = 0;
	protected final double startingTime = System.currentTimeMillis();

	
	/**Constructor for creating a planetsPanel and sets the size of the panel*/
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
		
		//painting the background black
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1000, 1000);
		
		//creating the Sun and adding it to the panel
		Planet sun = new Planet("Sun", 1391400L, 0, 0, Color.yellow);
		createPlanet(x, y, angle, sun, g);
		//adding an entry as a description
		g.drawString("Sun\t\t 1:25 relative size" , 20, 80);
		
		//creating Mercury and adding it to the panel
		Planet mercury = new Planet("Mercury", 4879L, 58, 88, Color.CYAN);
		createPlanet(x, y, angle, mercury, g);
		//adding an entry as a description
		g.drawString("Mercury\t\t 1:1 relative size", 20, 100);
		
		
		//creating Venus and adding it to the panel
		Planet venus = new Planet("Venus", 12104L, 108, 225, Color.ORANGE);
		createPlanet(x, y, angle, venus, g);
		//adding an entry as a description
		g.drawString("Venus\t\t 1:1 relative size", 20, 120);
		
		//creating Earth and adding it to the panel
		Planet earth = new Planet("Earth", 12742L, 150, 365, Color.blue);
		createPlanet(x, y, angle, earth, g);
		//adding an entry as a description
		g.drawString("Earth\t\t 1:1 relative size", 20, 140);
		
		//creating Mars and adding it to the panel
		Planet mars = new Planet("Mars", 6779L, 228, 687, Color.RED);
		createPlanet(x, y, angle, mars, g);
		//adding an entry as a description
		g.drawString("Mars\t\t 1:1 relative size", 20, 160);
		
		//adding general scaling information about the panel
		g.setColor(Color.WHITE);
		g.drawString("Simulation Units : Scaled Distance : Scaled Diameter \n 1pixel : 99731941km : 1000km", 300, 20);
		
		
		//adding the time that is elapsed
		g.setColor(Color.WHITE);
		g.drawString(String.format("%.2f", timeElapsed) + " \tseconds elapsed simulation time", 20, 20);
		g.drawString(String.format("%.2f", (timeElapsed * 2263)/(60*60*24)) + " \t days elapsed real time", 20, 40);
		
	}
	
	/**Method that creates a planet of certain color, certain size and certain position
	 * in the solar system
	 * 
	 * @param posX var describing the x position on the panel
	 * @param posY var describing the y position on the panel
	 * @param angle animation will occur by changing this angle value
	 * the real angle will be calculated by multiplying it with a 
	 * speed variable that is calculated by using the orbital period 
	 * variable stored in the planet object
	 * @param Planet planet object in which there are stored all the 
	 * variables that describe the planet 
	 * @param Graphics graphic object in which the new the representation
	 * of the planets will be saved
	 */
	protected static void createPlanet(int posX, int posY, double angle, Planet planet, Graphics g) {
		
		
		//scaling
		double scaledDiameter = planet.diameter/1000;
		double scaledDistance = planet.distanceFromSun*1.5;
		
		//implementing the different velocities of the planets
		double speed;
		
		//randomly scaling the speed of every planet. for the sun the speed
		//is automatically set to 0
		if (planet.orbitalPeriod > 0) {
			speed = 100/planet.orbitalPeriod;	
		}
		else {
			speed = 0;
		}

		
		//sun diameter is scaled differently: double scaled sun diameter
		if (planet.name.equals("Sun")) {
			scaledDiameter = planet.diameter/25000;
		}
		
		//describing the different objects on the plane with the different positions 
		//depending on the angle under which the solar system is displayed at the moment
		Graphics2D g2D = (Graphics2D)g;
		//setting the ellipse with the right parameters of the ellips to the right 
		//position on the panel 
		Ellipse2D.Double circle = new Ellipse2D.Double(posX - scaledDiameter/2 + Math.cos(Math.toRadians(speed * angle)) * scaledDistance, 
				posY - scaledDiameter/2 - Math.sin(Math.toRadians(speed * angle)) * scaledDistance,
				 scaledDiameter, scaledDiameter);
		//colouring the planet in its colour
		g2D.setColor(planet.planetColor);
		g2D.fill(circle);
		
	}


}
