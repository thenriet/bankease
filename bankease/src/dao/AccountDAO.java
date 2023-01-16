package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Account;
import model.CheckingAccount;
import model.SavingAccount;

/**
 * @author S. Lebrun
 *
 */
public class AccountDAO {

	/**
	 * Create CheckingAccount and SavingAccount objects with data from DB tables
	 * @param client ID
	 * @return Account Arraylist
	 */
	public static ArrayList<Account> getAccounts(int id) {
		ArrayList<Account> accountList = new ArrayList<>();

		try {
			Connection conn = Connect.getConnection();

			PreparedStatement checking_st = conn.prepareStatement("SELECT account_id, client_id, owner_description, balance, transfer_fee, min_balance FROM checking_account WHERE client_id = ?;");
			checking_st.setInt(1,  id);
			ResultSet checking = checking_st.executeQuery();

			while (checking.next()) {
				CheckingAccount checking_account = new CheckingAccount();

				checking_account.setAccountType("courant");
				checking_account.setAccountId(checking.getInt(1));
				checking_account.setClientId(checking.getInt(2));
				checking_account.setOwnerDescription(checking.getString(3));
				checking_account.setBalance(checking.getFloat(4));
				checking_account.setTransferFee(checking.getFloat(5));
				checking_account.setMinBalance(checking.getFloat(6));

				accountList.add(checking_account);
			}

			PreparedStatement saving_st = conn.prepareStatement("SELECT account_id, client_id, owner_description, balance, interest_rate, balance_limit FROM saving_account WHERE client_id = ?;");
			saving_st.setInt(1,  id);
			ResultSet saving = saving_st.executeQuery();
			
			while (saving.next()) {
				SavingAccount saving_account = new SavingAccount();

				saving_account.setAccountType("épargne");
				saving_account.setAccountId(saving.getInt(1));
				saving_account.setClientId(saving.getInt(2));
				saving_account.setOwnerDescription(saving.getString(3));
				saving_account.setBalance(saving.getFloat(4));
				saving_account.setInterestRate(saving.getFloat(5));
				saving_account.setBalanceLimit(saving.getFloat(6));

				accountList.add(saving_account);
			}

			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return accountList;
	}

	/**
	 * Recovers the client name/business name from DB
	 * @param client ID
	 * @return client description as String
	 */
	public static String getAccountOwner(int id) {
		String clientDesc = null;
		try {
			Connection conn = Connect.getConnection();
			
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
