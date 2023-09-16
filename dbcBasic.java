
//connection basic code
/*data insertion basic */
import java.sql.*;//importing sql jar file
public class dbcBasic{
    //connection variables specific for a DB and password
    // static Connection connection = null;
    // static String databaseName ="Expensedb";
    // static String url = "jdbc:mysql://localhost:3306/"+ databaseName;
    // static String username = "root";
    // static String password = "oracle";
    
    
    public static void checkLogin(String name, String pass) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{//to throw basic exceptions
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Expensedb", "root", "oracle");
			Statement stmt = con.createStatement();
			
			// SELECT query
			String q1 = "select password from loginTable WHERE name = '" + name + "';";
			ResultSet rs = stmt.executeQuery(q1);
			if (rs.next())
			{
				if(pass.compareTo(rs.getString("password"))==0){
                    System.out.println("Valid login");
                }
                else{
                System.out.println("Invalid login");
                }
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
    public static void inserting(String id, String name, String amt) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{//to throw basic exceptions
        Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Expensedb", "root", "oracle");
        PreparedStatement ps = connection.prepareStatement("insert into Expenses values('"+id+"', '"+name+"', '"+amt+"');");
        int status = ps.executeUpdate();//to execute that statement
        if(status!=0){ 
            System.out.println("database was connected");
            System.out.println("record was inserted");
        }
    }
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        inserting("107", "iphone", "150000");
        // checkLogin("Narendra", "2345");
    }
}
