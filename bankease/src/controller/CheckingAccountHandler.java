package controller;

import dao.CheckingAccountDAO;
import model.CheckingAccount;

public class CheckingAccountHandler {
	
public static void createCheckingAccount() {
	CheckingAccount newAccount = new CheckingAccount(data1,data2,data3);
	CheckingAccountDAO.CreateCheckingAccount(newAccount);
	
}

}
