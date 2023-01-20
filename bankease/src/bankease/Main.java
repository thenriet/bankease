package bankease;

import dao.CheckingAccountDAO;
import view.CheckingAccountView;
import view.ClientsList;

import view.FrmAccountList;
import view.OpenAccountView;

public class Main {

	public static void main(String[] args) {


		//CheckingAccountView a = new CheckingAccountView();
		//a.setVisible(true);
		
		new FrmAccountList(4, "");

//		new ClientsList();

	}
}
