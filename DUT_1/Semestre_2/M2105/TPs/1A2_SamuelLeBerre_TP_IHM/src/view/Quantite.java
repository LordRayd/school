package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.ButtonControler;

public class Quantite extends JPanel {

	private InterfaceGraphique iG;
	private JLabel titre;
	private JButton retour;
	private JButton valider;
	private JLabel quantite;
	
	public Quantite(InterfaceGraphique iG){
		super();
		this.setiG(iG);
		int height = this.getiG().getHeight();
		int width = this.getiG().getWidth();
		this.setLayout(null);
		Color color = new Color(116, 208, 241);
	    this.setBackground(color);

		//JLabel Titre
		this.setTitre(new JLabel("Quantite"));
		this.getTitre().setBounds((width/2)-(200/3), (height/2)-(height/3), 200, 100);
		this.add(this.getTitre());
		
		//JLabel Quantite
		this.setQuantite(new JLabel("Vous devez utilisez 5 bouchons de Cilite Bang"));
		this.getQuantite().setBounds((width/2)-(280/2), (height/2)-(50/2), 280, 50);
		this.add(this.getQuantite());
		
		// JButton Retour
		this.setRetour(new JButton("Retour"));
		this.getRetour().addActionListener(new ButtonControler(this.getiG()));
		this.getRetour().setBounds(0, 0, 150, 50);
		this.add(this.getRetour());
		
		//JButton Valider
		this.setValider(new JButton("Commencer a nettoyer"));
		this.getValider().addActionListener(new ButtonControler(this.getiG()));
		this.getValider().setBounds((width/2)-(200/2),(height-(height/4))-50, 200, 50);
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

	public JLabel getQuantite() {
		return quantite;
	}

	public void setQuantite(JLabel quantite) {
		this.quantite = quantite;
	}
}
