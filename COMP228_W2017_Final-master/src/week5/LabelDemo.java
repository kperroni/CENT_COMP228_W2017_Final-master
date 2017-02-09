package week5;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;

public class LabelDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Simple label with text
		JLabel northLabel = new JLabel("North");
		
		// Load icon 
		ImageIcon labelIcon = new ImageIcon("images/GUItip.gif");
		
		// Label with Icon
		JLabel centerLabel = new JLabel(labelIcon);
		
		// Label with Icon
		JLabel southLabel = new JLabel(labelIcon);
		southLabel.setText("South");
		
		JFrame application = new JFrame();
		
		// Set close operation. Add components to the JFrame
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(northLabel, BorderLayout.NORTH);
		application.add(centerLabel, BorderLayout.CENTER);
		application.add(southLabel, BorderLayout.SOUTH);
		
		application.setSize(300, 300); 	// Set the size of the frame
		application.setVisible(true); 	// Show the frame
	}

}
