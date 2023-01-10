package bankease;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
			
		Client test = new Client(1);
		test.newClient();
		System.out.println(test.getClientName());
		System.out.println(test.getClientId());
		System.out.println(test.getClientAddress());
		
		new Fenetre();

	}

}
