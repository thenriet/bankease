package controller;

import dao.AccountManagementDAO;
import model.Account;
import model.CheckingAccount;
import model.SavingAccount;

public class TransferController {

	
	public static String creditDebitAccount(Account source, Account destination, String amountTxt) {
		String errorMsg = "";
		float debitAmount = 0;
		float creditAmount = 0;
		
		if (destination == null) {
			return "Veuillez sélectionner un compte de destination";
		}
		
		if (checkInput(amountTxt)) {
			creditAmount = (float) Float.parseFloat(amountTxt);
			debitAmount = - creditAmount;
		} else {
			return "Veuillez entrer un nombre positif";
		}

		if (source instanceof CheckingAccount) {
			debitAmount -= debitAmount - ((CheckingAccount) source).getTransferFee() / 100;
		}

		errorMsg += validateAction(source, debitAmount);
		errorMsg += validateAction(destination, creditAmount);
		
		if (errorMsg == "") {
			source.setBalance(source.getBalance() - debitAmount);
			destination.setBalance(destination.getBalance() + creditAmount);
		}

		return errorMsg;
	}
	
	public static String applyChange(Account account, String action, String amount) {
		int rows = AccountManagementDAO.changeBalance(account);
		String message = null;
		
		if (rows == 1) {
			message = "Le compte n°" + account.getAccountId() + " a bien été " + action + "é de " + amount + " €";
		} else if (rows == 0) {
			message = "Erreur : le compte n°" + account.getAccountId() + " n'a pas pû être " + action + "é";
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
			return "Erreur : le solde ne peut pas être inférieur au solde minimum\n";
		} else if (account.getBalance() + amount >= 100000) {
			return "Erreur : un compte ne peut pas contenir plus de 100'000 €\n";
		} else {
			return "";
		}
	}
	
	public static String validateSavingAccount(SavingAccount account, float amount) {
		if (account.getBalance() + amount <= 0) {
			return "Erreur : le solde ne peut pas être négatif\n";
		} else if (account.getBalance() + amount >= account.getBalanceLimit()) {
			return "Erreur : le solde ne peut pas être supérieur au plafond\n";
		} else {
			return "";
		}
	}
}