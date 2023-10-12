package backend.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                String url = "jdbc:postgresql://localhost:5432/easybank";
                String username = "postgres";
                String password = "lamia";
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("connected to database");
            }
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return null;
    }


}
