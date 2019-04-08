
	/**
	 * Instantiates and use the object Student
	 * @author S.LEBERRE - JANVIER 2016
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	public class Promotion {
		
		private String nom;
		private Etudiant[] listeEtudiant;
		private int nbEtudiantMax;
		private int nbEtudiant;
		
		/**
		 * Instantiates a Promotion object
		 * @param nom the name of the promotion
		 * @param liste an array of student
		 */
		public Promotion(String nom, Etudiant[] liste){
			if(nom == null && liste == null){
				this.nom = "inconnu";
				this.listeEtudiant = new Etudiant[0];
				this.nbEtudiant = 0;
			}else if(nom == null){
				this.nom = "inconnu";
				this.listeEtudiant = liste;
				this.nbEtudiant = this.listeEtudiant.length;
			}else if(liste == null){
				this.nom = nom;
				this.listeEtudiant = new Etudiant[0];
				this.nbEtudiant = 0;
			}else {
				this.nom = nom;
				this.listeEtudiant = liste;
				this.nbEtudiant = this.listeEtudiant.length;
			}
		}
		
		/**
		 * Instantiates a Promotion object
		 *@param nom the name of the promotion
		 *@param n the number max of student
		 */
		public Promotion(String nom, int n){
			if(nom == null && n == 0){
				this.nom = "inconnu";
				this.listeEtudiant = new Etudiant[0];
				this.nbEtudiantMax = 0;
			}else if(nom == null){
				this.nom = "inconnu";
				this.listeEtudiant = new Etudiant[n];
				this.nbEtudiantMax = n;
			}else if(n == 0){
				this.nom = nom;
				this.listeEtudiant = new Etudiant[0];
				this.nbEtudiantMax = 0;
			}else {
				this.nom = nom;
				this.listeEtudiant = new Etudiant[n];
				this.nbEtudiantMax = n;
			}	

		}

		/**
		 * Method who give us the name of the promotion
		 * @return the name of the promotion
		 */
		public String getNom(){
			String ret = "FALSE";
			if(this.nom != null){
				ret = this.nom;
			}
			return ret;
		}
		
		/**
		 * Change the name of the promotion by the name provide in parameter
		 * @param n the new name of the promotion
		 */
		public void setNom(String n){
			if(n != null){
				this.nom = n;
			} else {
				System.out.println("Parametre non valide");
			}
		}
		
		/**
		 *Add a student to a promotion
		 *@param student the student add to the promotion
		 */
		public void addStudent(Etudiant student){
			if(this.nbEtudiant + 1 > this.nbEtudiantMax){
				System.out.println("Le tableau est plein.");
			} else if(this.nbEtudiant== 0){
				this.listeEtudiant[0] = student;
				this.nbEtudiant += 1;
			} else {
				this.listeEtudiant[this.nbEtudiant] = student;
				this.nbEtudiant += 1;
			}

		}

		/**
		 * Give to us the average of the marks of the promotion
		 * @return the average of the marks
		 */
		public double moyenne(){
			double ret = -1;
			if(this.listeEtudiant != null && this.nbEtudiant > 0){
				ret = 0;
				for(int i =0; i < this.nbEtudiant; i++){
					ret += this.listeEtudiant[i].moyenne();
				}
				ret = ret / this.listeEtudiant
				.length;
				ret = (double) Math.round(ret*10)/10;
			} else {
				System.out.println("Param faux");
			}
			return ret;
		}
		
		/**
		 * Give to us the best average of the marks of the promotion
		 * @return the average of the marks
		 */
		public double moyenneMax(){
			double ret = -1;
			if(this.listeEtudiant != null && this.listeEtudiant.length > 0){
				ret = this.listeEtudiant[0].moyenne();
				for(int i =1; i < this.nbEtudiant; i++){
					if(this.listeEtudiant[i].moyenne() > ret){
						ret = this.listeEtudiant[i].moyenne();
					}
				}
			} else {
				System.out.println("Param faux");
			}
			return ret;
		}
		
		/**
		 * Give to us the worst average of the marks of the promotion
		 * @return the average of the marks
		 */
		public double moyenneMin(){
			double ret = -1;
			if(this.listeEtudiant != null && this.listeEtudiant.length > 0){
				ret = this.listeEtudiant[0].moyenne();
				for(int i =1; i < this.nbEtudiant; i++){
					if(this.listeEtudiant[i].moyenne() < ret){
						ret = this.listeEtudiant[i].moyenne();
					}
				}
			} else {
				System.out.println("Param faux");
			}
			return ret;
		}
		
		/**
		 * Give to us the major of the promotion
		 * @return the student object who have the best average
		 */
		public Etudiant getMajor(){
			Etudiant major = null;
			if(this != null && this.listeEtudiant != null && this.listeEtudiant.length > 0){
				major = this.listeEtudiant[0];
				for(int i=1; i < this.nbEtudiant; i++){
					if ( major.moyenne() < this.listeEtudiant[i].moyenne()){
						major = this.listeEtudiant[i];
					}
				}
			}
			return major;
		}
		
		
		/**
		 * Give the promotion object in a string chain
		 * @return the describ of the promotion
		 */
		public String toString(){
			String ret;
			if(this.nom != null){
				ret = "\nLa promotion s'appelle : " + this.nom;
			} else {
				ret = "this promotion doesn't have a name";
			}
			if(this.listeEtudiant != null && this.nbEtudiant > 0){
				ret += "\n";
				for(int i = 0; i < this.nbEtudiant; i++){
					ret += this.listeEtudiant[i].toString() + "\n";
				}
			} else {
				ret += "This promotion doesn't have any student\n";
			}
			Etudiant major = this.getMajor();
			String nomMajor = major.getNom();
			ret += "The major of the promotion is " + nomMajor + " with an average of " + this.moyenneMax();
			ret += "\nThe worst student have an average of " + this.moyenneMin();
			return ret;
		}
	}
