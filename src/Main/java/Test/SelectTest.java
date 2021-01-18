package Test;
import Model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Random;


/**
 * Select implementation of {@link Test}.
 * @author lorenzobalzani
 */
public final class SelectTest implements Test {

   @Override
    public final Double executeTest(final Connection connection) throws SQLException {
        Random rand = new Random();
        String operators = "<>=";
        PreparedStatement st = connection.prepareStatement("SELECT id FROM accounts WHERE id"
                + operators.charAt(rand.nextInt(operators.length()))  + "?");
        st.setInt(1, rand.nextInt(1000));
        st.setInt(1, rand.nextInt(1000));
        long start = System.nanoTime();
        ResultSet rs = st.executeQuery();
        long finish = System.nanoTime() - start;
        rs.close();
        st.close();
        return (double) finish;
    }
}

