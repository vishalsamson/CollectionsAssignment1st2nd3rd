package Assignment3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AccountUI {
	Scanner scan=new Scanner(System.in);
	List<Account> list=new ArrayList<>();
	Map<String,List<Account>> map=new HashMap<>();
	
	public static void main(String[] args) {
		AccountUI app=new AccountUI();
		
		while(true) {
			
			System.out.println("1.Add Account to list");
			System.out.println("2.Group based on Location");
			
			System.out.print("\nEnter your choice: ");
			switch(new Scanner(System.in).nextInt()) {
			case 1:
				app.addAccountToList();
				break;
				
			case 2:
				app.groupAccountsByLocation();
				break;
				
			case 0:
				System.exit(0);
			}
		}
	}

	private void groupAccountsByLocation() {
		for(Map.Entry<String, List<Account>> entry:map.entrySet()) {
			String location=entry.getKey();
			List<Account> listOfAccounts=entry.getValue();
			System.out.println("The Accounts from "+location+" are: ");
			for(Account a:listOfAccounts) {
				displayAccount(a);
			}
		}
		
	}


	private void addAccountToList() {
		System.out.println("Enter Account Number");
		int accountNumber=scan.nextInt();
		
		System.out.println("Enter Account Holder Name");
		String accountHolderName=scan.next();
		
		System.out.println("Enter Account Balance");
		int accountBalance=scan.nextInt();
		
		System.out.println("Enter Location");
		String location=scan.next();
		
		Account a=new Account(accountNumber,accountHolderName,accountBalance,location);
		list.add(a);
		map.put(a.getLocation(), list);
		
	}
	
	private void displayAccount(Account a) {
		System.out.println("Account Number = " + a.getAccountNumber() + ", Account Holder Name = " + a.getAccountHolderName() + ", Balance = "
				+ a.getBalance() + ", Location = " + a.getLocation());
		
	}

}
