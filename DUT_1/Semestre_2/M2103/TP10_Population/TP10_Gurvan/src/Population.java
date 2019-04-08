package pays;

//-------ALL IMPORT FOR THIS CLASS ---------
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import tri.*;
//------------------------------------------

/**
 * This class will make a population with countries
 * @author LORANS G.
 * @version 1.0
 */
public class Population{
  //This attribute will store all countries
  private ArrayList<Pays> listePays;
  //this attribute will store countries name's and population
  private HashMap<String, Double> popMap;
  //this attribute will store countries name's and area
  private HashMap<String, Double>  areaMap;
  //this attribute will store countries name's and density
  private HashMap<String, Double>  densityMap;


  /**
   * This is the constructor it will make a population
   * @param popFileName the file where is store all populations
   * @param areaFileName the file where is store all areas
   */
  public Population(String popFileName, String areaFileName){

    if(popFileName != null){
      initialisePopMap(popFileName);
    }else{
      System.out.println("ERROR : File does not exist");
      popMap = new HashMap<String, Double>();
    }

    if(areaFileName != null){
      initialiseAreaMap(areaFileName);
    }else{
      System.out.println("ERROR : File does not exist");
      areaMap = new HashMap<String, Double>();
    }
    if(!areaMap.isEmpty() && !popMap.isEmpty()){
      listePays = new ArrayList<Pays>();
      initialiseListePays();
    }else{
      System.out.println("ERROR : HashMap Incorect");
    }

    initialiseDensityMap();
  }

  /**
   * This is the getter it will return the attribute popMap
   * @return the attribute pop map
   */
  public HashMap<String, Double> getPopMap(){
    return this.popMap;
  }

  /**
    * This is the getter it will return the attribute areaMap
    * @return the attribute area map
    */
  public HashMap<String, Double> getAreaMap(){
    return this.areaMap;
  }

  /**
    * This is the getter it will return the attribute densityMap
    * @return the attribute area map
    */
  public HashMap<String, Double> getDensityMap(){
    return this.densityMap;
  }

  /**
   * This is a getter that will return the attribute of listePays
   * @return an ArrayList of countries
   */
  public ArrayList<Pays> getListePays(){
    return this.listePays;
  }

  /**
   * This private method will initialise popMap attribute
   * @param popFile the file where is store pop data
   *
   */
  private void initialisePopMap(String popFile){
    ArrayList<String> popArray = RWFile.readFile(popFile);
		this.popMap = this.asMap(popArray);
  }

  /**
   * This private method will initialise areaMap attribute
   * @param areaFile the file where is store area data
   *
   */
  private void initialiseAreaMap(String areaFile){
    ArrayList<String> areaArray = RWFile.readFile(areaFile);
		this.areaMap = this.asMap(areaArray);
  }

  /**
   * This private method will initialise listePays attribute
   * It needs the 2 HashMap popMap and areaMap
   */
  private void initialiseListePays(){
    Set<String> nomPays = areaMap.keySet();
		if(popMap.size() == areaMap.size()){
			for(String nom : nomPays){

				listePays.add(new Pays(nom, popMap.get(nom), areaMap.get(nom)));
			}
		}else{
			System.out.println("Erreur : les tailles des HashMap sont différentes ");
		}

  }

  /**
   * This method will extract country name from a line
   * @param line a line to extract
   * @return the country name
   */
  private String extractCountry(String line){
    String res = null;
    int index = 0;
    if(line!=null){
			while(!Character.isDigit(line.charAt(index))&&(index<line.length())){
				index++;
			}
		}
		res = line.substring(0,index).trim();
    return res;
  }

  /**
   * This method will extract value from a line
   * @param line a line to extract
   * @return value in hashmap
   */
  private double extractValue(String line){
    int i=0;
    double res=0;
    if(line != null){
      while(!Character.isDigit(line.charAt(i))&&(i<line.length())){
        i++;
      }
    }
    res = Double.parseDouble(line.substring(i).trim());
    return res;
  }

  /**
   * This method will convert ArrayList into HashMap
   *  @param liste the liste to build into HashMap
   * @return a HashMap String, Double
   */
  private HashMap<String, Double> asMap(ArrayList<String> liste){
    HashMap<String, Double> map = new HashMap<String, Double>();
		if(liste != null){
			for(String line : liste){
				map.put(this.extractCountry(line), this.extractValue(line));
			}
		}
		return map;
  }

  /**
   * This method will initialise a map with countries for keys and values for density
   */
  public void initialiseDensityMap(){
    ArrayList<String> densityArray = new ArrayList<String>();
    double density = 0;
    double tmp = 0;
    for(String key : popMap.keySet()){
      tmp = (int)Math.round((popMap.get(key) / areaMap.get(key)*100));
      density = tmp /100;
      densityArray.add(key + " "+density);
    }
    this.densityMap = this.asMap(densityArray);
  }

  /**
   * This method will return the country that have the largest density
   * @return One country with the best density
   */
  public Pays maxDensity(){
    Pays res = listePays.get(0);

    double densityMax = 0;
    String name = null;
    for(String key : densityMap.keySet()){
      if(densityMax < densityMap.get(key)){
        densityMax = densityMap.get(key);
        name = key;
      }
    }

    for(Pays p : listePays){
      if(p.getNom().equals(name)){
        res = p;
      }
    }

    return res;
  }

  /**
   * This method will return the country that the user wanted
   * @param pays the name of the country
   * @return the country that corresponds to the String typed by user
   */
  public Pays containsPays(String pays){
    Pays res = null;
    String name = null;

    if(pays != null){
      rechercheDicho(this.listePays, pays.trim());
      if(pays.equals(rechercheDicho(this.listePays, pays.trim()))){
        name = pays.trim();
      }
    }

    for(Pays p : listePays){
      if(p.getNom().equals(name)){
        res = p;
      }
    }

    return res;
  }

  /**
   * This method will take search a country by its name
   * @param leTab is the collection where you will research
   * @param aRech the string that you want to research
   * @return a String, it's the string enterred if it's in the collection
   */
  private String rechercheDicho (ArrayList<Pays> leTab, String aRech ) {
    // variables locales
    // indD = indice de début du sous-tableau
    // indF = indice de fin du sous-tableau
    // indM
    //indice milieu entre indD et indF

    TriParSelectionAlpha tri = new TriParSelectionAlpha(this.listePays);
    listePays = tri.getPays();

    //System.out.println(listePays);

    int indD, indF, indM;
    String ret;
    // initialisations
    indD = 0;
    indF = leTab.size() - 1;
    // boucle
    while ( indD != indF ) {
      indM = ( indD + indF ) / 2; // division entière !
      if ( aRech.compareToIgnoreCase(leTab.get(indM).getNom()) > 0 ) {
        indD = indM + 1;
      }else{
         indF = indM ;
      }
    }
    // terminaison : indD == indF forcément
    // MAIS leTab [indD] par forcément = aRech !!
    //System.out.println(leTab.get(indD).getNom());
    if ( aRech.equals(leTab.get(indD).getNom()) ) {
      ret = leTab.get(indD).getNom();
    }else{
      ret = null;
    }
    return ret;
  }
}
