import mail.*;
	/**
	 * The class test the object MailServer
	 * @author S.LEBERRE - FEVRIER 2017
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	public class TestMailServer {
		
		/**
		 * Test the MailServer object
		 */
		public static void testMailServer(){

			System.out.println();
			System.out.println("===============================================================");
			System.out.println("===============Test of the MailServer class====================");
			System.out.println("===============================================================");

			// The server 
			MailServer server1 = new MailServer();
			MailServer server2 = new MailServer();

			// The mails
			MailItem item1 = new MailItem("Pierre","Jean","Hello Mr Jean");
			MailItem item2 = new MailItem("Pierre","Jacque","Sorry i ll be late to our meeting");
			MailItem item3 = new MailItem("Jean","Pierre","To continue our conversation");
			MailItem item4 = new MailItem(null,null,null);
			MailItem item5 = new MailItem("Pierre",null,null);
			MailItem item6 = new MailItem(null,"Jacque",null);
			MailItem item7 = new MailItem(null,null,"Hello we are going to play a game");
			MailItem item8 = new MailItem("Jean","Pierre","To end the conversation");
			MailItem item9 = new MailItem("Jean","Pierre","The best conversation ever");
			MailItem item10 = null;

			// enter mail in server1
			server1.post(item1);
			server1.post(item2);
			server1.post(item3);
			server1.post(item8);

			// enter mail in server2
			server2.post(item4);
			server2.post(item5);
			server2.post(item6);
			server2.post(item7);

			// view and use server1
				//test of getNextMailItem && howManyMailItems
				System.out.println("\nPierre have "+server1.howManyMailItems("Pierre")+" mails unread");
				server1.getNextMailItem("Pierre").print();
				System.out.println("\nPierre have "+server1.howManyMailItems("Pierre")+" mails unread");
				server1.getNextMailItem("Pierre").print();
				System.out.println("\nPierre have "+server1.howManyMailItems("Pierre")+" mails unread");
				server1.post(item9);
				System.out.println("\nPierre have "+server1.howManyMailItems("Pierre")+" mails unread");

			// view and use server2
				server2.getNextMailItem("Jacque").print();

				server2.post(item10);

				MailItem lastbertrand = server2.getNextMailItem("Bertrand");
				System.out.println("Last message of Bertrand : " + lastbertrand);


		}
	}			