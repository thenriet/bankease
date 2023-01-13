package bankease;

import java.util.List;

import dao.ClientDao;
import model.Client;
import view.ClientCreate;
import view.TestView;

public class Main {

	public static void main(String[] args) {
		

//		BankDAO.newBank();
//		BankDAO.getAllBanks();
		System.out.println(ClientDao.getAllClients());
		System.out.println(ClientDao.getOneClient(1).getClientName());

		new ClientCreate();
//		System.out.println(ClientCreate().Cl);

//		new ModificationAccount();

//		CheckingAccount a = new CheckingAccount(888888888);
//		System.out.println(a.getClient_id());
//		
//		SavingAccount s = new SavingAccount(777777777);
//		System.out.println(s.getClient_id());

	}

}
