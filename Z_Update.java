// Java program to illustrate
// updating the Database
import java.sql.*;

public class Z_Update
{
	public static void main(String args[])
	{
		String id = "id1";
		String pwd = "pwd1";
		String newPwd = "newpwd";
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "login1", "pwd1");
			Statement stmt = con.createStatement();
		
			// Updating database
			String q1 = "UPDATE userid set pwd = '" + newPwd +
					"' WHERE id = '" +id+ "' AND pwd = '" + pwd + "'";
			int x = stmt.executeUpdate(q1);
			
			if (x > 0)		
				System.out.println("Password Successfully Updated");		
			else		
				System.out.println("ERROR OCCURRED :(");
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
