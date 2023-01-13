package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.CheckingAccount;

public class CheckingAccountDAO {

	public static CheckingAccount OneCheckingAccount(int id) {
			
	CheckingAccount compte = null;

	try {

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_database", "root",
				"9D7896N6");
		java.sql.Statement st = conn.createStatement();
		ResultSet account_id = st.executeQuery("SELECT * FROM CHECKING_ACCOUNT WHERE account_id = '" + id + "'" );


		while (account_id.next()) {
				
				compte = new CheckingAccount(account_id.getFloat(3),account_id.getFloat(3),
						account_id.getFloat(4),account_id.getInt(5),account_id.getInt(6));
			
		}
		conn.close();

	}

	catch (SQLException e) {
		e.printStackTrace();
	}
	
	return compte;
	
	}
	
	public static CheckingAccount CreateCheckingAccount(int account_id, float balance, float transfer_fee, float min_balance, 
			int client_id,int bank_id) throws SQLException {

		Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_database", "root",
    				"9D7896N6");
            String sql = "INSERT INTO CHECKING_ACCOUNT (account_id, balance, client_id) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, account_id);
            statement.setFloat(2, balance);
            statement.setInt(3,client_id);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new account has been created.");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
		return null;
    }
	
	
}
