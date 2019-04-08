package staff;
	/**
	 * Instantiates and use the object StaffMember
	 * @author S.LEBERRE - MARS 2017
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	public abstract class StaffMember{
		
		protected String name;
		protected String address;
		protected String phone;
		
		/**
		 * Constructor of a StaffMember object
		 * @param eName the name of the member
		 * @param eAddress the address of the member
		 * @param ePhone the phone number of the Member
		 */
		public StaffMember(String eName, String eAddress, String ePhone){
			if(eName != null){
				this.name = eName;
			} else {
				System.out.println("Param eName StaffMember FALSE");
				this.name = "unknow";
			}
			if(eAddress != null){
				this.address = eAddress;
			} else {
				System.out.println("Param eAddress StaffMember FALSE");
				this.address = "unknow";
			}
			if(ePhone != null){
				this.phone = ePhone;
			} else {
				System.out.println("Param ePhone StaffMember FALSE");
				this.phone = "unknow";
			}
		}
		
		/**
		 * Give the salary of the member. It's an abstract method.
		 * @return the salary of the member
		 */
		public abstract double pay();
		
		/**
		 * Give a String of the StaffMember object
		 * @return a sentence who describ the StaffMember object
		 */
		public String toString(){
			String ret = "\nThe Member is named : " + this.name + "\nHe live at :" + this.address + "\nHis cellphone is :" + this.phone;
			return ret;
		}
	}
