package bankease;
import dao.CheckingAccountDAO;

import dao.SavingAccountDAO;
import model.CheckingAccount;
import model.SavingAccount;


import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import view.CheckingAccountView;
import view.OuvrirCompte;
import view.SavingAccountView;

public class Main {

	public static void main(String[] args) {
//		try {
//			Connection conn = DriverManager.getConnection(
//					"jdbc:mysql://localhost:3306/gestion_database","root","9D7896N6");
//			java.sql.Statement st = conn.createStatement();
//		    ResultSet rs = st.executeQuery("SELECT * FROM BANK");
//
//			while(rs.next()) {
//				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+
//			rs.getString(3));
//
//			}
//			conn.close();
//			
//		}
//		
//		catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
		SavingAccountView f = new SavingAccountView();
		f.setVisible(true);
		
		//System.out.println(CheckingAccountDAO.OneCheckingAccount(444444).getOwner_description());

	}

}
