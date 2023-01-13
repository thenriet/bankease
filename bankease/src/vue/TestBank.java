package vue;

import model.Account;
import model.AccountList;

/**
 * Test vue for Bank (console print)
 * @author S. Lebrun
 *
 */
public class TestBank {

	/**
	 * Print the Accounts list of the given Bank
	 * @param bank
	 */
	public static void showAccounts(AccountList bank) {

		for (Account element : bank.accountList) {
			System.out.println(element.toString());
		}
	}
}
