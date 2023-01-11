package bankease;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Client {
	private int clientId;
	private String clientName;
	private String clientAddress;
	private String clientPhone;

	public Client(int id) {
		this.clientId = id;

		try {

			Connection conn = Connect.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM CLIENT");

			while (rs.next()) {
				if (id == rs.getInt(1)) {
					this.clientName = rs.getString("client_name");
					this.clientAddress = rs.getString(3);
					this.clientPhone = rs.getString(4);
				}
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void newClient() {
		String request = "INSERT INTO CLIENT VALUES(2, 'nameTest', 'addressTest', 'phoneTest')";
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

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public String getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

}
