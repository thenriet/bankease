package dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.CheckingAccount;

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

		String sql = "INSERT INTO CHECKING_ACCOUNT (owner_description,client_id,transfer_fee,min_balance,balance) VALUES('"
				+ checkingaccount.getOwnerDescription() + "','" + checkingaccount.getClientId() +  "','" + checkingaccount.getTransferFee() + "','"
				+ checkingaccount.getMinBalance() + "','" + checkingaccount.getBalance() + "')";

		try {

			Connection conn = Connect.getConnection();
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
			Connection conn = Connect.getConnection();

			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, id);

			st.executeUpdate();

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void UpdateCheckingAccount(CheckingAccount checkingAccount) {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			String query = "UPDATE CHECKING_ACCOUNT SET owner_description = ?, transfer_fee = ? WHERE account_id = ?";

			conn = Connect.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, checkingAccount.getOwnerDescription());
			stmt.setFloat(2, checkingAccount.getTransferFee());
			stmt.setInt(3, checkingAccount.getAccountId());

			stmt.executeUpdate();

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
