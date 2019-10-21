package battle;

	/**
	 * nom, taille, position, direction
	 * 
	 * 
	 */
	public class Ship{
		
		private String name;
		private int size;
		private int xOrigin;
		private int yOrigin;
		private int hitNumber;
		private Direction direction;
		
		/**
		 * 
		 * @param 
		 * @param 
		 */
		public Ship(String name, int size){
			this.name = name;
			this.size = size;
		}
		
		/**
		 * 
		 */
		public void addHit(){
			this.hitNumber += 1;
		}
		
		/**
		 * 
		 */
		public String toString(){
			String ret = "Nom : " + this.name;
			ret += "\nTaille : " + this.size;
			ret += "\nOrigin en X : " + this.xOrigin;
			ret += "\nOrigin en Y : " + this.yOrigin;
			ret += "\nDirection : " + this.direction;
			ret += "\nTouche : " + this.hitNumber;
			return ret;
		}
		
		/**
		 * 
		 */
		public String getName(){
			return this.name;
		}
		
		/**
		 * 
		 * @param name 
		 */
		public void setName(String name){
			if(name != null){
				this.name = name;
			}
		}
		
		/**
		 * 
		 */
		public int getSize(){
			return this.size;
		}
		
		/**
		 * 
		 * @param size
		 */
		public void setSize(int size){
			if(size > 0 ){
				this.size = size;
			}
		}
		
		/**
		 * 
		 */
		public int getXOrigin(){
			return this.xOrigin;
		}
		
		/**
		 * 
		 * @param xOrigin 
		 */
		public void setXOrigin(int xOrigin){
			if(xOrigin >= 0){
				this.xOrigin = xOrigin;
			} else {
				System.out.println("setXOrigin FALSE param");
			}
		}
		
		/**
		 * 
		 */
		public int getYOrigin(){
			return this.yOrigin;
		}
		
		/**
		 * 
		 * @param yOrigin 
		 */
		public void setYOrigin(int yOrigin){
			if(yOrigin >= 0){
				this.yOrigin = yOrigin;
			} else {
				System.out.println("setYOrigin FALSE param");
			}
		}
		
		/**
		 * 
		 */
		public int getHitNumber(){
			return this.hitNumber;
		}
		
		/**
		 * 
		 * @param hitNumber 
		 */
		public void setHitNumber(int hitNumber){
			if(hitNumber >= 0){
				this.hitNumber = hitNumber;
			}
		}
		
		/**
		 * 
		 * 
		 */
		public Direction getDirection(){
			return this.direction;
		}
	}