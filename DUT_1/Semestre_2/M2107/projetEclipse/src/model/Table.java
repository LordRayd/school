package model;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class posses all the interaction with a Table
 * from a DataBase
 * @author Gurvan LORANS et Samuel LE BERRE
 * @version 1.0
 */
public class Table {

	/**
	 * This is the JDBC class that connect the user to the DB
	 */
	private InitJDBC initJdbc;

	/**
	 * This is the constructor, it only initialize the initJdbc attribute
	 * @param initJdbc The initJdbc object
	 */
	public Table(InitJDBC initJdbc){
		this.initJdbc = initJdbc;
	}
	
	/**
	 * /**
	 * This method will remove a Table from the DataBase
	 * @param nameTable The name of the table to remove
	 */
	public void removeTable(String nameTable){
		Statement stmt = null;
		try{
			stmt = this.initJdbc.getConnection().createStatement();
			String sql = "DROP TABLE " + nameTable+";"; 
			sql = sql.toUpperCase();
			stmt.executeUpdate(sql);
		} catch(Exception e){
			e.printStackTrace();
			//		}finally {
			//			try { if (stmt != null) stmt.close(); } catch (Exception e) {e.printStackTrace();};
		}
	}

	/**
	 * This method will return a Table into an HashMap of String for key and ResultSet for value
	 * @param nameTable The name of the table to convert 
	 * @return A HashMap with the query to select * from the table and the Result of this query
	 */
	public HashMap<String, ResultSet> returnTable(String nameTable){
		String key = new String();
		ResultSet rsReturnTable = null;
		HashMap<String, ResultSet> res = new HashMap<String, ResultSet>();
		Statement stmt = null;
		try{
			stmt = this.initJdbc.getConnection().createStatement();
			String sql = "SELECT * FROM "+nameTable+";"; 
			key = sql;
			rsReturnTable = stmt.executeQuery(sql);
			res.put(key, rsReturnTable);
		} catch(SQLException e){
			e.printStackTrace();
			//		}finally {
			//			try { if (stmt != null) stmt.close(); } catch (Exception e) {e.printStackTrace();};
			//			try { if (rsReturnTable != null) rsReturnTable.close(); } catch (Exception e) {e.printStackTrace();};
		}
		return res;
	}

	/**
	 * This method will return the names of the Tables into an ArrayList of String
	 * @return the Name of the Tables in the DataBase
	 */
	public ArrayList<String> getTableName(){
		ArrayList<String> listofTable = new ArrayList<String>();
		ResultSet rsGetTableName = null;
		try{
			DatabaseMetaData md = this.initJdbc.getConnection().getMetaData();
			rsGetTableName = md.getTables(null, null, "%", null);
			while (rsGetTableName.next()) {
				if (rsGetTableName.getString(4).equalsIgnoreCase("TABLE")) {
					listofTable.add(rsGetTableName.getString(3));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try { if (rsGetTableName != null) rsGetTableName.close(); } catch (Exception e) {e.printStackTrace();};
		}
		return listofTable;
	}

	/**
	 * This method will return the number of Table in the DataBase
	 * @return The Number of Table in the DataBase (integer)
	 */
	public int numberOfTable(){
		ArrayList<String> listofTable = this.getTableName();
		return listofTable.size();
	}

	/**
	 * This method will return the number of Column in a Table
	 * @param nameTable the name of the Table to analyze
	 * @return the number of Column (attribute) of a Table in the DB
	 */
	public int numberOfColumn(String nameTable){
		int nbColumn = 0;
		ArrayList<String> arr = this.tableToArrayList(nameTable);
		nbColumn = Integer.parseInt(arr.get(1));
		return nbColumn;
	}

	/**
	 * This method will return the Name of the column 
	 * @param nameTable The Name of the table to analyze
	 * @return A String array with all the column name
	 */
	public String[] getColumnName(String nameTable){
		String[] listOfColumns = new String[this.numberOfColumn(nameTable)];
		ArrayList<String> arr = this.tableToArrayList(nameTable);
		for(int j = 2; j <= Integer.parseInt(arr.get(1))+1 ; j++){
			listOfColumns[j-2] = arr.get(j);
		}
		return listOfColumns;
	}

	/**
	 * This method will return the number of Tuples of a Table
	 * @param nameTable the name of the Table to analyze
	 * @return the number of TUple (row) for the table 
	 */
	public int nbTuples(String nameTable){
		int nbTuples = 0;
		ResultSet rsNbTuples = null;
		Statement st = null;
		try{
			st = this.initJdbc.getConnection().createStatement();
			rsNbTuples = st.executeQuery("SELECT * FROM " + nameTable+";");		
			while (rsNbTuples.next()) {
				nbTuples = rsNbTuples.getRow();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try { if (st != null) st.close(); } catch (Exception e) {e.printStackTrace();};
			try { if (rsNbTuples != null) rsNbTuples.close(); } catch (Exception e) {e.printStackTrace();};
		}
		return nbTuples;
	}

	/**
	 * Return the Table into an ArrayList
	 * @param nameTable the name of the Table
	 * @return the ArrayList that contains the Table
	 */
	public ArrayList<String> tableToArrayList(String nameTable){
		HashMap<String,ResultSet> map =returnTable(nameTable); 
		String key = map.keySet().toArray(new String[1])[0];
		ResultSet rsTableToArrayList = map.get(key);
		ArrayList<String> ret = new ArrayList<String>();
		try{
			ResultSetMetaData rsmd = rsTableToArrayList.getMetaData();

			ret.add(rsmd.getTableName(1));
			ret.add(String.valueOf(rsmd.getColumnCount()));

			for(int i = 1; i <= rsmd.getColumnCount(); i++){
				ret.add(rsmd.getColumnLabel(i));
			}

			while(rsTableToArrayList.next() != false){
				for(int i = 1; i <= rsmd.getColumnCount(); i++){
					ret.add(rsTableToArrayList.getString(i));
				}
			}
		} catch(SQLException e){
			e.printStackTrace();
		}finally {
			try { if (rsTableToArrayList != null) rsTableToArrayList.close(); } catch (Exception e) {e.printStackTrace();};
		}
		return ret;
	}

	/**
	 * This method will remove a column in a JTable
	 * @param tableName the table where the column have to been remove
	 * @param columnName the name of the column to remove
	 */
	public void removeColumn(String tableName, String columnName){
		if(this.numberOfColumn(tableName)>1){
			
			String[] listColumn = this.getColumnName(tableName);
			String columnToCopy = new String();
			boolean elementFind = false;
			int j =0;
			while(j<listColumn.length-1 && !elementFind){
				if(listColumn[j].equals(columnName)){
					elementFind = true;
				}
				j++;
			}
			for(int i=j-1;i<listColumn.length-1;i++){
				if(listColumn[i+1].equals(columnName) == false){
					listColumn[i] = listColumn[i+1];
				}
			}
			for(int i=0;i<listColumn.length-1;i++){
				columnToCopy += listColumn[i];
				if(i<listColumn.length-2){
					columnToCopy += ",";				
				}
			}
			String sqlTable = new String();
			ResultSet rsRemoveColumn = null;
			Statement st = null;
			try{
				st = this.initJdbc.getConnection().createStatement();
				rsRemoveColumn = st.executeQuery("SELECT sql FROM sqlite_master WHERE type = 'table' AND name='"+tableName+"';");
				sqlTable += rsRemoveColumn.getString(1);
			}catch(SQLException e){
				e.printStackTrace();
			}finally {
				try { if (st != null) st.close(); } catch (Exception e) {e.printStackTrace();};
				try { if (rsRemoveColumn != null) rsRemoveColumn.close(); } catch (Exception e) {e.printStackTrace();};
			}

			int index = sqlTable.indexOf('(');
			sqlTable = sqlTable.substring(index+1);
			index = sqlTable.lastIndexOf(')');
			sqlTable = sqlTable.substring(0,index);

			String beforeColumn = new String();
			String afterColumn = new String();
			String attributs = new String();
			index = sqlTable.indexOf(columnName);

			if(index > 0){
				beforeColumn = sqlTable.substring(0, index-1);
			}else{
				beforeColumn = sqlTable.substring(0, index);
			}
			afterColumn = sqlTable.substring(index);

			index = afterColumn.indexOf(',');
			if(index == -1){
				afterColumn = new String();
			}else{
				afterColumn = afterColumn.substring(index+1);
			}
			if(afterColumn.equals(new String())){
				index = beforeColumn.lastIndexOf(',');
				attributs = beforeColumn.substring(0, index);
			}else{
				attributs = beforeColumn + afterColumn;
			}

			String query = "BEGIN TRANSACTION;";
			query += " CREATE TABLE "+ tableName +"_new (" + attributs + ");";
			query += " INSERT INTO " + tableName + "_new SELECT " + columnToCopy + " FROM " + tableName +";";
			query += " DROP TABLE " + tableName + ";";
			query += " ALTER TABLE " + tableName +"_new RENAME TO " + tableName + ";";
			query += " COMMIT;";
			this.initJdbc.query(query);
			this.initJdbc.getView().remakeView(tableName,columnName);
			this.initJdbc.getTrigger().remakeTrigger(tableName);
		}
	}
	
	/**
	 * This method will add a column into a Table
	 * @param tableName The table where we want to add a column 
	 * @param columnCode The name of the Column
	 * @param defaultValue The value to put in the new column
	 */
	public void addColumn(String tableName,String columnCode,String defaultValue){
		String[] listColumn = this.getColumnName(tableName);
		String columnToCopy = new String();

		for(int i=0;i<listColumn.length;i++){
			columnToCopy += listColumn[i];
			if(i<listColumn.length-1){
				columnToCopy += ",";				
			}
		}
		
		String sqlTable = new String();
		ResultSet rsRemoveColumn = null;
		Statement st = null;
		try{
			st = this.initJdbc.getConnection().createStatement();
			rsRemoveColumn = st.executeQuery("SELECT sql FROM sqlite_master WHERE type = 'table' AND name='"+tableName+"';");
			sqlTable += rsRemoveColumn.getString(1);
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try { if (st != null) st.close(); } catch (Exception e) {e.printStackTrace();};
			try { if (rsRemoveColumn != null) rsRemoveColumn.close(); } catch (Exception e) {e.printStackTrace();};
		}
		
		int index = sqlTable.lastIndexOf('(');
		sqlTable = sqlTable.substring(index+1);
		System.out.println(sqlTable);
		
		index = sqlTable.lastIndexOf(')');
		sqlTable = sqlTable.substring(0, index);
		System.out.println(sqlTable);
		
		sqlTable += " , " + columnCode;
		
		String query = "BEGIN TRANSACTION;";
		query += " CREATE TABLE "+ tableName +"_new (" + sqlTable + ");";
		query += " INSERT INTO " + tableName + "_new SELECT " + columnToCopy + "," + defaultValue + " FROM " + tableName +";";
		query += " DROP TABLE " + tableName + ";";
		query += " ALTER TABLE " + tableName + "_new RENAME TO " + tableName + ";";
		query += " COMMIT;";
		this.initJdbc.query(query);
	}
}