package Utils;

import java.sql.*;

/**
 * Generic utilities for PostGre DB.
 * @author lorenzobalzani
 */
public class PostGreUtils {
    private Connection connection;

    /**
     * It establishes a new connection to the DB.
     * @param url of the DB
     * @param user
     * @param password
     */
    public final void connectToPostGreSQL(final String url, final String user, final String password) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * It retrieves the connection to the DB.
     * @return connection to the DB
     */
    public Connection getConnection() {
        return connection;
    }
}
