package module9;

import java.awt.geom.Ellipse2D;
import java.awt.*;
import javax.swing.*;

/** Class that creates the planets in the solar system as a 
 * panel and then can be implemented in the main method to display
 * all the planets
 * @author Viktor
 *
 * @param distance is normaly given in AU in this representation 
 * we consider 1AU to be 100int
 */

public class Planets extends JLabel {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**Constructor sets the size of the panel*/
	public Planets(int width, int height) {
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
		createPlanet(Color.yellow, 50, x, y, g);
		
		//creating Mercury
		createPlanet(Color.CYAN, 20, x+100, y, g);

		//creating Venus
		createPlanet(Color.ORANGE, 30, x+200, y, g);
		
		//creating Earth
		createPlanet(Color.BLUE, 28, x+300, y, g);
		
		//creating Mars
		createPlanet(Color.RED, 10, x+400, y, g);
		
	}
	
	/**Method that creates a planet of certain color, certain size and certain position
	 * in the solar system
	 */
	protected static void createPlanet(Color color, int diameter, 
			int posX, int posY, Graphics g) {
		
		Graphics2D g2D= (Graphics2D)g;
		Ellipse2D.Double circle = new Ellipse2D.Double(posX-diameter/2, 
				posY-diameter/2, diameter, diameter);
		g2D.setColor(color);
		g2D.fill(circle);
		
	}
}
