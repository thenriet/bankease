package bankease;

import java.util.ArrayList;
import java.util.List;

import dao.AccountListDAO;
import dao.AccountManagementDAO;
import model.Account;
import view.FrmAccountList;

public class Main {

	public static void main(String[] args) {

		List<Account> list = new ArrayList<>(AccountListDAO.getAccounts(4));
		Account account = list.get(1);
		System.out.println(account);
		account.setBalance(1500);
		System.out.println(account);
		
		AccountManagementDAO.changeBalance(account);

		System.out.println("OK");
		
//		new FrmAccountList(4);
		
	}
}
