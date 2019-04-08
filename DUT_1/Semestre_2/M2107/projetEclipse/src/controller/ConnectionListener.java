package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.JOptionPane;

import model.CheckConnection;
import view.Connection;
import view.GUI;

/**
 * This class is the Listener of the object Connection
 * @author Gurvan LORANS et Samuel LE BERRE
 * @version 1.0
 */
public class ConnectionListener extends KeyAdapter implements ActionListener {

	/**
	 * This is the JFrame made for the connection (JTextField for IDs)
	 */
	private Connection connection;
	/**
	 * This is the controller for the DataBase (it makes the connection to the DB)
	 */
	private ControllerDB db;
	/**
	 * This will check the connection with the user ID's
	 */
	private CheckConnection check;

	/**
	 * This is the constructor it needs the connection to initialize the
	 * attribute and it initialize the CheckConnection attribute
	 * @param connection This is the connection that will be  the attribute for this class
	 */
	public ConnectionListener(Connection connection){
		this.connection = connection;
		check = new CheckConnection();
	}

	/**
	 * This is the implemented method from the ActionListener interface
	 * This method will store the file with id encrypted into a file and check if users ID are valid
	 * it will check if the user has clicked on the Validate button
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.connection.getValidate()){
			String base = "DataBase";
			String id = this.connection.getJtfId().getText();
			char[] passwdChar = this.connection.getJpfPasswd().getPassword();
			String passwd = new String(passwdChar);

			HashMap<String, String> identifiants = check.stringToMap();

			if(identifiants.containsKey(id)){
				if(identifiants.get(id).equals(passwd)){
					this.db = new ControllerDB(base);
					this.connection.setVisible(false);
					this.connection.dispose();
					new GUI(this.db);
				}else{
					JOptionPane.showMessageDialog(null, "Mot de passe incorrect", "ERREUR", JOptionPane.ERROR_MESSAGE); 
					this.connection.getValidate().requestFocus();
				}
			}else{
				JOptionPane.showMessageDialog(null, "Identifiant incorrect", "ERREUR", JOptionPane.ERROR_MESSAGE); 
				this.connection.getValidate().requestFocus();
			}
		}
	}

	/**
	 * This is the extended method from the KeyAdapter Class.
	 * It will check if user has pressed Enter in the JTextField
	 */
	public void keyReleased(KeyEvent evt) {
		if(evt.getSource() == connection.getJtfId() || evt.getSource() == connection.getJpfPasswd()){
			if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
				String base = "DataBase";
				String id = this.connection.getJtfId().getText();
				char[] passwdChar = this.connection.getJpfPasswd().getPassword();
				String passwd = new String(passwdChar);

				HashMap<String, String> identifiants = check.stringToMap();

				if (identifiants.containsKey(id)) {
					if (identifiants.get(id).equals(passwd)) {
						this.db = new ControllerDB(base);
						this.connection.setVisible(false);
						this.connection.dispose();
						new GUI(this.db);
						System.out.println("ID REUSSI");
					} else {
						JOptionPane.showMessageDialog(null, "Mot de passe incorrect", "ERREUR", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Identifiant incorrect", "ERREUR", JOptionPane.ERROR_MESSAGE);
				}
			}
		}	
	}
}