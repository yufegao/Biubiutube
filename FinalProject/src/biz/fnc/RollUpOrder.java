package biz.fnc;

import biz.account.Account;

import java.util.Calendar;

public class RollUpOrder {
    private Calendar createdAt;
    private Calendar updatedAt;
    private Account viewer;
    private Status status;
    private int amount;

    public Status getStatus() {
        return status;
    }

    RollUpOrder(Account viewer, int amount) {
        this.viewer = viewer;
        this.createdAt = Calendar.getInstance();
        this.updatedAt = Calendar.getInstance();
        this.amount = amount;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public Account getViewer() {
        return viewer;
    }

    public int getAmount() {
        return amount;
    }

    public Calendar getUpdatedAt() {
        return updatedAt;
    }

    enum Status {
        Submitted("Submitted", "You've submitted the roll up request and should have paid the bill."),
        Approved("Approved", "Your order has been approved and the coin has been added."),
        Canceled("Canceled", "The order is canceled due to some reason.");

        private String value;
        private String comment;

        Status(String value, String comment) {
            this.value = value;
            this.comment = comment;
        }

        @Override
        public String toString() {
            return value;
        }

        public String getComment() {
            return comment;
        }

        public String getValue() {
            return value;
        }
    }

    public void approve() throws Exception {
        if (!status.equals(Status.Submitted)) {
            throw new Exception("");
        }
        status = Status.Approved;
        updatedAt = Calendar.getInstance();
        viewer.getWallet().addCoin(amount);
    }

    public void cancel() throws Exception {
        if (!status.equals(Status.Submitted)) {
            throw new Exception();
        }
        status = Status.Canceled;
        updatedAt = Calendar.getInstance();
    }
}
