package controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


import dao.ClientDao;
import model.Client;

public class ClientHandler {

	public static List<Object> checkData(List<String> uncheckedData) {
		List<Object> checkedData = new ArrayList<>();
		for (String data : uncheckedData) {
			data.trim();
			checkedData.add(data);
		}
		Date date = Date.valueOf((String) checkedData.get(1));
		checkedData.set(1, date);
		return checkedData;
	}

	public static void createClient(List<Object> data) {

		Client newClient = new Client(data.get(0), data.get(1), data.get(2), data.get(3));
		ClientDao.createClient(newClient);
	}

}
