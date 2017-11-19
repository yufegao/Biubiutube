package biz.wrk;

import biz.account.Account;

import java.util.Calendar;

public abstract class WorkRequest {
    protected Account sender;
    protected Calendar createdAt;
    protected Calendar updatedAt;

    public WorkRequest(Account sender) {
        this.sender = sender;
        this.createdAt = Calendar.getInstance();
        this.updatedAt = Calendar.getInstance();
    }
}
