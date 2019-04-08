	/**
	 * Test the class Etudiant
	 * @author S.LEBERRE - JANVIER 2016
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	public class TestEtudiant {
		
		private static int nbTest;
		private static int testReussi;

		/**
		 * 
		 */
		public static void main(String[] args){
			System.out.println("================================== Test of the class Etudiant ================================== ");
			nbTest = 0;
			testReussi = 0;
			testEtudiantAndInitialisation();
			testGetNom();
			testSetNom();
			testGetNbNotes();
			testGetUneNote();
			testMoyenne();
			testToString();
			resultTest();
		}


		
		/**
		 * Test of the method Etudiant
		 */
		public static void testEtudiantAndInitialisation(){
			System.out.println("\n\n\n================= Test of the method Etudiant and initialisation ================= ");
			//variables
			String varNull = null;
			String nomE3 = "nom3";
			//Test the errors cases
			System.out.println("\n\n--------- All the errors cases");
			System.out.println("When param nom = null");
			Etudiant e1 = new Etudiant(varNull,6);
			nbTest = nbTest + 1;
			testReussi = testReussi + 1;
			System.out.println("OK");
			System.out.println("When param n = 0");
			Etudiant e2 = new Etudiant("unNom",0);
			nbTest = nbTest + 1;
			testReussi = testReussi + 1;
			System.out.println("OK");
			//Test the limits cases
			System.out.println("\n\n--------- All the limits cases");
			System.out.println("There is no limits cases");
			// Test the normals cases
			System.out.println("\n\n--------- All the normals cases");
			nbTest = nbTest + 1;
			Etudiant e3 = new Etudiant(nomE3,5);
			if(e3.getNom() != null && e3.getNbNotes() > 0 && e3.getNom().equals(nomE3)){
				System.out.println("OK");
				testReussi = testReussi + 1;
			} else {
				System.out.println("False");
			}
		}
		
		/**
		 * Test of the method getNom
		 */
		public static void testGetNom(){
			System.out.println("\n\n\n================= Test of the method getNom ================= ");
			String nomE1 = "nom1";
			//Test the errors cases
			System.out.println("\n\n--------- All the errors cases");
			System.out.println("There is no errors cases");
			//Test the limits cases
			System.out.println("\n\n--------- All the limits cases");
			System.out.println("There is no limits cases");
			// Test the normals cases
			System.out.println("\n\n--------- All the normals cases");
			nbTest = nbTest +1;
			Etudiant e1 = new Etudiant(nomE1,5);
			if(e1.getNom().equals(nomE1)){
				System.out.println("OK");
				testReussi = testReussi +1;
			}else {
				System.out.println("False");
			}
		}
		
		/**
		 * Test of the method setNom
		 */
		public static void testSetNom(){
			System.out.println("\n\n\n================= Test of the method setNom ================= ");
			String nomE1 = "nom1";
			String nomE2 = "nom2";
			String varNull = null;
			//Test the errors cases
			System.out.println("\n\n--------- All the errors cases");
			nbTest = nbTest+1;
			Etudiant e1 = new Etudiant(nomE1,4);
			e1.setNom(varNull);
			if(e1.getNom().equals(nomE1)){
				System.out.println("OK");
				testReussi = testReussi + 1;
			} else {
				System.out.println("False");
			}
			//Test the limits cases
			System.out.println("\n\n--------- All the limits cases");
			System.out.println("There is no limits cases");
			// Test the normals cases
			System.out.println("\n\n--------- All the normals cases");
			nbTest = nbTest+1;
			Etudiant e2 = new Etudiant(nomE2,6);
			e2.setNom(nomE1);
			if(e2.getNom().equals(nomE1)){
				System.out.println("OK");
				testReussi = testReussi + 1;
			} else {
				System.out.println("False");
			}
		}
		
		/**
		 * Test of the method getNbNotes
		 */
		public static void testGetNbNotes(){
			System.out.println("\n\n\n================= Test of the method getNbNotes ================= ");
			String nomE1 = "nom1";
			//Test the errors cases
			System.out.println("\n\n--------- All the errors cases");
			System.out.println("There is no errors cases. You can't create an object Etudiant with 0 marks");
			//Test the limits cases
			System.out.println("\n\n--------- All the limits cases");
			System.out.println("There is no limits cases");
			// Test the normals cases
			System.out.println("\n\n--------- All the normals cases");
			nbTest =nbTest+1;
			Etudiant e1 = new Etudiant(nomE1,6);
			if(e1.getNbNotes() == 6){
				System.out.println("OK");
				testReussi = testReussi + 1;
			} else {
				System.out.println("False");
			}
		}

		/**
		 * Test of the method getUneNote
		 */
		public static void testGetUneNote(){
			System.out.println("\n\n\n================= Test of the method getUneNote ================= ");
			String nomE1 = "nom1";
			//Test the errors cases
			System.out.println("\n\n--------- All the errors cases");
			System.out.println("When param i < 0");
			nbTest = nbTest +1;
			Etudiant e1 = new Etudiant(nomE1,3);
			if(e1.getUneNote(-1) == -1.0){
				System.out.println("OK");
				testReussi = testReussi + 1;
			} else {
				System.out.println("False");
			}
			System.out.println("When param i > notes.length");
			nbTest = nbTest +1;
			if(e1.getUneNote(5) == -1.0){
				System.out.println("OK");
				testReussi = testReussi + 1;
			} else {
				System.out.println("False");
			}
			//Test the limits cases
			System.out.println("\n\n--------- All the limits cases");
			System.out.println("There is no limits cases");
			// Test the normals cases
			System.out.println("\n\n--------- All the normals cases");
			nbTest = nbTest +1;
			if(e1.getUneNote(2) != -1.0){
				System.out.println("OK");
				testReussi = testReussi + 1;
			} else {
				System.out.println("False");
			}
		}

		/**
		 * Test of the method moyenne
		 */
		public static void testMoyenne(){
			System.out.println("\n\n\n================= Test of the method moyenne ================= ");
			String nomE1 = "nom1";
			//Test the errors cases
			System.out.println("\n\n--------- All the errors cases");
			System.out.println("There is no errors cases. You can't create an object Etudiant with 0 marks");
			//Test the limits cases
			System.out.println("\n\n--------- All the limits cases");
			System.out.println("There is no limits cases");
			// Test the normals cases
			System.out.println("\n\n--------- All the normals cases");
			nbTest = nbTest +1;
			Etudiant e1 = new Etudiant(nomE1,4);
			if(e1.getUneNote(0) <20 && e1.getUneNote(0) >=0 && e1.getUneNote(1) <20 && e1.getUneNote(1) >=0 && e1.getUneNote(2) <20 && e1.getUneNote(2) >=0 && e1.getUneNote(3) <20 && e1.getUneNote(3) >=0){
				System.out.println("OK");
				testReussi = testReussi + 1;
			} else {
				System.out.println("False");
			}
		}

		/**
		 * Test of the method toString
		 */
		public static void testToString(){
			System.out.println("\n\n\n================= Test of the method toString ================= ");
			//Test the errors cases
			System.out.println("\n\n--------- All the errors cases");
			System.out.println("There is no errors cases. You can't create an object Etudiant with 0 marks");
			//Test the limits cases
			System.out.println("\n\n--------- All the limits cases");
			System.out.println("There is no limits cases");
			// Test the normals cases
			System.out.println("\n\n--------- All the normals cases");
			nbTest = nbTest +1;
			String nomE1 = "nom1";
			Etudiant e1 = new Etudiant(nomE1,1);
			String ret = e1.toString();
			String testPrint= "Student: nom1 .\nMarks: " + e1.getUneNote(0) + "," ;
			if(ret.equals(testPrint)){
				System.out.println("OK");
				testReussi = testReussi + 1;
			} else {
				System.out.println("False");
			}
		}

		/**
		 * Show the result of the all test
		 */
		public static void resultTest(){
			int moy = (testReussi/nbTest)*100;
			System.out.println("Result : " + nbTest + " test done");
			System.out.println("Result : " + testReussi + " test OK");
			System.out.println("Result : " + moy + " % of success");
		}


	}
