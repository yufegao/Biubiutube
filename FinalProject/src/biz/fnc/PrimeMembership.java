package biz.fnc;

import biz.account.Account;

import java.util.Calendar;

public class PrimeMembership {
    private Account account;
    private Calendar expiration;

    public PrimeMembership(Account account) {
        this.account = account;
    }

    public boolean isExpired() {
        Calendar now = Calendar.getInstance();
        return (expiration == null) || expiration.before(now);
    }

    public void redeem(int weeks) {
        if (isExpired()) {
            expiration = Calendar.getInstance();
        }
        expiration.add(Calendar.WEEK_OF_YEAR, weeks);
    }

    public Account getAccount() {
        return account;
    }
}
