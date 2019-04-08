package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.tree.DefaultMutableTreeNode;

import view.AddColumnDialog;
import view.AddTableDialog;
import view.GUI;
import view.JScrollPaneToSave;
import view.LineDialog;
import view.Result;

/**
 * This is the RightPaneListener (the listener for the button on the right side)
 * @author Gurvan LORANS et Samuel LE BERRE
 * @version 1.0
 */
public class RightPaneListener implements ActionListener {

	/**
	 * This is the GUI of the application
	 */
	private GUI frame;

	/**
	 * This is the constructor, it initializes the attributes frame and initJDBC
	 * @param frame the frame where the listener will be put
	 */
	public RightPaneListener(GUI frame){
		this.frame = frame;
	}

	/**
	 * This is the implemented method from the ActionListener interface
	 * it check which element has been clicked and make an action
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		JTabbedPane tabbedPane = this.frame.getTabbedPane();

		if(e.getSource() == this.frame.getRightPane().getNewTable()){
			AddTableDialog addTableDialog = new AddTableDialog(this.frame);
		}

		// Remove Table
		if(e.getSource() == this.frame.getRightPane().getRemoveTable()){

			String[] listOfTable = this.getListTableName();

			String tableName = (String)JOptionPane.showInputDialog(this.frame, "<html>Nom de la Table o&ugrave; cr&eacute;er la colonne :</html>", "Choix de la table",JOptionPane.PLAIN_MESSAGE,null,listOfTable,listOfTable[0]);

			if(tableName != null){

				String sql = "DROP TABLE " + tableName + ";";

				this.frame.getDb().getInitJdbc().query(sql);

				this.frame.getDb().getInitJdbc().getView().remakeView(tableName);

				this.frame.getLeftPane().getTreeListener().updateTree();


				int i = 0;
				while(i < tabbedPane.getTabCount()){
						if(tabbedPane.getTitleAt(i).equals(tableName)){
							tabbedPane.removeTabAt(tabbedPane.indexOfTab(tabbedPane.getTitleAt(i)));
						}
						i++;
				}

			}

		}

		if(e.getSource() == this.frame.getRightPane().getNewColumn()){

			String[] listOfTable = this.getListTableName();

			String tableName = (String)JOptionPane.showInputDialog(this.frame, "<html>Nom de la Table o&ugrave; cr&eacute;er la colonne :</html>", "Choix de la table",JOptionPane.PLAIN_MESSAGE,null,listOfTable,listOfTable[0]);

			if(tableName != null){

				AddColumnDialog taddColumnDialog = new AddColumnDialog(this.frame,tableName);

			}
		}

		if(e.getSource() == this.frame.getRightPane().getRemoveColumn()){

			String[] listOfTable = this.getListTableName();

			String tableName = (String)JOptionPane.showInputDialog(this.frame, "<html>Nom de la Table o&ugrave; supprimer la colonne :</html>", "Choix de la table",JOptionPane.PLAIN_MESSAGE,null,listOfTable,listOfTable[0]);

			if(tableName != null){

				String[] listOfColumns = this.frame.getDb().getInitJdbc().getTable().getColumnName(tableName);

				String columnName = (String)JOptionPane.showInputDialog(this.frame, "<html>Nom de la colonne &agrave; supprimer :</html>", "Choix de la colonne",JOptionPane.PLAIN_MESSAGE,null,listOfColumns,listOfColumns[0]);

				if(columnName != null){

					this.frame.getDb().getInitJdbc().getTable().removeColumn(tableName, columnName);

					this.frame.getLeftPane().getTreeListener().updateTree();

					ArrayList<String> elements = new ArrayList<String>();

					DefaultMutableTreeNode view = this.frame.getLeftPane().getView();
					int nbChildView = view.getChildCount();

					if(nbChildView > 0){
						for (int i = 0; i < nbChildView; i++){
							elements.add(view.getChildAt(i).toString());
						}
					}

					DefaultMutableTreeNode table = this.frame.getLeftPane().getTable();
					int nbChildTable = table.getChildCount();

					if(nbChildTable > 0){
						for (int i = 0; i < nbChildTable; i++){
							elements.add(table.getChildAt(i).toString());
						}
					}

					DefaultMutableTreeNode trigger = this.frame.getLeftPane().getTrigger();
					int nbChildTrigger = trigger.getChildCount();

					if(nbChildTrigger > 0){
						for (int i = 0; i < nbChildTrigger; i++){
							elements.add(trigger.getChildAt(i).toString());
						}
					}

					JScrollPane scrollText = (JScrollPane)tabbedPane.getSelectedComponent();
					int i = 0;
					while(i < tabbedPane.getTabCount()){
						if(!elements.contains(tabbedPane.getTitleAt(i))){
							if(!(tabbedPane.getComponentAt(i) instanceof JScrollPaneToSave)){
								tabbedPane.removeTabAt(tabbedPane.indexOfTab(tabbedPane.getTitleAt(i)));
							}else{
								i++;
							}
						}else{
							if(tabbedPane.getTitleAt(i).equals(tableName)){
								int j = i;
								tabbedPane.removeTabAt(tabbedPane.indexOfTab(tabbedPane.getTitleAt(i)));
								TreeListener treeListener = new TreeListener(this.frame, this.frame.getLeftPane());
								treeListener.makeTable(tableName, j);
							}
							i++;
						}
						tabbedPane.setTabPlacement(1);
					}
				}
			}
		}

		if(e.getSource() == this.frame.getRightPane().getAddLine()){

			String[] listOfTable = this.getListTableName();

			String tableName = (String)JOptionPane.showInputDialog(this.frame, "Nom de la Table o&ugrave; inserer la ligne :", "Choix de la table",JOptionPane.PLAIN_MESSAGE,null,listOfTable,listOfTable[0]);

			if(tableName != null){

				LineDialog dialog = new LineDialog(this.frame,tableName,true);
			}
		}

		if(e.getSource() == this.frame.getRightPane().getRemoveLine()){

			String[] listOfTable = this.getListTableName();

			String tableName = (String)JOptionPane.showInputDialog(this.frame, "<html>Nom de la Table o&ugrave; supprimer la ligne :</html>", "Choix de la table",JOptionPane.PLAIN_MESSAGE,null,listOfTable,listOfTable[0]);

			if(tableName != null){

				LineDialog dialog = new LineDialog(this.frame,tableName,false);
			}
		}

		if(e.getSource() == this.frame.getRightPane().getRun()){
			if(tabbedPane.getSelectedComponent() instanceof JScrollPaneToSave){
				JScrollPaneToSave scrollText = (JScrollPaneToSave)tabbedPane.getSelectedComponent();
				if(scrollText.getViewport().getView() instanceof JTextPane){
					JTextPane textPane = (JTextPane) scrollText.getViewport().getView();
					if(textPane.getText() != null){
						String query = textPane.getText();
						String[] selectQuery = this.frame.getDb().getInitJdbc().query(query);
						Result resultat = new Result(frame);
						resultat.getTextPane().setText(query);
						resultat.getTextPane().setText(resultat.getTextPane().getText().toUpperCase()+selectQuery[0]+"\n"+selectQuery[1]);
						this.frame.getLeftPane().getTreeListener().updateTree();
					}
				}
			}
		}
	}

	/**
	 * Get the tables names
	 * @return The list of name of the table
	 */
	public String[] getListTableName(){
		String [] listOfTable = new String[this.frame.getDb().getInitJdbc().getTable().numberOfTable()];
		int i = 0;
		for(String s : this.frame.getDb().getInitJdbc().getTable().getTableName()){
			listOfTable[i] = s;
			i++;
		}
		return listOfTable;
	}
}
