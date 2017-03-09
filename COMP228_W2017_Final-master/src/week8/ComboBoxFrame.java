package week8;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboBoxFrame extends JFrame{
	
	private final JComboBox<String> imagesJComboBox;
	private final JLabel label;
	
	private static final String[] names = 
			{"bug1.png", "bug2.gif", "travelbug.gif", "buganim.gif"};
	
	private final Icon[] icons = 
		{new ImageIcon("images/" + names[0]),
		 new ImageIcon("images/" + names[1]),
		 new ImageIcon("images/" + names[2]),
		 new ImageIcon("images/" + names[3])};
	
	public ComboBoxFrame(){
		
		super("Testing JComboBox");
		setLayout(new FlowLayout());
		
		imagesJComboBox = new JComboBox<String>(names);
		imagesJComboBox.setMaximumRowCount(3);
		
		imagesJComboBox.addItemListener(
				
				new ItemListener()
				{

					@Override
					public void itemStateChanged(ItemEvent e) {
						
						if(e.getStateChange() == ItemEvent.SELECTED){
							
							label.setIcon(icons[imagesJComboBox.getSelectedIndex()]);
						}
						
					}
					
				} //End to our annoymous class
				
				); //End call to addItemListener
		
		add(imagesJComboBox);
		label = new JLabel(icons[0]); //Default label icon
		add(label);
	}

	
	
}
