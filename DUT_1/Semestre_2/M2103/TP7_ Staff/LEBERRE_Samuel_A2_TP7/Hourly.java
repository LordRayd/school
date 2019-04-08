package staff;
	/**
	 * Instantiates and use the object Hourly
	 * @author S.LEBERRE - MARS 2017
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	public class Hourly extends Employee{
		
		private int hoursWorked;
		
		/**
		 * Constructor of Hourly object
		 * @param eName the name of the Hourly
		 * @param eAddress the address of the Hourly
		 * @param ePhone the phone number of the Hourly
		 * @param socSecNumber the number of the social security of the Hourly
		 * @param rate the pay per hours of the Hourly
		 */
		public Hourly(String eName, String eAddress, String ePhone, String socSecNumber, double rate){
			super(eName,eAddress,ePhone,socSecNumber,rate);
		}
		
		/**
		 * Add hours to hoursWorked of a Hourly object
		 * @param moreHours the hours you want to add
		 */
		public void addHours(int moreHours){
			if(moreHours > 0){
				this.hoursWorked = this.hoursWorked + moreHours;
			} else { 
				System.out.println("Param addHours FALSE");
			}
		}

		/**
		 * Give his salary to the Employee
		 * @return the salary of the Employee
		 */
		public double pay(){
			double ret = this.payRate * this.hoursWorked;
			return ret;
		}
		
		/**
		 * Give a String of the Employee object
		 * @return a sentence who describ the Employee object
		 */
		public String toString(){
			String ret = super.toString();
			ret = ret + "\nHe have worked " + this.hoursWorked + " hours";
			return ret;
		}
	}
