// Java program to illustrate
// deleting from Database
import java.sql.*;

public class Z_Delete
{
	public static void deleteExpense(String id){
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Expensedb", "root", "oracle");
			Statement stmt = con.createStatement();
				
			// Deleting from database
			String q1 = "DELETE from expenses WHERE idexpenses = '" + id +"';";
			int x = stmt.executeUpdate(q1);
			
			if (x > 0)		
				System.out.println("One Expense Successfully Deleted");		
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
		deleteExpense("101");
	}
}
