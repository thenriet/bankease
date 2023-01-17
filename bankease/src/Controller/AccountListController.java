package Controller;

import java.util.ArrayList;
import java.util.List;
import dao.AccountDAO;
import model.Account;
import view.FrmCreditAccount;

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
		List<Account> accountList = new ArrayList<>(AccountDAO.getAccounts(id));
		return accountList;
	}
	
	/**
	 * Gets and returns the client's description
	 * @param client id
	 * @return String client description
	 */
	public static String getAccountOwner (int id) {
		return AccountDAO.getAccountOwner(id);
	}
	
	public static void goToCreditDebit (Account account, String action) {
		FrmCreditAccount newFrame = new FrmCreditAccount(account, action);
		newFrame.setVisible(true);
	}

}