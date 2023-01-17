package controller;

import java.sql.SQLException;

import dao.CheckingAccountDAO;
import model.CheckingAccount;
import view.CheckingAccountView;

public class CheckingAccountHandler {

	public static Object createCheckingAccount(int account_id, int client_id, String owner_description, float balance,
			float transfer_fee, float min_balance) throws SQLException {

		if (owner_description.length() > 100) {
			return "caractere_depasse";
		}
		
		if (balance != (int) balance && balance != (float) balance ) {
			//return "type_balance";
			
			System.out.println("e");
		}
		
		if (min_balance != (int) min_balance && min_balance != (float) min_balance ) {
			return "type_min_balance";
		}
		
		if (transfer_fee != (int) transfer_fee && transfer_fee != (float) transfer_fee ) {
			return "type_transfer_fee";
		}
		
		if(balance<min_balance) {
			return "min_balance";
		}

		else {

			CheckingAccount newAccount = new CheckingAccount(account_id, client_id, owner_description, balance,
					transfer_fee, min_balance);
			CheckingAccountDAO.CreateCheckingAccount(newAccount);
			return newAccount;

		}

	}
}