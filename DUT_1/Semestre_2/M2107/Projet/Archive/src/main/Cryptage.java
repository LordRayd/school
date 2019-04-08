import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Cryptage{
	private int[] cle;
	public static void main(String[] args){
		Cryptage crypt = new Cryptage("file/Users");
	}

	public Cryptage(String path){
		int size = Integer.parseInt(JOptionPane.showInputDialog(new JFrame(), "<html>Taille de la cl&eacute; de cryptage</html>", JOptionPane.INFORMATION_MESSAGE));
		cle = new int[size]; // premier chiffre ajouter pour le cryptage
		for(int i = 0; i<size; i++){
			cle[i] = Integer.parseInt(JOptionPane.showInputDialog(new JFrame(), String.valueOf(i+1)+" Valeur", JOptionPane.INFORMATION_MESSAGE));
		}
		String toStore = crypt(path);
		System.out.println(toStore);
		writeFile(toStore, "USERS_CRYPTED");

		writeFile(decrypt("file/USERS_CRYPTED"), "USERS_DECRYPTED");
		System.out.println(decrypt("file/USERS_CRYPTED"));
	}

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

	public String decrypt(String path){
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
	 * This method will write a file from an ArrayList
	 * One element for each line
	 * @param liste The ArrayList that contains data
	 * @param fileName The name that your file will have
	 */
	public static void writeFile(String s, String fileName) {
		try {
			// ouverture du fichier a ecrire
			PrintWriter out = new PrintWriter ("./file/"+fileName) ;
			out.println(s);
			// fermeture du fichier
			out.close() ;
		}catch (IOException ex) {
			ex.printStackTrace() ;
		}
	}

	public int[] getCle(){
		return this.cle;
	}
}