// Java program to illustrate
// deleting from Database
import java.sql.*;

public class Z_Delete
{
	public static void main(String args[])
	{
		String id = "id2";
		String pwd = "pwd2";
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "login1", "pwd1");
			Statement stmt = con.createStatement();
				
			// Deleting from database
			String q1 = "DELETE from userid WHERE id = '" + id +
					"' AND pwd = '" + pwd + "'";
					
			int x = stmt.executeUpdate(q1);
			
			if (x > 0)		
				System.out.println("One User Successfully Deleted");		
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
