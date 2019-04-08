	/**
	 *
	 */
	public class TriParSelection implements ITri{

		private Pays[] tab;

		/**
		 *
		 * @param tab 
		 */
		public TriParSelection(Pays[] tab){
			if(tab != null && tab.length > 0){
				this.tab = tab;
			}else{
				System.out.println("ERROR : tab TriParSelection");
			}
		}

		/**
		 *
		 * @param debut 
		 * @return 
		 */
		private int minimumPosition(int debut){
			int ret = debut;
			for(int i = debut; i < this.tab.length; i++){
				if(this.tab[i].getSurface() < this.tab[ret].getSurface()){
					ret = i;
				}
			}
			return ret;
		}

		/**
		 *
		 * @param i 
		 * @param j 
		 */
		private void swap(int i, int j){
			if(i >= 0 && j >=0 && i < this.tab.length && j < this.tab.length){
				Pays tmp = this.tab[i];
				this.tab[i] = this.tab[j];
				this.tab[j] = tmp;
			}
		}

		/**
		 *
		 */
		public void trier(){
			for(int i = 0; i < this.tab.length; i++){
				int indice = this.minimumPosition(i);
				this.swap(i,indice);
			}
		}
	}