package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class InterfaceGraphique extends JFrame {

	private JPanel panelVisible;
	private Accueil accueil;
	private Surface surface;
	private Quantite quantite;
	private MesOutils mesOutils;
	private MesUstensils mesUstensils;
	private MesProduits mesProduits;
	private AuMagasin auMagasin;
	private Acheter acheter;
	private Parametre parametre;
	private NettoyageEnCours nettoyageEnCours;
	
	public InterfaceGraphique(String nom){
		super();
		this.initComponents(nom);
	}

	private void initComponents(String nom){
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle(nom);
		setSize(1000,500);
		setLayout(new BorderLayout());

		// Accueil
		this.setAccueil(new Accueil(this));

		//Surface
		this.setSurface(new Surface(this));

		//Quantite
		this.setQuantite(new Quantite(this));

		//MesOutils
		this.setMesOutils(new MesOutils(this));

		//MesUstensils
		this.setMesUstensils(new MesUstensils(this));

		//MesProduits
		this.setMesProduits(new MesProduits(this));
		
		//AuMagasin
		this.setAuMagasin(new AuMagasin(this));
		
		//Acheter
		this.setAcheter(new Acheter(this));

		//Parametre
		this.setParametre(new Parametre(this));
		
		//NettoyageEnCours
		this.setNettoyageEnCours(new NettoyageEnCours(this));

		this.setPanelVisible(this.getAccueil());
		add(this.getPanelVisible());
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public JPanel getPanelVisible() {
		return panelVisible;
	}

	public void setPanelVisible(JPanel panelVisible) {
		this.panelVisible = panelVisible;
	}

	public Accueil getAccueil() {
		return accueil;
	}

	public void setAccueil(Accueil accueil) {
		this.accueil = accueil;
	}

	public Surface getSurface() {
		return surface;
	}

	public void setSurface(Surface surface) {
		this.surface = surface;
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

	public MesUstensils getMesUstensils() {
		return this.mesUstensils;
	}

	public void setMesUstensils(MesUstensils mesUstensils) {
		this.mesUstensils = mesUstensils;
	}

	public MesProduits getMesProduits() {
		return mesProduits;
	}

	public void setMesProduits(MesProduits mesProduits) {
		this.mesProduits = mesProduits;
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

	public NettoyageEnCours getNettoyageEnCours() {
		return nettoyageEnCours;
	}

	public void setNettoyageEnCours(NettoyageEnCours nettoyageEnCours) {
		this.nettoyageEnCours = nettoyageEnCours;
	}
}
