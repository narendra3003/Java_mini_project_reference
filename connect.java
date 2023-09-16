// Java program to illustrate
// Connecting to the Database
import java.sql.*;

public class connect
{
	public static void main(String args[])
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Expensedb", "root", "oracle");

			if (con != null)			
				System.out.println("Connected");		
			else		
				System.out.println("Not Connected");
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

