import java.sql.*;

public class OracleJDBCExample {

	static final String DB_NAME = "jdbc:oracle:thin:@ora12c.univ-ubs.fr:1521:ORAETUD";
	static final String USER = "e1604902";
	static final String PASSWORD = "Apache56";

    public static void main(String[] args) {

        System.out.println("\n-------- Oracle JDBC Connection Testing ------");

        try {
            
            Class.forName("org.sqlite.JDBC");
            
        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Sqlite Driver?");
            e.printStackTrace();
            return;

        }

        System.out.println("Oracle JDBC Driver Registered!");

        String url = "jdbc:sqlite:Test";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("A new database has been created.");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
