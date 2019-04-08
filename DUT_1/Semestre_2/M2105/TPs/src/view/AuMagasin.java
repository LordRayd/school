package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.ButtonControler;

public class AuMagasin extends JPanel {

	private InterfaceGraphique iG;
	private JLabel titre;
	private JLabel message1;
	private JLabel message2;
	private JButton retour;
	private JButton valider;
	private JCheckBox aCB;
	private JCheckBox bCB;
	private JCheckBox cCB;
	private JCheckBox dCB;
	private JCheckBox eCB;
	private JCheckBox fCB;

	public AuMagasin(InterfaceGraphique iG){
		super();
		this.setiG(iG);
		int height = this.getiG().getHeight();
		int width = this.getiG().getWidth();
		this.setLayout(null);
		Color color = new Color(116, 208, 241);
	    this.setBackground(color);

		//JLabel Titre
		this.setTitre(new JLabel("Au Magasin"));
		this.getTitre().setBounds((width/2)-(200/3), (height/2)-(height/3), 200, 100);
		this.add(this.getTitre());

		//JLabel Message1
		this.setMessage1(new JLabel("Attention il vous manque ou va vous manquez les objets suivants"));
		this.getMessage1().setBounds((width/2)-(400/2),((height/2)-(height/4)), 400, 100);
		this.add(this.getMessage1());

		//JLabel Message2
		this.setMessage2(new JLabel("Une fois les produits achetés cochez la cases les concernants et valider : "));
		this.getMessage2().setBounds((width/2)-(width/3),(height-(height/4))-(200/3), 500, 100);
		this.add(this.getMessage2());

		//JcheckBox aCB
		this.setaCB(new JCheckBox("Produit1"));
		this.getaCB().setBounds((width/2)-(width/3),(height/2)-(50/2), 100, 50);
		this.getaCB().setBackground(color);
		this.add(this.getaCB());
		//JcheckBox bCB
		this.setbCB(new JCheckBox("Produit2"));
		this.getbCB().setBounds((width/2)-(100/2), (height/2)-(50/2), 100, 50);
		this.getbCB().setBackground(color);
		this.add(this.getbCB());
		//JcheckBox cCB
		this.setcCB(new JCheckBox("Produit3"));
		this.getcCB().setBounds((width/2)+(width/5), (height/2)-(50/2), 100, 50);
		this.getcCB().setBackground(color);
		this.add(this.getcCB());
		//JcheckBox dCB
		this.setdCB(new JCheckBox("Produit4"));
		this.getdCB().setBounds((width/2)-(width/3), (height/2)+(50/2), 100, 50);
		this.getdCB().setBackground(color);
		this.add(this.getdCB());
		//JcheckBox eCB
		this.seteCB(new JCheckBox("Produit5"));
		this.geteCB().setBounds((width/2)-(100/2), (height/2)+(50/2), 100, 50);
		this.geteCB().setBackground(color);
		this.add(this.geteCB());
		//JcheckBox fCB
		this.setfCB(new JCheckBox("Produit6"));
		this.getfCB().setBounds((width/2)+(width/5), (height/2)+(50/2), 100, 50);
		this.getfCB().setBackground(color);
		this.add(this.getfCB());

		// JButton Retour
		this.setRetour(new JButton("Retour"));
		this.getRetour().addActionListener(new ButtonControler(this.getiG()));
		this.getRetour().setBounds(0, 0, 150, 50);
		this.add(this.getRetour());

		//JButton Valider
		this.setValider(new JButton("Valider"));
		this.getValider().addActionListener(new ButtonControler(this.getiG()));
		this.getValider().setBounds((width/2)+(width/4),(height-(height/4))-50, 150, 50);
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

	public JLabel getMessage1() {
		return message1;
	}

	public void setMessage1(JLabel message1) {
		this.message1 = message1;
	}

	public JLabel getMessage2() {
		return message2;
	}

	public void setMessage2(JLabel message2) {
		this.message2 = message2;
	}

	public JCheckBox getaCB() {
		return aCB;
	}

	public void setaCB(JCheckBox aCB) {
		this.aCB = aCB;
	}

	public JCheckBox getbCB() {
		return bCB;
	}

	public void setbCB(JCheckBox bCB) {
		this.bCB = bCB;
	}

	public JCheckBox getcCB() {
		return cCB;
	}

	public void setcCB(JCheckBox cCB) {
		this.cCB = cCB;
	}

	public JCheckBox getdCB() {
		return dCB;
	}

	public void setdCB(JCheckBox dCB) {
		this.dCB = dCB;
	}

	public JCheckBox geteCB() {
		return eCB;
	}

	public void seteCB(JCheckBox eCB) {
		this.eCB = eCB;
	}

	public JCheckBox getfCB() {
		return fCB;
	}

	public void setfCB(JCheckBox fCB) {
		this.fCB = fCB;
	}
}
