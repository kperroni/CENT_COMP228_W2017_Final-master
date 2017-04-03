package week10;

import java.sql.*;

public class PreparedStatementTest {

	private PreparedStatement pst;
	private Connection conn;
	
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;";
	private static final String USERNAME = "test";
	private static final String PASSWORD = "12345";
	
	public PreparedStatementTest(){
	
		try{
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			pst = conn.prepareStatement("INSERT INTO [dbo].[Product] (Product_ID, Producto_Name, Product_Description) VALUES (?, ?, ?)");
			pst.setInt(1, 4); //Sets 1st value to an integer
			pst.setString(2, "XBOX One"); //Sets 2nd value to a string
			pst.setString(3, "Manufactured by Microsoft"); //Sets 3rd value to a string
			
			int rowCount = pst.executeUpdate(); //Execute prepared statement
			
		}catch(SQLException e){
			
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			
			e.printStackTrace();
		}
		finally{
			System.out.println("Done!");
			
			if(pst != null){
				try{
					pst.close();
				}catch(Exception e) {}
			}
			if(conn != null){
				try{
					conn.close();
				}catch(Exception e) {}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
