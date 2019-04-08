package tri;
import pays.Pays;

/**
 * This class implements the ITri interface made by LORANS G.
 * It is call TriParSelection because this class will take arrays into parameters, and sort it, and that's all
 * @author LORANS G.
 * @version 1.0
 */
public class TriParSelection implements ITri{
	// This attribute will be an array that will be put in parameter
	private Pays[] tab;

	/**
	 * This constructor will take array of "Pays" to sort it you will make an instance of TriParSelection and it will change values of arrays directly into the arrays
	 * when this object is instancied, the arrays will be sort automatically
	 * @param tab the Array to sort
	 */
	public TriParSelection(Pays[] tab){
		if(tab != null){
			this.tab = tab;
			this.trier();
		}else{
			System.out.println("ERROR : Array Null");
		}
	}

	/**
	 * This method will search the index of the minimum value into the array
	 * @param debut this will permit to change the index where the research will start
	 * @return the index of the minimum value
	 */
	private int minimumPosition(int debut){
		int minim = debut;
		for(int i = debut+1; i < this.tab.length; i++){
			if(this.tab[i].compareTo(this.tab[minim]) == -1 ){
				minim = i;
			}
		}
		return minim;
	}

	/**
	 * This method will swap two values into an array
	 * @param i it's the first index of the value to swap
	 * @param j it's the second index of the value to swap
	 */
	private void swap (int i, int j){
		Pays tmp = tab[i];
		tab[i] = tab[j];
		tab[j] = tmp;
	}

	/**
	 * This procedure uses two other (swap and minimumPosition),
	 * It will start to an index it search the minimum value between i and the size of the Array,
	 * And it put the minimum to the start of the index and it add 1 to the start index
	 */
	public void trier(){
		for(int i = 0; i < this.tab.length-1; i++){
			this.swap(i, this.minimumPosition(i));
		}
	}
}// End TriParSelection
