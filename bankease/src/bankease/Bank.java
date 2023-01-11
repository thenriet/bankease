package bankease;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author S. Lebrun
 *
 */
public class Bank {
	public String businessName;
	public ArrayList<Account> accountList = new ArrayList<>();
	
	
	public void getAccounts() {
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_database", "slebrun", "Simplon59");
			Statement st = conn.createStatement();
			ResultSet checking = st.executeQuery("SELECT account_id, balance, bank_id, client_id, min_balance, transfer_fee FROM checking_account");
			
			while (checking.next()) {
				CheckingAccount checking_account = new CheckingAccount();
				
				checking_account.setAccountId(checking.getInt(1));
				checking_account.setBalance(checking.getFloat(2));
				checking_account.setBankId(checking.getInt(3));
				checking_account.setClientId(checking.getInt(4));
				checking_account.setMinBalance(checking.getFloat(5));
				checking_account.setTransferFee(checking.getFloat(6));

				accountList.add(checking_account);
			}
			
			Statement st2 = conn.createStatement();
			ResultSet saving = st2.executeQuery("SELECT account_id, balance, bank_id, client_id, balance_limit, interest_rate FROM saving_account");
			while (saving.next()) {
				SavingAccount saving_account = new SavingAccount();
				
				saving_account.setAccountId(checking.getInt(1));
				saving_account.setBalance(checking.getFloat(2));
				saving_account.setBankId(checking.getInt(3));
				saving_account.setClientId(checking.getInt(4));
				saving_account.setBalanceLimit(checking.getFloat(5));
				saving_account.setInterestRate(checking.getFloat(6));

				accountList.add(saving_account);
			}
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
