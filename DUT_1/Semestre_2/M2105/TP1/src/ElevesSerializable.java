import java.util.ArrayList;
import java.io.*;
import java.lang.*;

	/**
	 * Instantiates and use the object ElevesSerializable
	 * @author S.LEBERRE - MARS 2016
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	public class ElevesSerializable implements Serializable{
		private String nom;
		private ArrayList<Evaluation> notes;
	
		/**
		 * Constructor of Student object
		 * @param nom the name of the student
		 */
		public ElevesSerializable(String nom){
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
		 * Describ the student with a String
		 * @return a String who describ the student
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
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				this.writeObject(oos);
				oos.close(); // Ne change rien a l ecriture
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
				ObjectInputStream ois = new ObjectInputStream(fis);
				this.readObject(ois);
				ois.close(); // Ne change rien a la lecture
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}

		/**
		 * Read the specified object to the ObjectInputStream.
		 * @param stream the ObjectInputStream
		 * @throws IOException Any exception thrown by the underlying OutputStream.
		 * @throws ClassNotFoundException Any exception that was raised if an error occurred while attempting to load the class.
		 */
		private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException{
			this.nom = stream.readUTF();
			this.notes.clear();
			int nbNotes = stream.readInt();
			for(int y = 0;y< nbNotes;y++){
				Evaluation eval = new Evaluation(stream.readInt(),stream.readInt());
				this.addEvaluation(eval);
			}
			System.out.println(this.toRead());
			System.out.println("Moyenne : "+ this.getMoyenne());
		}

		/**
		 * Write the specified object to the ObjectOutputStream.
		 * @param stream the ObjectOutputStream
		 * @throws IOException Any exception thrown by the underlying OutputStream.
		 */
 		private void writeObject(java.io.ObjectOutputStream stream) throws IOException{
 			stream.writeUTF(this.nom);
			stream.writeInt(this.notes.size());
			for(Evaluation e : notes){
				stream.writeInt(e.getNote());
				stream.writeInt(e.getCoeff());
			}
 		}

 		/**
 		 * The readObjectNoData method is responsible for initializing the state of the object for its particular class in the event that the serialization stream does not list the given class as a superclass of the object being deserialized. 
 		 * This may occur in cases where the receiving party uses a different version of the deserialized instance's class than the sending party, and the receiver's version extends classes that are not extended by the sender's version. 
 		 * This may also occur if the serialization stream has been tampered; hence, readObjectNoData is useful for initializing deserialized objects properly despite a "hostile" or incomplete source stream.
 		 * @throws ObjectStreamException All exceptions specific to Object Stream classes.
 		 */
 		private void readObjectNoData() throws ObjectStreamException{
 		}
	}
