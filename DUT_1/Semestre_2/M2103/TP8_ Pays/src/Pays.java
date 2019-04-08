package pays;

	/**
	 * The Class Pays
	 * @author S.LEBERRE - AVRIL 2017
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	 public class Pays implements Comparable<Pays>{
		 
		 private String nom;
		 private double surface;
		 private double population;
		 
		 /**
		  * Constructor of Pays object
		  * @param nom The name pf the Pays
		  * @param population The number of people in the country
		  * @param surface the area of the country
		  */
		 public Pays(String nom,double population,double surface){
			 if(nom != null){
				 this.nom = nom;
			 }else{
				 System.out.println("ERROR : Nom PAYS");
			 }
			 if(surface > 0){
				 this.surface = surface;
			 }else{
				 System.out.println("ERROR : Surface PAYS");
			 }
			 if(population > 0){
				 this.population = population;
			 }else{
				 System.out.println("ERROR : Population PAYS");
			 }
		 }
		 
		 /**
		  * Get the name of the Pays object
		  * @return the name of the Pays
		  */
		 public String getNom(){
			return this.nom;
		 }
		 
		 /**
		  * Give a new name to the Pays object
		  * @param nom The new name of the Pays
		  */
		 public void setNom(String nom){
			 if(nom!=null){
				 this.nom = nom;
			 }else{
				 System.out.println("ERROR : Nom SETNOM");
			 }
		 }
		 
		 /**
		  * Get the surface of the Pays object
		  * @return The surface of the Pays object
		  */
		 public double getSurface(){
			return this.surface;
		 }
		 
		 /**
		  * Give a new surface to the Pays object
		  * @param surface The new surface of the Pays object
		  */
		 public void setSurface(double surface){
			 if(surface > 0){
				 this.surface = surface;
			 }else{
				 System.out.println("ERROR : Surface SETSURFACE");
			 }
		 }

		 /**
		  * Get the number of people who live in the country
		  * @return The number of people
		  */
		public double getPopulation(){
			return this.population;
		}

		/**
		 * Give a new number of people to the Pays object 
		 * @param population The new number of the population
		 */
		public void setPopulation(double population){
			if(population > 0){
				this.population = population;
			}else{
				System.out.println("ERROR : Population SETPOPULATION");
			}
		}

		/**
		 * Give a String who represant the Pays object
		 * @return a string who descibe the Pays object
		 */
		public String toString(){
			String ret = "\nNom : " + this.nom;
			ret = ret + "\nSurface : " + this.surface;
			ret = ret + "\nPopulation : " + this.population;
			return ret;
		}

		/**
		 * Compare two Pays object
		 * @param p the Pays object you want to compare with
		 * @return 1 if the first Pays is bigger than the second and -1 if it's the opposite
		 */
		public int compareTo(Pays p){
			int ret = 0;
			if(p != null){
				if(this.getSurface() > p.getSurface()){
					ret = 1;
				}else if(this.getSurface() < p.getSurface()){
					ret = -1;
				}
			}else{
				System.out.println("ERROR : p COMPARETO");
			}
			return ret;
		}
	 }
