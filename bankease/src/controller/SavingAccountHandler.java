package controller;

import java.sql.SQLException;
import java.util.ArrayList;
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
			updatedAccount.setInterestRate( Float.parseFloat((String) checkedData.get(1)));

			SavingAccountDAO.UpdateSavingAccount(updatedAccount);
		}
	}

	public static List<String> checkEmptyAndDataTrim(List<String> uncheckedData) {
		List<String> rawData = new ArrayList<>();
		for (String data : uncheckedData) {
			if (!data.isEmpty()) {
				data = data.trim();
				rawData.add(data);
			}
		}
		return rawData;
	}

	public static List<Object> checkClientDescription(List<String> uncheckedData) {
		List<Object> checkedData = new ArrayList<>();
		for (String data : uncheckedData) {
			checkedData.add(data);
		}
		String strClientDescription = (String) checkedData.get(0);
		if (strClientDescription.length() < 101 && strClientDescription.length() > 1) {
			return checkedData;
		} else {
			return null;
		}
	}

	public static List<Object> checkInterestRate(List<String> uncheckedData) {
		List<Object> checkedData = new ArrayList<>();
		for (String data : uncheckedData) {
			checkedData.add(data);
		}
		Float interestRate = Float.parseFloat((String) checkedData.get(1));
		if (interestRate >= 0 && interestRate <= 90) {
			return checkedData;
		} else {
			return null;
		}
	}
}
