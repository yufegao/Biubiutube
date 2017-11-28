package biz.fnc;

import biz.account.Account;
import biz.enterprises.UniversityEnterprise;

import java.util.ArrayList;

public class RollUpOrderCatalog {
    private ArrayList<RollUpOrder> rollUpOrderArrayList;
    private UniversityEnterprise universityEnterprise;

    public RollUpOrderCatalog(UniversityEnterprise universityEnterprise) {
        this.rollUpOrderArrayList = new ArrayList<>();
        this.universityEnterprise = universityEnterprise;
    }

    public RollUpOrder newRollUpOrder(Account account, int amount, String payment) {
        RollUpOrder o = new RollUpOrder(account, amount, payment);
        this.rollUpOrderArrayList.add(o);
        return o;
    }

    public UniversityEnterprise getUniversityEnterprise() {
        return universityEnterprise;
    }

    public ArrayList<RollUpOrder> getRollUpOrderArrayList() {
        return rollUpOrderArrayList;
    }
}
