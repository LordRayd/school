import pays.*;

	/**
	 * Test the package pays and utilitaire
	 * @author S.LEBERRE - AVRIL 2017
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	public class TestPopulation{

		/**
		 * Test the pays and utilitaire packages
	 	 * @param args the possible argument
		 */
		public static void main(String[] args){

			Population population = new Population("popFile","areaFile");
			System.out.println("\nName of countries : \n"+population.getListePays());
			System.out.println("\nPopulation : \n"+population.getPopMap());
			System.out.println("\nArea : \n"+population.getAreaMap());
			
		}
	}
