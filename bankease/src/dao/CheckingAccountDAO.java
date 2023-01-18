package dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.CheckingAccount;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CheckingAccountDAO {

	public static CheckingAccount OneCheckingAccount(int id) {

		CheckingAccount compte = null;

		try {

			Connection conn = Connect.getConnection();

			java.sql.Statement st = conn.createStatement();
			ResultSet accountId = st.executeQuery("SELECT * FROM CHECKING_ACCOUNT WHERE account_id = '" + id + "'");

			while (accountId.next()) {

				compte = new CheckingAccount(id, accountId.getInt(2), accountId.getString(3), accountId.getFloat(4),
						accountId.getFloat(5), accountId.getFloat(6));

			}
			conn.close();

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return compte;

	}

	public static void CreateCheckingAccount(CheckingAccount checkingaccount) {

		String sql = "INSERT INTO CHECKING_ACCOUNT (owner_description,transfer_fee,min_balance,balance) VALUES('"
				+ checkingaccount.getOwnerDescription() + "','" + checkingaccount.getTransferFee() + "','"
				+ checkingaccount.getMinBalance() + "','" + checkingaccount.getBalance() + "')";

		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_database", "root",
					"9D7896N6");
			Statement st = conn.createStatement();
			st.executeUpdate(sql);

			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void DeleteCheckingAccount(int id) {

		try {
			String query = "DELETE FROM SAVING_ACCOUNT WHERE account_id=?";
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_database", "root",
					"9D7896N6");

			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, id);

			st.executeUpdate();

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
