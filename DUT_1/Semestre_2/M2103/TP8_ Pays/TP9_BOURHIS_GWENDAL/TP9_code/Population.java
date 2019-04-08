package pays;
import java.util.ArrayList;
import utilitaire.*;
import java.lang.Double;
import java.util.HashMap;
import java.util.Set;

/**
 * Class Population
 * @author G.BOURHIS
 * @version 1.0
 */
public class Population{
	private HashMap<String, Double> popMap;
	private HashMap<String, Double> areaMap;
	private ArrayList<Pays> listePays;


	/**
	 *constructor Population
	 *@param popFileName the name of the file population
	 *@param areaFileName the came of the file area
	 */
	public Population(String popFileName,String areaFileName){
		if((popFileName != null)&&(areaFileName != null)){
			initializePopMap(popFileName);
			initializePopAreaMap(areaFileName);
			this.listePays = new ArrayList<Pays>();
			initializeListePays();
		}else{
			this.popMap = null;
			this.areaMap = null;
			this.listePays = new ArrayList<Pays>();
			initializeListePays();
			System.out.println("Erreur : paramètres population invalides");
		}
	}

	/**
	 *Method extractCountry : returns the name of the country from a line of a file
	 *@param line the line where extract the country
	 *@return ret the country extracted
	 */
	private String extractCountry(String line){
		String ret = null;
		int index = 0;
		if(line!=null){
			while(!Character.isDigit(line.charAt(index))&&(index<line.length())){
				index++;
			}
		}
		ret = line.substring(0,index).trim();
		return ret;
	}

/**
 *Method extractValue : returns the value from a line of a file
 *@param line the line where extract the country
 *@return ret the value extracted
 */
	private double extractValue(String line){
		int i=0;
		double ret=0;
		if(line != null){
			while(!Character.isDigit(line.charAt(i))&&(i<line.length())){
				i++;
			}
		}
		ret = Double.parseDouble(line.substring(i).trim());
		return ret;
	}

	/**
	 *Method asMap :returns a HashMap with the name of the country and the  data as key
	 *@param liste the ArrayList of string of the form "country, data"
	 *@return map the HashMap
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
	 *Method initializePopMap : used in the constructor to initialize the attribute popMap
	 *@param popFile the population file
	 */
	private void initializePopMap(String popFile){
		ArrayList<String> popArray = RWFile.readFile(popFile);
		this.popMap = this.asMap(popArray);
	}

	/**
	 *Method initializePopAreaMap : used in the constructor to initialize the attribute areaMap
	 *@param aeraFile the file area
	 */
	private void initializePopAreaMap(String areaFile){
		ArrayList<String> popArray = RWFile.readFile(areaFile);
		this.areaMap = this.asMap(popArray);
	}

	/**
	 *Method initializeListePays : used in the constructor to initialize the attribute listePays
	 */
	private void initializeListePays(){
		Set<String> nomPays = popMap.keySet();
		//test taille HashMap
		if(popMap.size() == areaMap.size()){
			for(String nom : nomPays){
				listePays.add(new Pays(nom,popMap.get(nom),areaMap.get(nom)));
			}
		}else{
			System.out.println("Erreur : les tailles des ArrayList sont différentes ");
		}
	}

	/**
	 *Getter getPopMap : returns the attribute popMap
	 *@return popMap the attribute popMap
	 */
	public HashMap<String, Double> getPopMap(){
		return this.popMap;
	}

	/**
	 *Getter getAreaMap : returns the attribute areaMap
	 *@return areaMap the attribute areaMap
	 */
	public HashMap<String, Double> getAreaMap(){
		return this.areaMap;
	}

	/**
	 *Getter getListePays : returns the ArrayList listePays
	 *@return listePays the attribue listePays
	 */
	public ArrayList<Pays> getListePays(){
		return this.listePays;
	}

}
