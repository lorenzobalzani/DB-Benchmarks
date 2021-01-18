package Model;

import java.sql.Timestamp;
import java.util.Optional;

/**
 * The following class models a DB account object.
 * @author lorenzobalzani
 */
public class Account {
    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    private String gender;
    private Timestamp created_on;

    private Account(final String username, final String password, final String email, final String firstname,
                    final String lastname, final String gender, final Timestamp created_on) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.created_on = created_on;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getGender() {
        return gender;
    }

    public Timestamp getCreated_on() {
        return created_on;
    }

    /**
     * {@link Account} object is being created using builder design pattern.
     * @author lorenzobalzani
     */
    public static class AccountBuilder{
        private String username = null;
        private String password = null;
        private String email = null;
        private String firstname = null;
        private String lastname = null;
        private String gender = null;
        private Timestamp created_on = null;

        /**
         * @param username string
         * @return {@link AccountBuilder} object
         */
        public AccountBuilder username(final String username) {
            this.username = username;
            return this;
        }

        /**
         * @param password string
         * @return {@link AccountBuilder} object
         */
        public AccountBuilder password(final String password) {
            this.password = password;
            return this;
        }

        /**
         * @param email string
         * @return {@link AccountBuilder} object
         */
        public AccountBuilder email(final String email) {
            this.email = email;
            return this;
        }

        /**
         * @param firstname string
         * @return {@link AccountBuilder} object
         */
        public AccountBuilder firstname(final String firstname) {
            this.firstname = firstname;
            return this;
        }

        /**
         * @param lastname string
         * @return {@link AccountBuilder} object
         */
        public AccountBuilder lastname(final String lastname) {
            this.lastname = lastname;
            return this;
        }

        /**
         * @param gender string
         * @return {@link AccountBuilder} object
         */
        public AccountBuilder gender(final String gender) {
            this.gender = gender;
            return this;
        }

        /**
         * @param timestamp when the account is created
         * @return {@link AccountBuilder} object
         */
        public AccountBuilder created_on(final Timestamp created_on) {
            this.created_on = created_on;
            return this;
        }

        /**
         * @return {@link Account} object
         * @throws IllegalStateException if any of the field are empty
         */
        public Account build() throws IllegalStateException{
            if (this.username == null || this.password == null || this.email == null
                    || this.firstname == null || this.lastname == null
            || this.gender == null || this.created_on == null){
                throw new IllegalStateException("Some field are empty."); }
            return new Account(this.username, this.password, this.email, this.firstname, this.lastname, this.gender, this.created_on); }
    }
}



