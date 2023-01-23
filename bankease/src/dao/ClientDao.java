package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Client;

/**
 * 
 * @author tomhe
 *
 */
public class ClientDao {

	/**
	 * @return get every client in the db and add them into a List of Clients
	 */
	public static List<Client> getAllClients() {
		List<Client> allClients = new ArrayList<>();

		ResultSet rs = null;
		try {
			Connection conn = Connect.getConnection();
			Statement st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM CLIENT ORDER BY client_id");

			while (rs.next()) {
				Client oneClient = new Client();
				oneClient.setClientId(rs.getInt(1));
				oneClient.setClientDescription(rs.getString(2));
				oneClient.setClientBirthdate(rs.getDate(3));
				oneClient.setClientAddress(rs.getString(4));
				oneClient.setClientPhone(rs.getString(5));
				allClients.add(oneClient);
			}
			conn.close();

		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return allClients;
	}

	public static void createClient(Client client) {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			//
			String query = "INSERT INTO CLIENT (client_description, birth_date, address, phone) VALUES(?, ?, ?, ?)";
			conn = Connect.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, client.getClientDescription());
			stmt.setDate(2, client.getClientBirthdate());
			stmt.setString(3, client.getClientAddress());
			stmt.setString(4, client.getClientPhone());

			stmt.executeUpdate();

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteClient(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			String query = "DELETE FROM CLIENT WHERE client_id=?";
			conn = Connect.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);

			stmt.executeUpdate();

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void updateClient(Client client) {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			String query = "UPDATE CLIENT SET client_description = ?, birth_date = ?, address = ?, phone = ? WHERE client_id = ?";

			conn = Connect.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, client.getClientDescription());
			stmt.setDate(2, client.getClientBirthdate());
			stmt.setString(3, client.getClientAddress());
			stmt.setString(4, client.getClientPhone());
			stmt.setInt(5, client.getClientId());

			stmt.executeUpdate();

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
