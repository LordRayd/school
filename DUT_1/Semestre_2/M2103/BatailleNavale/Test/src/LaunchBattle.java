import battle.*;


/**
 * Start the BattleShip Application
 * @author S.LEBERRE - MAI 2017
 * @version 1.0
 * @since JDK 1.8
 */
public class LaunchBattle {
	
	/**
	 * Launch the BattleShip Application
	 * @param args teh arguments we can put when we start it
	 */
	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(
				new Runnable(){
					public void	run(){
						new BattleShip("file","nom1","nom2");
					}
				}
		);
	}

}
