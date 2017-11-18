/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.account;

import biz.org.Organization;

import java.util.ArrayList;

/**
 *
 * @author 79813
 */
public class AccountCatalog {
    private Organization org;
    private ArrayList<Account> accountArrayList;

    public AccountCatalog(Organization org) {
        this.org = org;
        this.accountArrayList = new ArrayList<>();
    }

    public Organization getOrg() {
        return org;
    }

    public Account newAccount() {
        Account acc = new Account(org);
        this.accountArrayList.add(acc);
        // System.getInstance().addAccount(acc); TODO
        return acc;
    }

    public void removeAccount(Account account) {
        this.accountArrayList.remove(account);
        // System.getInstance().removeAccount(account); TODO
    }

    public ArrayList<Account> getAccountArrayList() {
        return accountArrayList;
    }
}
