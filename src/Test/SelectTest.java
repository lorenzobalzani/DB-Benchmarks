package Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Random;

public final class SelectTest implements Test {

    /**
     * It performs random select statements
     * @return Optional that might contain the select time duration expressed in nanoseconds (10^-9)
     */
    @Override
    public final Optional<Double> executeTest(Connection connection) {
        Random rand = new Random();
        String operators = "<>=";
        try {
            PreparedStatement st = connection.prepareStatement("SELECT id FROM accounts WHERE id"
                    + operators.charAt(rand.nextInt(operators.length()))  + "?");
            st.setInt(1, rand.nextInt(1000));
            long start = System.nanoTime();
            ResultSet rs = st.executeQuery();
            long finish = System.nanoTime() - start;
            rs.close();
            st.close();
            return Optional.of((double) finish);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }
}

