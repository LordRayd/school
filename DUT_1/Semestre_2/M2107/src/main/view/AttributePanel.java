package view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Gurvan LORANS and Samuel LE BERRE
 *
 */
public class AttributePanel extends JPanel {

	/**
	 * 
	 */
	private JLabel name;
	/**
	 * 
	 */
	private JTextField nameTF;
	/**
	 * 
	 */
	private JLabel type;
	/**
	 * 
	 */
	private JTextField typeTF;
	/**
	 * 
	 */
	private JComboBox<String> constraint;
	/**
	 * 
	 */
	private static String[] nameConstraint = {"AUCUN","NON NUL","CLE PRIMAIRE", "UNIQUE"};
	
	/**
	 * The constructor of the AtributePanel
	 * Call initComponent and addComponent
	 */
	public AttributePanel(){
		initComponent();
		addComponent();
	}
	
	/**
	 * This procedure initialize the Component
	 */
	private void initComponent(){
		this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		name = new JLabel("Nom d'attribut : ");
		nameTF = new JTextField();
		nameTF.setPreferredSize(new Dimension(100,15));
		
		type = new JLabel("Type d'attribut : ");
		typeTF = new JTextField();
		typeTF.setPreferredSize(new Dimension(100,15));
		
		constraint = new JComboBox<String>(AttributePanel.nameConstraint);
	}
	
	/**
	 * This procedure add the component to the JPanel
	 */
	private void addComponent(){
		add(name);
		add(nameTF);
		add(type);
		add(typeTF);
		add(constraint);
	}
	
	/**
	 * Get the JTextField who contains the name of the column
	 * @return The JTextField who contains the name of the column
	 */
	public JTextField getNameTF(){
		return this.nameTF;
	}
	/**
	 * Get the JTextField who contains the type of the column
	 * @return The JTextField who contains the type of the column
	 */
	public JTextField getTypeTF() {
		return typeTF;
	}
	/**
	 * Get the JComboBox with the Constraint of the column
	 * @return The JComboBox with the Constraint of the column
	 */
	public JComboBox<String> getConstraint(){
		return this.constraint;
	}
}