package bankease;

import java.util.ArrayList;
import java.util.List;

import dao.ClientDao;
import model.Client;
import view.ClientCreate;
import view.ClientsList;


public class Main {

	public static void main(String[] args) {
		

//		BankDAO.newBank();
//		BankDAO.getAllBanks();
		System.out.println(ClientDao.getAllClients());
		List<Client> clients = new ArrayList<>();
		clients.addAll(ClientDao.getAllClients());
		System.out.println(ClientDao.getOneClient(1).getClientDescription());
		System.out.println(clients);

	

//		new ClientCreate();
		new ClientsList();
//		System.out.println(ClientCreate().Cl);

//		new ModificationAccount();

//		CheckingAccount a = new CheckingAccount(888888888);
//		System.out.println(a.getClient_id());
//		
//		SavingAccount s = new SavingAccount(777777777);
//		System.out.println(s.getClient_id());

	}

}
