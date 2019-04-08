package battle;
	/**
	 * coordonées
	 * état : libre ou occupé
	 * 
	 */
	public class Square{
		
		private int x;
		private int y;
		private boolean free;
		private boolean hit;
		
		public Square(int x, int y){
			this.x =x;
			this.y = y;
			this.free = true;
			this.hit = false;
		}
		
		public void setHit(){
			this.hit = true;
		}
		
		public void setBusy(){
			this.free = true;
		}
		
		public String toString(){
			String ret = null;
			return ret;
		}
		
		public int getX(){
			return this.x;
		}
		
		public void setX(int x){
			if(x >= 0){
				this.x = x;
			} else {
				System.out.println("setX FALSE param");
			}
		}
		
		public int getY(){
			return this.y;
		}
		
		public void setY(int y){
			if(y >= 0){
				this.y = y;
			} else {
				System.out.println("setY FALSE param");
			}
		}
		
		public boolean isFree(){
			return this.free;
		}
		
		public boolean isHit(){
			return this.hit;
		}		
	}
