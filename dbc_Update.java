// Java program to illustrate
// updating the Database
import java.sql.*;

public class dbc_Update
{
	public static void updateTable(String newId, String newName, String newAmt){
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Expensedb", "root", "oracle");
			Statement stmt = con.createStatement();
		
			// Updating database
			String q1 = "UPDATE expenses set Name = '" +newName+ "', amt = '"+ newAmt+"' WHERE idExpenses = '" + newId + "';"  ;
			int x = stmt.executeUpdate(q1);
			
			if (x > 0)		
				System.out.println("Expenses Updated");		
			else		
				System.out.println("ERROR OCCURRED :(");
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String args[])
	{
		updateTable("103","Fan", "15000");
	}
}
