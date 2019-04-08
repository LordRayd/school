import mail.*;
	/**
	 * The class test the object MailItem
	 * @author S.LEBERRE - FEVRIER 2017
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	public class TestMailItem {
		
		/**
		 * Test the MailItem object
		 */
		public static void testMailItem(){

			System.out.println();
			System.out.println("===============================================================");
			System.out.println("===============Test of the MailItem class======================");
			System.out.println("===============================================================");

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

			//test getFrom
			System.out.println("\nSender of the first mail : "+item1.getFrom());
			System.out.println("Sender of the forth mail : "+item4.getFrom());

			//test getTo
			System.out.println("\nReceiver of the first mail : "+item1.getTo());
			System.out.println("Receiver of the forth mail : "+item4.getTo());

			//test getMessage
			System.out.println("\nMessage of the first mail : "+item1.getMessage());
			System.out.println("Message of the forth mail : "+item4.getMessage());

			// View of the mails
			item1.print();
			item2.print();
			item3.print();
			item4.print();
			item5.print();
			item6.print();
			item7.print();
			item8.print();
			item9.print();
			//item10.print();
		}
	}