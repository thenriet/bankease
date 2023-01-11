package bankease;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SavingAccount {

	private int account_id;
	private float balance;
	private float interest_rate;
	private float balance_limit;
	private int client_id;
	private int bank_id;

	public SavingAccount(int id) {

		this.account_id = account_id;

		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_database", "thenriet",
					"thomas1991");
			java.sql.Statement st = conn.createStatement();
			ResultSet account_id = st.executeQuery("SELECT * FROM SAVING_ACCOUNT");
			while (account_id.next()) {
				if (id == account_id.getInt(1)) {

					this.balance = account_id.getFloat(2);
					this.interest_rate = account_id.getFloat(3);
					this.balance_limit = account_id.getFloat(4);
					this.client_id = account_id.getInt(5);
					this.bank_id = account_id.getInt(6);
					break;
				}
			}
			conn.close();

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public float getInterest_rate() {
		return interest_rate;
	}

	public void setInterest_rate(float interest_rate) {
		this.interest_rate = interest_rate;
	}

	public float getBalance_limit() {
		return balance_limit;
	}

	public void setBalance_limit(float balance_limit) {
		this.balance_limit = balance_limit;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public int getBank_id() {
		return bank_id;
	}

	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}

}