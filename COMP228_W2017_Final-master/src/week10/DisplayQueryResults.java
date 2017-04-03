package week10;

import java.awt.*;
import java.awt.event.*;

import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;

import javax.swing.*;
import javax.swing.table.*;

public class DisplayQueryResults extends JFrame{

	public static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;databaseName=AdventureWorks2014";
	public static final String USERNAME = "user=test";
	public static final String PASSWORD = "password=12345";
	 
	//Default query to retrieve information
	public static final String DEFAULT_QUERY = "SELECT * FROM Person.Person";
	
	private ResultSetTableModel tableModel;
	private JTextArea queryArea;
	
	public DisplayQueryResults(){
		super("Displaying query results");
		
		try{
			
			tableModel = new ResultSetTableModel(DRIVER, DATABASE_URL, USERNAME, PASSWORD, DEFAULT_QUERY);
			
			//Instantiate queryArea
			queryArea = new JTextArea(DEFAULT_QUERY, 3, 100);
			queryArea.setWrapStyleWord(true);
			queryArea.setLineWrap(true);
			
			JScrollPane scrollPane = new JScrollPane(queryArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			JButton submitButton = new JButton("Submit Query");
			
			//Create Box to manage placement of queryArea and submitButton in GUI
			Box boxNorth = Box.createHorizontalBox();
			boxNorth.add(scrollPane);
			boxNorth.add(submitButton);
			
			//Create JTable to represent row and column data (2D data)
			JTable resultTable = new JTable(tableModel);
			
			JLabel filterLabel = new JLabel("Filter:");
			JTextField filterText = new JTextField();
			JButton filterButton = new JButton("Apply Filter");
			Box boxSouth = boxNorth.createHorizontalBox();
			
			boxSouth.add(filterLabel);
			boxSouth.add(filterText);
			boxSouth.add(filterButton);
			
			add(boxNorth, BorderLayout.NORTH);
			add(new JScrollPane(resultTable), BorderLayout.CENTER);
			add(boxSouth, BorderLayout.SOUTH);
			
			
			//Anonymous inner class for Submit button
			submitButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try{
						tableModel.setQuery(queryArea.getText());
					}catch(SQLException ex){
						JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
						
						tableModel.disconnectFromDatabase();
						
						System.exit(1);
					}
				}
				
			});
			
			TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
			resultTable.setRowSorter(sorter);
			
			filterButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String text = filterText.getText();
					if(text.length() == 0){
						sorter.setRowFilter(null);
					}
					
					else{
						try{
							sorter.setRowFilter(RowFilter.regexFilter(text));
						}catch(PatternSyntaxException pse){
							JOptionPane.showMessageDialog(null, "Bad regex pattern", "Bad regex pattern", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				
			});
			
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
			tableModel.disconnectFromDatabase();
			System.exit(1);
		}
		catch(ClassNotFoundException e){
			JOptionPane.showMessageDialog(null, "Database Driver Not Found", "Driver Not Found", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		
		//Set window properties
		setSize(500, 250);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosed(WindowEvent e){
				tableModel.disconnectFromDatabase();
				System.exit(0);
			}
			
		});
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DisplayQueryResults();

	}

}
