package bank;
	/**
	 * Instantiates and use the object SavingsAccount
	 * @author S.LEBERRE - MARS 2017
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	 public class SavingsAccount extends BankAccount {
	 	
	 	private double interestRate;

	 	/**
	 	 * Constructor of SavingsAccount
	 	 * @param accountNumber the number of your count
	 	 * @param rate the insterest rate
	 	 */
	 	public SavingsAccount(int accountNumber, double rate){
	 		super(accountNumber,0);
	 		if(rate >= 0.0){
	 			this.interestRate = rate;
	 		} else {
	 			this.interestRate = 0.0;
	 			System.out.println("Param rate SavingsAccount FALSE");
	 		}
	 	}
	 	
	 	/**
		 * Get the interestRate of the count
		 * @return the interestRate
		 */
	 	public double getInterestRate(){
	 		return this.interestRate;
	 	}

	 	/**
	 	 * Add 0.1 pourcent to the interestRate
	 	 */
	 	public void addInterest(){
	 		this.interestRate = this.interestRate + 0.1;
	 	}

	 	/**
	 	 * Give a look to your count with a String
	 	 */
	 	public String toString(){
	 		String ret = super.toString();
	 		ret = ret + "\nYou have " + this.interestRate + " interest";
	 		return ret;
	 	}
	 }
