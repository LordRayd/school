import java.util.ArrayList;
import java.io.*;
import java.lang.*;

	/**
	 * Instantiates and use the object Eleves
	 * @author S.LEBERRE - MARS 2016
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	public class Eleves {
		private String nom;
		private ArrayList<Evaluation> notes;
	
		/**
		 * Constructor of Student object
		 * @param nom the name of the student
		 */
		public Eleves(String nom){
			if(nom != null){
				this.nom = nom;
			}else{
				System.out.println("ERROR : NOM NULL");
			}
			notes = new ArrayList<Evaluation>();
		}
		
		/**
		 * Give us the name of the student
		 * @return the name of the student
		 */
		public String getNom(){
			return this.nom;
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
		
		/**
		 * Describ the student with a String to write it
		 * @return a String who describ the student to write it
		 */
		public String toWrite(){
			String ret =  this.nom;
			ret = ret + "\n" + this.notes.size();
			for(Evaluation e : notes){
				ret = ret + "\n" + e.getNote() + "\n" + e.getCoeff();
			}
			return ret;
		}
		
		/**
		 * Describ the student with a String to read it
		 * @return a String who describ the student to read it
		 */
		public String toRead(){
			String ret =  "\nNom : " + this.nom;
			ret = ret + "\nNombre de notes : " + this.notes.size();
			for(Evaluation e : notes){
				ret = ret + "\nNotes : " + e.getNote() + "\nCoefficient : " + e.getCoeff();
			}
			//ret = ret + "\nMoyenne : " + this.getMoyenne
			return ret;
		}
		
		/**
		 * Write the student object in a text file
		 * @param fileName the name of the new file
		 */
		public void ecrireTexte(String fileName){
			try{
				FileWriter fw = new FileWriter (fileName+".txt");
				PrintWriter pw = new PrintWriter (fw	);
				pw.println(this.toWrite());//+"\nMoyenne : "+this.moyenne());
				pw.close(); // Ne change rien a l ecriture
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		
		/**
		 * Read the text file and give is values to a student object
		 * @param fileName the name of the file who contains the values
		 */
		public void lireTexte(String fileName){
			try{
				FileReader fr = new FileReader (fileName+".txt");
				BufferedReader bf = new BufferedReader(fr);
				this.nom = bf.readLine();
				this.notes.clear();
				int nbNotes = Integer.parseInt(bf.readLine());
				for(int i = 0;i< nbNotes;i++){
					Evaluation eval = new Evaluation(Integer.parseInt(bf.readLine()),Integer.parseInt(bf.readLine()));
					this.addEvaluation(eval);
				}
				System.out.println(this.toRead());
				System.out.println("Moyenne : "+ this.getMoyenne());
				bf.close(); // Ne change rien a la lecture
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
