	/**
	 *
	 */
	public class Etudiant {
		//
		private String nom;
		private double[] notes;
		
		/**
		 * 
		 * @param nom the name of the student
		 * @param n the number of mark you want to give to the student
		 */
		public Etudiant(String nom, int n){
			if( nom != null && n > 0){
				this.nom = nom;
				this.notes = new double[n];
				initialisation();
			}
		}
		
		/**
		 * 
		 * @return 
		 */
		public String getNom(){
			return this.nom;
		}
		
		/**
		 * 
		 * @param n 
		 */
		public void setNom(String n){
			if(n != null){
				this.nom = n;
			}
		}
		
		/**
		 * 
		 * @return 
		 */
		public int getNbNotes(){
			int nbNotes = -1;
			if(this.notes.length > 0){
				nbNotes = this.notes.length;
			}
			return nbNotes;
		}
		
		/**
		 * 
		 * @param 
		 * @return 
		 */
		public double getUneNote(int i){
			double ret = -1.0;
			if( i < this.notes.length && i >= 0 && this.notes != null && getNbNotes() != 0){
				ret = this.notes[i];
			}
			return ret;
		}
		
		/**
		 * 
		 */
		private void initialisation(){
			if(this.notes != null && getNbNotes() != 0){
				for(int i=0; i < this.notes.length;i++){
					this.notes[i] = Math.random() * 20;
				}
			}
		}
		
		/**
		 * 
		 */
		public double moyenne(){
			double ret = -1;
			if(this.notes != null && getNbNotes() != 0){
				for(int i=0; i<this.notes.length; i++){
					ret = ret + this.notes[i];
				}
				ret = ret / this.notes.length;
				ret = (double)Math.round(ret*10/10);
			}
			return ret;
		}
		
		/**
		 * 
		 * 
		 */
		public String toString(){
			String ret;
			if(this.nom != null){
				ret = "Student:" + this.nom + ".";;
			} else {
				ret = "He doesn't have a name";
			}
			if(this.notes != null && getNbNotes() != 0){
				ret = ret + "\nMarks";
				for(int i = 0; i < this.notes.length; i++){
					ret = ret + " " + this.notes[i] " ,";
				}
			} else {
				ret = ret + "\nThis student doesn't have any mark";
			}
			return ret;
		}
	}
