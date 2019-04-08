package bank;
import java.util.ArrayList;
	/**
	 * Instantiates and use the object Bank
	 * @author S.LEBERRE - MARS 2017
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	 public class Bank {
		 
		 private ArrayList<BankAccount> accounts;
		 
		 /**
		  * Constructor of Bank object
		  */
		 public Bank(){
			 accounts = new ArrayList<BankAccount>();
		 }
		 
		 /**
		  * Add an account to the Bank
		  * @param a the account you want to add to the Bank
		  */
		 public void addAccount(BankAccount a){
			 if(a != null){
			 	this.accounts.add(a);
			 } else {
			 	System.out.println("Param addAccount FALSE");
			 }
		 }
		 
		 /**
		  * Give the total of balance the Bank have in her accounts
		  * @return the sum of all the balance of the count in the bank
		  */
		 public double getTotalBalance(){
			 double ret = 0.0;
			 for(BankAccount account : this.accounts){
					ret = ret + account.getBalance();
			}
			return ret;
		 }
		 
		 
		 /**
		  * Count the number of account who have a balance bigger than atLeast
		  * @param atLeast the minimum balance you count
		  * @return the number of count who have a balance bigger than atLeast
		  */
		 public int count(double atLeast){
			 int ret = 0;
			 for(BankAccount account : this.accounts){
			 		if(account.getBalance() >= atLeast){
			 			ret++ ;
			 		}
			}
			return ret;
		 }
		 
		 /**
		  * Give the BankAccount with the accountNumber give in PARAM
		  * @param accountNumber the accountNumber of the BankAccount you want to get
		  * @return the BankAccount with the accountNumber in Param
		  */
		 public BankAccount find(int accountNumber){
			BankAccount ret = new BankAccount(0,0);
			 for(BankAccount account : this.accounts){
			 		if(account.getAccountNumber() == accountNumber){
			 			ret = account;
			 		}
			}
			return ret; 
		 }
		 
		 /**
		  * Give the BankAccount with the biggest balance
		  * @return the BankAccount with the biggest balance
		  */
		 public BankAccount getMaximum(){
			 BankAccount ret = new BankAccount(0,0);
			 for(BankAccount account : this.accounts){
			 		if(account.getBalance() > ret.getBalance()){
			 			ret = account;
			 		}
			}
			return ret;
		 }
	 }
