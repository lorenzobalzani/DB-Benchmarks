import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PosteGreUtility {
    private Connection connection;

    public final void connect(final String url, final String user, final String password) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public final void executeSelect() {

    }
}
