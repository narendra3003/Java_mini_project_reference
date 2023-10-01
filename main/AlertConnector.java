package main;
import java.sql.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertConnector {
    static Alert a = new Alert(AlertType.NONE);
	// alert function for invalid login
    public static void handle()
	    {
	    	// set alert type
	    	a.setAlertType(AlertType.ERROR);
            // content to show
            a.setContentText("Invalid Login");
	    	// show the dialog
	    	a.show();
	    }
    public static boolean checkLogin1(String name, String pass) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{//to throw basic exceptions
		// connecting database
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Exp_tracker", "root", "oracle");
		Statement stmt = con.createStatement();
		
		// SELECT query
		String q1 = "select password from user WHERE username = '" + name + "';";
		ResultSet rs = stmt.executeQuery(q1);
		if (rs.next())
		{
			if(pass.compareTo(rs.getString("password"))==0){
                System.out.println("Valid login");
				return true;
            }
            else{
                System.out.println("Invalid login");
                handle();
            }
		}
		else
		{
			System.out.println("No such Valid User");
            handle();
		}
		con.close();
		return false;
    }
	public static boolean giveTrans() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{//to throw basic exceptions
		// connecting database
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Exp_tracker", "root", "oracle");
		Statement stmt = con.createStatement();
		
		// SELECT query
		String q1 = "select password from transactions;";
		ResultSet rs = stmt.executeQuery(q1);
		while(rs.next()){
            String type = rs.getString("description");
			String date = rs.getString("date");
			int amt = rs.getInt("amount");
			String categ = rs.getString("Ecategory_id");
            new Transactions(type, amt, categ, date);
		}
		con.close();
		return false;
    }
}
