package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.ButtonControler;

public class Surface extends JPanel {

	private InterfaceGraphique iG;
	private JLabel titre;
	private JButton retour;
	private JButton valider;
	private JComboBox<String> surfaceList;
	private JComboBox<String> pieceList;

	public Surface(InterfaceGraphique iG){
		super();
		this.setiG(iG);
		int height = this.getiG().getHeight();
		int width = this.getiG().getWidth();
		this.setLayout(null);
		Color color = new Color(116, 208, 241);
		this.setBackground(color);

		//JLabel Titre
		this.setTitre(new JLabel("Choix de la Surface"));
		this.getTitre().setBounds((width/2)-(200/3), (height/2)-(height/3), 200, 100);
		this.add(this.getTitre());

		//ComboBoxSurface
		String[] surfaceTitles = new String[] {"Carrelage","Parquet","Bois", "Faillance", "Tapisserie"};
		this.setSurfaceList(new JComboBox<>(surfaceTitles));
		this.getSurfaceList().setBounds((width/2)-(width/3), (height/3)+(height/8), 170, 50);
		this.add(this.getSurfaceList());

		//ComboBoxPiece
		String[] pieceTitles = new String[] {"Cuisine","Salle","Salle de Bain", "Toilette", "Chambre"};
		this.setPieceList(new JComboBox<>(pieceTitles));
		this.getPieceList().setBounds((width/2)+(width/3)-170,(height/3)+(height/8), 170, 50);
		this.add(this.getPieceList());
		
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

	public JComboBox<String> getSurfaceList() {
		return surfaceList;
	}

	public void setSurfaceList(JComboBox<String> surfaceList) {
		this.surfaceList = surfaceList;
	}

	public JComboBox<String> getPieceList() {
		return pieceList;
	}

	public void setPieceList(JComboBox<String> pieceList) {
		this.pieceList = pieceList;
	}
}
