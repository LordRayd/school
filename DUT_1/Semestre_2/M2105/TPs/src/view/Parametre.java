package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Controller.ButtonControler;

public class Parametre extends JPanel{

	private InterfaceGraphique iG;
	private JLabel titre;
	private JButton retour;
	private JButton valider;
	private JRadioButton son;
	
	public Parametre(InterfaceGraphique iG){
		super();
		this.setiG(iG);
		int height = this.getiG().getHeight();
		int width = this.getiG().getWidth();
		this.setLayout(null);
		Color color = new Color(116, 208, 241);
	    this.setBackground(color);

		//JLabel Titre
		this.setTitre(new JLabel("Parametre"));
		this.getTitre().setBounds((width/2)-(200/3), (height/2)-(height/3), 200, 100);
		this.add(this.getTitre());

		//SON
		this.setSon(new JRadioButton("Son"));
		this.getSon().setBounds((width/2)-(100/2),(height/2)-(50/2), 100, 50);
		this.getSon().setBackground(color);
		this.add(this.getSon());
		
		// JButton Retour
		this.setRetour(new JButton("Retour"));
		this.getRetour().addActionListener(new ButtonControler(this.getiG()));
		this.getRetour().setBounds(0, 0, 150, 50);
		this.add(this.getRetour());

		//JButton Valider
		this.setValider(new JButton("Valider"));
		this.getValider().addActionListener(new ButtonControler(this.getiG()));
		this.getValider().setBounds((width/2)-(150/2),(height-(height/4))-50, 150, 50);
		this.add(this.getValider());

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

	public JButton getValider() {
		return valider;
	}

	public void setValider(JButton valider) {
		this.valider = valider;
	}

	public JRadioButton getSon() {
		return son;
	}

	public void setSon(JRadioButton son) {
		this.son = son;
	}	
}
