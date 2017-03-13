package week8;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class LayoutManagerTest extends JFrame{


		//Variables
		
		private JPanel pNorth, pCenter, pWest, pEast, pSouth;
		private JLabel lblName, lblPosition;
		private JTextField txtName, txtPosition;
		private JButton left, center, right, bEast, bWest, bSouth1, bSouth2;
		
		
		//Constructor
		
		public LayoutManagerTest(){
			
			super("Multiple layout test");
			
			//Creating new panels for each region
			
			pNorth = new JPanel();
			pCenter = new JPanel();
			pWest = new JPanel();
			pEast = new JPanel();
			pSouth = new JPanel();
			
			//Initializing buttons
			left = new JButton("Left");
			center = new JButton("Center");
			right = new JButton("Right");
			bWest = new JButton("West");
			bEast = new JButton("East");
			bSouth1 = new JButton("Java Programming");
			bSouth2 = new JButton("COMP228");
		
			//Register button events
			
			ButtonHandler handler = new ButtonHandler();
			left.addActionListener(handler);
			center.addActionListener(handler);
			right.addActionListener(handler);
			
			//Add components to the panel
			
			pNorth.add(left);
			pNorth.add(right);
			pNorth.add(center);
			pNorth.setBackground(Color.RED);
			
			pCenter.setLayout(new GridLayout(2,2,5,5));
			
			lblName = new JLabel("Name: ");
			lblPosition = new JLabel("Position: ");
			txtName = new JTextField(20);
			txtPosition = new JTextField(20);
			
			pCenter.add(lblName);
			pCenter.add(txtName);
			pCenter.add(lblPosition);
			pCenter.add(txtPosition);
			pCenter.setBackground(Color.GREEN);
			
			pEast.add(bEast);
			pEast.setBackground(Color.ORANGE);
			
			pWest.add(bWest);
			pWest.setBackground(Color.PINK);
			
			pSouth.add(bSouth1);
			pSouth.add(bSouth2);
			pSouth.setBackground(Color.LIGHT_GRAY);
			
			add(pNorth, BorderLayout.NORTH);
			add(pCenter, BorderLayout.CENTER);
			add(pEast, BorderLayout.EAST);
			add(pWest, BorderLayout.WEST);
			add(pSouth, BorderLayout.SOUTH);
			
			pack();
			
	}
		
		//Private inner class
		
		private class ButtonHandler implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(e.getSource() == "left"){
					pNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
				}
				
				else if(e.getSource() == "center"){
					pNorth.setLayout(new FlowLayout(FlowLayout.CENTER));
				}
				
				else if(e.getSource() == "right"){
					pNorth.setLayout(new FlowLayout(FlowLayout.RIGHT));
				}
				
				pNorth.validate();
			}
			
			
			
		}
		public static void main(String[] args) {
			
			LayoutManagerTest layoutManagerTest = new LayoutManagerTest();
			layoutManagerTest.setTitle("TESTING LAYOUT MANAGERS");
			layoutManagerTest.setSize(500, 300);
			layoutManagerTest.setVisible(true);


	}
}
