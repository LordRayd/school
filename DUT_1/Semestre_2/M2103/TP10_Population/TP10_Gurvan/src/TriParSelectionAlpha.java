package tri;
import pays.*;
import java.util.ArrayList;

/**
 * class TriParSelection
 * sort countries on their surfaces
 * */
public class TriParSelectionAlpha{
	private Pays[] tab;

	/**
	 * constructor for TriParSelection
	 * @param arrayList the tab who'll be sorted
	 * */
	public TriParSelectionAlpha(ArrayList<Pays> arrayList){
		if(arrayList != null){
			this.tab = new Pays[arrayList.size()];
			for (int i = 0; i < this.tab.length; i++){
				this.tab[i] = arrayList.get(i);
			}
			trierAlpha();
		}else{
			System.out.println("tableau inexistant");
		}
	}

	/**
	 * Getter that will return the collection in ArrayList
	 * @return the collection sort into ArrayList
	 */
	public ArrayList<Pays> getPays(){
		ArrayList<Pays> arrayList = new ArrayList<Pays>(tab.length);
		for(int i = 0; i< this.tab.length; i++){
			arrayList.add(this.tab[i]);
		}
		return arrayList;
	}

	/**
	 * method minimumPosition
	 * returns the index of the lowest surface
	 * @param debut the index where you start to sort
	 * @return minPos the index of the minimum surface
	 * */
	private int minimumPositionAlpha(int debut){
		int minPos = debut;
		int i = debut;
		while(i<this.tab.length ){
			if(this.tab[i].getNom().compareTo(this.tab[minPos].getNom()) < 0 ){
				minPos = i;
			}
			i++;
		}
		return minPos;
	}

	/**
	 * method swap
	 * shambles 2 countries int the tab of countries
	 * @param i the first integer to swap
	 * @param j the second integer to swap
	 * */
	public void swap(int i , int j){
		Pays k;
		k = tab[j];
		tab[j] = tab[i];
		tab[i] = k;
	}

	/**
	 * method trier
	 * sort countries using swap and minimumPosition
	 * */
	public void trierAlpha(){
		int min = 0;
		for(int i =0; i< this.tab.length-1 ; i++){
			min = this.minimumPositionAlpha(i);
			this.swap(min, i);
		}
	}
}
