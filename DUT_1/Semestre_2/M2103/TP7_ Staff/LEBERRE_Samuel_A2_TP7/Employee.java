package staff;
	/**
	 * Instantiates and use the object Employee
	 * @author S.LEBERRE - MARS 2017
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	public class Employee extends StaffMember{ 
		
		protected String socialSecurityNumber;
		protected double payRate;
		
		/**
		 * Constructor of Employee object
		 * @param eName the name of the Employee
		 * @param eAddress the address of the Employee
		 * @param ePhone the phone number of the Employee
		 * @param socSecNumber the number of the social security of the Employee
		 * @param rate the pay per hours of the Employee
		 */
		public Employee(String eName, String eAddress, String ePhone, String socSecNumber, double rate){
			super(eName,eAddress,ePhone);
			if(socSecNumber != null){
				this.socialSecurityNumber = socSecNumber;
			} else {
				System.out.println("Param socSecNumber Employee FALSE");
				this.socialSecurityNumber = "unknow";
			}
			if(rate > 0 ){
				this.payRate = rate;
			} else {
				System.out.println("Param rate Employee FALSE");
				this.payRate = 0.1;
			}
		}
		
		/**
		 * Give his salary to the Employee
		 * @return the salary of the Employee
		 */
		public double pay(){
			return this.payRate;
		}
		
		/**
		 * Give a String of the Employee object
		 * @return a sentence who describ the Employee object
		 */
		public String toString(){
			String ret = super.toString();
			ret = ret + "\nHis social security number is :" + this.socialSecurityNumber + "\nHis salary is : " + this.payRate;
			return ret;
		}
	}
