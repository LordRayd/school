import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;

/**
 * Classe Interface graphique
 * @author Furno - Le Berre -- Groupe A
 * @version 1.0
 */
public class InterfaceGraphique extends JFrame {

	private ToolBar toolBar;
	private StatusBar statusBar;
	private InformationPanel informationPanel;
	private ArrayList<Eleve> listeEleve;
	/**
	 * 
	 * @param nom
	 */
	public InterfaceGraphique(String nom) {
		this.initComponents(nom);
	}

	/**
	 * 
	 * @param nom
	 */
	private void initComponents(String nom) {
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setTitle("Registre des Eleves");
		toolBar = new ToolBar(this);
		statusBar = new StatusBar(nom, new Date());
		informationPanel = new InformationPanel(this);
		add(toolBar, BorderLayout.WEST);
		add(statusBar, BorderLayout.SOUTH);
		add(informationPanel, BorderLayout.CENTER);
		setSize(1000,500);

		listeEleve = new ArrayList<Eleve>();

		toolBar.getNewButton().addActionListener(new ControlerButton(this));
		toolBar.getRemoveButton().addActionListener(new ControlerButton(this));
		toolBar.getLoadButton().addActionListener(new ControlerButton(this));
		toolBar.getSaveButton().addActionListener(new ControlerButton(this));
		toolBar.getSaveAsButton().addActionListener(new ControlerButton(this));

		setLocationRelativeTo(null);
		setVisible(true);
	}

	public ArrayList<Eleve> getListeEleve() {
		return listeEleve;
	}

	public void setListeEleve(ArrayList<Eleve> listeEleve) {
		this.listeEleve = listeEleve;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new InterfaceGraphique("Professeur Xavier");
			}
		});
	}
	/**
	 * 
	 * @return
	 */
	public StatusBar getStatusBar(){
		return this.statusBar;
	}
	/**
	 * 
	 * @return
	 */
	public ToolBar getToolBar(){
		return this.toolBar;
	}
	/**
	 * 
	 * @return
	 */
	public InformationPanel getInformationPanel(){
		return this.informationPanel;
	}
}
