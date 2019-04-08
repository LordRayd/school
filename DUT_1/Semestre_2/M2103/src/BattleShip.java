package battle;

import java.io.*;
import java.util.*;
import java.util.ArrayList;
	
	/**
	 * 
	 * 
	 * 
	 */
	public class BattleShip {
		
		private int width;
		private int height;
		private final String delimiter ="\\s^:\\s^";
		private Game gamePlay;
		private ArrayList<Ship> fleet;
		
		public BattleShip(String fileName, String playerName1, String playerName2){
			this.configure(fileName);
			this.gamePlay = new Game(this.fleet,playerName1,playerName2,this.width,this.height);
		}
		
		private void configure(String fileName){
			this.width =10;
			this.height = 10;
		}
		
		public Game getPlay(){
			return this.gamePlay;
		}
		
		public void printConfiguration(){
			
		}
	}
