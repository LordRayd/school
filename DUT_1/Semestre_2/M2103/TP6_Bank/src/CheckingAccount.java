package bank;
	/**
	 * Instantiates and use the object CheckingAccount
	 * @author S.LEBERRE - MARS 2017
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	 public class CheckingAccount extends BankAccount {
	 
		private int transactionCount;
		final private int FREE_TRANSACTIONS = 3;
		final private double TRANSACTIONS_FEE = 2.0;
		
		/**
		 * Constructor of CheckingAccount object
		 * @param accountNumber the number of the count
		 */
		public CheckingAccount(int accountNumber){
			super(accountNumber,0);
			this.transactionCount = 0;
		}
		
		/**
		 * Add money to your count only if the amount is plus
		 * @param amount the sum you want to deposit on your count
		 */
		public void deposit(double amount){
			if(amount > 0){
				super.setBalance(super.getBalance() + amount);
			} else {
				System.out.println("Param deposit FALSE");
			}
		}
		
		/**
		 * Withdraw the sum given in PARAM only if this sum is plus and if you don't exceed the overdraft authorized if we withdraw
		 * @param amount the sum you want to withdraw from your count
		 */
		public void withdraw(double amount){
			if(amount > 0){
				if((super.getBalance() - amount) > super.getOverdraft()){
					super.setBalance(super.getBalance() - amount);
					this.transactionCount++;
					deductFees();
				} else {
					System.out.println("You don't have enough money on your count");
				}	
			} else {
				System.out.println("Param withdraw FALSE");
			}
		}
		
		/**
		 * Deduct the Fees if you have done more than 3 transactions
		 */
		public void deductFees(){
			if(transactionCount > FREE_TRANSACTIONS){
				super.setBalance(super.getBalance() - TRANSACTIONS_FEE);
			}
		}

		/**
		 * Give a look to your count with a String
		 */
		public String toString(){
			String ret = super.toString();
			ret = ret + "\nYou have done " + this.transactionCount + " transactions";
			return ret;
		}
	 }
