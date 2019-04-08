package battle;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Create a BattleShip
 * @author S.LEBERRE - MAI 2017
 * @version 1.0
 * @since JDK 1.8
 */
public class BattleShip {
	
	private int width;
	private int height;
	//private final String delimiter ="\\s^:\\s^";
	private Game gamePlay;
	private ArrayList<Ship> fleet;
	
	/**
	 * Create an object BattleShip
	 * @param fileName The file were is going to be read the configuration
	 * @param playerName1 The name of the first player
	 * @param playerName2 The name of the second player
	 */
	public BattleShip(String fileName, String playerName1, String playerName2){
		this.configure(fileName);
		this.gamePlay = new Game(this.fleet,playerName1,playerName2,this.width,this.height);
	}
	
	/**
	 * Read a file and tale the configuration
	 * @param fileName The file were is going to be read the configuration
	 */
	private void configure(String fileName){
		try{
			FileReader fr = new FileReader("./data/"+fileName+".txt");
  			Scanner sc = new Scanner (fr);
  			this.width = sc.nextInt();
  			System.out.println("pass 0");
  			this.height = sc.nextInt();
  			System.out.println("pass 1");
  			this.fleet = new ArrayList<Ship>();
  			System.out.println("pass 2");
  			while(sc.hasNext()){
    			System.out.println("pass 3");
  				String name = sc.next();
  				int size = Integer.parseInt(sc.next());
    			this.fleet.add(new Ship(name,size));
    			System.out.println("pass 4");
  			}
  			sc.close() ;
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Give the GamePlay of the BattleShip
	 * @return the GamePlay of the BattleShip
	 */
	public Game getPlay(){
		return this.gamePlay;
	}
	
	/**
	 * Print the configuration on the screen
	 */
	public void printConfiguration(){
		System.out.println("Width : " + this.width);
		System.out.println("Height : " + this.height);
		System.out.println(this.fleet.toString());
	}
}
