package week8;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

class TextFieldFrame extends JFrame {

	private final JTextField textField1;
	private final JTextField textField2;
	private final JTextField textField3;
	private final JPasswordField passwordField;

	public TextFieldFrame() {

		super("Testing JTextField and JPasswordField");
		setLayout(new FlowLayout()); // Sets layout

		textField1 = new JTextField(10); // 10 character width
		add(textField1);

		textField2 = new JTextField("Enter text here"); // Default text
		add(textField2);

		textField3 = new JTextField("Uneditable text field", 21);
		textField3.setEditable(false); // Disables editing
		add(textField3);

		passwordField = new JPasswordField("Hidden Text");
		add(passwordField);
		
		TextFieldHandler handler = new TextFieldHandler();
		textField1.addActionListener(handler);
		textField2.addActionListener(handler);
		textField3.addActionListener(handler);
		passwordField.addActionListener(handler);
	}

	private class TextFieldHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String str = "";

			if (e.getSource() == textField1) {

				str = String.format("textField1: %s", e.getActionCommand());
			}		
			
			else if (e.getSource() == textField2) {

				str = String.format("textField2: %s", e.getActionCommand());
			}
			
			else if (e.getSource() == textField3) {

				str = String.format("textField3: %s", e.getActionCommand());
			}
			else if (e.getSource() == passwordField) {

				str = String.format("passwordField: %s", e.getActionCommand());
			}
			JOptionPane.showMessageDialog(null, str);
			
			
		}

	}
}
