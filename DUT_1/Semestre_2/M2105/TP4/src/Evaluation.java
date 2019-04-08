/**
 * Classe Evaluation
 * @author Furno - Le Berre -- Groupe A
 * @version 1.0
 */
public class Evaluation {

	private int coeff;
	private int note;
	
	/**
	 * Constructor of the mark
	 * @param note the mark 
	 * @param coefficient the coefficient of the mark
	 */
	public Evaluation(int note, int coefficient){
		if(note <= 20 && note >= 0){
			this.note = note;
		}else{
			this.note = 0;
			System.out.println("ERROR : NOTE MANQUANT");
		}
		if(coefficient >= 0 && coefficient <= 10){
			this.coeff = coefficient;
		}else{
			System.out.println("ERROR : COEFF MANQUANT");
			this.coeff = 0;
		}
	}
	
	/**
	 * Give us the mark
	 * @return The mark
	 */
	public int getNote(){
		return this.note;
	}
	
	/**
	 * Give us the coefficient of the mark
	 * @return The coefficient of the mark
	 */
	public int getCoeff(){
		return this.coeff;
	}
}
