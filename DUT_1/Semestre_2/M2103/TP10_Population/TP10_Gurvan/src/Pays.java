package pays;

/**
 * This class will implements Comparable (interface pre-made)
 * This will make countries item with Name, Surface and population
 * @author LORANS G.
 * @version 1.0
 */
public class Pays implements Comparable<Pays>{
	//This attribute will add name to items
	private String nom;
	//This attribute will add surface to items
	private double surface;
	//This attribute will add population to items
	private double population;

	/**
	 * This is the construction it needs name, surface and population
	 * @param nom The name of the country
	 * @param surface The surface of the country
	 * @param population The population of the country
	 *
	 */
	public Pays(String nom, double surface, double population){
		if(nom != null){
			this.nom = nom;
		}else{
			this.nom = "ERROR";
			System.out.println("ERROR : Name Country");
		}
		if(surface >= 0){
			this.surface = surface;
		}else{
			this.surface = 0;
			System.out.println("ERROR : Surface < 0");
		}
		if(population >= 0){
			this.population = population;
		}else{
			this.population = 0;
			System.out.println("ERROR : Population < 0");
		}
	}

	/**
	 * This is a getter for the name attribute
	 * @return a String that corresponds to the name of the country
	 *
	 */
	public String getNom(){
		return this.nom;
	}

	/**
	 * This procedure will changes the values of the name attribute
	 * @param nom It will be the new values to store into the attribute
	 */
	public void setNom(String nom){
		if (nom != null){
			this.nom = nom;
		}else{
			this.nom = "ERROR";
			System.out.println("ERROR : Name Incorrect");
		}
	}

	/**
	 * This is a getter for the Surface attribute
	 * @return a double that corresponds to the Surface of the country
	 */
	public double getSurface(){
		return this.surface;
	}


	/**
	 * This procedure will changes the values of the surface attribute
	 * @param surface It will be the new values to store into the attribute
	 */
	public void setSurface(double surface){
		if (surface >= 0){
			this.surface = surface;
		}else{
			this.surface = 0;
			System.out.println("ERROR : Surface Incorrect");
		}
	}


	/**
	 * This is a getter for the population attribute
	 * @return a double that corresponds to the population of the country
	 */
	public double getPopulation(){
		return this.population;
	}


	/**
	 * This procedure will changes the values of the population attribute
	 * @param population It will be the new values to store into the attribute
	 */
	public void setPopulation(double population){
		if (population >= 0){
			this.population = population;
		}else{
			this.population = 0;
			System.out.println("ERROR : Population Incorrect");
		}
	}

	/**
	 * This is a toString method, it will changes values of the object into string to permit to print it
	 * @return the String values of the object
	 */
	public String toString(){
		return "\n> Nom : "+this.nom+", Surface : "+this.surface+", Population : "+this.population;
	}

	/**
	 * This method will compare 2 objects,
	 * @param p it will be the second object to compare
	 * @return if the current object is bigger than the object puts in parameter, it will return 1, else it will print -1, if the surface of the two objects are in equalité it will prints 0
	 *
	 */
	public int compareTo(Pays p){
		int res = 0;
		if(this.surface > p.getSurface()){
			res = 1;
		}
		if(this.surface < p.getSurface()){
			res = -1;
		}
		return res;
	}

}
