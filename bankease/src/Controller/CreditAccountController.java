package Controller;

import model.Account;
import model.CheckingAccount;
import model.SavingAccount;

/**
 * @author S. Lebrun
 *
 */
public class CreditAccountController {
	
	public static void moneyTransferChoice(String action, Account account, float amount) {
		
		switch (action) {
			case "créditer":
				// TODO envoyer vers crédit-débit avec amount
				// TODO appliquer l'objet en BDD
			case "débiter":
				// TODO envoyer vers crédit-débit avec -amount
				// TODO vérifier si objet OK
				// TODO appliquer l'objet en BDD
		}
	}
	
	public static void balanceCreditDebit(Account account, float amount) {
		String validated = "";
		
		switch (account.getAccountType()) {
			case "épargne":
				if (amount > 0) {
					validated = validateCheckingAccount((CheckingAccount) account, amount);
				}
			case "courant":
				if (amount < 0) {
					validated = validateSavingAccount((SavingAccount) account, amount);
				}
		}
		
		if (validated == "") {
			account.setBalance(amount);
		}
	}
	
	public static String validateCheckingAccount(CheckingAccount account, float amount) {
		if (account.getBalance() + amount >= account.getMinBalance()) {
			return "";
		} else {
			return "";
		}
	}
	
	public static String validateSavingAccount(SavingAccount account, float amount) {
		if (account.getBalance() + amount <= account.getBalanceLimit() && account.getBalance() + amount <= 100000) {
			return "";
		} else {
			return "";
		}
	}
}
