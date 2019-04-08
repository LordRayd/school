package model;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class will permit to decrypt file
 * @author Gurvan LORANS et Samuel LE BERRE
 * @version 1.0
 */
public class Cryptage{

	/**
	 * This is the key to decrypt file
	 */
	private int[] cle;

	/**
	 * This is the method that will decrypt
	 * @param path the path for the file that will be decrypt
	 * @param cle the key of encryption
	 * @return the String of the file decrypted
	 */
	public String decrypt(String path, int[] cle){
		String res = null;
		String toDecrypt = readFile(path);
		char[] caracToDecrypt = toDecrypt.toCharArray();
		for(int i = 0; i < cle.length; i++){
			while(cle[i] > 127){
				cle[i] = cle[i]-127;
			}
		}
		for(int i = 0; i < caracToDecrypt.length; i++){
			for(int j = 0; j< cle.length; j++){
				if(i < caracToDecrypt.length){
					if((int)caracToDecrypt[i] != 10){ // Retour a la ligne
						caracToDecrypt[i] = (char)((int)caracToDecrypt[i]-(int)cle[j]);
						i++;
					}
				}
			}
		}
		res = new String(caracToDecrypt);
		return res;
	}

	/**
	 * This method will encrypt id write by User to check with file
	 * @param id the ID write in JTextField
	 * @param pswd the password write in JTextField
	 * @param cle the key to encrypt them
	 * @return a HashMap with 2 String encrypt (ID and PassWord)
	 */
	public HashMap<String,String> cryptId(String id, String pswd, int[] cle){

		HashMap<String, String> res = new HashMap<String, String>();
		String toCrypt = id+"\n"+pswd;
		
		char[] caracToCrypt = toCrypt.toCharArray();
		for(int i = 0; i < cle.length; i++){
			while(cle[i] > 127){
				cle[i] = cle[i]-127;
			}
		}
		for(int i = 0; i < caracToCrypt.length; i++){
			for(int j = 0; j< cle.length; j++){
				if(i < caracToCrypt.length){
					if((int)caracToCrypt[i] != 10){ // Retour a la ligne
						caracToCrypt[i] = (char)((int)caracToCrypt[i]+(int)cle[j]);
						i++;
					}
				}
			}
		}
		res.put(new String(caracToCrypt).split("\n")[0], new String(caracToCrypt).split("\n")[1]);
		return res;
	}

	/**
	 * This method will encrypt file
	 * @param path the path of the file to encrypt
	 * @return the String that correspond to the data encrypted
	 */
	public String crypt(String path){
		String res = null;
		String toCrypt = readFile(path);
		char[] caracToCrypt = toCrypt.toCharArray();
		for(int i = 0; i < cle.length; i++){
			while(cle[i] > 127){
				cle[i] = cle[i]-127;
			}
		}
		for(int i = 0; i < caracToCrypt.length; i++){
			for(int j = 0; j< cle.length; j++){
				if(i < caracToCrypt.length){
					if((int)caracToCrypt[i] != 10){ // Retour a la ligne
						caracToCrypt[i] = (char)((int)caracToCrypt[i]+(int)cle[j]);
						i++;
					}
				}
			}
		}
		res = new String(caracToCrypt);
		return res;
	}

	/**
	 * This static method will read a file
	 * @param path the path to the file to read
	 * @return a String that contains data from file
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
	 * This static method will write data from a String to a file it will overwrite if the file already exists
	 * the file will be store in a File directory
	 * @param s The String that will be put in the file
	 * @param fileName The Name of the file
	 */
	public static void writeFile(String s, String fileName) {
		try {
			// ouverture du fichier a ecrire
			PrintWriter out = new PrintWriter ("file/"+fileName) ;
			out.println(s);
			// fermeture du fichier
			out.close() ;
		}catch (IOException ex) {
			ex.printStackTrace() ;
		}
	}

	/**
	 * This is a getter
	 * @return the key of encryption
	 */
	public int[] getCle(){
		return this.cle;
	}
}