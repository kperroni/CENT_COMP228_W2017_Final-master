package week10;

import java.sql.*;

public class ConnectURL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=TestDB;user=test;password=12345";

		Connection con = null; // Holds connection information to the DB
		Statement stmt = null; // Allows us to create SQL statements
		ResultSet rs = null; // Holds the results of a SQL query

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			// We have successfully connected!
			String SQL = "SELECT * FROM [dbo].[order]";
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);

			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString("order_name"));
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			// Closing connection of ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			// Closing connection of Statement
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}
			// Closing connection of Connection
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}
	}

}
