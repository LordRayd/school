package battle;

import java.util.ArrayList;

/**
 * Create a Game
 * @author S.LEBERRE - MAI 2017
 * @version 1.0
 * @since JDK 1.8
 */
public class Game implements IGame {

	private ShotResult result;
	private Player captain;
	private Player auto;
	private ArrayList<Ship> fleet;

	/**
	 * Create an object HumanPlayer
	 * @param fleet The fleet of boat
	 * @param playerName1 The name of the first Player
	 * @param playerName2 The name of the second Player
	 * @param width The width of the Grid of the players
	 * @param height The height of the Grid of the players
	 */
	public Game(ArrayList<Ship> fleet, String playerName1, String playerName2, int width, int height){
		this.fleet = fleet; 
		this.captain = new HumanPlayer(this.fleet,playerName1,width,height);
		this.auto = new AutoPlayer(this.fleet,playerName2,width,height);
		this.start();
	}

	/**
	 * Make shoot a player
	 * @param player the player you want to see the shoot
	 * @return the position where shoot the Player
	 */
	public int[] readShot(Player player){
		int[] ret = null;
		if(player != null){
			ret = player.newShot();
		}
		return ret;
	}

	/**
	 * See if a player shot hit is target
	 * @param shot the shot of the Player
	 * @param player the grid you want to analyzed
	 * @return Give the result of the Shot
	 */
	public ShotResult analizedShot(int[] shot, Player player){
		ShotResult ret = null;
		if( !player.getMyGrid()[shot[0]][shot[1]].isFree() ){
			player.getMyGrid()[shot[0]][shot[1]].setHit();
			ret = ShotResult.HIT;
		}
		if( player.getMyGrid()[shot[0]][shot[1]].isFree() ){
			player.getMyGrid()[shot[0]][shot[1]].setHit();
			ret = ShotResult.MISS;
		}
		if( ret == ShotResult.HIT){
			boolean toutTouche = true;
			int i1 = shot[0] ; // to check the right
			int i2 = shot[0] ; // to check the left
			int j1 = shot[1] ; // to check the down
			int j2 = shot[1] ; // to check the high
			// check the Right
			while( toutTouche == true && i1 < player.getWidth() && !player.getMyGrid()[i1][shot[1]].isFree() ){
				if( !player.getMyGrid()[i1][shot[1]].isHit() ){
					toutTouche = false;
				}
				i1++;
			}
			// check the Left
			while( toutTouche == true && i2 >= 0 && !player.getMyGrid()[i2][shot[1]].isFree() ){
				if( !player.getMyGrid()[i2][shot[1]].isHit() ){
					toutTouche = false;
				}
				i2--;
			}
			// check the Down
			while( toutTouche == true && j1 < player.getHeight() && !player.getMyGrid()[shot[0]][j1].isFree() ){
				if( !player.getMyGrid()[shot[0]][j1].isHit() ){
					toutTouche = false;
				}
				j1++;
			}
			// check the High
			while( toutTouche == true && j2 >= 0 && !player.getMyGrid()[shot[0]][j2].isFree() ){
				if( !player.getMyGrid()[shot[0]][j2].isHit() ){
					toutTouche = false;
				}
				j2--;
			}
			if(toutTouche == true){
				ret = ShotResult.SUNK;
			}
		}
		return ret;
	}

	/**
	 * Check if all the boat of a player are sunk
	 * @param player the Player
	 * @return true if all the boat of the player are hit
	 */
	public boolean allSunk(Player player){
		boolean ret = true;
		Square[][] grid = player.getMyGrid();
		for(int i=0; i<player.getWidth(); i++){
			for(int j=0; j<player.getHeight(); j++){
				if( (grid[i][j].isFree()==false) && (grid[i][j].isHit()==false) ){
					ret = false;
				}
			}
		}
		return ret;
	}

	/**
	 * Give a description of the game
	 */
	public String description(){
		String ret = null;
		ret = "\nName player 1 : " + this.captain.getName();
		ret += "\nName player 2 : " + this.auto.getName();
		ret += "\n" + this.fleet.toString();
		return ret;
	}

	/**
	 * Start the Game
	 */
	public void start(){
		int [] shot;
		while(!this.allSunk(this.captain) && !this.allSunk(this.auto)){
			this.captain.displayMygrid();
			this.captain.displayOpponentGrid();
			shot = this.readShot(this.captain);
			this.result = this.analizedShot(shot,this.auto);
			if(result == ShotResult.HIT){
				this.captain.getOponentGrid()[shot[0]][shot[1]].setBusy();
			}
			if(result == ShotResult.SUNK){
				this.captain.getOponentGrid()[shot[0]][shot[1]].setBusy();
			}
			System.out.println(result);
			if(!this.allSunk(this.auto)){
				shot = this.readShot(this.auto);
				this.result = this.analizedShot(shot,this.captain);
				System.out.println(result);
			}
		}
		this.endOfGame();
	}

	/**
	 * Give the Winner of the Game
	 */
	public void endOfGame(){
		if(this.allSunk(this.captain)){
			System.out.println("\n\nTHE WINNER IS : " + this.auto.getName());
		} else {
			System.out.println("\n\nTHE WINNER IS : " + this.captain.getName());
		}
	}

}
