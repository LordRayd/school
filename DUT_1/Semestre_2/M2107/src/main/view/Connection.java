package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.ConnectionListener;

public class Connection extends JFrame {
	/**
	 * This JLabel will display "Identifiant"
	 */
	private JLabel labelId;
	/**
	 * This JTextField will be used to write the ID
	 */
	private JTextField jtfId;
	/**
	 * This JLabel will display "Mot de passe"
	 */
	private JLabel labelPasswd;
	/**
	 * This JPasswordField will be used to write the password
	 */
	private JPasswordField jpfPasswd;
	/**
	 * This button will be used to commit the ID
	 */
	private JButton validate;
	/**
	 * This is the constraint for the GridBagLayout placement
	 */
	private GridBagConstraints c;

	/**
	 * This is the constructor, it only call the methods the initialize element add them etc
	 */
	public Connection(){
		super();
		this.initFrame();
		this.initComponent();
		this.addComponent();
		this.printFrame();		
	}

	/**
	 * This procedure will initialize the frame settings
	 */
	private void initFrame(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Connection");
		this.setResizable(false);
		this.setPreferredSize(new Dimension(300,300));
		this.setLayout(new GridBagLayout());
		this.c = new GridBagConstraints();
		pack();
	}

	/**
	 * This method will put settings for the display of the JFrame
	 * LocationRelativeTo : null
	 * setVisible : true
	 */
	private void printFrame(){
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	/**
	 * This procedure will initialize the component of the JFrame
	 */
	private void initComponent(){

		//Border line = BorderFactory.createLineBorder(Color.DARK_GRAY);
		//Border empty = new EmptyBorder(0, 20, 0, 0);
		//CompoundBorder border = new CompoundBorder(line, empty);

		this.labelId = new JLabel("Identifiant : ");
		this.labelId.setHorizontalAlignment(JLabel.CENTER);
		this.labelId.setVerticalAlignment(JLabel.CENTER);
		this.jtfId = new JTextField();
		//this.jtfId.setBorder(border);
		this.jtfId.addKeyListener(new ConnectionListener(this));

		this.labelPasswd = new JLabel("Mot de passe : ");
		this.labelPasswd.setHorizontalAlignment(JLabel.CENTER);
		this.labelPasswd.setVerticalAlignment(JLabel.CENTER);
		this.jpfPasswd = new JPasswordField();
		//this.jpfPasswd.setBorder(border);
		this.jpfPasswd.addKeyListener(new ConnectionListener(this));

		this.validate = new JButton("Valider");
		this.validate.addActionListener(new ConnectionListener(this));
	}

	/**
	 * This procedure will add the component in the Frame
	 */
	private void addComponent(){
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.ipady = 10;
		c.insets = new Insets(5,5,5,5);
		add(this.labelId, c);
		add(this.jtfId, c);
		c.ipady = 0;
		add(this.labelPasswd, c);
		c.ipady = 10;
		add(this.jpfPasswd, c);
		c.ipady = 0;
		add(this.validate, c);
	}


	/**
	 * This is a getter
	 * @return the JTextField where the Id is write
	 */
	public JTextField getJtfId() {
		return jtfId;
	}

	/**
	 * This is a getter
	 * @return the JPasswordField where the password had been writed
	 */
	public JPasswordField getJpfPasswd() {
		return jpfPasswd;
	}

	/**
	 * This is a getter 
	 * @return the JButton to commit the ID
	 */
	public JButton getValidate() {
		return validate;
	}	
}