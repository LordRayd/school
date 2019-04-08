package battle;
import java.util.ArrayList;

	public class AutoPlayer extends Player{
		
		public AutoPlayer(ArrayList<Ship> fleet, String name, int width, int height){
			super(fleet,name,width,height);
		}
		
		public int[] newShot(){
			int[] ret = new int[2];
			boolean shoot = false
			while(shoot == false){
				Random rand = new Random();
				ret[0] = rand.nextInt(this.width + 1);
				ret[1] = rand.nextInt(this.height + 1);
				if(this.oponentGrid[ret[0]][ret[1]].isFree()){
					shoot = true;
					this.oponentGrid[ret[0]][ret[1]].setHit();
				}
			}
			return ret;
		}
		
		public void shipPlacement(){
			for(Ship boat : this.fleet){
				boolean placer = false;
				while(placer == false){
					Random rand = new Random();
					int dir = (int)Math.random()+1;
					if(dir == 1){
						boat.setDirection(Direction.HORIZONTAL);
					} else {
						boat.setDirection(Direction.VERTICAL);
					}
					int x = rand.nextInt(this.width + 1);
					int y = rand.nextInt(this.height + 1);
					boat.setXOrigin(x);
					boat.setYOrigin(y);
					if(boat.getDirection().equals(Direction.HORIZONTAL)){
						placer = true;
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
						placer = true;
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
	}
