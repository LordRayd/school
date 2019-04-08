package battle;

import java.util.ArrayList;
import java.util.Random;

/**
 * Create an IA
 * @author S.LEBERRE - MAI 2017
 * @version 1.0
 * @since JDK 1.8
 */
public class AutoPlayer extends Player{

	/**
	 * Create an object AutoPlayer
	 * @param fleet The fleet of boat
	 * @param name The name of the player
	 * @param width The width of the Grid of the player
	 * @param height The height of the Grid of the player
	 */
	public AutoPlayer(ArrayList<Ship> fleet, String name, int width, int height){
		super(fleet,name,width,height);
	}

	/**
	 * Shoot on another Player
	 * @return Where we shoot
	 */
	public int[] newShot(){
		int[] ret = new int[2];
		boolean shoot = false;
		while(shoot == false){
			Random rand = new Random();
			ret[0] = rand.nextInt(this.width-1);
			ret[1] = rand.nextInt(this.height-1);
			if( !this.oponentGrid[ret[0]][ret[1]].isHit() ){
				shoot = true;
				this.oponentGrid[ret[0]][ret[1]].setHit();
			}
		}
		return ret;
	}

	/**
	 * Give a position to the boats
	 */
	public void shipPlacement(){
		System.out.println("\n\nJoueur : "+ this.getName());
		for(Ship boat : this.fleet){
			System.out.println("\nBateau : " + boat.getName());
			boolean placer = false;
			int nbDeTentative = 0;
			while( (placer == false) && (nbDeTentative < 50) ){

				// ------------------- Direction --------------------------------
				Random rand = new Random();
				int dir = 2;
				while( (dir > 1) || (dir < 0)){
					dir = rand.nextInt(2);
					if(dir == 0){
						boat.setDirection(Direction.HORIZONTAL);
					} else if(dir == 1){
						boat.setDirection(Direction.VERTICAL);
					}
				}
				// ------------------- FinDirection -----------------------------

				//========================= Horizontale ==============================================
				if(boat.getDirection().equals(Direction.HORIZONTAL)){
					int x = rand.nextInt(this.width);
					int y = rand.nextInt(this.height);
					boat.setXOrigin(x);
					boat.setYOrigin(y);
					placer = true;
					int fin = x+boat.getSize()-1;
					if(fin < this.height){
						while(placer == true && x <= fin){
							if( (boat.getYOrigin()<this.height-1) && (boat.getYOrigin()>0) && (x<this.width-1) && (x>0)){
								//position du bateau
								if(this.myGrid[x][boat.getYOrigin()].isFree() == false){
									placer = false;
								}
								//position a droite
								if( (x+1)<this.width){
									if( this.myGrid[x+1][boat.getYOrigin()].isFree() == false ){
										placer = false;
									}
								}
								//position en bas a droite
								if( ((x+1) < this.width) && ((boat.getYOrigin()+1)<this.height)){
									if(this.myGrid[x+1][boat.getYOrigin()+1].isFree() == false){
										placer = false;
									}
								}
								//position en bas
								if( (boat.getYOrigin()+1) < this.height ){
									if(this.myGrid[x][boat.getYOrigin()+1].isFree() == false){
										placer = false;
									}
								}
								//postion en bas a gauche
								if( ((x-1)>=0) && ((boat.getYOrigin()+1)<this.height) ){
									if(this.myGrid[x-1][boat.getYOrigin()+1].isFree() == false){
										placer = false;
									}
								}
								//position a gauche
								if( ((x-1)>=0) ){
									if(this.myGrid[x-1][boat.getYOrigin()].isFree() == false){
										placer = false;
									}
								}
								//position en haut a gauche
								if( ((x-1)>=0) && ((boat.getYOrigin()-1)>=0) ){
									if(this.myGrid[x-1][boat.getYOrigin()-1].isFree() == false){
										placer = false;
									}
								}
								//position en haut
								if( (boat.getYOrigin()-1) >= 0 ){
									if(this.myGrid[x][boat.getYOrigin()-1].isFree() == false){
										placer = false;
									}
								}
								//position en haut a droite
								if( ((x+1) < this.width) && ((boat.getYOrigin()-1)>=0) ){
									if(this.myGrid[x+1][boat.getYOrigin()-1].isFree() == false){
										placer = false;
									}
								}
							} else { 
								placer = false;
							}
							x++;
						}
						if(placer == true){
							x = boat.getXOrigin();
							while( x <= fin){
								this.myGrid[x][boat.getYOrigin()].setBusy();
								System.out.println("Position en x :" + x + "\nPosition en y :" + boat.getYOrigin());
								x++;
							}
						}
					} else {
						placer = false;
					}
				}


				//========================= Verticale ==============================================
				if(boat.getDirection().equals(Direction.VERTICAL)){
					int x = rand.nextInt(this.width);
					int y = rand.nextInt(this.height);
					boat.setXOrigin(x);
					boat.setYOrigin(y);
					placer = true;
					int fin = (y+boat.getSize())-1;
					if(fin < this.width){
						while(placer == true && y <= fin){
							if( (boat.getXOrigin() < this.width-1) && (boat.getXOrigin() > 0) && (y < this.height-1) && (y > 0)){
								//position du bateau
								if(this.myGrid[x][boat.getYOrigin()].isFree() == false){
									placer = false;
								}
								//position a droite
								if( (x+1)<this.width){
									if( this.myGrid[x+1][boat.getYOrigin()].isFree() == false ){
										placer = false;
									}
								}
								//position en bas a droite
								if( ((x+1) < this.width) && ((boat.getYOrigin()+1)<this.height)){
									if(this.myGrid[x+1][boat.getYOrigin()+1].isFree() == false){
										placer = false;
									}
								}
								//position en bas
								if( (boat.getYOrigin()+1) < this.height ){
									if(this.myGrid[x][boat.getYOrigin()+1].isFree() == false){
										placer = false;
									}
								}
								//postion en bas a gauche
								if( ((x-1)>=0) && ((boat.getYOrigin()+1)<this.height) ){
									if(this.myGrid[x-1][boat.getYOrigin()+1].isFree() == false){
										placer = false;
									}
								}
								//position a gauche
								if( ((x-1)>=0) ){
									if(this.myGrid[x-1][boat.getYOrigin()].isFree() == false){
										placer = false;
									}
								}
								//position en haut a gauche
								if( ((x-1)>=0) && ((boat.getYOrigin()-1)>=0) ){
									if(this.myGrid[x-1][boat.getYOrigin()-1].isFree() == false){
										placer = false;
									}
								}
								//position en haut
								if( (boat.getYOrigin()-1) >= 0 ){
									if(this.myGrid[x][boat.getYOrigin()-1].isFree() == false){
										placer = false;
									}
								}
								//position en haut a droite
								if( ((x+1) < this.width) && ((boat.getYOrigin()+1)>=0) ){
									if(this.myGrid[x+1][boat.getYOrigin()+1].isFree() == false){
										placer = false;
									}
								}
							} else { 
								placer = false;
							}
							y++;
						}
						if(placer == true){
							y = boat.getYOrigin();
							while( y <= fin){
								this.myGrid[boat.getXOrigin()][y].setBusy();
								System.out.println( "Position en x :" + boat.getXOrigin() + "\nPosition en y :" + y );
								y++;
							}
						}
					} else {
						placer = false;
					}
				} 
				nbDeTentative++;
			}
			if(placer == false){
				System.out.println(""+ boat.getName()+" : Bateau impossible a placer");
			}
		}
	}
}
