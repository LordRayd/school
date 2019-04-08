package mail;
	/**
	 * Instantiates and use the object MailClient
	 * @author S.LEBERRE - FEVRIER 2017
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	public class MailClient{
	
		private String user;
		private MailServer server;

		/**
		 * Constructor of the Client object
	 	 * @param server the server the user is on
	 	 * @param user the name of the client
	 	 */
		public MailClient(MailServer server, String user){
			if(server != null){
				this.server = server;
			} else {
				System.out.println("ERROR MailClient : server null");
			}
			if(user != null){
				this.user = user;
			} else {
				System.out.println("ERROR MailClient : user null");
			}
		}

		/**
		 * Take the last message the client receive
		 * @return the last message the user receive
		 */
		public MailItem getNextMailItem(){
			return this.server.getNextMailItem(user);
		}

		/**
		 * Print the last message the client receive
		 */
		public void printNextMailItem(){
			this.server.getNextMailItem(user).print();
		}

		/**
		 * Send the message ona server
		 * @param to the person you want to send the message
		 * @param message the message you want to send
		 */
		public void sendMailItem(String to, String message){
			if(to == null){
				to = "unknow";
			}
			if(message == null){
				message = "unknow";
			}
			MailItem item = new MailItem(user,to,message);
			this.server.post(item);
		}
	}