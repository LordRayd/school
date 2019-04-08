package staff;
		/**
	 * Instantiates and use the object Executive
	 * @author S.LEBERRE - MARS 2017
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	public class Executive extends Employee{
		
		private double bonus;

		/**
		 * Constructor of Executive object
		 * @param eName the name of the Executive
		 * @param eAddress the address of the Executive
		 * @param ePhone the phone number of the Executive
		 * @param socSecNumber the number of the social security of the Executive
		 * @param rate the pay per month of the Executive
		 */
		public Executive(String eName, String eAddress, String ePhone, String socSecNumber, double rate){
			super(eName,eAddress,ePhone,socSecNumber,rate);
		}

		/**
		 * Give his salary to the Employee
		 * @return the salary of the Employee
		 */
		public double pay(){
			double ret = this.payRate + this.bonus;
			this.bonus = 0.0;
			return ret;
		}

		/**
		 * Add a bonus to the bonus already existing
		 * @param execBonus the bonus you want to add to the old bonus
		 */
		public void awardBonus(double execBonus){
			if(execBonus > 0.0){
				this.bonus = this.bonus + execBonus;
			} else {
				System.out.println("Param awardBonus FALSE");
			}
		}

		/**
		 * Give a String of the Employee object
		 * @return a sentence who describ the Employee object
		 */
		public String toString(){
			String ret = super.toString();
			ret = ret + "\nHe have a bonus of : " + this.bonus;
			return ret;
		}
	}
