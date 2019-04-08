import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Accueil extends JPanel {

	private InterfaceGraphique iG;
	private JButton parametre;
	private JButton faireMenage;
	private JButton auMagasin;
	private JButton mesOutils;

	public Accueil(InterfaceGraphique iG){
		super();
		this.setiG(iG);
		this.setSize(1000,400);
		this.setBackground(Color.WHITE);
		this.setVisible(true);
		this.setParametre(new JButton("Parametres"));
		this.getParametre().setLocation(100,100);
		this.getParametre().addActionListener(new ButtonControler(this.getiG()));
		this.setFaireMenage(new JButton("Faire le menage"));
		this.getFaireMenage().setLocation(200, 200);
		this.getFaireMenage().addActionListener(new ButtonControler(this.getiG()));
		this.setAuMagasin(new JButton("Au magasin"));
		this.getAuMagasin().setLocation(300, 300);
		this.getAuMagasin().addActionListener(new ButtonControler(this.getiG()));
		this.setMesOutils(new JButton("Mes outils"));
		this.getMesOutils().setBounds(400, 400, 100, 100);
		this.getMesOutils().addActionListener(new ButtonControler(this.getiG()));
		this.add(this.getParametre());
		this.add(this.getFaireMenage());
		this.add(this.getAuMagasin());
		this.add(this.getMesOutils());
		validate();
		repaint();
//		this.setLayout(new GridBagLayout());
//		GridBagConstraints gbc = new GridBagConstraints();
//		gbc.fill = GridBagConstraints.BOTH;
//		//La taille en hauteur et en largeur
//		gbc.gridheight = 1;
//		gbc.gridwidth = 1;
//		//On positionne la case de départ du composant
//		gbc.gridx = 0;
//		gbc.gridy = 1;
//		add(this.getFaireMenage(),gbc);
//		gbc.gridx = 4;
//		add(this.getMesOutils(),gbc);
//		gbc.gridx = 2;
//		gbc.gridy = 15;
//		add(this.getAuMagasin(),gbc);
	}


	public InterfaceGraphique getiG() {
		return iG;
	}


	public void setiG(InterfaceGraphique iG) {
		this.iG = iG;
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
