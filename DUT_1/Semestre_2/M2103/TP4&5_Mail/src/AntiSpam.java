package mail;
public class AntiSpam{
	/**
	 *
	 */
	ArrayList<String> filtres;

	/**
	 * Constructor of the AntiSpam object
	 */
	public AntiSapam(ArrayList<String> filtres){
		if(filtres != null){
			this.filtres = filtres;
		} else {
			this.filtres = new ArrayList<String>()
		}
	}

	public boolean scan(String message){

	} 

	public void add(String f){
		if(f != null){
			this.filtres.add(f);
		} else {
			System.out.println("ERROR add String in parameter is NULL");
		}
	}
}