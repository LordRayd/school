import java.util.ArrayList;
import java.io.*;
import java.lang.*;
	
	/**
	 * Instantiates and use the object ElevesBinaire
	 * @author S.LEBERRE - MARS 2016
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	public class ElevesBinaire{
		private String nom;
		private ArrayList<Evaluation> notes;
		
		/**
		 * Constructor of Student object
		 * @param nom the name of the student
		 */
		public ElevesBinaire(String nom){
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
			int coeffTotal = 0;
			for(Evaluation e : notes){
				ret = ret + e.getNote() * e.getCoeff();
				coeffTotal = coeffTotal + e.getCoeff();
			}
			ret = ret / coeffTotal;
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
			return ret;
		}
		
		/**
		 * Write the student object in binary in a text file
		 * @param fileName the name of the new file
		 */
		public void ecrireTexte(String fileName){
			try{
				FileOutputStream fos = new FileOutputStream(fileName+".txt");
				DataOutputStream dos = new DataOutputStream(fos);
				dos.writeUTF(this.nom);
				dos.writeInt(this.notes.size());
				for(Evaluation e : notes){
					dos.writeInt(e.getNote());
					dos.writeInt(e.getCoeff());
				}
				dos.close(); // Ne change rien a l ecriture
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		
		/**
		 * Read the text file in binary and give is values to a student object
		 * @param fileName the name of the file who contains the values
		 */
		public void lireTexte(String fileName){
			try{
				FileInputStream fis = new FileInputStream(fileName+".txt");
				DataInputStream dis = new DataInputStream(fis);
				this.nom = dis.readUTF();
				this.notes.clear();
				int nbNotes = dis.readInt();
				for(int y = 0;y< nbNotes;y++){
					Evaluation eval = new Evaluation(dis.readInt(),dis.readInt());
					this.addEvaluation(eval);
				}
				System.out.println(this.toRead());
				System.out.println("Moyenne : "+ this.getMoyenne());
				dis.close(); // Ne change rien a la lecture
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
