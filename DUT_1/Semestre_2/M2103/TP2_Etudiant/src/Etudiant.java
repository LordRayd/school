	/**
	 * Instantiates and use the object Student
	 * @author S.LEBERRE - JANVIER 2016
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	public class Etudiant {
		
		private String nom;
		private double[] notes;
		
		/**
		 * Instantiates a Student object
		 * @param nom the name of the student
		 * @param n the number of mark you want to give to the student
		 */
		public Etudiant(String nom, int n){
			if( nom != null && n > 0){
				this.nom = nom;
				this.notes = new double[n];
				initialisation();
			} else {
				System.out.println("The informations are not correct");
			}
		}
		
		/**
		 * Method who give us the name of the student
		 * @return the name of the student
		 */
		public String getNom(){
			return this.nom;
		}
		
		/**
		 * Change the name of the student by the name provide in parameter
		 * @param n the new name of the student
		 */
		public void setNom(String n){
			if(n != null){
				this.nom = n;
			}
		}
		
		/**
		 * Method who give us the number of marks in the table
		 * @return the number of marks in the table
		 */
		public int getNbNotes(){
			int nbNotes = -1;
			if(this.notes.length > 0){
				nbNotes = this.notes.length;
			}
			return nbNotes;
		}
		
		/**
		 * Return a value stock in the marks table
		 * @param i the index where the value is stock in the table
		 * @return the value in the table at the index i
		 */
		public double getUneNote(int i){
			double ret = -1.0;
			if( i < this.notes.length && i >= 0 && this.notes != null && this.getNbNotes() != 0){
				ret = this.notes[i];
			} else {
				System.out.println("the param i or the table is false");
			}
			return ret;
		}
		
		/**
		 * Initializes the marks table
		 */
		private void initialisation(){
			if(this.notes != null && this.getNbNotes() != 0){
				for(int i=0; i < this.notes.length;i++){
					this.notes[i] = Math.random() * 20;
					this.notes[i] = (double)Math.round(this.notes[i]*10)/10;
				}
			}
		}
		
		/**
		 * Give to us the average of the marks
		 * @return the average of the marks
		 */
		public double moyenne(){
			double ret = -1;
			if(this.notes != null && this.getNbNotes() != 0){
				ret = 0;
				for(int i=0; i<this.notes.length; i++){
					ret = ret + this.notes[i];
				}
				ret = ret / this.notes.length;
				ret = (double) Math.round(ret*10)/10;
			}
			return ret;
		}
		
		/**
		 * Give the student object in a string chain
		 */
		public String toString(){
			String ret;
			if(this.nom != null){
				ret = "Student: " + this.nom + " .";;
			} else {
				ret = "He doesn't have a name";
			}
			if(this.notes != null && this.getNbNotes() != 0){
				ret = ret + "\nMarks:";
				for(int i = 0; i < this.notes.length; i++){
					ret = ret + " " + this.notes[i] + ",";
				}
			} else {
				ret = ret + "\nThis student doesn't have any mark";
			}
			return ret;
		}
	}
