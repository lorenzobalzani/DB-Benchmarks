package Model;

import java.sql.Timestamp;
import java.util.Optional;

/**
 * Account is created by using Builder design pattern
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

    public static class AccountBuilder{
        private String username = null;
        private String password = null;
        private String email = null;
        private String firstname = null;
        private String lastname = null;
        private String gender = null;
        private Timestamp created_on = null;

        public AccountBuilder username(final String username) {
            this.username = username;
            return this;
        }

        public AccountBuilder password(final String password) {
            this.password = password;
            return this;
        }

        public AccountBuilder email(final String email) {
            this.email = email;
            return this;
        }

        public AccountBuilder firstname(final String firstname) {
            this.firstname = firstname;
            return this;
        }

        public AccountBuilder lastname(final String lastname) {
            this.lastname = lastname;
            return this;
        }

        public AccountBuilder gender(final String gender) {
            this.gender = gender;
            return this;
        }

        public AccountBuilder created_on(final Timestamp created_on) {
            this.created_on = created_on;
            return this;
        }

        public Account build() throws IllegalStateException{
            if (this.username == null || this.password == null || this.email == null
                    || this.firstname == null || this.lastname == null
            || this.gender == null || this.created_on == null){
                throw new IllegalStateException("Some field are empty."); }
            return new Account(this.username, this.password, this.email, this.firstname, this.lastname, this.gender, this.created_on); }
    }
}



