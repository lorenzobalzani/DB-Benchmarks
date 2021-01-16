package Test;

import java.sql.Connection;
import java.util.Optional;

public interface Test {
    Optional<Double> executeTest(Connection connection);
}
