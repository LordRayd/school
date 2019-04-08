	/**
	 * Test the class ElevesBinaire
	 * @author S.LEBERRE - MARS 2017
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	public class TestPartB {

		/**
		 * Test the ElevesBinaire object
	 	 * @param args the possible argument
		 */
		public static void main(String[] args){
			ElevesBinaire eleve1 = new ElevesBinaire("Robert");
			ElevesBinaire eleve2 = new ElevesBinaire("Bernarde");

		
			Evaluation eval1 = new Evaluation(20,1);
			Evaluation eval2 = new Evaluation(5,4);
			Evaluation eval3 = new Evaluation(3,3);
			Evaluation eval4 = new Evaluation(10,10);
			Evaluation eval5 = new Evaluation(1,10);
			Evaluation eval6 = new Evaluation(10,1);
		
			eleve1.addEvaluation(eval1);
			eleve1.addEvaluation(eval2);
			eleve1.addEvaluation(eval3);
			eleve1.addEvaluation(eval4);
			eleve2.addEvaluation(eval5);
			eleve2.addEvaluation(eval6);
		
			System.out.println(eleve1.toRead());
			System.out.println(eleve2.toRead());
		
			eleve1.ecrireTexte("eleveBinaire1");
			eleve2.ecrireTexte("eleveBinaire2");
			eleve1.lireTexte("eleveBinaire2");
			eleve2.lireTexte("eleveBinaire1");
		}
	}
