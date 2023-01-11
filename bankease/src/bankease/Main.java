package bankease;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		try {
			Connection conn = Connect.getConnection();
			Statement st = conn.createStatement();
		    ResultSet rs = st.executeQuery("SELECT * FROM BANK");

			while(rs.next()) {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+
			rs.getString(3));

			}
			conn.close();
			
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
//		new Fenetre();
		
//		CheckingAccount a = new CheckingAccount(888888888);
//		System.out.println(a.getClient_id());
//		
//		SavingAccount s = new SavingAccount(777777777);
//		System.out.println(s.getClient_id());
		
	}

}
