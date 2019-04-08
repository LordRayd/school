package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import controller.MenuBarListener;

/**
 * 
 * @author Gurvan LORANS et Samuel LE BERRE
 * @version 1.0
 */
public class MenuBar extends JMenuBar{
	
	/**
	 * This is the GUI where the MenuBar will be add
	 */
	private GUI frame;
	/**
	 * This is a Menu
	 */
	private JMenu fichier;
	/**
	 * This is a Menu
	 */
	private JMenu aide;
	/**
	 * This is an Item for the Menu
	 */
	private JMenuItem nouveau;
	/**
	 * This is an Item for the Menu
	 */
	private JMenuItem ouvrir;
	/**
	 * This is an Item for the Menu
	 */
	private JMenuItem enregistrer;
	/**
	 * This is an Item for the Menu
	 */
	private JMenuItem enregistrerSous;
	/**
	 * This is an Item for the Menu
	 */
	private JMenuItem imprimer;
	/**
	 * This is an Item for the Menu
	 */
	private JMenuItem deconnexion;
	/**
	 * This is an Item for the Menu
	 */
	private JMenuItem quitter;
	/**
	 * This is an Item for the Menu
	 */
	private JMenuItem aPropos;
	/**
	 * This is an Item for the Menu
	 */
	private JMenuItem help;

	/**
	 * This is the constructor, it calls menuFichier and menuAide
	 * @param frame the frame where will be add this menubar
	 */
	public MenuBar(GUI frame){
		if(frame != null){
			this.frame = frame;
		}
		menuFichier();
		menuAide();
	}
	
	/**
	 * This procedure will initialize and add elements for the menu "Fichier"
	 */
	public void menuFichier(){
		//Build the first menu.
		MenuBarListener listener = new MenuBarListener(frame, this);
		fichier = new JMenu("Fichier");
		fichier.setMnemonic(KeyEvent.VK_F); // Souligne le A pour les raccourcis
		fichier.addActionListener(listener);
		
		nouveau = new JMenuItem("Nouveau", KeyEvent.VK_N);
		nouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		nouveau.addActionListener(listener);
		fichier.add(nouveau);
		
		fichier.addSeparator();
		
		ouvrir = new JMenuItem("Ouvrir", KeyEvent.VK_O);
		ouvrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		ouvrir.addActionListener(listener);
		fichier.add(ouvrir);
		
		fichier.addSeparator();
		enregistrer = new JMenuItem("Enregistrer", KeyEvent.VK_E);
		enregistrer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		enregistrer.addActionListener(listener);
		fichier.add(enregistrer);
		
		enregistrerSous = new JMenuItem("Enregistrer Sous", KeyEvent.VK_S);
		enregistrerSous.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.SHIFT_MASK | KeyEvent.CTRL_MASK));
		enregistrerSous.addActionListener(listener);
		fichier.add(enregistrerSous);
		
		fichier.addSeparator();
		imprimer = new JMenuItem("Imprimer", KeyEvent.VK_I);
		imprimer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		imprimer.addActionListener(listener);
		fichier.add(imprimer);
		
		fichier.addSeparator();
		deconnexion = new JMenuItem("Deconnexion",KeyEvent.VK_D);
		deconnexion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		deconnexion.addActionListener(listener);
		fichier.add(deconnexion);
		
		quitter = new JMenuItem("Quitter", KeyEvent.VK_I);
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		quitter.addActionListener(listener);
		fichier.add(quitter);
		this.add(fichier);
		
	}
	
	/**
	 * This procedure will initialize and add elements for the menu "Aide"
	 */
	public void menuAide(){
		aide = new JMenu("Aide");
		aide.setMnemonic(KeyEvent.VK_A); // Souligne le A pour les raccourcis
		
		help = new JMenuItem("Aide", KeyEvent.VK_A);
		aide.add(help);

		
		aide.addSeparator();
		
		
		aPropos = new JMenuItem("<html>&Agrave; propos</html>", KeyEvent.VK_P);
		aide.add(aPropos);
				
		this.add(aide);
	}

	/**
	 * This is a getter
	 * @return the MenuItem "Nouveau"
	 */
	public JMenuItem getNouveau() {
		return nouveau;
	}
	/**
	 * This is a getter
	 * @return the MenuItem "Ouvrir"
	 */
	public JMenuItem getOuvrir() {
		return ouvrir;
	}
	/**
	 * This is a getter
	 * @return the MenuItem "Enregistrer"
	 */
	public JMenuItem getEnregistrer() {
		return enregistrer;
	}
	/**
	 * This is a getter
	 * @return the MenuItem "EnregistrerSous"
	 */
	public JMenuItem getEnregistrerSous() {
		return enregistrerSous;
	}
	/**
	 * This is a getter
	 * @return the MenuItem "Imprimer"
	 */
	public JMenuItem getImprimer() {
		return imprimer;
	}
	/**
	 * This is a getter
	 * @return the MenuItem "Deconnexion"
	 */
	public JMenuItem getDeconnexion() {
		return deconnexion;
	}
	/**
	 * This is a getter
	 * @return the MenuItem "Quitter"
	 */
	public JMenuItem getQuitter() {
		return quitter;
	}
	/**
	 * This is a getter
	 * @return the MenuItem "aPropos"
	 */
	public JMenuItem getaPropos() {
		return aPropos;
	}
	/**
	 * This is a getter
	 * @return the MenuItem "Help"
	 */
	public JMenuItem getHelp() {
		return help;
	}
}