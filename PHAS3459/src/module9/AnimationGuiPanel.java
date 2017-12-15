package module9;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


/**
 * @author zcapmvs
 *
 *Class putting together all the different Panels we want to have in a main
 *panel and at the same moment adding a layout.
 *Rotating the single planets around the sun
 *with start, stop and exit buttons. Displaying legend and timer and scaling
 *descriptions
 */
public class AnimationGuiPanel extends planetsPanel implements ActionListener {
	/**
	 * I don't really know what this means but Eclipse tells me to implement this
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private AnimatedPlanets animPanel; 	//panel with the animation
	private JButton startButton;		//Button to start the program
	private JButton stopButton;			//Button to stop the program
	private JButton exitButton;			//Button to exit the program
	
	
	/**
	 * Create planetsPanel containing animation panel and buttons.
	 */
	public AnimationGuiPanel() {
		super(1000, 1000, 0);
		
		//setting the preferred Size and choosing the BoxLayout for this panel
		setPreferredSize(new Dimension(1000, 1000));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
				
		//creating the AnimatedPlanets panel
		animPanel = new AnimatedPlanets(1000, 1000, 0);
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");
		exitButton = new JButton("Exit");
		
		//Adding ActionListeners to the Buttons
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		exitButton.addActionListener(this);
		
		//creating the button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(
				buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(exitButton);
		
		//adding the two panels to our main panel
		add(animPanel);
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
		animPanel.start();
	}
	
	/** Stop animation when applet is stopped */
	public void stop() {
		animPanel.stop();
	}
	

}
