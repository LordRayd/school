import java.util.ArrayList;

/** Classe eleve
 * Classe Interface graphique
 * @author Furno - Le Berre -- Groupe A
 * @version 1.0
 */
public class Eleve {

	private String nom;
	private ArrayList<Evaluation> notes;
	private boolean sexe;
	private String prenom;
	private String courriel;
	private boolean annee1;
	private boolean annee2;
	private String dateDeNaissance;
	
	/**
	 * Constructor of Student object
	 * @param nom the name of the student
	 */
	public Eleve(String nom, String prenom, String date, String courriel, boolean sexe,boolean annee1 , boolean annee2){
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = date;
		this.courriel = courriel;
		this.sexe = sexe;
		this.annee1 = annee1;
		this.annee2 = annee2;
		notes = new ArrayList<Evaluation>();
	}
	
	/**
	 * Give us the name of the student
	 * @return the name of the student
	 */
	public String getNom(){
		return this.nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Add an evaluation to the ArrayList notes only if the param is not null
	 * @param note the evaluation you want to add to the marks
	 */
	public void addEvaluation(Evaluation note){
		if(note != null){
			this.notes.add(note);
		}
	}
	
	/**
	 * Give the average of the student with is marks and their coefficient
	 * @return the average of the student
	 */
	public double getMoyenne(){
		double ret = 0;
		int coefTotal = 0;
		for(Evaluation e : notes){
			ret = ret + e.getNote() * e.getCoeff();
			coefTotal = coefTotal + e.getCoeff();
		}
		ret = ret / coefTotal;
		ret = (double) Math.round(ret*10)/10;
		return ret;
	}
	
	public ArrayList<Evaluation> getNotes() {
		return notes;
	}
	
	public void setNotes(ArrayList<Evaluation> notes) {
		this.notes = notes;
	}

	public boolean isSexe() {
		return sexe;
	}

	public void setSexe(boolean sexe) {
		this.sexe = sexe;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCourriel() {
		return courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	public boolean isAnnee1() {
		return annee1;
	}

	public void setAnnee1(boolean annee1) {
		this.annee1 = annee1;
	}

	public boolean isAnnee2() {
		return annee2;
	}

	public void setAnnee2(boolean annee2) {
		this.annee2 = annee2;
	}

	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
}
