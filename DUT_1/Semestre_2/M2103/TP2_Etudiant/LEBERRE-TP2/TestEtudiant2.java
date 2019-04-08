/**
	 * Present the result of a class with the class Etudiant
	 * @author S.LEBERRE - JANVIER 2016
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	public class TestEtudiant2 {

		/**
		 * Only method in the class. All is done in her. 
		 */
		public static void main(String[] args){
			Etudiant e1 = new Etudiant("NOM1",10);
			Etudiant e2 = new Etudiant("NOM2",10);
			Etudiant e3 = new Etudiant("NOM3",10);
			Etudiant e4 = new Etudiant("NOM4",10);
			Etudiant e5 = new Etudiant("NOM5",10);
			Etudiant e6 = new Etudiant("NOM6",10);
			Etudiant e7 = new Etudiant("NOM7",10);
			Etudiant e8 = new Etudiant("NOM8",10);
			Etudiant e9 = new Etudiant("NOM9",10);
			Etudiant e10 = new Etudiant("NOM10",10);
			Etudiant e11 = new Etudiant("NOM11",10);
			Etudiant e12 = new Etudiant("NOM12",10);
			Etudiant e13 = new Etudiant("NOM13",10);
			Etudiant e14 = new Etudiant("NOM14",10);
			Etudiant e15 = new Etudiant("NOM15",10);
			Etudiant e16 = new Etudiant("NOM16",10);
			Etudiant e17 = new Etudiant("NOM17",10);
			Etudiant e18 = new Etudiant("NOM18",10);
			Etudiant e19 = new Etudiant("NOM19",10);
			Etudiant e20 = new Etudiant("NOM20",10);
			Etudiant e21 = new Etudiant("NOM21",10);
			Etudiant e22 = new Etudiant("NOM22",10);
			Etudiant e23 = new Etudiant("NOM23",10);
			Etudiant e24 = new Etudiant("NOM24",10);
			System.out.println(e1.toString()+" Average: "+e1.moyenne());
			System.out.println(e2.toString()+" Average: "+e2.moyenne());
			System.out.println(e3.toString()+" Average: "+e3.moyenne());
			System.out.println(e4.toString()+" Average: "+e4.moyenne());
			System.out.println(e5.toString()+" Average: "+e5.moyenne());
			System.out.println(e6.toString()+" Average: "+e6.moyenne());
			System.out.println(e7.toString()+" Average: "+e7.moyenne());
			System.out.println(e8.toString()+" Average: "+e8.moyenne());
			System.out.println(e9.toString()+" Average: "+e9.moyenne());
			System.out.println(e10.toString()+" Average: "+e10.moyenne());
			System.out.println(e11.toString()+" Average: "+e11.moyenne());
			System.out.println(e12.toString()+" Average: "+e12.moyenne());
			System.out.println(e13.toString()+" Average: "+e13.moyenne());
			System.out.println(e14.toString()+" Average: "+e14.moyenne());
			System.out.println(e15.toString()+" Average: "+e15.moyenne());
			System.out.println(e16.toString()+" Average: "+e16.moyenne());
			System.out.println(e17.toString()+" Average: "+e17.moyenne());
			System.out.println(e18.toString()+" Average: "+e18.moyenne());
			System.out.println(e19.toString()+" Average: "+e19.moyenne());
			System.out.println(e20.toString()+" Average: "+e20.moyenne());
			System.out.println(e21.toString()+" Average: "+e21.moyenne());
			System.out.println(e22.toString()+" Average: "+e22.moyenne());
			System.out.println(e23.toString()+" Average: "+e23.moyenne());
			System.out.println(e24.toString()+" Average: "+e24.moyenne());
			double moyclasse = 0;
				moyclasse = moyclasse + e1.moyenne();
				moyclasse = moyclasse + e2.moyenne();
				moyclasse = moyclasse + e3.moyenne();
				moyclasse = moyclasse + e4.moyenne();
				moyclasse = moyclasse + e5.moyenne();
				moyclasse = moyclasse + e6.moyenne();
				moyclasse = moyclasse + e7.moyenne();
				moyclasse = moyclasse + e8.moyenne();
				moyclasse = moyclasse + e9.moyenne();
				moyclasse = moyclasse + e10.moyenne();
				moyclasse = moyclasse + e11.moyenne();
				moyclasse = moyclasse + e12.moyenne();
				moyclasse = moyclasse + e13.moyenne();
				moyclasse = moyclasse + e14.moyenne();
				moyclasse = moyclasse + e15.moyenne();
				moyclasse = moyclasse + e16.moyenne();
				moyclasse = moyclasse + e17.moyenne();
				moyclasse = moyclasse + e18.moyenne();
				moyclasse = moyclasse + e19.moyenne();
				moyclasse = moyclasse + e20.moyenne();
				moyclasse = moyclasse + e21.moyenne();
				moyclasse = moyclasse + e22.moyenne();
				moyclasse = moyclasse + e23.moyenne();
				moyclasse = moyclasse + e24.moyenne();
			moyclasse = moyclasse/24;
			moyclasse = (double)Math.round(moyclasse*10)/10;
			System.out.println("THE AVERAGE OF THE CLASS IS ---->  " + moyclasse);
			if(moyclasse < 5.0){
				System.out.println("This class is the sadest I ever had");
			} else if(moyclasse < 10.0 ){
				System.out.println("This class doesn't have the average it's bad for them");
			}else if(moyclasse >= 10.0){
				System.out.println("This class is not bad but not good too");
			}else if(moyclasse > 15.0){
				System.out.println("This class is the best I ever had");
			}
		}
	}