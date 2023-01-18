package controller;

import java.util.ArrayList;
import java.util.List;
import dao.AccountDAO;
import model.Account;

/**
 * @author S. Lebrun
 *
 */
public class AccountListController {
//	private static ;

	/**
	 * Fills accountList with Account objects created from database
	 * @param client id
	 */
	public static List<Account> getAccountList(int id) {
		List<Account> accountList = new ArrayList<>(AccountDAO.getAccounts(id));
		return accountList;
	}
	
	public static String getAccountOwner (int id) {
		return AccountDAO.getAccountOwner(id);
	}

}