package controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import dao.ClientDao;
import dao.Regex;
import model.Client;

public class ClientHandler {

	public static List<String> checkEmptyAndDataTrim(List<String> uncheckedData) {
		List<String> rawData = new ArrayList<>();
		for (String data : uncheckedData) {
			if (!data.isEmpty()) {
				data = data.trim();
				rawData.add(data);
			}
		}
		return rawData;
	}

	public static List<Object> checkClientDescription(List<String> uncheckedData) {
		List<Object> checkedData = new ArrayList<>();
		for (String data : uncheckedData) {
			checkedData.add(data);
		}
		String strClientDescription = (String) checkedData.get(0);
		if (strClientDescription.length() < 101 && strClientDescription.length() > 1) {
			return checkedData;
		} else {
			return null;
		}
	}

	public static List<Object> checkPhone(List<String> uncheckedData) {
		List<Object> checkedData = new ArrayList<>();
		Regex regex = new Regex();
		for (String data : uncheckedData) {
			checkedData.add(data);
		}
		String strPhone = (String) checkedData.get(3);
		if (regex.phoneMatch(strPhone)) {

			return checkedData;
		} else {
			return null;
		}
	}

	public static List<Object> checkDate(List<String> uncheckedData) {
		List<Object> checkedData = new ArrayList<>();
		Regex regex = new Regex();

		for (String data : uncheckedData) {
			checkedData.add(data);
		}

		String strDate = (String) checkedData.get(1);

		if (regex.matches(strDate)) {
			Date date = Date.valueOf((String) checkedData.get(1));
			checkedData.set(1, date);
			return checkedData;
		} else {
			return null;
		}
	}

	public static void createClient(List<Object> checkedData) {

		if (checkedData != null) {
			Client newClient = new Client(checkedData.get(0), checkedData.get(1), checkedData.get(2),
					checkedData.get(3));
			ClientDao.createClient(newClient);
		}
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

	public static Client[] listOfClients() {
		List<Client> allClients = new ArrayList<>();
		allClients.addAll(ClientDao.getAllClients());
		Client[] arrayClients = allClients.toArray(new Client[0]);
		return arrayClients;
	}


	public static void deleteClient(int id) {
		ClientDao.deleteClient(id);
	}

}
