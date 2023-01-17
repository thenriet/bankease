package dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.SavingAccount;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SavingAccountDAO {


	public static SavingAccount OneSavingAccount(int id) {
			
	SavingAccount compte = null;

	try {

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_database", "root",
				"9D7896N6");
		java.sql.Statement st = conn.createStatement();
		ResultSet account_id = st.executeQuery("SELECT * FROM SAVING_ACCOUNT WHERE account_id = '" + id + "'" );
		
		while (account_id.next()) {
				
				compte = new SavingAccount(id, account_id.getInt(2),account_id.getString(3),
						account_id.getFloat(4),account_id.getFloat(5),account_id.getFloat(6));
			
		}
		conn.close();

	}

	catch (SQLException e) {
		e.printStackTrace();
	}
	
	return compte;
	
	}
	
	public static void CreateSavingAccount(SavingAccount savingaccount) {
		
		String sql = "INSERT INTO SAVING_ACCOUNT (owner_description,interest_rate,balance_limit,balance) VALUES('"+ savingaccount.getOwnerDescription()+"','"+ savingaccount.getInterestRate() +"','"+savingaccount.getBalanceLimit()+"','"+savingaccount.getBalance()+"')";
				
		try {

			Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/gestion_database","root","9D7896N6");
			Statement st = conn.createStatement();
			st.executeUpdate(sql);
          
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void DeleteSavingAccount(int id) {

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