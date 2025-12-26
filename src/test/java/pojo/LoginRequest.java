package pojo;

public class LoginRequest {

    private String username;
    private String password;

    // Constructor
    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters (VERY IMPORTANT for REST Assured)
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
