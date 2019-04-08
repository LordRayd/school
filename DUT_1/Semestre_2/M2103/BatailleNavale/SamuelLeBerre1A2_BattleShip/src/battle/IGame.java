package battle;

/**
 * The interface of Game
 * @author S.LEBERRE - MAI 2017
 * @version 1.0
 * @since JDK 1.8
 */
public interface IGame {

	/**
	 * 
	 * @return
	 */
	public String description();
	
	/**
	 * 
	 */
	public void start();
	
	/**
	 * 
	 */
	public void endOfGame();
	
}
