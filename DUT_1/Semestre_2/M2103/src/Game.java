package battle;
import java.util.ArrayList;

	/**
	 * 
	 * 
	 * 
	 */
	public class Game implements IGame{
		
		private ShotResult result;
		private Player captain;
		private Player auto;
		private ArrayList<Ship> fleet;
		
		
		public Game(ArrayList<Ship> fleet, String playerName1, String playerName2, int width, int height){
			this.captain = new HumanPlayer(fleet,playerName1,width,height);
			this.auto = new AutoPlayer(fleet,playerName2,width,height);
			this.fleet = fleet;
		}
		
		public int[] readShot(Player player){
			int[] ret = null;
			return ret;
		}
		
		public ShotResult analizedShot(int[] shot){
			ShotResult ret = null;
			return ret;
		}
		
		public boolean allSunk(Player player){
			boolean ret = false;
			int longueur = 0;
			int longueur2 = 0;
			Square[][] grid = player.getMyGrid();
			for(Ship boat : this.fleet){
				longueur += boat.getSize();
			}
			for(int i =0; i<grid.length(); i++){
				if(grid.isHit()){
					longueur2 += 1;
				}
			}
			if(longueur <= longueur2){
				ret = true;
			}
			return ret;
		}
		
		public String description(){
			String ret = null;
			return ret;
		}
		
		public void start(){
			int [] shot;
			ShotResult result;
			while(!this.allSunk(this.captain) && !this.allSunk(this.auto)){
				shot = this.readShot(this.captain);
				result = this.analizedShot(shot);
				shot = this.readShot(this.auto);
				result = this.analizedShot(shot);
			}
			this.endOfGame();
		}
		
		public void endOfGame(){
			
		}
	}