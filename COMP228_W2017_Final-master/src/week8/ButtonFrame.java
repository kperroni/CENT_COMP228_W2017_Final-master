package week8;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ButtonFrame extends JFrame {
	
	private final JButton plainJButton; //Just text
	private final JButton fancyJButton; //Icons
	
	public ButtonFrame(){
		
		super("Testing buttons");
		setLayout(new FlowLayout());
		
		plainJButton = new JButton("Plain Button");
		add(plainJButton);
		
		Icon bug1  = new ImageIcon("images/bug1.png");
		Icon bug2 = new ImageIcon("images/bug2.gif");
		fancyJButton = new JButton("Fancy Button", bug1);
		fancyJButton.setRolloverIcon(bug2);
		add(fancyJButton);
		
		ButtonHandler handler = new ButtonHandler();
		plainJButton.addActionListener(handler);
		fancyJButton.addActionListener(handler);
	}
	
	private class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		
			JOptionPane.showMessageDialog(ButtonFrame.this, String.format("You pressed: %s", e.getActionCommand()));
			
		}
		
		
	}

}
