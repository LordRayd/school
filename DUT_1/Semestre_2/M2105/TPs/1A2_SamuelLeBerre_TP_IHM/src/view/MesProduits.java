package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.ButtonControler;

public class MesProduits extends JPanel {

	private InterfaceGraphique iG;
	private JLabel titre;
	private JButton retour;
	private JButton ajouter;
	private JButton modifier;
	private JComboBox<String> produitsList;

	public MesProduits(InterfaceGraphique iG){
		super();
		this.setiG(iG);
		int height = this.getiG().getHeight();
		int width = this.getiG().getWidth();
		this.setLayout(null);
		Color color = new Color(116, 208, 241);
		this.setBackground(color);

		//JLabel Titre
		this.setTitre(new JLabel("Mes Produits"));
		this.getTitre().setBounds((width/2)-(200/3), (height/2)-(height/3), 200, 100);
		this.add(this.getTitre());

		//ComboBoxOutils
		String[] produitsTitles = new String[] {"Bois","Sol","Cilit Bang","Eau de javel","Eau déminéralisé"};
		this.setProduitsList(new JComboBox<>(produitsTitles));
		this.getProduitsList().setBounds((width/2)-(170/2),(height/3)+(height/8), 170, 50);
		this.add(this.getProduitsList());

		//JButton Modifier
		this.setModifier(new JButton("Modifier"));
		this.getModifier().addActionListener(new ButtonControler(this.getiG()));
		this.getModifier().setBounds((width/2)-(170/2),(height-(height/4))-70, 170, 70);
		this.add(this.getModifier());

		//JButton Ajouter
		this.setAjouter(new JButton("Ajouter"));
		this.getAjouter().addActionListener(new ButtonControler(this.getiG()));
		this.getAjouter().setBounds((width/2)+(width/4),(height-(height/4))-70, 170, 70);
		this.add(this.getAjouter());

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

	public JButton getAjouter() {
		return ajouter;
	}

	public void setAjouter(JButton ajouter) {
		this.ajouter = ajouter;
	}

	public JButton getModifier() {
		return modifier;
	}

	public void setModifier(JButton modifier) {
		this.modifier = modifier;
	}

	public JComboBox<String> getProduitsList() {
		return produitsList;
	}

	public void setProduitsList(JComboBox<String> produitsList) {
		this.produitsList = produitsList;
	}

}
