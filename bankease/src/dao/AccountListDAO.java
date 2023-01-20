package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Account;
import model.CheckingAccount;
import model.SavingAccount;

/**
 * DB queries for Account list creation
 * @author S. Lebrun
 *
 */
public class AccountListDAO {

	/**
	 * Create CheckingAccount and SavingAccount objects with data from DB tables
	 * @param id : client ID
	 * @return Account Arraylist
	 */
	public static ArrayList<Account> getAccounts(int id) {
		ArrayList<Account> accountList = new ArrayList<>();

		try (Connection conn = Connect.getConnection()){

			PreparedStatement checking_st = conn.prepareStatement("SELECT account_id, client_id, owner_description, balance, transfer_fee, min_balance FROM checking_account WHERE client_id = ?;");
			checking_st.setInt(1,  id);
			ResultSet checking_rs = checking_st.executeQuery();

			while (checking_rs.next()) {
				CheckingAccount checking_account = new CheckingAccount();

				checking_account.setAccountType("courant");
				checking_account.setAccountId(checking_rs.getInt(1));
				checking_account.setClientId(checking_rs.getInt(2));
				checking_account.setOwnerDescription(checking_rs.getString(3));
				checking_account.setBalance(checking_rs.getFloat(4));
				checking_account.setTransferFee(checking_rs.getFloat(5));
				checking_account.setMinBalance(checking_rs.getFloat(6));

				accountList.add(checking_account);
			}

			PreparedStatement saving_st = conn.prepareStatement("SELECT account_id, client_id, owner_description, balance, interest_rate, balance_limit FROM saving_account WHERE client_id = ?;");
			saving_st.setInt(1,  id);
			ResultSet saving_rs = saving_st.executeQuery();
			
			while (saving_rs.next()) {
				SavingAccount saving_account = new SavingAccount();

				saving_account.setAccountType("épargne");
				saving_account.setAccountId(saving_rs.getInt(1));
				saving_account.setClientId(saving_rs.getInt(2));
				saving_account.setOwnerDescription(saving_rs.getString(3));
				saving_account.setBalance(saving_rs.getFloat(4));
				saving_account.setInterestRate(saving_rs.getFloat(5));
				saving_account.setBalanceLimit(saving_rs.getFloat(6));

				accountList.add(saving_account);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return accountList;
	}
	
	public static int DeleteAccount(Account account) {
		String query;
		int rows = 0;
		
		if (account instanceof SavingAccount) {
			query = "DELETE FROM saving_account WHERE account_id = ?";
		} else {
			query = "DELETE FROM checking_account WHERE account_id = ?";
		}

		try (Connection conn = Connect.getConnection()) {
			PreparedStatement prst = conn.prepareStatement(query);
			prst.setInt(1, account.getAccountId());
			rows = prst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;

	}

	/**
	 * Recovers the client name/business name from DB
	 * @param id : client ID
	 * @return client description as String
	 */
	// TODO retirer si plus utilisé après mise en commun (récupération du Client dans la frame)
	public static String getAccountOwner(int id) {
		String clientDesc = null;
		try (Connection conn = Connect.getConnection()) {
			
			PreparedStatement prst = conn.prepareStatement("SELECT client_description FROM client WHERE client_id = ?");
			prst.setInt(1, id);
			ResultSet rs = prst.executeQuery();
			rs.next();
			clientDesc = rs.getString(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientDesc;
	}
}
