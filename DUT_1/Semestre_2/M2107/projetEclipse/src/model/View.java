package model;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * This class posses all the interaction with a View
 * from a DataBase
 * @author Gurvan LORANS et Samuel LE BERRE
 * @version 1.0
 */
public class View {

	/**
	 * This is the initJdbc class that permit many action on the DataBase
	 */
	private InitJDBC initJdbc;

	/**
	 * This is the constructor, it only initialize the initJdbc attribute
	 * @param initJdbc The initJDBC object who containsthe View class
	 */
	public View(InitJDBC initJdbc){
		this.initJdbc = initJdbc;
	}

	/**
	 * This method will remove a view from the DataBase with its a name 
	 * @param nameView The name of the view to remove
	 */
	public void removeView(String nameView){
		String query = "DROP VIEW " + nameView + ";";
		query = query.toUpperCase();
		this.initJdbc.query(query);
	}

	/**
	 * This method will return an ArrayList of String
	 * @return All the name of view in the DataBase
	 */
	public ArrayList<String> getViewName(){
		ArrayList<String> listofView = new ArrayList<String>();
		ResultSet rsGetViewName = null;
		try{
			DatabaseMetaData md = this.initJdbc.getConnection().getMetaData();
			String[] names = {"VIEW"};
			rsGetViewName = md.getTables(null,"%", null, names);

			while (rsGetViewName.next()) {
				String viewName = rsGetViewName.getString("TABLE_NAME");
				listofView.add(viewName);
			}
		}catch(Exception e){
			e.printStackTrace();
			//		}finally {
			//			try { if (rsGetViewName != null) rsGetViewName.close(); } catch (Exception e) {e.printStackTrace();};
		}
		return listofView;
	}

	/**
	 * This method will return the number of view in the DataBase
	 * @return The number of view in the DataBase
	 */
	public int numberOfView(){
		return this.getViewName().size();
	}

	/**
	 * This method will return the number of column in a View
	 * @param nameView The name of the view to analyze 
	 * @return The Number of column in the view
	 */
	public int numberColumnView(String nameView){
		int nbColumn = 0;
		ArrayList<String> arr = this.initJdbc.getTable().tableToArrayList(nameView);
		nbColumn = Integer.parseInt(arr.get(1));
		return nbColumn;
	}

	/**
	 * This method will return the code of the view
	 * @param nameView The view to analyze
	 * @return The code of the view
	 */
	public String getCodeView(String nameView){
		String view = new String();
		ResultSet rsGetCodeView = null;
		try{
			Statement st = this.initJdbc.getConnection().createStatement();
			rsGetCodeView = st.executeQuery("SELECT sql FROM sqlite_master WHERE type = 'view' AND name='"+nameView+"';");
			view = rsGetCodeView.getString(1);
		}catch(SQLException e){
			e.printStackTrace();
			//		}finally {
			//			try { if (rsGetCodeView != null) rsGetCodeView.close(); } catch (Exception e) {e.printStackTrace();};
		}
		return view;
	}

	/**
	 * This method will remade the view from the DataBase (remove view that depends of the table that will be remove)
	 * @param nameTable The name of the Table which the view depends
	 */
	public void remakeView(String nameTable){
		ResultSet rsRemoveView = null;
		Statement st = null;
		for(String nameView : this.getViewName()){
			try{
				String sql = new String();
				st = this.initJdbc.getConnection().createStatement();
				rsRemoveView = st.executeQuery("SELECT sql FROM sqlite_master WHERE type = 'view' AND name='"+nameView+"';");
				sql += rsRemoveView.getString(1);
				if(sql.toUpperCase().contains("FROM " + nameTable.toUpperCase())){
						this.removeView(nameView);
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				try { if (st != null) st.close(); } catch (Exception e) {e.printStackTrace();};
				try { if (rsRemoveView != null) rsRemoveView.close(); } catch (Exception e) {e.printStackTrace();};
			}
		}
	}

	/**
	 * This method will remade the view from the DataBase (remove view that depends of column that will be remove)
	 * @param nameTable The name of the Table which the view depends
	 * @param columnToRemove The column that we wanted to remove 
	 */
	public void remakeView(String nameTable,String columnToRemove){
		ResultSet rsRemoveView = null;
		Statement st = null;

		for(String nameView : this.getViewName()){
			try{
				String sql = new String();
				st = this.initJdbc.getConnection().createStatement();
				rsRemoveView = st.executeQuery("SELECT sql FROM sqlite_master WHERE type = 'view' AND name='"+nameView+"';");
				sql += rsRemoveView.getString(1);
				if(sql.toUpperCase().contains("FROM " + nameTable.toUpperCase())){
					int index = sql.indexOf("SELECT ");
					sql = sql.substring(index + 7);
					index = sql.indexOf("FROM");
					sql = sql.substring(0, index-1);
					if(sql.toUpperCase().contains(columnToRemove.toUpperCase()) || sql.toUpperCase().contains("*")){
						this.removeView(nameView);
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				try { if (st != null) st.close(); } catch (Exception e) {e.printStackTrace();};
				try { if (rsRemoveView != null) rsRemoveView.close(); } catch (Exception e) {e.printStackTrace();};
			}
		}
	}

	/**
	 * This method will check the Attribute of Table to know if the 
	 * @param nameTable the name of the Table 
	 * @param listColumn the list of column in a Table
	 * @return a boolean true if the view contains a column that the Table contains too
	 */
	public boolean verifAttribut(String nameTable,ArrayList<String> listColumn){
		boolean ret = true;
		for(int i = 0; (i < listColumn.size()) && (ret == true); i++){
			ret = false;
			for(int j=0 ; (j<this.initJdbc.getTable().getColumnName(nameTable).length) && (ret == false); j++){
				if(this.initJdbc.getTable().getColumnName(nameTable)[j].toUpperCase().equals(listColumn.get(i).toUpperCase())){
					ret = true;
				}
			}
		}
		return ret;
	}
}