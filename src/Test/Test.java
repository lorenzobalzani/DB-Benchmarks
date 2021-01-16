package Test;

import java.sql.Connection;
import java.util.Optional;

public interface Test {
    public Optional<Double> executeTest(Connection connection);
}
