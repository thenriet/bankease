package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SavingAccountDAO {

	private int account_id;
	private float balance;
	private float interest_rate;
	private float balance_limit;
	private int client_id;
	private int bank_id;

	public SavingAccountDAO(int id) {

		this.account_id = account_id;

		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_database", "root",
					"9D7896N6");
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
}
