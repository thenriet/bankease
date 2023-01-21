package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import model.Account;

/**
 * DB queries to change account balance
 * @author S. Lebrun
 *
 */
public class AccountManagementDAO {

	/**
	 * Sets the DB balance value to the Account's balance value
	 * @param account : previously modified Account object with new balance value
	 * @return number of rows impacted by change
	 */
	public static int changeBalance(Account account) {
		String query;
		int rows = 0;
		
		if (account.getAccountType() == "courant") {
			query = "UPDATE checking_account SET balance = ? WHERE account_id = ?;";
		} else {
			query = "UPDATE saving_account SET balance = ? WHERE account_id = ?;";
		}
		
		try (Connection conn = Connect.getConnection()){
			PreparedStatement prst = conn.prepareStatement(query);
			
			prst.setFloat(1, account.getBalance());
			prst.setInt(2, account.getAccountId());
			
			rows = prst.executeUpdate();
			prst.close();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
}
