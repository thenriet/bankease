package controller;

import java.sql.SQLException;
import java.util.List;

import dao.SavingAccountDAO;
import model.SavingAccount;

public class SavingAccountHandler {

	public static void createSavingAccount(List<String> trimmedData) {
		// TODO Auto-generated method stub

	}

	public static Object createSavingAccount(int accountId, int clientId, String ownerDescription, float balance,
			float interestRate, float balanceLimit) throws SQLException {

		if (ownerDescription.length() < 100) {
			SavingAccount newAccount = new SavingAccount(accountId, clientId, ownerDescription, balance, interestRate,
					balanceLimit);
			SavingAccountDAO.CreateSavingAccount(newAccount);
			return newAccount;
		} else {
			return null;
		}

	}

	public static void updateSavingAccount(List<Object> checkedData, SavingAccount updatedAccount) {

		if (checkedData != null) {
			updatedAccount.setOwnerDescription((String) checkedData.get(0));
			updatedAccount.setInterestRate(Float.parseFloat((String) checkedData.get(1)));

			SavingAccountDAO.UpdateSavingAccount(updatedAccount);
		}
	}
}
