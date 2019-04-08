import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class InterfaceGraphique extends JFrame {

	private Accueil accueil;
	private FaireLeMenage faireMenage;
	private Quantite quantite;
	private MesOutils mesOutils;
	private Ustensils ustensils;
	private Produits produits;
	private AuMagasin auMagasin;
	private Acheter acheter;
	private Parametre parametre;
	
	public static void main (String[] args){
		java.awt.EventQueue.invokeLater(new Runnable(){
			public void run(){
				new InterfaceGraphique("Fait le menage");
			}
		});
	}
	
	public InterfaceGraphique(String nom){
		super();
		this.initComponents(nom);
	}
	
	private void initComponents(String nom){
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle(nom);
		setSize(1000,500);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new BorderLayout());
		this.setAccueil(new Accueil(this));
		this.setFaireMenage(new FaireLeMenage(this));
		this.setQuantite(new Quantite(this));
		setContentPane(this.getAccueil());
		repaint();
	}

	public Accueil getAccueil() {
		return accueil;
	}

	public void setAccueil(Accueil accueil) {
		this.accueil = accueil;
	}

	public FaireLeMenage getFaireMenage() {
		return faireMenage;
	}

	public void setFaireMenage(FaireLeMenage faireMenage) {
		this.faireMenage = faireMenage;
	}

	public Quantite getQuantite() {
		return quantite;
	}

	public void setQuantite(Quantite quantite) {
		this.quantite = quantite;
	}

	public MesOutils getMesOutils() {
		return mesOutils;
	}

	public void setMesOutils(MesOutils mesOutils) {
		this.mesOutils = mesOutils;
	}

	public Ustensils getUstensils() {
		return ustensils;
	}

	public void setUstensils(Ustensils ustensils) {
		this.ustensils = ustensils;
	}

	public Produits getProduits() {
		return produits;
	}

	public void setProduits(Produits produits) {
		this.produits = produits;
	}

	public AuMagasin getAuMagasin() {
		return auMagasin;
	}

	public void setAuMagasin(AuMagasin auMagasin) {
		this.auMagasin = auMagasin;
	}

	public Acheter getAcheter() {
		return acheter;
	}

	public void setAcheter(Acheter acheter) {
		this.acheter = acheter;
	}

	public Parametre getParametre() {
		return parametre;
	}

	public void setParametre(Parametre parametre) {
		this.parametre = parametre;
	}
	
	
}
