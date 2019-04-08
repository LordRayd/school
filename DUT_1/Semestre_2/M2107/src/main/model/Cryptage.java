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
	 * This is the method that will decrypt
	 * @param path the path for the file that will be decrypt
	 * @param cle the key of encryption
	 * @return the String of the file decrypted
	 */
	public String decrypt(String path, int[] cle){
		String res = null;
		String toDecrypt = RWFile.readFile(path);
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
}
