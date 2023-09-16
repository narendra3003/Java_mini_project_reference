// Java program to illustrate
// selecting from Database
import java.sql.*;

public class dbc_Select
{
	public static void PrintSelected(String id){
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Expensedb", "root", "oracle");
			Statement stmt = con.createStatement();
			
			// SELECT query
			String q1 = "select * from expenses WHERE idexpenses = '" + id + "';";
			// String q1 = "select * from userid WHERE id = '" + id +
			// 						"' AND pwd = '" + pwd + "'";
			ResultSet rs = stmt.executeQuery(q1);
			if (rs.next())
			{
				System.out.println("Expense -Id : " + rs.getString(1));
				System.out.println("Name :" + rs.getString(2));
				System.out.println("Amount :" + rs.getString(3));
			}
			else
			{
				System.out.println("No such user id is already registered");
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String args[])
	{
		PrintSelected("102");
	}
		
}

