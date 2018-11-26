package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static Connection connection = null;

	public ConnectionManager() {
		super();

		ConnectionConfig connectionConfig = new ConnectionConfig();
		connectionConfig.setDriver("com.mysql.jdbc.Driver");
		connectionConfig.setDatabase("/siscarnes?");
		connectionConfig.setUrl("jdbc:mysql://localhost");
		connectionConfig.setUser("root");
		connectionConfig.setPassword("vitor1999");
		try {
			Class.forName(connectionConfig.getDriver());
			connection = (Connection) DriverManager.getConnection(
					connectionConfig.getUrl() + connectionConfig.getDatabase(), connectionConfig.getUser(),
					connectionConfig.getPassword());
		} catch (SQLException e) {
			System.err.println("Erro ao criar conexão in ConnectionManager");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("Erro ao criar conexão in ConnectionManager - Classe não encontrada");
			e.printStackTrace();
		}
	}

	public static Connection getMysqlConnection() throws SQLException {
		if (connection == null)
			new ConnectionManager();

		return connection;
	}

}
