package week10;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class ConnectDS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = null;
		CallableStatement csmt = null;
		ResultSet rs = null;

		try {

			SQLServerDataSource ds = new SQLServerDataSource();

			// Setup our datasource properties
			ds.setUser("test");
			ds.setPassword("12345");
			ds.setServerName("localhost");
			ds.setPortNumber(1433);
			ds.setDatabaseName("AdventureWorks2014");

			// Establish connection
			con = ds.getConnection();

			// Execute stored procedure that returns some data

			csmt = con.prepareCall("{call dbo.uspGetEmployeeManagers(?)}");
			csmt.setInt(1, 50);
			rs = csmt.executeQuery();

			// Print result set to the console
			while (rs.next()) {
				System.out.println("EMPLOYEE: " + rs.getString("LastName") + ", " + rs.getString("FirstName"));
				System.out.println(
						"MANAGER: " + rs.getString("ManagerLastName") + ", " + rs.getString("ManagerFirstName"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {

				}
			}
			if (csmt != null) {
				try {
					csmt.close();
				} catch (Exception e) {

				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {

				}
			}
			System.exit(1);

		}
	}

}
