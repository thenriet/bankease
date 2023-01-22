package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CheckingAccountDAO;
import model.CheckingAccount;

public class CheckingAccountHandler {

	public static Object createCheckingAccount(int accountId, int clientId, String ownerDescription, float balance,
			float transferFee, float minBalance) throws SQLException {

		if (ownerDescription.length() > 100) {
			return "caractere_depasse";
		}

		if (balance != (int) balance && balance != (float) balance) {
			// return "type_balance";

			System.out.println("e");
		}

		if (minBalance != (int) minBalance && minBalance != (float) minBalance) {
			return "type_min_balance";
		}

		if (transferFee != (int) transferFee && transferFee != (float) transferFee) {
			return "type_transfer_fee";
		}

		if (balance < minBalance) {
			return "min_balance";
		}

		else {

			CheckingAccount newAccount = new CheckingAccount(accountId, clientId, ownerDescription, balance,
					transferFee, minBalance);
			CheckingAccountDAO.CreateCheckingAccount(newAccount);
			return newAccount;

		}
	}

	public static void updateCheckingAccount(List<Object> checkedData, CheckingAccount updatedAccount) {

		if (checkedData != null) {
			updatedAccount.setOwnerDescription((String) checkedData.get(0));
			updatedAccount.setTransferFee(Float.parseFloat((String) checkedData.get(1)));

			CheckingAccountDAO.UpdateCheckingAccount(updatedAccount);
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

	public static List<Object> checkTransferFee(List<String> uncheckedData) {
		List<Object> checkedData = new ArrayList<>();
		for (String data : uncheckedData) {
			checkedData.add(data);
		}
		Float transferFee = Float.parseFloat((String) checkedData.get(1));
		if (transferFee >= 0 && transferFee <= 90) {
			return checkedData;
		} else {
			return null;
		}
	}

}