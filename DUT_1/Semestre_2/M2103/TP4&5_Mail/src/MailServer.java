package mail;
import java.util.ArrayList;
	/**
	 * Instantiates and use the object MailServer
	 * @author S.LEBERRE - FEVRIER 2017
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	public class MailServer{
		
		private ArrayList<MailItem> items;

		/**
		 * Constructor of MailServer
		 */
		public MailServer(){
			this.items = new ArrayList<MailItem>();
		}
		
		/**
		 * Method who return to us the number of mail which posesses a user
		 * @param who the user we want to know the number of mail
		 * @return The number of mail which possesses the user
		 */
		public int howManyMailItems(String who){
			int ret = 0;
			if(this.items != null && this.items.size() > 0 && who != null){
				for(MailItem item : this.items){
					if((item.getTo()).equals(who)){
						ret++; 
					}
				}
			} else {
				System.out.println("\nparam FALSE for howManyMailItems");
			}
			return ret;
		}
		
		/**
		 * Method who give us the last mail a user receive and return null if the user doesn't have any mail
		 * @param who the user we want to know the last mail he receive
		 * @return the last mail the user receive
		 */
		public MailItem getNextMailItem(String who){
			MailItem ret = null;
			if(this.items != null && this.items.size() > 0 && who != null && howManyMailItems(who)>0){
				for(MailItem item : this.items){
					if((item.getTo()).equals(who)){
						ret = item;
					}
				}
				this.items.remove(ret);
			} else{
				System.out.println("\nparam FALSE for getNextMailItem");
			}
			return ret;
		}

		/**
		 * Add in the items list a mail we give in parameter
		 * @param item we want to add to the ArrayList items
		 */
		public void post(MailItem item){
			if(item != null && this.items != null){
				this.items.add(item);
			} else{
				System.out.println("\nparam FALSE for post");
			}
		}
	}
