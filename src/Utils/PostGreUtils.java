package Utils;

import java.sql.*;
public class PostGreUtils {
    private Connection connection;

    public final void connectToPostGreSQL(final String url, final String user, final String password) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
