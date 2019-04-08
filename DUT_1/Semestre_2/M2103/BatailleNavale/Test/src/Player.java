package battle;

import java.util.ArrayList;

import view.GridTableFrame;

/**
 * Create a player
 * @author S.LEBERRE - MAI 2017
 * @version 1.0
 * @since JDK 1.8
 */
public abstract class Player{
	
	protected String name;
	protected int width;
	protected int height;
	protected ArrayList<Ship> fleet;
	protected Square[][] myGrid;
	protected Square[][] oponentGrid;
	
	/**
	 * Create an object Player
	 * @param fleet The fleet of boat
	 * @param name The name of the player
	 * @param width The width of the Grid of the player
	 * @param height The height of the Grid of the player
	 */
	public Player(ArrayList<Ship> fleet, String name, int width, int height){
		this.createCopy(fleet);
		this.name =name;
		this.width = width;
		this.height = height;
		this.initializeMyGrid();
		this.initializeOponentGrid();
		this.shipPlacement();
	}
	
	/**
	 * Create a defensive copy of the fleet
	 * @param fleet The fleet to copy
	 */
	protected void createCopy(ArrayList<Ship> fleet){
		this.fleet = new ArrayList<Ship>();
		for(Ship boat : fleet){
 			this.fleet.add(new Ship(boat.getName(),boat.getSize()));
 		}
	}
	
	/**
	 * Initialized the Grid of the player
	 */
	protected void initializeMyGrid(){
		this.myGrid = new Square[this.width][this.height];
		for(int i = 0; i < this.width; i++){
			for(int j = 0; j < this.height; j++){
				this.myGrid[i][j] = new Square(i,j);
			}
		}
	}
	
	/**
	 * Initialized the Grid of the oponnent
	 */
	protected void initializeOponentGrid(){
		this.oponentGrid = new Square[this.width][this.height];
		for(int i = 0; i < this.width; i++){
			for(int j = 0; j < this.height; j++){
				this.oponentGrid[i][j] = new Square(i,j);
			}
		}
	}
	
	/**
	 * Shoot a position of the oponnentGrid
	 * @return the shoot
	 */
	public abstract int[] newShot();
	
	/**
	 * Put the boat in the Grid of the player if it's possible
	 */
	public abstract void shipPlacement();
	
	/**
	 * Give the name of the player
	 * @return The name of the player
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Give the width of the Grid
	 * @return The width of the Grid
	 */
	public int getWidth(){
		return this.width;
	}
	
	/**
	 * Give the height of the Grid
	 * @return The height of the Grid
	 */
	public int getHeight(){
		return this.height;
	}

	/**
	 * Give the Grid of the Player
	 * @return the Grid of the Player
	 */
	public Square[][] getMyGrid() {
		return myGrid;
	}
	
	/**
	 * Give the OponnentGrid of the Player
	 * @return The OponnentGrid
	 */
	public Square[][] getOponentGrid() {
		return oponentGrid;
	}
	
	/**
	 * Print the Grid of the Player
	 */
	public void displayMygrid() {
	    GridTableFrame otframe = new GridTableFrame(this.getMyGrid());
	    otframe.showIt("Ma Grille",0,200);
	}
	
	/**
	 * Print the oponnentGrid of the Player
	 */
	 public void displayOpponentGrid() {
	    GridTableFrame otframe = new GridTableFrame(this.getOponentGrid());
	    otframe.showIt("Grille Enemie",800,200);
	 }
}
