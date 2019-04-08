import bank.*;
	/**
	 * Test the class BankAccount, CheckingAccount and SavingsAccount
	 * @author S.LEBERRE - MARS 2017
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	public class Scenario1 {

		/**
		 * Test BankAccount, CheckingAccount and SavingsAccount
		 * @param args the different args we can have in param
		 */
		public static void main(String[] args){
			
			//Test of BankAccount
			System.out.println("\n========********** Test BankAccount **********========");

				//Test constructor
				System.out.println("\n======== Test constructor ========");
				System.out.println("\nTest OK");
				BankAccount bankaccount1 = new BankAccount(1,-10.5);
				System.out.println("\nTest accountNumber < 0");
				BankAccount bankaccount2 = new BankAccount(-2,-10.5);
				System.out.println("\nTest overdraft > 0");
				BankAccount bankaccount3 = new BankAccount(2,5.5);
				
				//Test getOverdraft
				System.out.println("\n======== Test getOverdraft ========");
				System.out.println("\nTest OK");
				System.out.println(bankaccount1.getOverdraft());
				System.out.println("\nTest overdraft > 0");
				System.out.println(bankaccount3.getOverdraft());

				//Test setOverdraft
				System.out.println("\n======== Test setOverdraft ========");
				System.out.println("\nTest OK");
				bankaccount1.setOverdraft(-5);
				System.out.println("\nTest overdraft > 0");
				bankaccount3.setOverdraft(6);

				//Test deposit
				System.out.println("\n======== Test deposit ========");
				System.out.println("\nTest OK");
				bankaccount1.deposit(100.5);
				bankaccount2.deposit(40.5);
				System.out.println("\nTest amount < 0");
				bankaccount3.deposit(-10.36);


				//Test withdraw
				System.out.println("\n======== Test withdraw ========");
				System.out.println("\nTest OK");
				bankaccount1.withdraw(50);
				System.out.println("\nTest amount < 0");
				bankaccount2.withdraw(-10);
				System.out.println("\nTest balance - amount < authorizedOverdraft");
				bankaccount2.withdraw(60);

				//Test transfert
				System.out.println("\n======== Test transfert ========");
				System.out.println("\nTest OK bankaccount1 -> 10 -> bankaccount2");
				System.out.println("bankaccount1 balance : " +bankaccount1.getBalance());
				System.out.println("bankaccount2 balance : " +bankaccount2.getBalance());
				bankaccount1.transfert(10,bankaccount2);
				System.out.println("bankaccount1 balance : " +bankaccount1.getBalance());
				System.out.println("bankaccount2 balance : " +bankaccount2.getBalance());
				System.out.println("\nTest  amount < 0");
				bankaccount1.transfert(-10,bankaccount2);
				System.out.println("bankaccount1 balance : " +bankaccount1.getBalance());
				System.out.println("bankaccount2 balance : " +bankaccount2.getBalance());
				System.out.println("\nTest balance - amount < authorizedOverdraft");
				bankaccount1.transfert(70,bankaccount2);
				System.out.println("bankaccount1 balance : " +bankaccount1.getBalance());
				System.out.println("bankaccount2 balance : " +bankaccount2.getBalance());

				//Test toString
				System.out.println("\n======== Test toString ========");
				System.out.println("\nTest bankaccount1");
				System.out.println(bankaccount1.toString());
				System.out.println("\nTest bankaccount2");
				System.out.println(bankaccount2.toString());
				System.out.println("\nTest bankaccount3");
				System.out.println(bankaccount3.toString());
				

			//Test of CheckingAccount
			System.out.println("\n========********** Test CheckingAccount **********========");

				//Test constructor
				System.out.println("\n======== Test constructor ========");
				System.out.println("\nTest OK");
				CheckingAccount checkingaccount1 = new CheckingAccount(1);
				CheckingAccount checkingaccount3 = new CheckingAccount(2);
				System.out.println("\nTest accountNumber < 0");
				CheckingAccount checkingaccount2 = new CheckingAccount(-2);

				//Test deposit
				System.out.println("\n======== Test deposit ========");
				System.out.println("\nTest OK");
				checkingaccount1.deposit(100.5);
				checkingaccount2.deposit(40.5);
				System.out.println("\nTest amount < 0");
				checkingaccount3.deposit(-10.36);

				//Test withdraw
				System.out.println("\n======== Test withdraw ========");
				System.out.println("\nTest OK");
				System.out.println("checkingaccount1 balance : " + checkingaccount1.getBalance());
				checkingaccount1.withdraw(50);
				System.out.println("checkingaccount1 balance : " + checkingaccount1.getBalance());
				System.out.println("\nTest amount < 0");
				System.out.println("checkingaccount2 balance : " + checkingaccount2.getBalance());
				checkingaccount2.withdraw(-10);
				System.out.println("checkingaccount2 balance : " + checkingaccount2.getBalance());
				System.out.println("\nTest balance - amount < authorizedOverdraft");
				System.out.println("checkingaccount2 balance : " + checkingaccount2.getBalance());
				checkingaccount2.withdraw(60);
				System.out.println("checkingaccount2 balance : " + checkingaccount2.getBalance());
				System.out.println("\nTest transactionCount > 3. withdraw 10. withdraw 10.");
				checkingaccount1.withdraw(10);
				checkingaccount1.withdraw(10);
				System.out.println("checkingaccount1 balance : " + checkingaccount1.getBalance());
				System.out.println("checkingaccount1 withdraw 20");
				checkingaccount1.withdraw(20);
				System.out.println("checkingaccount1 balance : " + checkingaccount1.getBalance());

				//Test toString
				System.out.println("\n======== Test toString ========");
				System.out.println("\nTest checkingaccount1");
				System.out.println(checkingaccount1.toString());
				System.out.println("\nTest checkingaccount2");
				System.out.println(checkingaccount2.toString());
				System.out.println("\nTest checkingaccount3");
				System.out.println(checkingaccount3.toString());


			//Test of SavingsAccount
			System.out.println("\n========********** Test SavingsAccount **********========");

				//Test constructor
				System.out.println("\n======== Test constructor ========");
				System.out.println("\nTest OK");
				SavingsAccount savingsaccount1 = new SavingsAccount(1,0.5);
				System.out.println("\nTest accountNumber < 0");
				SavingsAccount savingsaccount2 = new SavingsAccount(-1,0.4);
				System.out.println("\nTest rate < 0");
				SavingsAccount savingsaccount3 = new SavingsAccount(3,-0.4);


				//Test addInterest
				System.out.println("\n======== Test addInterest ========");
				System.out.println("savingsaccount1 interestRate : " + savingsaccount1.getInterestRate());
				savingsaccount1.addInterest();
				System.out.println("savingsaccount1 interestRate : " + savingsaccount1.getInterestRate());

				//Test toString
				System.out.println("\n======== Test toString ========");
				System.out.println("\nTest savingsaccount1");
				System.out.println(savingsaccount1.toString());
				System.out.println("\nTest savingsaccount2");
				System.out.println(savingsaccount2.toString());
				System.out.println("\nTest savingsaccount3");
				System.out.println(savingsaccount3.toString());
		}

	}