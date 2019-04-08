package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import model.InitJDBC;
import view.ButtonTab;
import view.GUI;
import view.LeftPane;
/**
 * This method will be the Listener for the JTree (on the left of the GUI) it
 * extends MouseAdapter Class
 * @author Gurvan LORANS et Samuel LE BERRE
 * @version 1.0
 */
public class TreeListener extends MouseAdapter{

	/**
	 * This is the GUI of the application
	 */
	private GUI frame;
	/**
	 * This is the LeftPane of the GUI (JTree)
	 */
	private LeftPane pane;
	/**
	 * This is the model class InitJDBC that permit many things with the
	 * DataBase
	 */
	private InitJDBC db;

	/**
	 * This is the constructor of this class, it needs the GUI to initialize all
	 * the others attributes
	 * @param frame The GUI of the Application
	 * @param pane The LeftPane of the GUI
	 */
	public TreeListener(GUI frame, LeftPane pane){
		this.frame = frame;
		this.pane = pane;
		this.db = this.frame.getDb().getInitJdbc();
		this.updateTree();
	}

	/**
	 * This is the method extended from the MouseAdapter It will check if the
	 * user has Double-Clicked on an element and it will open a new Tab with
	 * information about this element if its an leaf
	 */
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			String nameOfObject = this.getPane().getTree().getLastSelectedPathComponent().toString();
			if(this.tabAlreadyIn(nameOfObject, this.getFrame().getTabbedPane()) == false ){
				if(this.db.getTable().getTableName().contains(nameOfObject)){
					this.makeTable(nameOfObject);
				}
				if(this.db.getView().getViewName().contains(nameOfObject)){
					this.makeView(nameOfObject);
				}
				if(this.db.getTrigger().getTriggerName().contains(nameOfObject)){
					this.makeTrigger(nameOfObject);
				}
			}
		}
	}

	/**
	 * This is the method that will make a new Tab when Table element are double
	 * clicked
	 * @param nameOfObject The name of the object that has been clicked
	 */
	public void makeTable(String nameOfObject){
		JScrollPane scrollPane = new JScrollPane();
		JPanel pane = new JPanel();
		scrollPane.setViewportView(pane);

		pane.setLayout(new BorderLayout());
		Vector<String> columnNames = new Vector<String>();
		ArrayList<String> arr = this.db.getTable().tableToArrayList(nameOfObject);

		for (int i = 2; i <= Integer.parseInt(arr.get(1)) + 1; i++) {
			columnNames.add(arr.get(i));
		}

		DefaultTableModel model = new DefaultTableModel(columnNames, this.db.getTable().nbTuples(nameOfObject));
		JTable table = new JTable(model) {
			public boolean isCellEditable(int row, int column) {
				return (false);
			}
		};
		table.getTableHeader().setReorderingAllowed(false);
		ResultSet rs = null;
		String query = null;
		HashMap<String, ResultSet> map = this.db.getTable().returnTable(nameOfObject);
		query = map.keySet().toArray(new String[1])[0];
		rs = map.get(query);

		try {
			ResultSetMetaData rsmd = rs.getMetaData();

			for (int i = 0; rs.next(); i++) {
				for (int j = 0; j < rsmd.getColumnCount(); j++) {
					table.setValueAt(rs.getString(j + 1), i, j);
				}
			}

			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		pane.add(new JScrollPane(table), BorderLayout.NORTH);
		JTextArea text = new JTextArea();
		text.setEditable(false);
		text.setText(query);
		pane.add(text, BorderLayout.CENTER);
		JTabbedPane tabPane = this.getFrame().getTabbedPane();
		tabPane.add(nameOfObject, scrollPane);
		tabPane.setTabComponentAt(tabPane.indexOfTab(nameOfObject), new ButtonTab(tabPane, nameOfObject));
		text.addKeyListener(new ClosableTabListener(tabPane));
		table.addKeyListener(new ClosableTabListener(tabPane));
		tabPane.requestFocus();
	}

	/**
	 * This is the method that will make a new Tab when Table element are double clicked
	 * The tab will be put at the i put in parameter
	 * @param nameOfObject the name of the object that has been clicked
	 * @param i The index were we want to put the new table in the JTabbedPane
	 */
	public void makeTable(String nameOfObject, int i) {
		JScrollPane scrollPane = new JScrollPane();
		JPanel pane = new JPanel();
		scrollPane.setViewportView(pane);

		pane.setLayout(new BorderLayout());
		Vector<String> columnNames = new Vector<String>();
		ArrayList<String> arr = this.db.getTable().tableToArrayList(nameOfObject);

		for (int j = 2; j <= Integer.parseInt(arr.get(1)) + 1; j++) {
			columnNames.add(arr.get(j));
		}
		
		DefaultTableModel model = new DefaultTableModel(columnNames, this.db.getTable().nbTuples(nameOfObject));
		JTable table = new JTable(model) {
			public boolean isCellEditable(int row, int column) {
				return (false);
			}
		};
		table.getTableHeader().setReorderingAllowed(false);
		ResultSet rs = null;
		String query = null;
		HashMap<String, ResultSet> map = this.db.getTable().returnTable(nameOfObject);
		query = map.keySet().toArray(new String[1])[0];
		rs = map.get(query);

		try {
			ResultSetMetaData rsmd = rs.getMetaData();

			for (int j = 0; rs.next(); j++) {
				for (int k = 0; k < rsmd.getColumnCount(); k++) {
					table.setValueAt(rs.getString(k + 1), j, k);
				}
			}

			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		pane.add(new JScrollPane(table), BorderLayout.NORTH);
		JTextArea text = new JTextArea();
		text.setEditable(false);
		text.setText(query);
		pane.add(text, BorderLayout.CENTER);
		JTabbedPane tabPane = this.getFrame().getTabbedPane();
		tabPane.insertTab(nameOfObject, null, scrollPane, null, i);
		tabPane.setTabComponentAt(tabPane.indexOfTab(nameOfObject), new ButtonTab(tabPane, nameOfObject));
		text.addKeyListener(new ClosableTabListener(tabPane));
		table.addKeyListener(new ClosableTabListener(tabPane));
		tabPane.requestFocus();
	}

	/**
	 * This is the method that will make a new Tab when a View element has been
	 * double clicked
	 * @param nameOfObject The name of the object that has been clicked
	 */
	public void makeView(String nameOfObject){
		JScrollPane scrollPane = new JScrollPane();
		JPanel pane = new JPanel();
		scrollPane.setViewportView(pane);

		pane.setLayout(new BorderLayout());
		Vector<String> columnNames = new Vector<String>();
		ArrayList<String> arr = this.db.getTable().tableToArrayList(nameOfObject);

		for (int i = 2; i <= Integer.parseInt(arr.get(1)) + 1; i++) {
			columnNames.add(arr.get(i));
		}

		DefaultTableModel model = new DefaultTableModel(columnNames, this.db.getTable().nbTuples(nameOfObject));
		JTable table = new JTable(model) {
			public boolean isCellEditable(int row, int column) {
				return (false);
			}
		};
		table.getTableHeader().setReorderingAllowed(false);
		ResultSet rs = null;
		String query = null;
		HashMap<String, ResultSet> map = this.db.getTable().returnTable(nameOfObject);
		query = map.keySet().toArray(new String[1])[0];
		rs = map.get(query);

		try {
			ResultSetMetaData rsmd = rs.getMetaData();

			for (int i = 0; rs.next(); i++) {
				for (int j = 0; j < rsmd.getColumnCount(); j++) {
					table.setValueAt(rs.getString(j + 1), i, j);
				}
			}

			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		String sqlView = new String();
		ResultSet rsMakeView = null;
		Statement st = null;
		try {
			st = this.frame.getDb().getInitJdbc().getConnection().createStatement();
			rsMakeView = st
					.executeQuery("SELECT sql FROM sqlite_master WHERE type = 'view' AND name='" + nameOfObject + "';");
			sqlView += rsMakeView.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { 
				if (st != null) st.close(); 
			}catch (Exception e) { 
				e.printStackTrace();
			}

			try { 
				if (rsMakeView != null) rsMakeView.close(); 
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		pane.add(new JScrollPane(table), BorderLayout.NORTH);
		JTextArea text = new JTextArea();
		text.setEditable(false);
		text.setText(sqlView);
		pane.add(text, BorderLayout.CENTER);
		JTabbedPane tabPane = this.getFrame().getTabbedPane();
		tabPane.add(nameOfObject, scrollPane);
		tabPane.setTabComponentAt(tabPane.indexOfTab(nameOfObject), new ButtonTab(tabPane, nameOfObject));
		text.addKeyListener(new ClosableTabListener(tabPane));
		table.addKeyListener(new ClosableTabListener(tabPane));
		tabPane.requestFocus();
	}

	/**
	 * This is the method that will make a new Tab when a View element has been
	 * double clicked
	 * @param nameOfObject The name of the object that has been clicked
	 */
	public void makeTrigger(String nameOfObject){
		String query = this.db.getTrigger().getCodeTrigger(nameOfObject);
		JTabbedPane tabbedPane = this.getFrame().getTabbedPane();
		JScrollPane scrollText = new JScrollPane();
		JTextPane pane = new JTextPane();
		pane.setEditable(false);
		pane.setText(query);
		pane.setPreferredSize(new Dimension(tabbedPane.getSize()));
		pane.addKeyListener(new ClosableTabListener(tabbedPane));
		///!\/!\/!\/!\/!\/!\/!\/!\/!\/!\/!\Voir pour changer le nom avec l'enregistrement /!\/!\/!\/!\/!\/!\/!\/!\/!\	
		scrollText.setViewportView(pane);
		scrollText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		tabbedPane.add(nameOfObject, scrollText);
		tabbedPane.setTabComponentAt(tabbedPane.indexOfTab(nameOfObject), new ButtonTab(tabbedPane, nameOfObject));
		tabbedPane.requestFocus();
	}

	/**
	 * This method will update the JTree (removeAllChildren and re-add them)
	 */
	public void updateTree(){
		this.getPane().getTable().removeAllChildren();
		this.getPane().getView().removeAllChildren();
		this.getPane().getTrigger().removeAllChildren();
		for(int i=0; i< this.db.getTable().numberOfTable(); i++){
			this.getPane().getTable().add(new DefaultMutableTreeNode(this.db.getTable().getTableName().get(i)));
		}
		for(int i=0; i< this.db.getView().numberOfView(); i++){
			this.getPane().getView().add(new DefaultMutableTreeNode(this.db.getView().getViewName().get(i)));
		}
		for(int i=0; i< this.db.getTrigger().numberOfTrigger(); i++){
			this.getPane().getTrigger().add(new DefaultMutableTreeNode(this.db.getTrigger().getTriggerName().get(i)));
		}
		DefaultTreeModel model = (DefaultTreeModel)this.getPane().getTree().getModel();
		model.reload();
	}

	/**
	 * This method will check if the element is already open
	 * @param title The title of the tab
	 * @param pane The JTabbedPane where tabs are add
	 * @return True if the element is already open
	 */
	public boolean tabAlreadyIn(String title, JTabbedPane pane){
		boolean in = false;
		if(pane.indexOfTab(title) != -1){
			in = true;
		}
		return in;
	}

	/**
	 * Get the GUI of the Application
	 * @return The GUI of the Application
	 */
	public GUI getFrame() {
		return frame;
	}
	/**
	 * Get the LeftPane of the Application
	 * @return The LeftPane of the Application
	 */
	public LeftPane getPane() {
		return pane;
	}
}