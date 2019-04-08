package battle;

/**
 * Create a Ship
 * @author S.LEBERRE - MAI 2017
 * @version 1.0
 * @since JDK 1.8
 */
public class Ship {

	private String name;
	private int size;
	private int xOrigin;
	private int yOrigin;
	private int hitNumber;
	private Direction direction;
	
	/**
	 * Create a Ship object
	 * @param name The nameof the Ship
	 * @param size The size of the Ship
	 */
	public Ship(String name, int size){
		this.setName(name);
		this.setSize(size);
	}
	
	/**
	 * Make hit equals true
	 */
	public void addHit(){
		this.hitNumber += 1;
	}
	
	/**
	 * Give a String who represent the Ship
	 * @return a description of the ship
	 */
	public String toString(){
		String ret = "Nom : " + this.name;
		ret += "\nTaille : " + this.size;
		ret += "\nOrigin en X : " + this.xOrigin;
		ret += "\nOrigin en Y : " + this.yOrigin;
		ret += "\nDirection : " + this.direction;
		ret += "\nTouche : " + this.hitNumber;
		return ret;
	}
	
	/**
	 * Give the name of the Ship
	 * @return The name of the ship
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Give a new name to the ship
	 * @param name The new name
	 */
	public void setName(String name){
		if(name != null){
			this.name = name;
		}
	}
	
	/**
	 * Give us the size of the ship
	 * @return The size of the ship
	 */
	public int getSize(){
		return this.size;
	}
	
	/**
	 * Give a new size to the ship
	 * @param size The new size
	 */
	public void setSize(int size){
		if(size > 0 ){
			this.size = size;
		}
	}
	
	/**
	 * Give the Origin in X of the ship
	 * @return The XOrigin of the ship
	 */
	public int getXOrigin(){
		return this.xOrigin;
	}
	
	/**
	 * Give a new XOrigin to the ship
	 * @param xOrigin The new Origin in X
	 */
	public void setXOrigin(int xOrigin){
		if(xOrigin >= 0){
			this.xOrigin = xOrigin;
		} else {
			System.out.println("setXOrigin FALSE param");
		}
	}
	
	/**
	 * Give the Origin in Y of the ship
	 * @return The YOrigin of the ship
	 */
	public int getYOrigin(){
		return this.yOrigin;
	}
	
	/**
	 * Give a new Origin in Y to the ship
	 * @param yOrigin The new YOrigin of the ship
	 */
	public void setYOrigin(int yOrigin){
		if(yOrigin >= 0){
			this.yOrigin = yOrigin;
		} else {
			System.out.println("setYOrigin FALSE param");
		}
	}
	
	/**
	 * Get the hitNumber of the ship
	 * @return The hitNumber
	 */
	public int getHitNumber(){
		return this.hitNumber;
	}
	
	/**
	 * Give a new Number of hit of the ship
	 * @param hitNumber The new Number of Hit
	 */
	public void setHitNumber(int hitNumber){
		if(hitNumber >= 0){
			this.hitNumber = hitNumber;
		}
	}
	
	/**
	 * Give a new Direction to the boat
	 * @param direction The new Direction
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	/**
	 * Give the Direction of the ship
	 * @return The direction of the ship
	 */
	public Direction getDirection(){
		return this.direction;
	}
	
}
