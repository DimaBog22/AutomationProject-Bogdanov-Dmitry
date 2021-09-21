package PageFactory.Saucedemo;

public class UserBuilder {

    private String username;
    private String password;

    @Override
    public String toString() {
        return "UserBuilder{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static  class Builder {

        private UserBuilder userBuilder;

        public Builder() {
            userBuilder = new UserBuilder();
        }

        public Builder withUsername(String username) {
            userBuilder.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            userBuilder.password = password;
            return this;
        }

        public UserBuilder build() {
            return userBuilder;
        }

    }

}
