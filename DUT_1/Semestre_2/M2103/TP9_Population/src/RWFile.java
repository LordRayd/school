package utilitaire;
import java.util.*;
import java.io.*;
	/**
	 * The Class for read and write a file of the population class
	 * @author S.LEBERRE - AVRIL 2017
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	public class RWFile{

		/**
		 * Read a file given in param
		 * @param fileName the file you want to read
		 * @return An ArrayList of the file
		 */
		public static ArrayList<String> readFile(String fileName){
			ArrayList<String> ret = new ArrayList<String>();
			try{
				FileReader fr = new FileReader(fileName+".txt");
      			Scanner sc = new Scanner (fr);
      			while(sc.hasNextLine()){
        			ret.add(sc.nextLine ());
      			}
      			sc.close() ;
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			return ret;
		}

		/**
		 * Write a file with an ArrayList
		 * @param liste An ArrayList you want to write
		 * @param fileName the name of the file you want to write
		 */
		public static void writeFile(ArrayList<String> liste, String fileName){
			try{
				FileWriter fw = new FileWriter (fileName + ".txt");
				PrintWriter pw = new PrintWriter (fw);
				for(String listeDePays : liste){
					pw.println(listeDePays);
				}
				pw.close();
			} catch(Exception e){
				System.out.println(e.getMessage());
			} 
		}

		/**
		 * Write an HashMap in a new file
		 * @param map The HashMap you want to write
		 * @param fileName The name of the file you want to write
		 */
		public static void writeMap(HashMap<String,Double> map, String fileName){
			try{
				FileWriter fw = new FileWriter (fileName + ".txt");
				PrintWriter pw = new PrintWriter (fw);
				for(String key : map.keySet()){
        			pw.println (key + " " + map.get(key).toString()) ;
				}
				pw.close();
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}