package controller;

import java.sql.SQLException;
import dao.SavingAccountDAO;
import model.SavingAccount;

public class SavingAccountHandler {
	
public static Object createSavingAccount(int accountId, int clientId,String ownerDescription, 
		float balance, float interestRate, float balanceLimit) throws SQLException {

	if(ownerDescription.length()<100) {
	SavingAccount newAccount = new SavingAccount(accountId,clientId,ownerDescription,balance,interestRate, balanceLimit);
	SavingAccountDAO.CreateSavingAccount(newAccount);
	return newAccount;
}
	else { return null;}
	
}
}