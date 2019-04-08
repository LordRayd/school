package model;


//============ALL IMPORT FOR THIS CLASS =====================
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//===========================================================

/**
 * This class will write and read file
 * @author Gurvan LORANS et Samuel LE BERRE
 * @version 1.0
 */
public class RWFile {

	/**
	 * This method will readFile and store it into a String
	 * @param path the path of the file to read
	 * @return the Content of the file into a String
	 */
	public static String readFile (String path) {
		String content = new String();

		try {
			//  ouverture du fichier
			Scanner in = new Scanner (new FileReader (path)) ;
			if(in.hasNextLine() ){
				content = content+in.nextLine();
			}
			//  lecture et ajout des lignes une par une
			while (in.hasNextLine() ) {
				content = content +"\n"+in.nextLine ();
			}

			// fermeture du fichier ouvert en lecture
			in.close() ;
		} catch (IOException ex) {
			ex.printStackTrace() ;
		}
		return content;
	}

	/**
	 * This method will write a file with a String
	 * @param s the text of the file to save
	 * @param fileName the name of the file
	 */
	public static void writeFile(String s, String fileName) {
		try {
			// ouverture du fichier a ecrire
			PrintWriter out = new PrintWriter (fileName) ;
			out.println(s);
			// fermeture du fichier
			out.close() ;
		}catch (IOException ex) {
			ex.printStackTrace() ;
		}
	}

}