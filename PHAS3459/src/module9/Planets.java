package module9;

import java.awt.geom.Ellipse2D;
import java.awt.*;
import javax.swing.*;

/** Class that creates the planets in the solar system as a 
 * panel and then can be implemented in the main method to display
 * all the planets
 * @author Viktor
 *
 */

public class Planets extends JLabel {


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
		
		//Painting the sun in the middle of the Frame
		Graphics2D sun = (Graphics2D)g;
		int x = width/2;
		int y = height/2;
		Ellipse2D.Double circle = new Ellipse2D.Double(x, y, 50, 50);
		sun.setColor(Color.yellow);
		sun.fill(circle);
		
		
	}
}
