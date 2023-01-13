package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Client;

public class ClientDao {

	public static List<Client> getAllClients() {
		List<Client> allClients = new ArrayList<>();
		
		ResultSet rs1 = null;
		try {
			Connection conn = Connect.getConnection();
			Statement st = conn.createStatement();
			rs1 = st.executeQuery("SELECT * FROM CLIENT");

			while (rs1.next()) {
				Client oneClient = new Client(rs1.getString(2));
				allClients.add(oneClient);
			}
			conn.close();

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allClients;
	}
	
	public static Client getOneClient(int id) {
		ResultSet rs1 = null;
		Client oneClient = null;
		try {
			Connection conn = Connect.getConnection();
			Statement st = conn.createStatement();
			
			rs1 = st.executeQuery("SELECT * FROM CLIENT WHERE client_id = '" + id + "'");

			while (rs1.next()) {
				oneClient = new Client(rs1.getString(2));
			}
			conn.close();

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oneClient;

	}
	
	public static void createClient(Client client) {
		
		String request = "INSERT INTO CLIENT (client_name) VALUES('"+ client.getClientName()+"')";

		try {

			Connection conn = Connect.getConnection();
			Statement st = conn.createStatement();
			st.executeUpdate(request);

			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
