import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Classe Bar Outil avec les boutons
 * @author Furno - Le Berre -- Groupe A
 * @version 1.0
 */
public class ToolBar extends JPanel{

	private JButton newButton;
	private JButton removeButton;
	private JButton loadButton;
	private JButton saveButton;
	private JButton saveAsButton;
	private JButton newNoteButton;
	
	/**
	 * 
	 * @param iG
	 */
	public ToolBar(InterfaceGraphique iG){
		super();
		newButton = new JButton("<html><font size = 3>Nouveau</font></html>");
		removeButton = new JButton("<html><font size = 3>Supprimer</font></html>");
		loadButton = new JButton("<html><font size = 3>Charger</font></html>");
		saveButton = new JButton("<html><font size = 3>Enregistrer</font></html>");
		saveAsButton = new JButton("<html><font size = 3>Enregistrer-sous</font></html>");
		setLayout(new GridBagLayout());
		GridBagConstraints gBC = new GridBagConstraints();
		gBC.fill = GridBagConstraints.BOTH;
		int mGau = 15;
		int mDro = 15;
		int mHau = 10;
		int mBas = 10;
		gBC.insets = new Insets(mHau,mGau,mBas,mDro);
		gBC.weightx = 1;
		gBC.weighty = 5;
		gBC.gridx = 0;
		gBC.gridy = 0;
		add(newButton,gBC);
		gBC.gridy = 1;
		add(removeButton,gBC);
		gBC.gridy = 2;
		add(loadButton,gBC);
		gBC.gridy = 3;
		add(saveButton,gBC);
		gBC.gridy = 4;
		add(saveAsButton,gBC);
		setVisible(true);
	}
	
	/**
	 * 
	 * @return
	 */
	public JButton getNewButton(){
		return this.newButton;
	}
	/**
	 * 
	 * @return
	 */
	public JButton getRemoveButton(){
		return this.removeButton;
	}
	/**
	 * 
	 * @return
	 */
	public JButton getLoadButton(){
		return this.loadButton;
	}
	/**
	 * 
	 * @return
	 */
	public JButton getSaveButton(){
		return this.saveButton;
	}
	/**
	 * 
	 * @return
	 */
	public JButton getSaveAsButton(){
		return this.saveAsButton;
	}
	/**
	 * 
	 * @param newButton
	 */
	public void setNewButton(JButton newButton) {
		this.newButton = newButton;
	}
	/**
	 * 
	 * @param removeButton
	 */
	public void setRemoveButton(JButton removeButton) {
		this.removeButton = removeButton;
	}
	/**
	 * 
	 * @param loadButton
	 */
	public void setLoadButton(JButton loadButton) {
		this.loadButton = loadButton;
	}
	/**
	 * 
	 * @param saveButton
	 */
	public void setSaveButton(JButton saveButton) {
		this.saveButton = saveButton;
	}
	/**
	 * 
	 * @param saveAsButton
	 */
	public void setSaveAsButton(JButton saveAsButton) {
		this.saveAsButton = saveAsButton;
	}

	public JButton getNewNoteButton() {
		return newNoteButton;
	}

	public void setNewNoteButton(JButton newNoteButton) {
		this.newNoteButton = newNoteButton;
	}
	
	
}
