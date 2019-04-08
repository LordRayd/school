package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AddColumnDialog;
import view.GUI;

/**
 * This class is the listener of the AddColumnDialog class
 * Extends ActionListener
 * @author Gurvan LORANS et Samuel LE BERRE
 * @version 1.0
 */
public class AddColumnListener implements ActionListener {

	/**
	 * The GUI of the application
	 */
	private GUI frame;
	/**
	 * The AddColumnDialog to listen
	 */
	private AddColumnDialog dialog;

	/**
	 * Constructor of the addColumnListener class
	 * @param frame The GUI of the application
	 * @param dialog The AddColumnDialog to listen
	 */
	public AddColumnListener(GUI frame , AddColumnDialog dialog){
		this.frame = frame;
		this.dialog = dialog;
	}
	
	/**
	 *Tell the action to do if the Validate button from AddColumnDialog is pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.dialog.getValidate()){
			
			String defaultValue = null ;
			String sql = new String();
			sql += this.dialog.getPanelAttribut().getNameTF().getText();
			sql += " " + this.dialog.getPanelAttribut().getTypeTF().getText();

			String type = (String)this.dialog.getPanelAttribut().getConstraint().getSelectedItem();
			
			if(!type.equals("AUCUN")){
				
				sql += " CONSTRAINT ";
				
				if(type.equals("UNIQUE")){
					
					sql += "uq" + this.dialog.getPanelAttribut().getNameTF().getText();
					sql += " UNIQUE";
					
				}else if(type.equals("NON NUL")){
					
					sql += "nn" + this.dialog.getPanelAttribut().getNameTF().getText();
					sql += " NOT NULL";
					defaultValue = "' '";
					
				}else if(type.equals("CLE PRIMAIRE")){
					
					sql += "pk" + this.dialog.getPanelAttribut().getNameTF().getText();
					sql += " PRIMARY KEY ";
					
				}
			}
			this.frame.getDb().getInitJdbc().getTable().addColumn(this.dialog.getTableName(), sql, defaultValue);
			this.dialog.dispose();
		}
	}
}