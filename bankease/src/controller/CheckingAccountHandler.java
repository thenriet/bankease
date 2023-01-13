package controller;

import java.sql.SQLException;

import dao.CheckingAccountDAO;
import model.CheckingAccount;

public class CheckingAccountHandler {
	
public static void createCheckingAccount(int account_id, float balance, float transfer_fee, float min_balance, int client_id,
		int bank_id) throws SQLException {
	CheckingAccount newAccount = new CheckingAccount(account_id,balance,transfer_fee,min_balance,client_id,bank_id);
	CheckingAccountDAO.CreateCheckingAccount(newAccount);
	
}

}
