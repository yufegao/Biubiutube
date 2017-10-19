package biz.Components;

import biz.Catalog.AbstractCatalog;
import java.util.ArrayList;

public class AccountCatalog extends AbstractCatalog<Account> {

    public AccountCatalog() {
        elementArrayList = new ArrayList<>();
    }
    
    @Override
    public Account createElement() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Account newElement() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Account login(String username, char[] password) throws LoginFailed {
        Account account = findElement(a -> a.getUsername().equals(username));
        if (account == null) {
            throw new LoginFailed("Account not exist.");
        }

        if (!account.checkPassword(new String(password))) {
            throw new LoginFailed("Invalid password");
        }

        if (!account.isActive()) {
            throw new LoginFailed("User disabled.");
        }

        return account;
    }

    public class LoginFailed extends Exception {
        LoginFailed(String message) {
            super(message);
        }
    }
}
