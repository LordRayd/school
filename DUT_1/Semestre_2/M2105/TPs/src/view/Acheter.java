package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.ButtonControler;

public class Acheter extends JPanel {

	private InterfaceGraphique iG;
	private JLabel titre;
	private JButton retour;
	private JButton confirmer;
	private JLabel description1;
	private JLabel description2;
	private JLabel description3;
	private JLabel description4;

	public Acheter(InterfaceGraphique iG){
		super();
		this.setiG(iG);
		int height = this.getiG().getHeight();
		int width = this.getiG().getWidth();
		this.setLayout(null);
		Color color = new Color(116, 208, 241);
		this.setBackground(color);

		//JLabel Titre
		this.setTitre(new JLabel("Acheter"));
		this.getTitre().setBounds((width/2)-(200/3), (height/2)-(height/3), 200, 100);
		this.add(this.getTitre());

		//JLabel Description1
		this.setDescription1(new JLabel("vous avez choisi les articles suivants :"));
		this.getDescription1().setBounds((width/2)-(300/2), (height/2)-(height/3), 300, 300);
		this.add(this.getDescription1());

		//JLabel Description2
		this.setDescription2(new JLabel("Produit2"));
		this.getDescription2().setBounds((width/2)-(width/3), (height/2)+(50/2), 100, 50);
		this.add(this.getDescription2());
		//JLabel Description3
		this.setDescription3(new JLabel("Produit4"));
		this.getDescription3().setBounds((width/2)-(100/2), (height/2)+(50/2), 100, 50);
		this.add(this.getDescription3());
		//JLabel Description4
		this.setDescription4(new JLabel("Produit5"));
		this.getDescription4().setBounds((width/2)+(width/5), (height/2)+(50/2), 100, 50);
		this.add(this.getDescription4());

		// JButton Retour
		this.setRetour(new JButton("Retour"));
		this.getRetour().addActionListener(new ButtonControler(this.getiG()));
		this.getRetour().setBounds(0, 0, 150, 50);
		this.add(this.getRetour());

		//JButton Confirmer
		this.setConfirmer(new JButton("Confirmer"));
		this.getConfirmer().addActionListener(new ButtonControler(this.getiG()));
		this.getConfirmer().setBounds((width/2)+(width/4),(height-(height/5))-50, 150, 50);
		this.add(this.getConfirmer());

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

	public JButton getConfirmer() {
		return confirmer;
	}

	public void setConfirmer(JButton confirmer) {
		this.confirmer = confirmer;
	}

	public JLabel getDescription1() {
		return description1;
	}

	public void setDescription1(JLabel description1) {
		this.description1 = description1;
	}

	public JLabel getDescription2() {
		return description2;
	}

	public void setDescription2(JLabel description2) {
		this.description2 = description2;
	}

	public JLabel getDescription3() {
		return description3;
	}

	public void setDescription3(JLabel description3) {
		this.description3 = description3;
	}

	public JLabel getDescription4() {
		return description4;
	}

	public void setDescription4(JLabel description4) {
		this.description4 = description4;
	}
}
