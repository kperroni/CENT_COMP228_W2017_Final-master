package week8;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RadioButtonFrame extends JFrame{

	private JTextField textField;
	private Font plainFont;
	private Font italicFont;
	private Font boldFont;
	private Font boldItalicFont;
	private JRadioButton plainJRadioButton;
	private JRadioButton italicJRadioButton;
	private JRadioButton boldJRadioButton;
	private JRadioButton boldItalicJRadioButton;
	private ButtonGroup radioGroup;
	
	public RadioButtonFrame(){
		
		super("Radio Button Test"); //Title bar
		setLayout(new FlowLayout());
		
		textField = new JTextField("Watch the font style change", 25);
		add(textField);
		
		plainJRadioButton = new JRadioButton("Plain", true); //Text , is Selected
		italicJRadioButton = new JRadioButton("Italic", false);
		boldJRadioButton = new JRadioButton("bold", false);
		boldItalicJRadioButton = new JRadioButton("Bold/Italic", false);
		add(plainJRadioButton);
		add(italicJRadioButton);
		add(boldJRadioButton);
		add(boldItalicJRadioButton);
		
		//Radio button Group
		radioGroup = new ButtonGroup();
		radioGroup.add(plainJRadioButton);
		radioGroup.add(italicJRadioButton);
		radioGroup.add(boldJRadioButton);
		radioGroup.add(boldItalicJRadioButton);
		
		//Fonts
		plainFont = new Font("Serif", Font.PLAIN, 14);
		boldFont = new Font("Serif", Font.BOLD, 14);
		italicFont = new Font("Serif", Font.ITALIC, 14);
		boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
		textField.setFont(plainFont);
		
		plainJRadioButton.addItemListener(new RadioButtonHandler(plainFont));
		boldJRadioButton.addItemListener(new RadioButtonHandler(boldFont));
		italicJRadioButton.addItemListener(new RadioButtonHandler(italicFont));
		boldItalicJRadioButton.addItemListener(new RadioButtonHandler(boldItalicFont));
	}
	
	
	private class RadioButtonHandler implements ItemListener{

		private Font f;
		
		//Constructor
		public RadioButtonHandler(Font f){
			
			this.f = f;
		}
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			
			textField.setFont(f);
			
		}
		
		
	}
	
}
