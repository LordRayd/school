package battle;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Create a Human Player
 * @author S.LEBERRE - MAI 2017
 * @version 1.0
 * @since JDK 1.8
 */
public class HumanPlayer extends Player{

	/**
	 * Create an object HumanPlayer
	 * @param fleet The fleet of boat
	 * @param name The name of the player
	 * @param width The width of the Grid of the player
	 * @param height The height of the Grid of the player
	 */
	public HumanPlayer(ArrayList<Ship> fleet, String name, int width, int height){
		super(fleet,name,width,height);
	}

	/**
	 * Shoot on another Player
	 * @return Where we shoot
	 */
	public int[] newShot(){
		int[] ret = new int[2];
		boolean shoot = false;
		boolean ok1;
		boolean ok2;
		int valeur;
		while(shoot == false){
			ok1 = false;
			ok2 = false;
			while(!ok1 && !ok2){
				ret[0] = this.width;
				ret[1] = this.height;
				while( (ret[0] < 0) || (ret[0] > this.width-1) ){
					String message =  JOptionPane.showInputDialog(null, "Coordonné en X du tire"); 
					valeur = Integer.parseInt(message);
					ret[0] = valeur;
					ok1 = true;
				}
				while( (ret[1] < 0) || (ret[1] > this.height-1) ){
					String message =  JOptionPane.showInputDialog(null, "Coordonné en Y du tire"); 
					valeur = Integer.parseInt(message);
					ret[1] = valeur;
					ok2 = true;
				}
				shoot = true;
				if( ok1 == true && ok2 == true && this.oponentGrid[ret[0]][ret[1]].isHit() == false ){
					shoot = true;
					this.oponentGrid[ret[0]][ret[1]].setHit();
				} else {
					System.out.println("Vous avez déja tiré sur cette position");
					ok1 = false;
					ok2 = false;
				}
			}
		}
		return ret;
	}

	/**
	 * Put the boat in the Grid of the player if it's possible
	 */
	public void shipPlacement(){
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nJoueur : "+ this.getName());
		for(Ship boat : this.fleet){
			System.out.println("\nBateau : "+boat.getName());
			boolean placer = false;
			while( (placer == false) ){

				// ------------------- Direction --------------------------------
				int dir = 2;
				while( (dir > 1) || (dir < 0)){
					System.out.println("Saisisez 0 pour Horizontale et 1 pour Verticale :");
					dir = sc.nextInt();
				}
				if(dir == 0){
					boat.setDirection(Direction.HORIZONTAL);
				}else if(dir == 1){
					boat.setDirection(Direction.VERTICAL);
				}
				// ------------------- FinDirection -----------------------------


				//========================= Horizontale ==============================================
				if(boat.getDirection().equals(Direction.HORIZONTAL)){
					int x = this.width + 5;
					while( (x<=0) || (x >= (this.width-1)) ){
						System.out.println("Saisisez la position en x :");
						x = sc.nextInt();
					}
					int y = this.height + 5;
					while( (y<=0) || (y >= (this.height-1)) ){
						System.out.println("Saisisez la position en y :");
						y = sc.nextInt();
					}
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
					System.out.println("Saisisez la position en x :");
					int x = sc.nextInt();
					System.out.println("Saisisez la position en y :");
					int y = sc.nextInt();
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
								if( ((x+1) < this.width) && ((boat.getYOrigin()-1)>=0) ){
									if(this.myGrid[x+1][boat.getYOrigin()-1].isFree() == false){
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
			}
			if(placer == false){
				System.out.println(""+ boat.getName()+" : Bateau impossible a placer");
			}
		}
		sc.close();
	}
}
