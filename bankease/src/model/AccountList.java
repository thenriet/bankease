package model;

import java.util.ArrayList;
import dao.AccountDAO;

/**
 * @author S. Lebrun
 *
 */
public class AccountList {
	public ArrayList<Account> accountList = new ArrayList<>();

	/**
	 * Constructor, fills accountList with Account objects created from database
	 */
	public AccountList(int id) {
		this.accountList = AccountDAO.getAccounts(id);
	}


	public ArrayList<Account> getAccountList(int id) {
		return accountList;
	}

}
