package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

/**
 * Drop table implementation of {@link Test}
 * @author lorenzobalzani
 */
public class DropTableTest implements Test {

    @Override
    public Optional<Double> executeTest(Connection connection) {
        try {
            PreparedStatement st = connection.prepareStatement(
                    "DROP TABLE accounts");
            long start = System.nanoTime();
            st.executeUpdate();
            long finish = System.nanoTime() - start;
            st.close();
            return Optional.of((double) finish);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }
}
