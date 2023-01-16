package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import dao.AccountDAO;
import model.Account;

/**
 * @author S. Lebrun
 *
 */
public class AccountListController {
	private List<Account> accountList = new ArrayList<>();

	/**
	 * Constructor, fills accountList with Account objects created from database
	 * @param client id
	 */
	public AccountListController(int id) {
		this.accountList = AccountDAO.getAccounts(id);
	}
	
	/**
	 * Converts Account elements of accountList to String elements
	 */
	public List<String> accountListToStringList() {
		List<String> stringList = new ArrayList<>();
		for (Account element : accountList) {
			stringList.add(element.toString());
		}
		return stringList;
	}


	/**
	 * Print the Accounts list in console
	 *
	 */
	public void showAccountList() {

		for (Account element : accountList) {
			System.out.println(element.toString());
		}
	}

	public List<Account> getAccountList() {
		return accountList;
	}

}
