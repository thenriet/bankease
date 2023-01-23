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
	public static String getAccountOwner (int id) {
		return AccountListDAO.getAccountOwner(id);
	}
	
	/**
	 * Deletes the account from database and returns an information message
	 * @param account : the account to delete
	 * @return confirmation or error message
	 */
	public static String deleteAccount (Account account) {
		String message = "";
		
		int rows = AccountListDAO.DeleteAccount(account);
		
		if (rows == 1) {
			message = "Le compte n°" + account.getAccountId() + " a bien été supprimé";
		} else {
			message = "Erreur : le compte n'a pas pu être supprimé";
		}
		
		return message;
	}
	
}