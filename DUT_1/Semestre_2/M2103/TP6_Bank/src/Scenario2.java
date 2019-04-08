import bank.*;
	/**
	 * Test the class Bank
	 * @author S.LEBERRE - MARS 2017
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	public class Scenario2 {

		/**
		 * Test Bank
		 * @param args the different args we can have in param
		 */
		public static void main(String[] args){
			
			//Test constructor
			System.out.println("\n======== Test constructor ========");
			Bank bank1 = new Bank();

			//Test addAccount
			System.out.println("\n======== Test addAccount ========");
			BankAccount bankaccount1 = new BankAccount(1,-10.5);
			bankaccount1.setBalance(50);
			BankAccount bankaccount2 = null;
			CheckingAccount checkingaccount1 = new CheckingAccount(2);
			checkingaccount1.setBalance(40);
			CheckingAccount checkingaccount2 = new CheckingAccount(3);
			checkingaccount2.setBalance(30);
			SavingsAccount savingsaccount1 = new SavingsAccount(4,0.5);
			savingsaccount1.setBalance(20);
			System.out.println("\nTest OK bankaccount");
			bank1.addAccount(bankaccount1);
			System.out.println("\nTest OK checkingaccount");
			bank1.addAccount(checkingaccount1);
			bank1.addAccount(checkingaccount2);
			System.out.println("\nTest OK savingsaccount");
			bank1.addAccount(savingsaccount1);
			System.out.println("\nTest FALSE add object null");
			bank1.addAccount(bankaccount2);

			//Test getTotalBalance
			System.out.println("\n======== Test getTotalBalance ========");
			System.out.println("Total balance = 140");
			System.out.println("Result = "+ bank1.getTotalBalance());

			//Test count
			System.out.println("\n======== Test count ========");
			System.out.println("Total count >=30  = 3");
			System.out.println("Result = "+ bank1.count(30));
			System.out.println("Total count >=40  = 2");
			System.out.println("Result = "+ bank1.count(40));

			//Test find
			System.out.println("\n======== Test find ========");
			System.out.println("find 2");
			System.out.println("Result = "+ bank1.find(2).getAccountNumber());
			System.out.println("find 3");
			System.out.println("Result = "+ bank1.find(3).getAccountNumber());
			System.out.println("find 1");
			System.out.println("Result = "+ bank1.find(1).getAccountNumber());

			//Test getMaximum
			System.out.println("\n======== Test getMaximum ========");
			System.out.println("Maximum balance of bank1 is 50");
			System.out.println("Result :");
			System.out.println(bank1.getMaximum());
		}
	}