import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Classe Interface graphique
 * @author Furno - Le Berre -- Groupe A
 * @version 1.0
 */
public class InformationPanel extends JPanel{
	
	private JTextField nomJTF;
	private JTextField prenomJTF;
	private JTextField dateNaissanceJTF;
	private JTextField courrielJTF;
	private JLabel nom;
	private JLabel prenom;
	private JLabel dateNaissance;
	private JLabel courriel;
	private JLabel redoublant;
	private JLabel listeEval;
	private JLabel moyenne;
	private JRadioButton homme;
	private JRadioButton femme;
	private ButtonGroup group;
	private JCheckBox premiereACB;
	private JCheckBox deuxiemeACB;
	private JTable evaluation;
	private DefaultTableModel model;
	private Vector<String> columnNames;
	
	private int nbNote;
	
	/**
	 * 
	 * @param iG
	 */
	public InformationPanel(InterfaceGraphique iG){
		leftPane();
		rightPane();
	}

	/**
	 * 
	 */
	private void leftPane(){
		setLayout(new GridLayout(1,2,50,50));
		JPanel details = new JPanel();
		nom = new JLabel("Nom");
		prenom = new JLabel("Prenom");
		dateNaissance = new JLabel("Date de naissance");
		courriel = new JLabel("Courriel");
		redoublant = new JLabel("Redoublant");
		nomJTF = new JTextField();
		nomJTF.addFocusListener(new ControlerFocus(this));
		prenomJTF = new JTextField();
		prenomJTF.addFocusListener(new ControlerFocus(this));
		dateNaissanceJTF = new JTextField();
		dateNaissanceJTF.addFocusListener(new ControlerFocus(this));
		courrielJTF = new JTextField();
		courrielJTF.addFocusListener(new ControlerFocus(this));
		homme = new JRadioButton("H");
		femme = new JRadioButton("F");
		group = new ButtonGroup();
		group.add(homme);
		group.add(femme);
		premiereACB = new JCheckBox("1A");
		deuxiemeACB = new JCheckBox("2A");
		details.setLayout(new GridBagLayout());
		GridBagConstraints gBC = new GridBagConstraints();
		gBC.fill = GridBagConstraints.BOTH;
		gBC.insets = new Insets(5,5,5,5);
		gBC.weightx = 2;
		gBC.weighty = 7;
		gBC.gridx = 0;
		gBC.gridy = 0;
		details.add(nom,gBC);
		gBC.gridy = 1;
		details.add(prenom,gBC);
		gBC.gridy = 2;
		details.add(dateNaissance,gBC);
		gBC.gridy = 3;
		details.add(courriel,gBC);
		gBC.gridy = 4;
		details.add(homme,gBC);
		gBC.gridwidth = 2;
		gBC.gridy = 5;
		details.add(redoublant,gBC);
		gBC.gridwidth = 1;
		gBC.gridy = 6;
		details.add(premiereACB,gBC);
		gBC.gridx = 1;
		gBC.gridy = 0;
		details.add(nomJTF,gBC);
		gBC.gridy = 1;
		details.add(prenomJTF,gBC);
		gBC.gridy = 2;
		details.add(dateNaissanceJTF,gBC);
		gBC.gridy = 3;
		details.add(courrielJTF,gBC);
		gBC.gridy = 4;
		details.add(femme,gBC);
		gBC.gridy = 6;
		details.add(deuxiemeACB,gBC);
		add(details);
	}

	/**
	 * 
	 */
	private void rightPane(){
		JPanel rightPane = new JPanel();
		rightPane.setLayout(new BorderLayout());
		columnNames = new Vector<String>();
		columnNames.add("Liste des Evaluations");
	  	columnNames.add("Coefficient");	 
	    model = new DefaultTableModel(columnNames, 50);
		evaluation = new JTable(model);
		rightPane.add(new JScrollPane(evaluation));
		add(rightPane);
	}

	/**
	 * 
	 * @return
	 */
	public JTextField getNomJTF() {
		return nomJTF;
	}

	/**
	 * 
	 * @param nomJTF
	 */
	public void setNomJTF(JTextField nomJTF) {
		this.nomJTF = nomJTF;
	}

	/**
	 * 
	 * @return
	 */
	public JTextField getPrenomJTF() {
		return prenomJTF;
	}

	/**
	 * 
	 * @param prenomJTF
	 */
	public void setPrenomJTF(JTextField prenomJTF) {
		this.prenomJTF = prenomJTF;
	}

	/**
	 * 
	 * @return
	 */
	public JTextField getDateNaissanceJTF() {
		return dateNaissanceJTF;
	}

	/**
	 * 
	 * @param dateNaissanceJTF
	 */
	public void setDateNaissanceJTF(JTextField dateNaissanceJTF) {
		this.dateNaissanceJTF = dateNaissanceJTF;
	}

	/**
	 * 
	 * @return
	 */
	public JTextField getCourrielJTF() {
		return courrielJTF;
	}

	/**
	 * 
	 * @param courrielJTF
	 */
	public void setCourrielJTF(JTextField courrielJTF) {
		this.courrielJTF = courrielJTF;
	}

	/**
	 * 
	 * @return
	 */
	public JLabel getNom() {
		return nom;
	}

	/**
	 * 
	 * @param nom
	 */
	public void setNom(JLabel nom) {
		this.nom = nom;
	}

	/**
	 * 
	 * @return
	 */
	public JLabel getPrenom() {
		return prenom;
	}

	/**
	 * 
	 * @param prenom
	 */
	public void setPrenom(JLabel prenom) {
		this.prenom = prenom;
	}

	/**
	 * 
	 * @return
	 */
	public JLabel getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * 
	 * @param dateNaissance
	 */
	public void setDateNaissance(JLabel dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * 
	 * @return
	 */
	public JLabel getCourriel() {
		return courriel;
	}

	/**
	 * 
	 * @param courriel
	 */
	public void setCourriel(JLabel courriel) {
		this.courriel = courriel;
	}
	
	/**
	 * 
	 * @return
	 */
	public JLabel getRedoublant() {
		return redoublant;
	}

	/**
	 * 
	 * @param redoublant
	 */
	public void setRedoublant(JLabel redoublant) {
		this.redoublant = redoublant;
	}
	
	/**
	 * 
	 * @return
	 */
	public JLabel getListeEval() {
		return listeEval;
	}

	/**
	 * 
	 * @param listeEval
	 */
	public void setListeEval(JLabel listeEval) {
		this.listeEval = listeEval;
	}

	/**
	 * 
	 * @return
	 */
	public JLabel getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(JLabel moyenne) {
		this.moyenne = moyenne;
	}

	public JRadioButton getHomme() {
		return homme;
	}

	public void setHomme(JRadioButton homme) {
		this.homme = homme;
	}

	public JRadioButton getFemme() {
		return femme;
	}

	public void setFemme(JRadioButton femme) {
		this.femme = femme;
	}

	public JCheckBox getPremiereACB() {
		return premiereACB;
	}

	public void setPremiereACB(JCheckBox premiereACB) {
		this.premiereACB = premiereACB;
	}

	public JCheckBox getDeuxiemeACB() {
		return deuxiemeACB;
	}

	public void setDeuxiemeACB(JCheckBox deuxiemeACB) {
		this.deuxiemeACB = deuxiemeACB;
	}

	public JTable getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(JTable evaluation) {
		this.evaluation = evaluation;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public Vector<String> getColumnNames() {
		return columnNames;
	}
	
	public void setColumnNames(Vector<String> columnNames) {
		this.columnNames = columnNames;
	}
}