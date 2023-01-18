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

	public static void changeBalance(Account account) {
		String query;
		
		if (account.getAccountType() == "courant") {
			query = "UPDATE checking_account SET balance = ? WHERE account_id = ?;";
		} else {
			query = "UPDATE saving_account SET balance = ? WHERE account_id = ?;";
		}
		
		try (Connection conn = Connect.getConnection()){
			PreparedStatement prst = conn.prepareStatement(query);
			
			prst.setFloat(1, account.getBalance());
			prst.setInt(2, account.getAccountId());
			
			int rows = prst.executeUpdate();
			prst.close();

			System.out.println("Rows impacted : " + rows);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
