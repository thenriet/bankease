package bankease;
import dao.CheckingAccountDAO;

import dao.SavingAccountDAO;
import model.CheckingAccount;
import model.SavingAccount;


import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import view.CheckingAccountView;
import view.ClientsList;
import view.FrmAccountList;

public class Main {

	public static void main(String[] args) {

		//FrmAccountList mainFrame = new FrmAccountList(4);
		//CheckingAccountView a = new CheckingAccountView();
		//a.setVisible(true);
		new ClientsList();

	}
}
