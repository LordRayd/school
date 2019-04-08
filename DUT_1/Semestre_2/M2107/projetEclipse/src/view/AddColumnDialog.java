package view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import controller.AddColumnListener;

/**
 * The class AddColumnDialog made for add a column to an existing table
 * @author Gurvan LORANS et Samuel LE BERRE
 * @version 1.0
 */
public class AddColumnDialog extends JDialog {

	/**
	 * The GUI of the application
	 */
	private GUI frame;
	/**
	 * The name of the table
	 */
	private String tableName;
	/**
	 * The JPanel who contains the values of the new xolumn
	 */
	private AttributePanel panelAttribut;
	/**
	 * The button to validate the input
	 */
	private JButton validate;
	/**
	 * The JPanel of the JDialog
	 */
	private JPanel panePrincipale;

	/**
	 * The constructor of AddColumnDialog
	 * @param frame The GUI of the application
	 * @param tableName The name of the table where add the column
	 */
	public AddColumnDialog(GUI frame,String tableName){
		super(frame);
		this.frame = frame;
		this.tableName = tableName;
		this.initComponent();
		this.addComponent();
		this.displayDialog();
	}

	/**
	 * This procedure initialize the component
	 */
	private void initComponent(){
		this.panePrincipale = new JPanel();
		this.panelAttribut = new AttributePanel();
		this.validate = new JButton("Valider");
		this.validate.addActionListener(new AddColumnListener(this.frame,this));
		this.panePrincipale.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	}

	/**
	 * This procedure add the component to the JDialog
	 */
	private void addComponent(){
		this.panePrincipale.add(this.panelAttribut);
		this.panePrincipale.add(this.validate);
		this.add(panePrincipale);
	}

	/**
	 * This procedure display the JDialog
	 */
	private void displayDialog(){
		this.setPreferredSize(new Dimension(550,150));
		this.pack();
		this.setLocationRelativeTo(this.frame);
		this.setVisible(true);
	}

	/**
	 * Get the Validate button
	 * @return The JButton Validate
	 */
	public JButton getValidate() {
		return this.validate;
	}
	/**
	 * Get the JPanel where is put the information of the new column 
	 * @return The JPanel who contains the values
	 */
	public AttributePanel getPanelAttribut() {
		return this.panelAttribut;
	}
	/**
	 * Get the name of the table where add  the column
	 * @return The name of the table
	 */
	public String getTableName() {
		return this.tableName;
	}
}