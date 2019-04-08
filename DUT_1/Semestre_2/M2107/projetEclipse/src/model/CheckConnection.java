package model;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class will check the connection (data from JTextField with file)
 * @author Gurvan LORANS and Samuel LE BERRE
 * @version 1.0
 */
public class CheckConnection{
	
	/**
	 * This is the key of the encrypted file
	 */
	int[] cle = {1,2,3};

	/**
	 * This method will return a file into a HashMap
	 * @return the HashMap that contains ID from file
	 */
	public HashMap<String, String> fileToMap(){
		HashMap<String, String> identifiants = new HashMap<String, String>(); 
		try {
			Scanner in = new Scanner (new FileReader ("file/USERS_CRYPTED")) ;
			while (in.hasNextLine()){
				identifiants.put(in.nextLine(), in.nextLine());
			}
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return identifiants;
	}
	
	/**
	 * This method will return a HashMap who decrypt a file
	 * @return the HashMap of file decrypted
	 */
	public HashMap<String, String> stringToMap(){
		Cryptage crypt = new Cryptage();
		String toDecrypt = crypt.decrypt("file/USERS_CRYPTED", this.cle);
		HashMap<String, String> identifiants = new HashMap<String, String>(); 
		String[] toAdd = toDecrypt.split("\n");
		
		for(int i = 0; i < toAdd.length; i=i+2){
			identifiants.put(toAdd[i], toAdd[i+1]);
		}
		
		identifiants.toString();
		return identifiants;
	}
}