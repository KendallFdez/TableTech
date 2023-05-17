package Classes;

/**
 * Este metodo define un usuario
 */
public class User {
    private String username;
    private String password;

    /**
     * Este es el metodo constructor para la clase User
     * @param username
     * @param password
     */
    public User( String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Este metodo define la variable username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Este metodo regresa la variable username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Este metodo define la varibale password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Este metodo retorna la variable password
     * @return password
     */
    public String getPassword() {
        return password;
    }
}

