package controller;


import dao.AccountManagementDAO;
import model.Account;
import model.CheckingAccount;
import model.SavingAccount;

/**
 * @author S. Lebrun
 *
 */
public class CreditAccountController {
	
	// TODO choisir créditer ou débiter => -amount
	// TODO vérifier si transfer possible => message d'erreur
	// TODO faire le changement en BDD => message d'erreur
	
	public static String creditDebitAccount(String action, Account account, String amountTxt) {
		String errorMsg = null;
		float amount = 0;
		
		if (checkInput(amountTxt)) {
			amount = (float) Float.parseFloat(amountTxt);
		} else {
			errorMsg = "Veuillez entrer un nombre positif";
			return errorMsg;
		}
		
		if (action == "débit") {
			amount = - amount;
		}
		
		errorMsg = validateAction(account, amount);
		
		if (errorMsg == null) {
			account.setBalance(account.getBalance() + amount);
		}

		return errorMsg;
	}
	
	public static String applyChange(Account account, String action, String amount) {
		int rows = AccountManagementDAO.changeBalance(account);
		String message = null;
		
		if (rows == 1) {
			message = "Le compte n°" + account.getAccountId() + " a bien été " + action + "é de " + amount + " €";
		} else if (rows == 0) {
			message = "Erreur : le compte n°" + account.getAccountId() + " n'a pas pû être " + amount + "é";
		} else {
			message = "Erreur en base de données";
		}
		return message;
	}
	
	public static boolean checkInput(String input) {
		if (input == null) {
			return false;
		}
		try {
			Float f = Float.parseFloat(input);
			if (f <= 0) {
				return false;
			}
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	
	public static String validateAction(Account account, float amount) {
		if (account instanceof CheckingAccount) {
			return validateCheckingAccount((CheckingAccount) account, amount);
		} else {
			return validateSavingAccount((SavingAccount) account, amount);
		}
		
	}
	
	public static String validateCheckingAccount(CheckingAccount account, float amount) {
		if (account.getBalance() + amount <= account.getMinBalance()) {
			return "Erreur : le solde ne peut pas être inférieur au solde minimum";
		} else if (account.getBalance() + amount >= 100000) {
			return "Erreur : un compte ne peut pas contenir plus de 100'000 €";
		} else {
			return null;
		}
	}
	
	public static String validateSavingAccount(SavingAccount account, float amount) {
		if (account.getBalance() + amount <= 0) {
			return "Erreur : le solde ne peut pas être négatif";
		} else if (account.getBalance() + amount >= account.getBalanceLimit()) {
			return "Erreur : le solde ne peut pas être supérieur au plafond";
		} else {
			return null;
		}
	}
}
