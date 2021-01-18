package Test;

import Model.Account;
import org.apache.commons.lang3.RandomStringUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Insert implementation of {@link Test}
 * @author lorenzobalzani
 */
public final class InsertTest implements Test {
    private final Account account;

    public InsertTest() {
        this.account = new Account.AccountBuilder()
                .username(RandomStringUtils.randomAlphabetic(20))
                .password(RandomStringUtils.randomAlphabetic(64))
                .email(RandomStringUtils.randomAlphabetic(30))
                .firstname(RandomStringUtils.randomAlphabetic(10))
                .lastname(RandomStringUtils.randomAlphabetic(10))
                .gender(RandomStringUtils.randomAlphabetic(5))
                .created_on(new java.sql.Timestamp(new java.util.Date().getTime()))
                .build();
    }

    @Override
    public final Double executeTest(final Connection connection) throws SQLException {
        PreparedStatement st = connection.prepareStatement("INSERT INTO Accounts (username, password, email, firstname, lastname, gender, created_on) VALUES (?, ?, ?, ?, ?, ? ,?)");
        st.setString(1, account.getUsername());
        st.setString(2, account.getPassword());
        st.setString(3, account.getEmail());
        st.setString(4, account.getFirstname());
        st.setString(5, account.getLastname());
        st.setString(6, account.getGender());
        st.setTimestamp(7, account.getCreated_on());
        long start = System.nanoTime();
        st.executeUpdate();
        long finish = System.nanoTime() - start;
        return (double) finish;
    }
}
