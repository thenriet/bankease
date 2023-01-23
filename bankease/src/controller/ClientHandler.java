package controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import dao.ClientDao;
import model.Client;

public class ClientHandler {

	public static void createClient(List<Object> checkedData) {

		if (checkedData != null) {
			Client newClient = new Client(checkedData.get(0), checkedData.get(1), checkedData.get(2),
					checkedData.get(3));
			ClientDao.createClient(newClient);
		}
	}

	public static Client[] listOfClients() {
		List<Client> allClients = new ArrayList<>();
		allClients.addAll(ClientDao.getAllClients());
		Client[] arrayClients = allClients.toArray(new Client[0]);
		return arrayClients;
	}

	public static void updateClient(List<Object> checkedData, Client updatedClient) {

		if (checkedData != null) {
			updatedClient.setClientDescription((String) checkedData.get(0));
			updatedClient.setClientBirthdate((Date) checkedData.get(1));
			updatedClient.setClientAddress((String) checkedData.get(2));
			updatedClient.setClientPhone((String) checkedData.get(3));

			ClientDao.updateClient(updatedClient);
		}
	}

	public static void deleteClient(int id) {
		ClientDao.deleteClient(id);
	}

}
