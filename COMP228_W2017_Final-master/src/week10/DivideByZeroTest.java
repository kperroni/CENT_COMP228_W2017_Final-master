package week10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.text.DecimalFormat;

public class DivideByZeroTest extends JFrame implements ActionListener{
	
	private JTextField input1, input2, output;
	private int number1, number2;
	private double result;
	
	public DivideByZeroTest(){
		super("Demonstrating Exception");
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(3,2));
		
		//Add numerator to container
		c.add(new JLabel("Enter numerator", SwingConstants.RIGHT));
		input1 = new JTextField(10);
		
		//Add textfield to container
		c.add(input1);
		
		//Add denominator label to container
		c.add(new JLabel("Enter denominator and press enter", SwingConstants.RIGHT));
		
		//Add textfield to container
		input2 = new JTextField(10);
		c.add(input2);
		input2.addActionListener(this);
		
		//Add output label to container
		c.add(new JLabel("RESULT ", SwingConstants.RIGHT));
		
		//Add textfield to container
		output = new JTextField();
		c.add(output);
		
		setSize(425,100);
		setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		DecimalFormat precision3 = new DecimalFormat("0.000");
		
		output.setText("");
		
		try{
			number1 = Integer.parseInt(input1.getText());
			number2 = Integer.parseInt(input2.getText());
			result  = quoitient(number1, number2);
			
			output.setText(precision3.format(result));
			
		}catch(NumberFormatException nfe){
			JOptionPane.showMessageDialog(this, "You must enter two integers", "Invalid Number Format", JOptionPane.ERROR_MESSAGE);
		}catch(DivideByZeroException dbze){
			JOptionPane.showMessageDialog(this, dbze.toString(), "Attempted to Divide by Zero", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	public double quoitient(int numerator, int denominator) throws DivideByZeroException{
		
		if(denominator == 0){
			throw new DivideByZeroException();
		}
		
		return (double) numerator / denominator;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DivideByZeroTest app = new DivideByZeroTest();
		
		app.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				e.getWindow().dispose();
				System.exit(0);
			}
		});
		
	}



}
