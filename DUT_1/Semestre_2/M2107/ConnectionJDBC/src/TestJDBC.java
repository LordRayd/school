import java.sql.*;

public class TestJDBC {
    
    public static void main(String[] args){
		try {
			
            Class.forName("org.sqlite.JDBC");
			
        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Oracle sqlite Driver?");
            e.printStackTrace();
            return;

        }
        
        System.out.println("Oracle JDBC Driver Registered!");

        String url = "jdbc:sqlite:Test";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
}
