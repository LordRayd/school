package pays;

/**
 * Class Pays
 * @author G.BOURHIS
 * @version 1.0
 */
public class Pays implements Comparable<Pays>{
  private String nom;
  private double surface;
  private double population;

	/**
	 * constructor Pays
	 * @param nom the name of the country
	 * @param surface the area covered by the coutry
	 * @param population the number of inhabitants of that country
	 * */

  public Pays(String nom, double surface, double population){
    if((nom != null)){
      this.nom = nom;
      this.surface = surface;
      this.population = population;
    }else{
      System.out.println("Erreur : paramètres pays invalides");
      this.nom = "";
      this.surface = 0;
      this.population = 0;
    }
  }


	/**
	 * method compareTo
	 * compares two areas of two countries
	 * @param o the other country compared
	 * @return ret which says if the area is lower, equal or higher than the compared country
	 * */
  public int compareTo(Pays o){
    int ret = 0;
    if(o != null){
      if(this.surface == o.getSurface()){
        ret = 0;
      }
      if(this.surface < o.getSurface()){
        ret = -1;
      }
      if(this. surface > o.getSurface()){
        ret = 1;
      }
    }else{
        System.out.println("Erreur : paramètres compareTo invalides");
        ret = 0;
    }
    return ret;
  }

  /**
   * getter getNom
   * @return nom the name of the country
   * */
  public String getNom(){
    return this.nom;
  }

  /**
   * setter setNom
   * @param nom the new name of the country
   * */
  public void setNom(String nom){
    if(nom != null){
      this.nom = nom;
    }else{
        System.out.println("Erreur : paramètres setNom invalides");
    }
  }

  /**
   * getter getSurface
   * @return surface the area of the country
   * */
    public double getSurface(){
      return this.surface;
    }

    /**
     * setter setSurface
     * @param surface the new area of the country
     * */
    public void setSurface(double surface){
      if(surface > 0 ){
        this.surface = surface;
      }else{
          System.out.println("Erreur : paramètres setSurface invalides");
      }
    }

    /**
     * getter getPopulation
     * @return population the population of the country
     * */
      public double getPopulation(){
        return this.population;
      }

      /**
       * setter setPopulation
       * @param population the new population of the country
       * */
      public void setPopulation(double population){
        if(population != 0){
          this.population = population;
        }else{
            System.out.println("Erreur : paramètres setPopulation invalides");
        }
      }

      /**
       * method toString
       * show the different attributes of Pays
       * @return ret
       * */
      public String toString(){
        return "nom : "+this.getNom()+"\tpopulation : "+this.getPopulation()+"\tsurface : "+this.getSurface()+"\n";
      }
}
