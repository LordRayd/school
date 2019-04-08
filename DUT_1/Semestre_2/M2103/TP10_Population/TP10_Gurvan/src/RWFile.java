package pays;


//============ALL IMPORT FOR THIS CLASS =====================
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
//===========================================================

/**
 * This class will write and read file
 * From ArrayList and HashMap
 */
public class RWFile {

  /**
   * This method will read file line after line
   * and make an ArrayList from it
   * @param fileName File to read
   * @return One ArrayList that contains file Data cut
   */
  public static ArrayList<String> readFile (String fileName) {
    ArrayList<String> file = new ArrayList<String>();

    try {
      //  ouverture du fichier
      Scanner in = new Scanner (new FileReader ("data/"+fileName+".txt")) ;

      //  lecture et ajout des lignes une par une
      while (in.hasNextLine() ) {
        file.add(in.nextLine ()) ;
      }

      // fermeture du fichier ouvert en lecture
      in.close() ;
    } catch (IOException ex) {
      ex.printStackTrace() ;
    }
    return file;
  }

  /**
   * This method will write a file from an ArrayList
   * One element for each line
   * @param liste The ArrayList that contains data
   * @param fileName The name that your file will have
   */
  public static void writeFile(ArrayList<String> liste, String fileName) {

    try {
      // ouverture du fichier a ecrire
      PrintWriter out = new PrintWriter ("data/"+fileName+".txt") ;
      for (String ligne : liste)
        out.println (ligne) ;
      // fermeture du fichier
      out.close() ;
      }catch (IOException ex) {
      ex.printStackTrace() ;
    }
  }

  /**
   * This method will write a file with an HashMap
   * Key and value on the same line
   * @param map The map to write
   * @param fileName The name that your file will takes
   */
  public static void writeMap (HashMap<String, Double> map, String fileName) {

    try {
      // ouverture du fichier a ecrire
      PrintWriter out = new PrintWriter ("data/"+fileName+".txt") ;
      for (String key : map.keySet())
        out.println (key + "     " + map.get(key).toString()) ;  // concatene une chaine et un Double.toString()
      // fermeture du fichier
      out.close() ;

    } catch (IOException ex) {
      ex.printStackTrace() ;
    }
  } // -------------------------------------------------- writeMap()



}
