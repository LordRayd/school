package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LineDialog;

/**
 * This class is the Listener of the class LineDialog
 * @author Gurvan LORANS et Samuel LE BERRE
 * @version 1.0
 */
public class LineDialogListener implements ActionListener {

	/**
	 * The LineDialog object to listen
	 */
	private LineDialog lineDialog;

	/**
	 * Initiate the LineDialogListener
	 * @param lineDialog The object to listen
	 */
	public LineDialogListener(LineDialog lineDialog){
		this.lineDialog = lineDialog;
	}

	/**
	 * This is the implemented method from the ActionListener interface
	 * The action to do if the button validate or back is pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.lineDialog.getValidate()){
			if(this.lineDialog.getTable().isEditing()){
				this.lineDialog.getTable().getCellEditor().stopCellEditing();
			}
			if(this.lineDialog.isAddLine()){
				String sql = "INSERT INTO " + this.lineDialog.getTableName();
				sql += " VALUES( ";
				for(int i=0;i<this.lineDialog.getTable().getModel().getColumnCount();i++){
					sql += "'"+this.lineDialog.getTable().getValueAt(0, i)+"'";
					if(i<this.lineDialog.getTable().getColumnCount()-1){
						sql +=",";
					}
				}
				sql += ");";
				this.lineDialog.getFrame().getDb().getInitJdbc().query(sql);
				this.lineDialog.dispose();
			}else{
				String sql = "DELETE FROM " + this.lineDialog.getTableName();
				sql += " WHERE ";
				String compare = sql;
				for(int i=0; i<this.lineDialog.getTable().getModel().getColumnCount();i++){
					if(this.lineDialog.getTable().getModel().getValueAt(0,i) != null){
						if(sql.compareTo(compare) != 0){
							sql += " AND ";
						}
						sql += this.lineDialog.getTable().getModel().getColumnName(i) + " =  '";
						sql += this.lineDialog.getTable().getModel().getValueAt(0,i) + "' ";
						
					}
				}
				sql += ";";
				this.lineDialog.getFrame().getDb().getInitJdbc().query(sql);
				this.lineDialog.dispose();
			}
		}
		if(e.getSource() == this.lineDialog.getBack()){
			this.lineDialog.dispose();
		}
	}
}