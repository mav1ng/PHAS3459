package module9;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


/**
 * @author zcapmvs
 *
 *Rotating the single planets around the sun
 *with start, stop and exit buttons
 */
public class AnimationGuiPanel extends JPanel implements ActionListener {
	/**
	 * I don't really know what this means but Eclipse tells me to implement this
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private AnimatedPlanets animSun, animMercury, animVenus, animEarth, animMars; //panel with the animation
	private JButton startButton;
	private JButton stopButton;
	private JButton exitButton;
	
	
	/**
	 * Create planetsPanel containing animation panel and buttons.
	 */
	public AnimationGuiPanel() {
		super();
		setPreferredSize(new Dimension(100, 100));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
				
		
		Planet sun = new Planet("Sun", 1391400L, 0, 0, Color.yellow);
		animSun = new AnimatedPlanets(1000, 1000, 0, sun);

		Planet mercury = new Planet("Mercury", 4879L, 58, 88, Color.CYAN);
		animMercury = new AnimatedPlanets(1000, 1000, 0, mercury);
		
		Planet venus = new Planet("Venus", 12104L, 108, 225, Color.ORANGE);
		animVenus = new AnimatedPlanets(1000, 1000, 0, venus);
		
		Planet earth = new Planet("Earth", 12742L, 150, 365, Color.blue);
		animEarth = new AnimatedPlanets(1000, 1000, 0, earth);

		Planet mars = new Planet("Mars", 6779L, 228, 687, Color.RED);
		animMars = new AnimatedPlanets(1000, 1000, 0, mars);
		
		
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");
		exitButton = new JButton("Exit");
		
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		exitButton.addActionListener(this);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(
				buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(exitButton);
		
		
		add(animSun);
		add(animMercury);
		add(animVenus);
		add(animEarth);
		add(animMars);
		add(buttonPanel);
	}
	
	/** Respond to the button clicks */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==startButton) start();
		else if (e.getSource()==stopButton) stop();
		else if (e.getSource()==exitButton) System.exit(0);
	}
	
	/** Start animation when applet is started */
	public void start() {
		animSun.start();
		animMercury.start();
		animVenus.start();
		animEarth.start();
		animMars.start();
	}
	
	/** Stop animation when applet is stopped */
	public void stop() {
		animSun.stop();
		animMercury.stop();
		animVenus.stop();
		animEarth.stop();
		animMars.stop();
	}
	

}
