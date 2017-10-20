package biz.Components;

public class Account {
    private String username;
    private String password;
    private boolean isActive;

    public Account() {
        this.isActive = true;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(HashHelper.generateHash(password));
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
    
    @Override
    public String toString() {
        return username;
    }
}
