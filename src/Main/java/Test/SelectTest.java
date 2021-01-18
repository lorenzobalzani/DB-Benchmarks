package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;


/**
 * Select implementation of {@link Test}.
 * @author lorenzobalzani
 */
public final class SelectTest implements Test {

   @Override
    public Double executeTest(final Connection connection) {
       long finish = 0;
       try {
           Random rand = new Random();
           String operators = "<>=";
           PreparedStatement st = null;
           st = connection.prepareStatement("SELECT id FROM accounts WHERE id"
                   + operators.charAt(rand.nextInt(operators.length()))  + "?");

           st.setInt(1, rand.nextInt(1000));
           st.setInt(1, rand.nextInt(1000));
           long start = System.nanoTime();
           ResultSet rs = st.executeQuery();
           finish = System.nanoTime() - start;
           rs.close();
           st.close();
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
        return (double) finish;
    }
}

