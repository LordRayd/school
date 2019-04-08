package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AddTableDialog;

/**
 * This class is the Listener of the class AddTableDialog
 * Extends ActionListenr
 * @author Gurvan LORANS et Samuel LE BERRE
 * @version 1.0
 */
public class AddTableListener implements ActionListener {

	/**
	 * The AddTableDialog to listen
	 */
	private AddTableDialog dialog;
	
	/**
	 * Constructor of the AddTableListener class
	 * @param dialog The AddTableDialog to listen
	 */
	public AddTableListener(AddTableDialog dialog){
		this.dialog = dialog;
	}
	
	/**
	 * Tell what action to do if Validate or Back from AddTableDialog is pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.dialog.getValidate()){
			
			String sql = new String();
			if(this.dialog.getNameTableTF().getText() != null){
				sql += "CREATE TABLE " + this.dialog.getNameTableTF().getText();
				sql += " (";
				if(this.dialog.getListAttributePanel().length > 0){
					for(int i=0; i< this.dialog.getListAttributePanel().length;i++){
						
						sql += this.dialog.getListAttributePanel()[i].getNameTF().getText();
						sql += " " + this.dialog.getListAttributePanel()[i].getTypeTF().getText();
						
						String type = (String)this.dialog.getListAttributePanel()[i].getConstraint().getSelectedItem();
						if(!type.equals("AUCUN")){
							
							sql += " CONSTRAINT ";
							
							if(type.equals("UNIQUE")){
								
								sql += "uq" + this.dialog.getListAttributePanel()[i].getNameTF().getText();
								sql += " UNIQUE";
								
							}else if(type.equals("NON NUL")){
								
								sql += "nn" + this.dialog.getListAttributePanel()[i].getNameTF().getText();
								sql += " NOT NULL";
								
							}else if(type.equals("CLE PRIMAIRE")){
								
								sql += "pk" + this.dialog.getListAttributePanel()[i].getNameTF().getText();
								sql += " PRIMARY KEY ";
								
							}
						}
						if(i<this.dialog.getListAttributePanel().length-1){
							sql += " , ";
						}
					}
					sql += " );"; 
					this.dialog.getFrame().getDb().getInitJdbc().query(sql);
				}
			}
			this.dialog.dispose();
			this.dialog.getFrame().getLeftPane().getTreeListener().updateTree();
		}
		
		if(e.getSource() == this.dialog.getCommit()){
			this.dialog.addComponentSecond();
		}
	}
}