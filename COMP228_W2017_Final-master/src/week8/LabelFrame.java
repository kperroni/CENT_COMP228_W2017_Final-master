package week8;

import java.awt.FlowLayout; 		//Specifies how components are arranged
import javax.swing.JFrame; 			//Basic window functionality
import javax.swing.JLabel; 			//Displays text and images
import javax.swing.SwingConstants; 	//Utility class with common constants used with Swing
import javax.swing.Icon; 			//Interface used to manipulate images
import javax.swing.ImageIcon; 		//Load images

public class LabelFrame extends JFrame{

	//Labels
	private final JLabel label1;
	private final JLabel label2;
	private final JLabel label3;
	
	//Constructor
	public LabelFrame() {
		
		super("Testing JLabel"); //Title bar string
		setLayout(new FlowLayout()); //Sets layout of the window
		
		label1 = new JLabel("Label with text"); //Initializes JLabel with text
		label1.setToolTipText("This is label1"); //Adds a tool tip to the label
		add(label1); //Adds label1 to the window
		
		Icon bug = new ImageIcon("images/GUItip.gif");
		label2 = new JLabel("Label with text and icon", bug, SwingConstants.LEFT);
		label2.setToolTipText("This is label2");
		add(label2);
		
		label3 = new JLabel();
		label3.setText("Label with icons and text at bottom");
		label3.setIcon(bug);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		label3.setToolTipText("This is label3");
		add(label3);
	}

}
