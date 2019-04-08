package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.ButtonControler;

public class NettoyageEnCours extends JPanel {

	private InterfaceGraphique iG;
	private JLabel titre;
	private JButton arret;
	private JButton retour;

	public NettoyageEnCours(InterfaceGraphique iG){
		super();
		this.setiG(iG);
		int height = this.getiG().getHeight();
		int width = this.getiG().getWidth();
		this.setLayout(null);
		Color color = new Color(116, 208, 241);
		this.setBackground(color);

		//JLabel Titre
		this.setTitre(new JLabel("Nettoyage en Cours"));
		this.getTitre().setBounds((width/2)-(200/3), (height/2)-(height/3), 200, 100);
		this.add(this.getTitre());

		// JButton Arret
		this.setArret(new JButton("Arreter le Nettoyage"));
		this.getArret().addActionListener(new ButtonControler(this.getiG()));
		this.getArret().setBounds((width/2)-(200/2),(height-(height/4))-50, 200, 50);
		this.add(this.getArret());

		// JButton Retour
		this.setRetour(new JButton("Retour"));
		this.getRetour().addActionListener(new ButtonControler(this.getiG()));
		this.getRetour().setBounds(0, 0, 150, 50);
		this.add(this.getRetour());
		this.setVisible(true);
	}

	public InterfaceGraphique getiG() {
		return iG;
	}

	public void setiG(InterfaceGraphique iG) {
		this.iG = iG;
	}

	public JLabel getTitre() {
		return titre;
	}

	public void setTitre(JLabel titre) {
		this.titre = titre;
	}

	public JButton getArret() {
		return arret;
	}

	public void setArret(JButton arret) {
		this.arret = arret;
	}

	public JButton getRetour() {
		return retour;
	}

	public void setRetour(JButton retour) {
		this.retour = retour;
	}
}
