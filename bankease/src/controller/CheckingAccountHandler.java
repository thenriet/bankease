package controller;

import java.sql.SQLException;

import dao.CheckingAccountDAO;
import model.CheckingAccount;
import view.CheckingAccountView;

public class CheckingAccountHandler {

	public static Object createCheckingAccount(int accountId, int clientId, String ownerDescription, float balance,
			float transferFee, float minBalance) throws SQLException {

		if (ownerDescription.length() > 100) {
			return "caractere_depasse";
		}
		
		if (balance != (int) balance && balance != (float) balance ) {
			//return "type_balance";
			
			System.out.println("e");
		}
		
		if (minBalance != (int) minBalance && minBalance != (float) minBalance ) {
			return "type_min_balance";
		}
		
		if (transferFee != (int) transferFee && transferFee != (float) transferFee ) {
			return "type_transfer_fee";
		}
		
		if(balance<minBalance) {
			return "min_balance";
		}

		else {

			CheckingAccount newAccount = new CheckingAccount(accountId, clientId, ownerDescription, balance,
					transferFee, minBalance);
			CheckingAccountDAO.CreateCheckingAccount(newAccount);
			return newAccount;

		}

	}
}