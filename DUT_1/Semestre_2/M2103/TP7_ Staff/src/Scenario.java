import staff.*;
	/**
	 * Test the package staff with a scenario
	 * @author S.LEBERRE - MARS 2017
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	public class Scenario{

		public static void main(String[] args){

			Staff staff1 = new Staff();

			// Object Volunteer
			Volunteer volunteer1 = new Volunteer("Samuel LE BERRE","Impasse des dauphins 56400 Vannes","0645256325");
			Volunteer volunteer2 = new Volunteer("Gurvan LORANS-CANO","32 rue du général de Gaulle 56400 Vannes","0685642654");
			Volunteer volunteer3 = new Volunteer("Adrien COMTE","16 rue Jean Jaurès 56400 Vannes","0634562515");
			Volunteer volunteer4 = new Volunteer("Tristan FURNO","75 rue Pasteur 56400 Vannes","0614523652");

			//Object Hourly
			Hourly hourly1 = new Hourly("Yan Augerau","14 rue Jean Marin","0652351456","125032145",10.5);
			Hourly hourly2 = new Hourly("Malo Nicolle","45 rue Jean Marin","061789652","145627851",9.5);
			Hourly hourly3 = new Hourly("Samuel Barre","42 rue Jean Marin","0615235524","065287203",11.3);
			Hourly hourly4 = new Hourly("Julian Descharreaux","01 rue Jean Marin","0642425452","872512515",7.8);

			//Object Executive
			Executive executive1 = new Executive("Alexandre Boudet","2 rue Michel Behic","0625362514","472422515",2500);

			//Add member to staff1
			staff1.addNewMember(volunteer1);
			staff1.addNewMember(volunteer2);
			staff1.addNewMember(volunteer3);
			staff1.addNewMember(volunteer4);
			staff1.addNewMember(hourly1);
			staff1.addNewMember(hourly2);
			staff1.addNewMember(hourly3);
			staff1.addNewMember(hourly4);
			staff1.addNewMember(executive1);

			//Add hours to Hourly object
			hourly1.addHours(20);
			hourly2.addHours(20);
			hourly3.addHours(20);
			hourly4.addHours(20);

			//Add bonus to Executive object
			executive1.awardBonus(250);

			//toString on all object
			System.out.println(volunteer1.toString());
			System.out.println(volunteer2.toString());
			System.out.println(volunteer3.toString());
			System.out.println(volunteer4.toString());
			System.out.println(hourly1.toString());
			System.out.println(hourly2.toString());
			System.out.println(hourly3.toString());
			System.out.println(hourly4.toString());
			System.out.println(executive1.toString());

			//It's the day to pay members
			staff1.payDay();

		}
	}