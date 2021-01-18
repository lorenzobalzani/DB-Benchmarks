package Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Test interface to implement when creating new type of test
 * @author lorenzobalzani
 */
public interface Test {

    /**
     * It performs a generic test on a RDBMS using a {@link java.sql.Connection} object
     * @return Optional that might contain the select time duration expressed in nanoseconds (10^-9)
     */
    Double executeTest(final Connection connection) throws SQLException;
}
