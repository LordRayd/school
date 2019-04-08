package view;

import javax.swing.JScrollPane;

/**
 * 
 * @author Gurvan LORANS et Samuel LE BERRE
 * @version 1.0
 */
public class JScrollPaneToSave extends JScrollPane {

	/**
	 * This String is the savePath of the Tab
	 */
	private String savePath;

	/**
	 * The getter for the SavePath
	 * @return The path
	 */
	public String getSavePath(){
		return this.savePath;
	}
	
	/**
	 * The setter to change the SavePath
	 * @param savePath The new SavePath
	 */
	public void setSavePath(String savePath){
		if(savePath != null){
			this.savePath = savePath;
		}
	}
}