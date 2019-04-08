package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import model.OpenAndSave;
import view.Connection;
import view.GUI;
import view.JScrollPaneToSave;
import view.MenuBar;
import view.APropos;
import view.HelpDialog;

/**
 * This class is the Listener of the class Menubar
 * Extends ActionListener
 * @author Gurvan LORANS and Samuel LE BERRE
 * @version 1.0
 */
public class MenuBarListener implements ActionListener{

	/**
	 * This is the MenuBar from the GUI JFrame
	 */
	private MenuBar mb;
	/**
	 * This is the GUI of the application
	 */
	private GUI frame;
	/**
	 * This is a model class that contains Open, Save, Save As, Print, New methods
	 */
	private OpenAndSave openAndSave;
	/**
	 * This is the JTabbedPane of the GUI that will be change with interaction
	 */
	private JTabbedPane tabbedPane;
	/**
	 * The constructor of the listener
	 * @param frame The GUI of the application
	 * @param mb The MenuBar to listen
	 */
	public MenuBarListener(GUI frame, MenuBar mb) {
		if(mb != null){
			this.mb = mb;
		}
		if(frame != null){
			this.frame = frame;
		}
		this.tabbedPane = frame.getTabbedPane();
		this.openAndSave = new OpenAndSave(this);
	}

	/**
	 * This is the implemented method from the ActionListener interface.
	 * It will check the different elements are pressed (Nouveau, Enregistrer, Enregistrer Sous ...)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mb.getOuvrir()){
			this.openAndSave.openFileInTab();
			this.tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
		}
		
		if(e.getSource() == mb.getNouveau()){
			int i = 1;
			while(tabbedPane.indexOfTab("Sans Titre "+String.valueOf(i)) != -1){
				i++;
			}		
			openAndSave.makeTextPaneTab("Sans Titre "+String.valueOf(i));
			tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
		}
		
		if(e.getSource() == mb.getEnregistrer()){
			if(tabbedPane != null && tabbedPane.getTabCount()>0){
				if(tabbedPane.getSelectedComponent() instanceof JScrollPaneToSave){
					JScrollPaneToSave scrollText = (JScrollPaneToSave)tabbedPane.getSelectedComponent();
					if(scrollText.getSavePath() == null){
						scrollText.setSavePath(openAndSave.saveAs());
					}else{
							frame.getActionBar().getAction().setText("<html>Fichier &eacute;cras&eacute;");
							openAndSave.save(scrollText.getSavePath());
					}
				}
			}
		}
		
		if(e.getSource() == mb.getEnregistrerSous()){
			if(tabbedPane != null){
				openAndSave.saveAs();
			}
		}
		
		if(e.getSource() == mb.getImprimer()){	
			openAndSave.print();
		}

		if(e.getSource() == mb.getDeconnexion()){
			try{
				this.getFrame().getDb().getInitJdbc().getConnection().close();
			}catch(SQLException e1){
				e1.printStackTrace();
			}
			this.getFrame().dispose();
			new Connection();
		}

		if(e.getSource() == mb.getQuitter()){
			int choice = JOptionPane.showConfirmDialog(frame,"<html>Avez-vous bien tout enregistr&eacute;?</html>","Quitter ?",JOptionPane.YES_NO_OPTION);			
			if(choice == JOptionPane.YES_OPTION){
				try{
					this.getFrame().getDb().getInitJdbc().getConnection().close();
				}catch(SQLException e1){
					e1.printStackTrace();
				}
				this.getFrame().dispose();
			}
		}
		
		if(e.getSource() == mb.getaPropos()){
			APropos aPropos = new APropos(frame);
		}
		
		if(e.getSource() == mb.getHelp()){
			HelpDialog aPropos = new HelpDialog(frame);
		}
		
	}

	/**
	 * This method will return the GUI of Application for the OpenAndSave model method for example
	 * @return the GUI of the Application
	 */
	public GUI getFrame() {
		return frame;
	}	
}
