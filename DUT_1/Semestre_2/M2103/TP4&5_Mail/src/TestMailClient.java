import mail.*;
	/**
	 * The class test the object MailClient
	 * @author S.LEBERRE - FEVRIER 2017
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	public class TestMailClient {
		
		/**
		 * Test the MailClient object
		 */
		public static void testMailClient(){
		

			// Test MailClient
			System.out.println();
			System.out.println("===============================================================");
			System.out.println("===============Test of the MailClient class====================");
			System.out.println("===============================================================");

			MailServer server3 = new MailServer();

			MailClient clientA = new MailClient(server3,"Bernard");
			MailClient clientB = new MailClient(server3,"James");
			MailClient clientC = new MailClient(server3,"Toto");
			MailClient clientD = new MailClient(server3,"Titi");
			MailClient clientE = new MailClient(server3,"Tata");

			clientA.sendMailItem("James","A message from Bernard to James");
			clientB.sendMailItem("Toto","A message from James to Toto");
			clientC.sendMailItem("Titi","A message from Toto to Titi");
			clientD.sendMailItem("Tata","A message from Titi to Tata");
			clientE.sendMailItem("Bernard","A message from Tata to Bernard");
			clientB.sendMailItem("Bernard","A message from James to Bernard");

			server3.getNextMailItem("Bernard").print();
			server3.getNextMailItem("James").print();
			server3.getNextMailItem("Toto").print();
			server3.getNextMailItem("Titi").print();
			server3.getNextMailItem("Tata").print();
		}
	}