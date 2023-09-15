
//connection basic code
/*data insertion basic */
import java.sql.*;//importing sql jar file
public class dbcBasic{
    //connection variables specific for a DB and password
    static Connection connection = null;
    static String databaseName ="Expensedb";
    static String url = "jdbc:mysql://localhost:3306/"+ databaseName;
    static String username = "root";
    static String password = "oracle";
    
    
    public static void checkLogin(String name, String pass) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{//to throw basic exceptions
        Class.forName("com.mysql.jdbc.Driver").newInstance(); //making instance of the class
        connection=DriverManager.getConnection(url, username, password); //Connecting the SQL server
        PreparedStatement p = connection.prepareStatement("select password from loginTable;");
        ResultSet rs = p.executeQuery();
        System.out.println(rs.getString("password"));
        
        
        while(rs.next()){
            String oldPass = rs.getString("Name");
            if(oldPass==pass){
               System.out.println("correct login");
            }
            else{
                System.out.println("invalid login");
            }
        }
    }
    public static void instrting() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{//to throw basic exceptions
        Class.forName("com.mysql.jdbc.Driver").newInstance(); //making instance of the class
        connection=DriverManager.getConnection(url, username, password); //Connecting the SQL server
        PreparedStatement ps = connection.prepareStatement("insert into Expenses values(105, 'laptop', 70000);");//basic statement to be run on the SQL server
        int status = ps.executeUpdate();//to execute that statement
        if(status!=0){ //if error occured in statement execution then status will be 0
            //thus executed only when the statement executed
            System.out.println("database was connected");
            System.out.println("record was inserted");
        }
    }
    // public static void main(String[] args) {
    //     launch(args);
    // }
}
