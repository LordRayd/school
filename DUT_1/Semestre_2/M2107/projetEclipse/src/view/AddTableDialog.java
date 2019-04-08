package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.AddTableListener;

/**
 * Add a table to the DataBase with an input. Calls AttributePanel
 * Extends JDialog
 * @author Gurvan LORANS and Samuel LE BERRE
 * @version 1.0
 */
public class AddTableDialog extends JDialog {

	/**
	 * The GUI of the application
	 */
	private GUI frame;
	/**
	 * The ScrollPane of AddTableDialog
	 */
	private JScrollPane scrollPane;
	/**
	 * The JPanel who contains all the graphical elements
	 */
	private JPanel contentPane;
	/**
	 * The JLabel to choose the name of the Table
	 */
	private JLabel nameTable;
	/**
	 * The JTextField who contains the Name of the Table
	 */
	private JTextField nameTableTF;
	/**
	 * The Jlabel to choose the number of attributes
	 */
	private JLabel nbAttributes;
	/**
	 * The JTextField who contains the number of attributes
	 */
	private JTextField nbAttributesTF;
	/**
	 * The button to go to the second component
	 */
	private JButton commit;
	/**
	 * The button to validate the data capture
	 */
	private JButton validate;
	/**
	 * The GridBagContraints of the JDialog
	 */
	private GridBagConstraints c = new GridBagConstraints();
	/**
	 * The list of attributes of the Table
	 */
	private AttributePanel[] listAttributePanel;

	/**
	 * The constructor of the AddTableDialog. Call initComponentFirst and addComponentFirst
	 * @param gui The GUI of the application
	 */
	public AddTableDialog(GUI gui){
		super(gui);
		this.frame = gui;
		initComponentFirst();
		addComponentFirst();
		setTitle("Ajout d'une Table");
		setContentPane(scrollPane);
		setPreferredSize(new Dimension(300,150));
		pack();
		setLocationRelativeTo(gui);
		setVisible(true);
	}

	/**
	 * Init the frame of the first dialog
	 */
	private void initComponentFirst(){

		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		contentPane.setLayout(new GridBagLayout());

		scrollPane = new JScrollPane();
		scrollPane.setViewportView(contentPane);

		nameTable = new JLabel("Nom : ");
		nameTableTF = new JTextField();
		nameTableTF.setPreferredSize(new Dimension(100,15));

		nbAttributes = new JLabel("Nombre d'attributs : ");
		nbAttributesTF = new JTextField();
		nbAttributesTF.setPreferredSize(new Dimension(100,15));

		commit = new  JButton("Valider");
		commit.addActionListener(new AddTableListener(this));
	}

	/**
	 * Add the component of the first Dialog
	 */
	private void addComponentFirst(){
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(2,2,2,2);

		c.weightx = 0;
		c.weighty = 0;
		contentPane.add(nameTable, c);

		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		contentPane.add(nameTableTF, c);

		c.gridwidth = 1;
		c.weightx = 0;
		c.weighty = 0;
		contentPane.add(nbAttributes, c);

		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		contentPane.add(nbAttributesTF, c);


		c.weightx = 0;
		c.weighty = 0;
		c.gridwidth = GridBagConstraints.REMAINDER;
		contentPane.add(commit, c);
	}

	/**
	 * Print the dialog for choose the column
	 */
	public void addComponentSecond(){
		setVisible(false);
		
		contentPane.removeAll();
		contentPane.repaint();
		scrollPane.repaint();

		//		c.weightx = 0;
		//		c.weighty = 0;
		c.gridwidth = GridBagConstraints.REMAINDER;
		this.listAttributePanel = new AttributePanel[Integer.parseInt(nbAttributesTF.getText())];
		for(int i = 0; i < Integer.parseInt(nbAttributesTF.getText()); i++){
			this.listAttributePanel[i] = new AttributePanel();
			contentPane.add(this.listAttributePanel[i], c);
		}
		validate = new JButton("Valider");
		validate.addActionListener(new AddTableListener(this));
		contentPane.add(validate);
		setPreferredSize(new Dimension(600,150));
		pack();
		setLocationRelativeTo(this.frame);
		setVisible(true);
	}

	/**
	 * Get the GUI of the application
	 * @return The GUI of the application
	 */
	public GUI getFrame() {
		return frame;
	}
	/**
	 * Get the JTextField who contains the name of the table
	 * @return The JTextField who contains the name of the table
	 */
	public JTextField getNameTableTF() {
		return nameTableTF;
	}
	/**
	 * Get the Commit button to go to the second component
	 * @return The Commit button
	 */
	public JButton getCommit() {
		return commit;
	}
	/**
	 * Get the Validate button to add the Table
	 * @return The Validate button
	 */
	public JButton getValidate() {
		return validate;
	}
	/**
	 * Get the list of columns to add in the table
	 * @return The list of columns
	 */
	public AttributePanel[] getListAttributePanel() {
		return listAttributePanel;
	}
}