
/* select a table */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbc {
    //connection variables specific for a DB and password
    static Connection connection = null;
    static String databaseName ="Expensedb";
    static String url = "jdbc:mysql://localhost:3306/"+ databaseName;
    static String username = "root";
    static String password = "oracle";
    public static void ShowExpenses()  throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver"); //making instance of the class
        connection=DriverManager.getConnection(url, username, password); //Connecting the SQL server
        PreparedStatement p = connection.prepareStatement("select * from Expenses;");
        ResultSet rs = p.executeQuery();
        System.out.println("printing now");
        System.out.println("idexpenses\t\tName\t\tAmt");
        while(rs.next()){
            int id = rs.getInt("idExpenses");
            String name = rs.getString("Name");
            int Amount= rs.getInt("Amt");
            System.out.println(id+"\t\t"+name+"\t\t"+Amount);
        }
    }
    public static void main(String[] args)  throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{//to throw basic exceptions
        ShowExpenses();
    }
}
