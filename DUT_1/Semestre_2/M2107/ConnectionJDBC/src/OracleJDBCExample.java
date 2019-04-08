import java.sql.*;

public class OracleJDBCExample {

	static final String DB_NAME = "jdbc:oracle:thin:@ora12c.univ-ubs.fr:1521:ORAETUD";
	static final String USER = "e1604902";
	static final String PASSWORD = "Apache56";

    public static void main(String[] args) {

        System.out.println("\n-------- Oracle JDBC Connection Testing ------");

        try {
			
            Class.forName("oracle.jdbc.driver.OracleDriver");
			
        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;

        }

        System.out.println("Oracle JDBC Driver Registered!");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(DB_NAME,USER,PASSWORD);
			//~ Connection conn = DriverManager.getConnection
         //~ ("jdbc:oracle:thin:scott/tiger@//myhost:1521/myservicename");
			//~ Connection conn = DriverManager.getConnection
         //~ ("jdbc:oracle:thin:@myhost:1521:orcl", "scott", "tiger");
         
        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }

}
