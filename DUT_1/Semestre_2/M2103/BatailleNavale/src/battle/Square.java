package battle;

/**
 * Create a Square ( a part of the Grid)
 * @author S.LEBERRE - MAI 2017
 * @version 1.0
 * @since JDK 1.8
 */
public class Square {

	private int x;
	private int y;
	private boolean free;
	private boolean hit;
	
	/**
	 * Create a Square for the Grid of the player
	 * @param x The position in X of the square in the Grid of the player
	 * @param y The position in Y of the square in the Grid of the player
	 */
	public Square(int x, int y){
		this.setX(x);
		this.setY(y);
		this.free = true;
		this.hit = false;
	}

	/**
	 * Give the position in X  of the Square in the Grid of the player
	 * @return The position X of the Square in the Grid of the player
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Set the position in X  of the Square in the Grid of the player
	 * @param x The new position in X  of the Square in the Grid of the player
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Give the position in Y  of the Square in the Grid of the player
	 * @return The position Y of the Square in the Grid of the player
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Set the position in Y  of the Square in the Grid of the player
	 * @param y The new position in Y  of the Square in the Grid of the player
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Give true if the position is empty
	 * @return If the position is empty return true 
	 */
	public boolean isFree() {
		return this.free;
	}

	/**
	 * Set the position busy
	 */
	public void setBusy() {
		this.free = false;
	}

	/**
	 * Give true if the position is hit
	 * @return If the position is hit return true
	 */
	public boolean isHit() {
		return this.hit;
	}

	/**
	 * Set the position hit
	 */
	public void setHit() {
		this.hit = true;
	}
	
	/**
	 * Give a description of the Square
	 * @return A string who describes the Square
	 */
	public String toString(){
		String ret = null;
		ret = "Position X : " + this.getX();
		ret += "Position Y : " + this.getY();
		ret += "Free : " + this.isFree();
		ret += "Hit : " + this.isHit();
		return ret;
	}	
}
