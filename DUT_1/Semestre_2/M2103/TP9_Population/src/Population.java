package pays;
import utilitaire.*;
import java.lang.*;
import java.util.*;

	/**
	 * The Population Class
	 * @author S.LEBERRE - AVRIL 2017
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	 public class Population{

	 	private HashMap<String,Double> popMap;
	 	private HashMap<String,Double> areaMap;
	 	private ArrayList<Pays> listePays;

	 	/**
	 	 * Constructor of Population object
	 	 * @param popFileName the file where we find the popMap
	 	 * @param areaFileName the file where we find the areaMap
	 	 */
	 	public Population(String popFileName, String areaFileName){
	 		this.initializePopMap(popFileName);
	 		this.initializeAreaMap(areaFileName);
	 		this.initializeListePays();
	 	}

	 	/**
	 	 * Give us an HashMap with for key the name of the Pays and for value the number of people
	 	 * @return an HashMap with the name and the people of the Pays
	 	 */
	 	public HashMap<String,Double> getPopMap(){
	 		return this.popMap;
	 	}

	 	/**
	 	 * Give us an HashMap with for key the name of the Pays and for value the surface 
	 	 * @return an HashMap with the name and the surface of the Pays
	 	 */
	 	public HashMap<String,Double> getAreaMap(){
	 		return this.areaMap;
	 	}

	 	/**
	 	 * Give an ArrayList of Pays
	 	 * @return An ArrayList of Pays
	 	 */
	 	public ArrayList<Pays> getListePays(){
	 		return this.listePays;
	 	}

	 	/**
	 	 * Initialize the listePays attribut
	 	 */
	 	public void initializeListePays(){
	 		this.listePays = new ArrayList<Pays>();
	 		Set<String> nomPays = popMap.keySet();
			if(popMap.size() == areaMap.size()){
				for(String nom : nomPays){
					this.listePays.add(new Pays(nom,popMap.get(nom),areaMap.get(nom)));
				}
			}else{
				System.out.println("La taille des 2 ArrayList sont differentes ");
			}
	 	}

	 	/**
	 	 * Initialize the popMap attribut
	 	 * @param popFile The file where we read the value
	 	 */
	 	private void initializePopMap(String popFile){
	 		if(popFile != null){
	 			ArrayList<String> popArray = RWFile.readFile(popFile);
	 			this.popMap = this.asMap(popArray);
	 		}else{
	 			System.out.println("ERROR : popFile initializePopMap");
	 		}
	 	}

	 	/**
	 	 * Initialize the areaMap attribut
	 	 * @param areaFile the file where we read the value
	 	 */
	 	private void initializeAreaMap(String areaFile){
	 		if(areaFile != null){
	 			ArrayList<String> areaArray = RWFile.readFile(areaFile);
	 			this.areaMap = this.asMap(areaArray);
	 		}else{
	 			System.out.println("ERROR : areaFile initializeAreaMap");
	 		}
	 	}

	 	/**
	 	 * Give the name(key) of the Pays object with a string
	 	 * @param line the line where you find the key
	 	 * @return A string with the name of the Pays object who serve for key in the HashMap
	 	 */
	 	private String extractCountry(String line){
	 		String ret = null;
			int i = 0;
			if(line!=null){
	 			while(!Character.isDigit(line.charAt(i)) && (i<line.length())){
					i++;
				}
				ret = line.substring(0,i).trim();
			}
			return ret;
	 	}

	 	/**
	 	 * Give the value of the Pays object with a string
	 	 * @param line the line where you find the value
	 	 * @return A string with the value of the Pays object who serve for value in the HashMap
	 	 */
	 	private Double extractValue(String line){
	 		Double ret = 0.0;
	 		if(line != null){
	 			int i = 0;
	 			while(!Character.isDigit(line.charAt(i)) && (i<line.length())){
	 				i++;
	 			}
	 			ret = Double.parseDouble(line.substring(i).trim());
	 		}
	 		return ret;
	 	}

	 	/**
	 	 * Turn an ArrayList into an HashMap with the contains of the String
	 	 * @param liste An ArrayList with the key(name) and value of a population 
	 	 * @return An HashMap with for key the name of the Pays object
	 	 */
	 	private HashMap<String,Double> asMap(ArrayList<String> liste){
	 		HashMap<String,Double> map = new HashMap<String,Double>();
	 		if(liste != null){
	 			for(String line : liste){
	 				map.put(this.extractCountry(line),this.extractValue(line));
	 			}
	 		}
	 		return map;
	 	}
	 }