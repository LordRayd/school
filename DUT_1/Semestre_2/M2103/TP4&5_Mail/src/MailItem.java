package mail;
	/**
	 * Instantiates and use the object MailItem
	 * @author S.LEBERRE - FEVRIER 2017
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	public class MailItem {
		private String to;
		private String from;
		private String message;
		
		/**
		 * Constructor of the MailItem class
		 * @param from the sender
		 * @param to the receiver
		 * @param message the message the sender want to pass to the receiver
		 */
		public MailItem(String from, String to, String message){
			if(from != null ){
				this.from = from;
			} else{
				this.from = "unknow";
			}
			if(to != null){
				this.to = to;
			} else{
				this.to = "unknow";
			}
			if(message != null){
				this.message = message;
			} else{
				this.message = "unknow";
			}
		}
		
		/**
		 * Give to us the name of the sender of the object MailItem
		 * @return the sender of the mail
		 */
		public String getFrom(){
			String ret = "\nParam from FALSE";
			if(this.from != null){
				ret = this.from;
			}
			return ret;
		}
		
		/**
		 * give to us the name of the receiver of the object MailItem
		 * @return the receiver of the mail
		 */
		public String getTo(){
			String ret = "\nParam to FALSE";
			if(this.to != null){
				ret = this.to;
			}
			return ret;
		}
		
		/**
		 * Give to us the content of the message the sender want to pass to the receiver
		 * @return the massage of the object MailItem
		 */
		public String getMessage(){
			String ret = "\nParam message FALSE";
			if(this.message != null){
				ret = this.message;
			}
			return ret;
		}

		/**
		 * Give the view of the MailItem object with the method getFrom, getTo and getMessage
		 */
		public void print(){
			if(this != null && this.from != null && this.to != null && this.message != null){
			System.out.println("\nThe sender is : "+this.from+"\nThe receiver is : "+this.to+"\nMessage : "+this.message);
			} else{
				System.out.println("\nparam FALSE for print");
			}
		}
	}
