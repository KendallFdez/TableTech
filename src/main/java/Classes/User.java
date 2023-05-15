package Classes;

public class User {
    private String userType;
    private String username;
    private String password;
    public User(){
        this("Admin", "Andres", "jojo");
    }
    public User(String userType, String username, String password) {
        this.userType = userType;
        this.username = username;
        this.password = password;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
    public String getUserType() {
        return userType;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
}

