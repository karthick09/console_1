package Model;

public abstract class User {
    private final String name;
    private String email;
    private String phone;
    private final Account account;

    public User(String name, String email, String phone, Account account) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Account getAccount() {
        return account;
    }
}
