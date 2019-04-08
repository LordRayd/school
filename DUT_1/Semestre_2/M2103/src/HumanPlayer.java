package battle;
import java.util.ArrayList;

	public class HumanPlayer extends Player{
		
		public HumanPlayer(ArrayList<Ship> fleet, String name, int width, int height){
			super(fleet,name,width,height);
		}
		
		public int[] newShot(){
			int[] ret = null;
			return ret;
		}
		
		public void shipPlacement(){
			for(Ship boat : this.fleet){
				if(boat.getDirection().equals(Direction.HORIZONTAL)){
					boolean placer = true;
					int x = boat.getXOrigin();
					int fin = x+boat.getSize();
					while(placer == true && x <= fin){
						if(this.myGrid[x][boat.getYOrigin()].isFree() == false){
							placer = false;
						}
						x++;
					}
					if(placer == true){
						x = boat.getXOrigin();
						while( x <= fin){
							this.myGrid[x][boat.getYOrigin()].setBusy();
							x++;
						}
					}else{
						System.out.println(boat.getName()+" : Bateau impossible a placer");
					}
				}
				if(boat.getDirection().equals(Direction.VERTICAL)){
					boolean placer = true;
					int y = boat.getYOrigin();
					int fin = y+boat.getSize();
					while(placer == true && y <= fin){
						if(this.myGrid[boat.getXOrigin()][y].isFree() == false){
							placer = false;
						}
						y++;
					}
					if(placer == true){
						y = boat.getYOrigin();
						while( y <= fin){
							this.myGrid[boat.getXOrigin()][y].setBusy();
							y++;
						}
					}else{
						System.out.println(boat.getName()+" : Bateau impossible a placer");
					}
				}
			}
		}
	}
