	import java.util.ArrayList;

	/**
	 *
	 */
	public class ScenarioPromotion {
		public static void main (String [] args){

			Etudiant e1 = new Etudiant("Samuel Le Berre",5);
			Etudiant e2 = new Etudiant("Gurvan Lorans-Cano",5);
			Etudiant e3 = new Etudiant("Tristan Furno",5);
			Etudiant e4 = new Etudiant("Adrien Comte",5);
			Etudiant e5 = new Etudiant("Julian Descharreaux",5);
			Etudiant e6 = new Etudiant("Yan Abdoul-Madjide-Augerau",5);
			Etudiant e7 = new Etudiant("Sylvain Paviot",5);
			Etudiant e8 = new Etudiant("Allan Comisso",5);
			Etudiant e9 = new Etudiant("Typhanie Bernard",5);
			Etudiant e10 = new Etudiant("Samuel Barre",5);
			Etudiant e11 = new Etudiant("Gwendal Bourhis",5);
			Etudiant e12 = new Etudiant("Benoit Martel",5);
			Etudiant e13 = new Etudiant("Antoine Gicquel",5);
			Etudiant e14 = new Etudiant("Maxime Herve",5);
			Etudiant e15 = new Etudiant("Alexandre de Rick",5);
			Etudiant e16 = new Etudiant("Malo Nicolle",5);
			Etudiant e17 = new Etudiant("Quentin Morissot",5);
			Etudiant e18 = new Etudiant("Donatien Sattler",5);
			Etudiant e19 = new Etudiant("Corentin De Sousa Pexeira",5);
			Etudiant e20 = new Etudiant("Justine Binot",5);
			Etudiant e21 = new Etudiant("Mathis Allain",5);
			Etudiant e22 = new Etudiant("Simon Martin",5);
			Etudiant e23 = new Etudiant("Alexandre Boudet",5);
			Etudiant e24 = new Etudiant("Alexandre Pavart",5);
			Etudiant e25 = new Etudiant("Andrea Texeira",5);

			Etudiant [] liste1 = {e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,e17,e18,e19,e20,e21,e22,e23,e24,e25};
			Promotion p1 = new Promotion("Info1",liste1);
			System.out.println(p1.toString());

			p1.setNom("Info1A");
			e1.setNom("Me");
			System.out.println(p1.toString());

			e1.setNom("Samuel Le Berre");
			Promotion p2 = new Promotion("Info1", 25);
			p2.addStudent(e1);
			p2.addStudent(e2);
			System.out.println(p2.toString());
			p2.addStudent(e11);
			p2.addStudent(e23);
			p2.addStudent(e24);
			p2.addStudent(e25);
			System.out.println(p2.toString());

			System.out.println("");
			ArrayList<Etudiant> p3 = new ArrayList<Etudiant>();
			p3.add(e2);
			p3.add(e10);
			p3.add(e25);
			p3.add(e16);
			System.out.println(p3.toString());
		}

	}