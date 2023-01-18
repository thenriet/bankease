package dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Connect {
	
	private static final String host = "jdbc:mysql://localhost:";
	private static final String port = "3306";
	private static final String db = "/gestion_database";
	
	private static final String user = "root";
	private static final String password = "9D7896N6";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(host + port + db, user,
				password);
		}
}
