	/**
	 *
	 */
	public class Scenario{

		public static void main(String[] args){
			
			Pays[] tabPays = new Pays[10];
 			tabPays[0] = new Pays("Cuba",11423952,110860);
			tabPays[1] = new Pays("Chile",16454143,756950);
 			tabPays[2] = new Pays("Russia",140702094,17075200);
 			tabPays[3] = new Pays("Norway",4644457,323802);
 			tabPays[4] = new Pays("Nigeria",138283240,923768);
 			tabPays[5] = new Pays("Paraguay",6831306,406750);
 			tabPays[6] = new Pays("Oman",3311640,212460);
 			tabPays[7] = new Pays("Yemen",23013376,406750);
 			tabPays[8] = new Pays("Togo",5858673,56785);
 			tabPays[9] = new Pays("France",64057790,643427);


 			System.out.println(tabPays[0].compareTo(tabPays[4]));

 			TriParSelection pays = new TriParSelection(tabPays);
 			pays.trier();
 			for(int i = 0; i < 10; i++){
 				System.out.println(tabPays[i].toString());
 			}
 		}
	}