package bankease;

import java.util.ArrayList;
import java.util.List;

import dao.ClientDao;
import model.Client;
import view.ClientCreate;
import view.ClientsList;


public class Main {

	public static void main(String[] args) {
		
		System.out.println(ClientDao.getAllClients());
		List<Client> clients = new ArrayList<>();
		clients.addAll(ClientDao.getAllClients());
		System.out.println(ClientDao.getOneClient(1).getClientDescription());
		System.out.println(clients);

//		new ClientCreate();
		new ClientsList();
//		System.out.println(ClientCreate().Cl);

//		new ModificationAccount();

	}

}
