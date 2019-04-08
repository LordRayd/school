package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.ButtonControler;

public class Accueil extends JPanel{

	private InterfaceGraphique iG;
	private JLabel titre;
	private JButton parametre;
	private JButton faireMenage;
	private JButton auMagasin;
	private JButton mesOutils;

	public Accueil(InterfaceGraphique iG){
		super();
		this.setiG(iG);
		int height = this.getiG().getHeight();
		int width = this.getiG().getWidth();
		this.setLayout(null);
		Color color = new Color(116, 208, 241);
	    this.setBackground(color);
	    
		//JLabel Accueil
		this.setTitre(new JLabel("AIDE MOI A NETTOYER"));
		this.getTitre().setBounds((width/2)-(200/3), (height/2)-(height/3), 200, 100);
		this.add(this.getTitre());
		
		// JButton Parametre
		this.setParametre(new JButton("Parametre"));
		this.getParametre().addActionListener(new ButtonControler(this.getiG()));
		this.getParametre().setBounds(0, 0, 150, 50);
		this.add(this.getParametre());
		
		//JButton FaireMenage
		this.setFaireMenage(new JButton("Faire Le Menage"));
		this.getFaireMenage().addActionListener(new ButtonControler(this.getiG()));
		this.getFaireMenage().setBounds((width/2)-(width/3), (height/3)+(height/8), 170, 70);
		this.add(this.getFaireMenage());
		
		//JButton MesOutils
		this.setMesOutils(new JButton("Mes Outils"));
		this.getMesOutils().addActionListener(new ButtonControler(this.getiG()));
		this.getMesOutils().setBounds((width/2)+(width/3)-170,(height/3)+(height/8), 170, 70);
		this.add(this.getMesOutils());
		
		//JButton AuMagasin
		this.setAuMagasin(new JButton("Au Magasin"));
		this.getAuMagasin().addActionListener(new ButtonControler(this.getiG()));
		this.getAuMagasin().setBounds((width/2)-(170/2),(height/3)+(height/3), 170, 70);
		this.add(this.getAuMagasin());
		
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

	public JButton getParametre() {
		return parametre;
	}

	public void setParametre(JButton parametre) {
		this.parametre = parametre;
	}

	public JButton getFaireMenage() {
		return faireMenage;
	}

	public void setFaireMenage(JButton faireMenage) {
		this.faireMenage = faireMenage;
	}

	public JButton getAuMagasin() {
		return auMagasin;
	}

	public void setAuMagasin(JButton auMagasin) {
		this.auMagasin = auMagasin;
	}

	public JButton getMesOutils() {
		return mesOutils;
	}

	public void setMesOutils(JButton mesOutils) {
		this.mesOutils = mesOutils;
	}
}
