package model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class connect to the DataBase and have the attributes for
 * Table, View and Trigger
 * @author Gurvan LORANS and Samuel LE BERRE
 * @version 1.0
 */
public class InitJDBC {

	//=====================================================================================================================
	//=============================================== BEGIN DECLARATION ===================================================
	/**
	 * This string correspond to the name of the DataBase
	 */
	private String db_Name = "jdbc:sqlite:DataBase";
	/**
	 * This attribute will make the connection to the DB
	 */
	private Connection connection;
	/**
	 * This attribute is the Table class
	 */
	private Table table;
	/**
	 * This attribute is the View class
	 */
	private View view;
	/**
	 * This attribute is the Trigger class
	 */
	private Trigger trigger;
	//================================================= END DECLARATION ===================================================
	//=====================================================================================================================

	/**
	 * This method will connect user to the DB without send any query
	 * @param dbName the name of the DataBase
	 */
	public InitJDBC(String dbName){
		this.db_Name = "jdbc:sqlite:" +dbName;
		this.table = new Table(this);
		this.view = new View(this);
		this.trigger = new Trigger(this);
		this.connectDriver();
		this.connectionDB(this.getDb_Name());
	}




	//=====================================================================================================================
	//================================================= BEGIN DATABASE ====================================================
	/**
	 * This method will connect the driver JDBC
	 */
	public void connectDriver(){

		try {
			Class.forName("org.sqlite.JDBC");
		} catch(ClassNotFoundException e){
			e.printStackTrace();
			return;
		}
	}

	/**
	 * This method connect the user to the DataBase
	 * @param db_name the name of the db
	 */
	public void connectionDB(String db_name){
		try (Connection con = DriverManager.getConnection(db_name)) {
			if (con == null) {
				DatabaseMetaData meta = con.getMetaData();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		try {
			this.connection = DriverManager.getConnection(db_name);
		} catch(SQLException e){
			e.printStackTrace();
			return;
		}
	}
	//=================================================== END DATABASE ====================================================
	//=====================================================================================================================


	//=====================================================================================================================
	//=================================================== BEGIN QUERY =====================================================

	/**
	 *
	 * This method will permit to send query
	 * some queries need result (SELECT QUERIES) and some other queries doesn't need result
	 * then this method will serve as a filter to start the correct method according to the result
	 * @param query The Query to send to the database
	 * @return The result if there is one
	 */
	public String[] query(String query){
		String[] res = new String[2];
		res[0] = new String();
		res[1] = new String();
		if(query != null){
			String typeQuery = query.substring(0,query.indexOf(' ')).toUpperCase();
			query = query.toUpperCase();
			if(typeQuery.equals("SELECT")){
				res = resultQuery(query);
			}else {
				noResultQuery(query);
			}
		}
		return res;
	}

	/**
	 * This method will serve for queries that doesn't need result,
	 * for example : CREATE [TABLE|VIEW|TRIGGER]
	 * @param query The Query to send to the database
	 */
	public void noResultQuery(String query){
		Statement stmt = null;
		try{
			stmt = this.getConnection().createStatement();
			stmt.executeUpdate(query);
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try { if (stmt != null) stmt.close(); } catch (Exception e) {e.printStackTrace();};
		}
	}

	/**
	 * This method will be used for queries that needs result
	 * @param query The query to send to the database
	 * @return A String Array with at the 0 index the name of the table concerned and in at the 1 index the query
	 */
	public String[] resultQuery(String query){
		String[] res = new String[2];
		Statement st = null;
		ResultSet rsResultQuery = null;
		ResultSetMetaData rsmd = null;
		String tableName = query.substring(query.indexOf("FROM ")+5, query.length()).toUpperCase();
		char[] caracString = tableName.toCharArray();
		int j = 0;
		boolean trouve = false;
		while(!trouve && j < caracString.length){
			if(!Character.isLetterOrDigit(caracString[j])){
				trouve = true;
			}
			j++;
		}
		tableName = tableName.substring(0, j-1);
		res[0] = tableName;

		try{
			st = this.getConnection().createStatement();
			rsResultQuery = st.executeQuery(query);
			rsmd = rsResultQuery.getMetaData();
			String result = new String();
			for (int i =1; i <= rsmd.getColumnCount(); i++){
				result = result +rsmd.getColumnLabel(i)+"		";
			}
			result += "\n";
			while (rsResultQuery.next()) {
				for (int i =1; i <= rsmd.getColumnCount(); i++){
					result += rsResultQuery.getString(i)+"		";
				}
				result = result +"\n";
			}
			res[1] = result;
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try { if (rsResultQuery != null) rsResultQuery.close(); } catch (Exception e) {e.printStackTrace();};
			try { if (st != null) st.close(); } catch (Exception e) {e.printStackTrace();};
		}

		return res;
	}
	//=================================================== END QUERY =======================================================
	//=====================================================================================================================


	//=====================================================================================================================
	//============================================== BEGIN GETTERS SETTERS ================================================
	/**
	 * Get the name of the DataBase
	 * @return The name of the DataBase
	 */
	public String getDb_Name() {
		return db_Name;
	}
	/**
	 * Get the Connection object
	 * @return The connection object
	 */
	public Connection getConnection() {
		return connection;
	}
	/**
	 * Get the Table
	 * @return The Table
	 */
	public Table getTable() {
		return table;
	}
	/**
	 * Get the View
	 * @return the View
	 */
	public View getView() {
		return view;
	}
	/**
	 * Get the Trigger
	 * @return The Trigger
	 */
	public Trigger getTrigger() {
		return trigger;
	}
	//================================================ END GETTERS SETTERS ================================================
	//=====================================================================================================================
}