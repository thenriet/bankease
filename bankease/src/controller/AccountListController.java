package controller;

import java.util.ArrayList;
import java.util.List;

import dao.AccountListDAO;
import model.Account;
import view.FrmCreditDebit;

/**
 * Controller for account list page
 * @author S. Lebrun
 *
 */
public class AccountListController {
	
	/**
	 * Fills accountList with Account objects created from database
	 * @param id : client ID
	 * @return ArrayList of Account objects
	 */
	public static List<Account> getAccountList(int id) {
		List<Account> accountList = new ArrayList<>(AccountListDAO.getAccounts(id));
		return accountList;
	}
	
	/**
	 * Gets and returns the client's description
	 * @param id : client ID
	 * @return String client description
	 */
	// TODO retirer après mise en commun si envoi du client dans la frame
	public static String getAccountOwner (int id) {
		return AccountListDAO.getAccountOwner(id);
	}
}