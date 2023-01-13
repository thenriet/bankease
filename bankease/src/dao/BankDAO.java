package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class BankDAO {
	
	public static void getAllBanks() {
		ResultSet rs1 = null;
		try {
			Connection conn = Connect.getConnection();
			Statement st = conn.createStatement();
		 rs1 = st.executeQuery("SELECT * FROM BANK");

			while (rs1.next()) {
				System.out.println(rs1.getInt(1) + "  " + rs1.getString(2) + "  " + rs1.getString(3));

			}
			conn.close();

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void newBank() {
		String request = "INSERT INTO BANK (business_name, bank_address) VALUES('Test', '96 Route de Paris')";
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
