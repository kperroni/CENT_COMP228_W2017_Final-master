package week10;

import java.sql.*;
import javax.swing.table.AbstractTableModel;

public class ResultSetTableModel extends AbstractTableModel{

	//Variables
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private int numberOfRows;
	
	private boolean connectedToDatabase;
	
	//Constructor
	public ResultSetTableModel(String driver, String url, String username, String password, String query)
	   throws SQLException, ClassNotFoundException 
	{
		//Driver
		Class.forName(driver);
		
		connection = DriverManager.getConnection(url, username, password);
		
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		connectedToDatabase = true;
		
		setQuery(query);
		
	}
	
	public Class getColumnClass(int column) throws IllegalStateException{
		
		if(!connectedToDatabase){
			throw new IllegalStateException("Not connected to database");
		}
		
		try{
			String className = metaData.getColumnName(column + 1);
			
			return Class.forName(className);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return Object.class;
	}
	
	
	@Override
	public int getColumnCount() throws IllegalStateException {
		// TODO Auto-generated method stub
		if(!connectedToDatabase){
			throw new IllegalStateException("Not connected to the database");
		}
		
		try{
			return metaData.getColumnCount();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return 0; //Return 0 for number of columns
	}
	
	public String getColumnName(int column) throws IllegalStateException{
		
		if(!connectedToDatabase){
			throw new IllegalStateException("Not connected to the database");
		}
		
		try{
			return metaData.getColumnName(column + 1);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		 return ""; //Returns an empty string if problem occurs and connected to DB
	}
	
	@Override
	public int getRowCount() throws IllegalStateException {
		// TODO Auto-generated method stub
		if(!connectedToDatabase){
			throw new IllegalStateException("Not connected to the database");
		}
		
		return numberOfRows;
	}
	@Override
	public Object getValueAt(int row, int column) throws IllegalStateException {
		// TODO Auto-generated method stub
		if(!connectedToDatabase){
			throw new IllegalStateException("Not connected to the database");
		}
		
		try{
			resultSet.absolute(row + 1);
			resultSet.getObject(column + 1);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return "";
	}
	

	public void setQuery(String query) throws SQLException, IllegalStateException {
		// TODO Auto-generated method stub
		
		if(!connectedToDatabase){
			throw new IllegalStateException("Not connected to the database");
		}
		
		resultSet = statement.executeQuery(query);
		metaData = resultSet.getMetaData(); //Gets meta data of result set (Column numbers, names, rows...)
		
		//Obtain the number of rows in the resultSet
		resultSet.last();
		numberOfRows = resultSet.getRow();
		
		//"Refresh"
		fireTableDataChanged();
	}
	
	public void disconnectFromDatabase(){
		
		if(connectedToDatabase){
		  try{
			  resultSet.close();
			  statement.close();
			  connection.close();
		  }catch(SQLException e){
			  e.printStackTrace();
		  }
		  finally{
			  connectedToDatabase = false;
		  }
		}
	}

}
