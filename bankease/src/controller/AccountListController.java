package controller;

import java.util.ArrayList;
import java.util.List;
import dao.AccountListDAO;
import model.Account;
import view.FrmCreditDebit;

/**
 * @author S. Lebrun
 *
 */
public class AccountListController {
	
	/**
	 * Fills accountList with Account objects created from database
	 * @param client id
	 * @return ArrayList of Account objects
	 */
	public static List<Account> getAccountList(int id) {
		List<Account> accountList = new ArrayList<>(AccountListDAO.getAccounts(id));
		return accountList;
	}
	
	/**
	 * Gets and returns the client's description
	 * @param client id
	 * @return String client description
	 */
	public static String getAccountOwner (int id) {
		return AccountListDAO.getAccountOwner(id);
	}
}