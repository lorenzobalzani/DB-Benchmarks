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
     * @param user to login
     * @param password to login
     * @param autoCommit specifies whether users has to explicitly commit after statements.
     */
    public final void connectToPostGreSQL(final String url, final String user, final String password, final boolean autoCommit) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(autoCommit);
            System.out.println("Connected to the PostgreSQL server successfully with auto-commit = " + autoCommit);
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

    public void initTransaction() {

    }
}
