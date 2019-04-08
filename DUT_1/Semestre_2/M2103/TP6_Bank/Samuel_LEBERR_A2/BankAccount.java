package bank;
	/**
	 * Instantiates and use the super class BankAccount
	 * @author S.LEBERRE - MARS 2017
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	 public class BankAccount {
	 
		private int accountNumber;
		private double balance;
		private double authorizedOverdraft;
		
		/**
		 * Constructor of BankAccount
		 * @param anAccountNumber the number of the count
		 * @param overdraft the overdraft of the count
		 */
		public BankAccount(int anAccountNumber, double overdraft){
			if(anAccountNumber >= 0){
				this.accountNumber = anAccountNumber;
			} else {
				accountNumber = -1;
				System.out.println("Param anAccountNumber BankAccount FALSE");
			}
			if(overdraft <= 0){
				this.authorizedOverdraft = overdraft;
			} else {
				overdraft = 0;
				System.out.println("Param overdraft BankAccount FALSE");
			}
			this.balance = 0;
		}
		
		/**
		 * Get the accountNumber of the count
		 * @return the accountNumber
		 */
		public double getAccountNumber(){
			return this.accountNumber;
		}

		/**
		 * Get the sum on the count
		 * @return the balance
		 */
		public double getBalance(){
			return this.balance;
		}

		/**
		 * Change the balance by the new one given in PARAM
		 * @param n the new balance
		 */
		public void setBalance(double n){
			if(n >= 0){
				this.balance = n;
			} else {
				System.out.println("Param setBalance FALSE");
			}
		}

		/**
		 * Get the overdraft authorized on the count
		 * @return the overdraft authorized
		 */
		public double getOverdraft(){
			return this.authorizedOverdraft;
		}

		/**
		 * Change the overdraft authorized by the new one given in PARAM. Don't change the overdraft if the new overdraft is plus.
		 * @param n the new overdraft authorized
		 */
		public void setOverdraft(double n){
			if(n <= 0){
				this.authorizedOverdraft = n;
			} else {
				System.out.println("Param setOverdraft FALSE");
			}
		}
		
		/**
		 * Addmoney to your count only if the amount is plus
		 * @param amount the sum you want to deposit on your count
		 */
		public void deposit(double amount){
			if(amount > 0){
				this.balance = this.balance + amount;
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
				if((this.balance-amount) > this.authorizedOverdraft){
					this.balance = this.balance - amount;
				} else {
					System.out.println("You don't have enough money on your count");
				}
			} else {
				System.out.println("Param withdraw FALSE");
			}
		}
		
		/**
		 * Tranfert money from your count to an other one
		 * @param amount the sum you want to transfert 
		 * @param other the count where you transfert your money
		 */
		public void transfert(double amount, BankAccount other){
			if(amount > 0 && other != null){
				if((this.balance-amount) > this.authorizedOverdraft){
					this.withdraw(amount);
					other.deposit(amount);
				}
			} else {
				System.out.println("Param transfert FALSE");
			}
		}

		/**
		 * Give a look to your count with a String
		 */
		public String toString(){
			String ret = "Your count Number : "+ this.getAccountNumber();
			ret = ret + "\nYou have " + getBalance() + " on your count";
			ret = ret + "\nYou can have an overdraft of : " + getOverdraft();
			return ret;
		}
	 }
