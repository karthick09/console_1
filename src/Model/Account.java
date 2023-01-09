package Model;

public class Account {
    private final String username;
    private  String password;

    public Account(String id, String password) {
        this.username = id;
        this.password = password;
    }

    public String getId() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

}
