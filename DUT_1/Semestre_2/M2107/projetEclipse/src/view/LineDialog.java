package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.LineDialogListener;

public class LineDialog extends JDialog {

	private String tableName;
	private JPanel panelDialog;
	private JPanel panelUp;
	private JPanel panelDown;
	private JTable table;
	private GUI frame;
	private JButton validate;
	private JButton back;
	private boolean addLine;
	
	public LineDialog(GUI frame, String tableName, boolean addLine){
		super(frame);
		this.frame = frame;
		this.tableName = tableName;
		this.addLine = addLine;
		this.initDialog();
		this.initComponent();
		this.addComponent();
		this.displayDialog();
	}
	
	public void initComponent(){
		this.panelDialog = new JPanel();
		this.panelDialog.setLayout(new BorderLayout());
		
		this.panelUp = new JPanel();
		this.panelUp.setLayout(new BorderLayout());
		
		this.panelDown = new JPanel();
		
		Vector<String> columnNames = new Vector<String>();
		ArrayList<String> arr = this.frame.getDb().getInitJdbc().getTable().tableToArrayList(this.tableName);
		for(int i = 2; i <= Integer.parseInt(arr.get(1))+1 ; i++){
			columnNames.add(arr.get(i));
		}
		DefaultTableModel model = new DefaultTableModel(columnNames, 1);
		this.table = new JTable(model);
		this.table.getTableHeader().setReorderingAllowed(false);
		
		this.validate = new JButton("Valider");
		this.validate.addActionListener(new LineDialogListener(this));
		
		this.back = new JButton("Retour");
		this.back.addActionListener(new LineDialogListener(this));
	}
	
	public void addComponent(){
		this.panelUp.add(new JScrollPane(this.table),BorderLayout.CENTER);
		
		this.panelDown.add(this.validate);
		this.panelDown.add(this.back);
		
		this.panelDialog.add(this.panelUp, BorderLayout.CENTER);
		this.panelDialog.add(this.panelDown, BorderLayout.SOUTH);
		this.add(this.panelDialog);
	}
	
	public void initDialog(){
		this.setTitle("Dialog");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void displayDialog(){
		this.pack();
		this.setLocationRelativeTo(this.frame);
		this.setVisible(true);
	}

	public GUI getFrame() {
		return frame;
	}

	public JButton getValidate() {
		return validate;
	}

	public JButton getBack() {
		return back;
	}

	public JTable getTable() {
		return table;
	}

	public boolean isAddLine() {
		return addLine;
	}

	public String getTableName() {
		return tableName;
	}
}
