package org.tarascar.webapp;

public class User {

    private String login;
    private String password;

    private User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static UserBuilder getBuilder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private String login;
        private String password;

        public UserBuilder withLog(String login) {
            this.login = login;
            return this;
        }

        public UserBuilder withPass(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(login, password);
        }
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return login + ' ' + password ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
