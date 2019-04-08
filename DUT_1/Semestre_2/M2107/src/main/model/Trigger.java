package model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * This class posses all the interaction with a Trigger
 * from a DataBase
 * @author Gurvan LORANS et Samuel LE BERRE
 * @version 1.0
 */
public class Trigger {

	/**
	 * This is the class to make many actions on the DataBase
	 */
	private InitJDBC initJdbc;

	/**
	 * This is the constructor, it needs the initJDBC 
	 * @param initJdbc this is the class that permit to make many actions on the DataBase
	 */
	public Trigger(InitJDBC initJdbc){
		this.initJdbc = initJdbc;
	}
	
	/**
	 * This is the method to remove a Trigger from the DataBase
	 * @param triggerName The name of the Trigger to remove
	 */
	public void removeTrigger(String triggerName){
		Statement stmt = null;
		try{
			stmt = this.initJdbc.getConnection().createStatement();
			String sql = "DROP TRIGGER " + triggerName + ";";
			sql = sql.toUpperCase();
			stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try { if (stmt != null) stmt.close(); } catch (Exception e) {e.printStackTrace();};
		}
	}

	/**
	 * This method return the list of the TriggerName
	 * @return An ArrayList with all the Trigger Name
	 */
	public ArrayList<String> getTriggerName(){
		ArrayList<String> listofTrigger = new ArrayList<String>();
		ResultSet rsGetTriggerName = null;
		Statement st = null;
		try{
			st = this.initJdbc.getConnection().createStatement();
			rsGetTriggerName = st.executeQuery("SELECT name FROM sqlite_master WHERE type = 'trigger';");
			ResultSetMetaData rsmd = rsGetTriggerName.getMetaData();		
			while (rsGetTriggerName.next()) {
				for (int i =1; i <= rsmd.getColumnCount(); i++){
					listofTrigger.add(rsGetTriggerName.getString(i));
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
//		}finally {
//			try { if (st != null) st.close(); } catch (Exception e) {e.printStackTrace();};
//			try { if (rsGetTriggerName != null) rsGetTriggerName.close(); } catch (Exception e) {e.printStackTrace();};
		}
		return listofTrigger;
	}

	/**
	 * This method return the number of trigger into the DataBase
	 * @return The number of Trigger in the DataBase
	 */
	public int numberOfTrigger(){
		return this.getTriggerName().size();
	}

	/**
	 * This method will return the code of the trigger
	 * @param nameTrigger the trigger that we wanted to get the code
	 * @return The creation code SQL of the Trigger
	 */
	public String getCodeTrigger(String nameTrigger){
		String trigger = new String();
		ResultSet rsGetCodeTrigger = null;
		Statement st = null;
		try{
			st = this.initJdbc.getConnection().createStatement();
			rsGetCodeTrigger = st.executeQuery("SELECT sql FROM sqlite_master WHERE type = 'trigger' AND name='"+nameTrigger+"';");
			trigger = rsGetCodeTrigger.getString(1);
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try { if (st != null) st.close(); } catch (Exception e) {e.printStackTrace();};
			try { if (rsGetCodeTrigger != null) rsGetCodeTrigger.close(); } catch (Exception e) {e.printStackTrace();};
		}
		return trigger;
	}
	
	public void remakeTrigger(String nameTable){
		ResultSet rsRemoveView = null;
		Statement st = null;
		for(String nameView : this.getTriggerName()){
			try{
				String sql = new String();
				st = this.initJdbc.getConnection().createStatement();
				rsRemoveView = st.executeQuery("SELECT sql FROM sqlite_master WHERE type = 'trigger' AND name='"+nameView+"';");
				sql += rsRemoveView.getString(1);
				if(sql.toUpperCase().contains("ON " + nameTable.toUpperCase())){
						this.removeTrigger(nameView);
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				try { if (st != null) st.close(); } catch (Exception e) {e.printStackTrace();};
				try { if (rsRemoveView != null) rsRemoveView.close(); } catch (Exception e) {e.printStackTrace();};
			}
		}
	}
}
