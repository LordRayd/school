package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.ButtonControler;

public class MesOutils extends JPanel {

	private InterfaceGraphique iG;
	private JLabel titre;
	private JButton retour;
	private JButton ustensils;
	private JButton produits;

	public MesOutils(InterfaceGraphique iG){
		super();
		this.setiG(iG);
		int height = this.getiG().getHeight();
		int width = this.getiG().getWidth();
		this.setLayout(null);
		Color color = new Color(116, 208, 241);
		this.setBackground(color);

		//JLabel Titre
		this.setTitre(new JLabel("Mes Outils"));
		this.getTitre().setBounds((width/2)-(200/3), (height/2)-(height/3), 200, 100);
		this.add(this.getTitre());
		
		//JButton Ustensils
		this.setUstensils(new JButton("Ustensils"));
		this.getUstensils().addActionListener(new ButtonControler(this.getiG()));
		this.getUstensils().setBounds((width/2)-(width/4)-(170/2), (height/3)+(height/7), 170, 70);
		this.add(this.getUstensils());

		//JButton Produits
		this.setProduits(new JButton("Produits"));
		this.getProduits().addActionListener(new ButtonControler(this.getiG()));
		this.getProduits().setBounds((width/2)+(width/4)-(170/2), (height/3)+(height/7), 170, 70);
		this.add(this.getProduits());

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

	public JButton getRetour() {
		return retour;
	}

	public void setRetour(JButton retour) {
		this.retour = retour;
	}

	public JButton getUstensils() {
		return ustensils;
	}

	public void setUstensils(JButton ustensils) {
		this.ustensils = ustensils;
	}

	public JButton getProduits() {
		return produits;
	}

	public void setProduits(JButton produits) {
		this.produits = produits;
	}
}
