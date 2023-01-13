package bankease;

import model.AccountList;
import vue.FrmAccountList;
import vue.TestBank;

public class Main {

	public static void main(String[] args) {
		
		// Test impression console
		AccountList b = new AccountList(2);
		TestBank.showAccounts(b);
		System.out.println("OK");
		
		FrmAccountList mainFrame = new FrmAccountList();
		
	}
}
