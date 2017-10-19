package biz;

public class Account {
    private String username;
    private String password;
    private boolean isActive;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean checkPassword(String password) {
        return password.equals(HashHelper.generateHash(password));
    }

    public void setPassword(String password) {
        this.password = HashHelper.generateHash(password);
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
