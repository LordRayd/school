package staff;
	/**
	 * Instantiates and use the object Volunteer
	 * @author S.LEBERRE - MARS 2017
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	public class Volunteer extends StaffMember{
		
		/**
		 * Constructor of Volunteer
		 * @param eName the name of the Volunteer
		 * @param eAddress the address of the Volunteer
		 * @param ePhone the phone number of the Volunteer
		 */
		public Volunteer(String eName, String eAddress, String ePhone){
			super(eName,eAddress,ePhone);
		}
		
		/**
		 * The volunteer is not paid so he receive 0.0
		 * @return 0.0 because the volunteer is not pay
		 */
		public double pay(){
			return 0.0;
		}
	}
