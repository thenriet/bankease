package controller;

import dao.ClientDao;
import model.Client;

public class ClientHandler {
	
	public static void createClient(String data) {
		
		if(data.trim() != null) {
			
			Client newClient = new Client(data);
			ClientDao.createClient(newClient);
		}
	}

}
