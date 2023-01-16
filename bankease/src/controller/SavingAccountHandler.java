package controller;

import java.sql.SQLException;
import dao.SavingAccountDAO;
import model.SavingAccount;

public class SavingAccountHandler {
	
public static Object createSavingAccount(int account_id, int client_id,String owner_description, 
		float balance, float interest_rate, float balance_limit) throws SQLException {

	if(owner_description.length()<100) {
	SavingAccount newAccount = new SavingAccount(account_id,client_id,owner_description,balance,interest_rate, balance_limit);
	SavingAccountDAO.CreateSavingAccount(newAccount);
	return newAccount;
}
	else { return null;}
	
}
}