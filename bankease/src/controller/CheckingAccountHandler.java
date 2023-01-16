package controller;

import java.sql.SQLException;


import dao.CheckingAccountDAO;
import model.CheckingAccount;
import view.CheckingAccountView;

public class CheckingAccountHandler {
	
public static Object createCheckingAccount(int account_id,int client_id,String owner_description, float balance, float transfer_fee, float min_balance) throws SQLException {

	if(owner_description.length()<100) {
	CheckingAccount newAccount = new CheckingAccount(account_id,client_id,owner_description,balance,transfer_fee,min_balance);
	CheckingAccountDAO.CreateCheckingAccount(newAccount);
	return newAccount;
}
	else { return null;}
	
}
}