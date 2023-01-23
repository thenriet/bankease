package controller;

import dao.AccountManagementDAO;
import model.Account;
import model.CheckingAccount;
import model.SavingAccount;

/**
 * Controller for money transfer page
 * @author S. Lebrun
 *
 */
public class TransferController {

	/**
	 * Checks if transfer can be carried out, then modifies the Account objects
	 * @param source : account to debit
	 * @param destination : account to credit
	 * @param input : user input in form
	 * @return empty String if OK, or error message to display on frame
	 */
	public static String transferAccount(Account source, Account destination, String input) {
		String errorMsg = "";
		float debitAmount = 0;
		float creditAmount = 0;
		
		if (destination == null) {
			return "Veuillez sélectionner un compte de destination";
		}
		
		if (checkInput(input)) {
			creditAmount = (float) Float.parseFloat(input);
			debitAmount = - creditAmount;
		} else {
			return "Veuillez entrer un nombre positif";
		}

		if (source instanceof CheckingAccount) {
			creditAmount *= (1 - ((CheckingAccount) source).getTransferFee() / 100);
		}

		errorMsg += validateAction(source, debitAmount);
		errorMsg += validateAction(destination, creditAmount);
		
		if (errorMsg == "") {
			source.setBalance(source.getBalance() + debitAmount);
			destination.setBalance(destination.getBalance() + creditAmount);
		}

		return errorMsg;
	}
	
	/**
	 * Applies the account changes to database and collects messages to show on the frame
	 * @param account : Account object to apply on DB
	 * @param action : credit or debit, to display on messages
	 * @param amount : user entry, to display on messages
	 * @return message to display on next frame
	 */
	public static String applyChange(Account account, String action, String amount) {
		int rows = AccountManagementDAO.changeBalance(account);
		String message = null;
		
		if (rows == 1) {
			message = "Le compte n°" + account.getAccountId() + " a bien été " + action + "é";
		} else if (rows == 0) {
			message = "Erreur : le compte n°" + account.getAccountId() + " n'a pas pû être " + action + "é";
		} else {
			message = "Erreur en base de données";
		}
		return message;
	}
	
	/**
	 * Checks if user input is a positive number
	 * @param input : user input from the form (String)
	 * @return true if the input is correct
	 */
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
	
	/**
	 * Sends account to appropriate validator
	 * @param account : Account object
	 * @param amount : amount to add/subtract from account balance
	 * @return validator result (error message or empty string)
	 */
	public static String validateAction(Account account, float amount) {
		if (account instanceof CheckingAccount) {
			return validateCheckingAccount((CheckingAccount) account, amount);
		} else {
			return validateSavingAccount((SavingAccount) account, amount);
		}
		
	}
	
	/**
	 * Checks if the account's new balance conforms to limit values
	 * @param account : CheckingAccount object
	 * @param amount : float amount to add/subtract to the account's balance
	 * @return empty String if OK, or error message
	 */
	public static String validateCheckingAccount(CheckingAccount account, float amount) {
		if (account.getBalance() + amount < account.getMinBalance()) {
			return "Erreur : le solde ne peut pas être inférieur au solde minimum\n";
		} else if (account.getBalance() + amount > 100000) {
			return "Erreur : un compte ne peut pas contenir plus de 100 000 €\n";
		} else {
			return "";
		}
	}

	/**
	 * Checks if the account's new balance conforms to limit values
	 * @param account : SavingAccount object
	 * @param amount : float amount to add/substract to the account's balance
	 * @return empty String if OK, or error message
	 */
	public static String validateSavingAccount(SavingAccount account, float amount) {
		if (account.getBalance() + amount < 0) {
			return "Erreur : le solde ne peut pas être négatif\n";
		} else if (account.getBalance() + amount > account.getBalanceLimit()) {
			return "Erreur : le solde ne peut pas être supérieur au plafond\n";
		} else {
			return "";
		}
	}
}