import mail.*;
	/**
	 * A class who call the class TestMailItem, TestMailServer and TestMailClient
	 * @author S.LEBERRE - FEVRIER 2017
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	public class MailTest{

		/**
		 * The method call the test methods
		 * @param args the possible args at the call of the class MailTest
		 */
		public static void main(String[] args){


			//Call of the test Methods
			TestMailItem.testMailItem();
			TestMailServer.testMailServer();
			TestMailClient.testMailClient();
		}
	}