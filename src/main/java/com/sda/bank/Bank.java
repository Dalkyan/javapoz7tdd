package com.sda.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {

    private BankDatabase bankDatabase;

    public Bank(BankDatabase bankDatabase) {
        this.bankDatabase = bankDatabase;
    }
    public boolean deposit(String nameOfAccount, int amount){
        return bankDatabase.deposit(nameOfAccount,amount);
    }


    public boolean addBankUser(BankUser bankUser) {
        return bankDatabase.addBankUser(bankUser);

    }

    public int numberOfUsers() {
        return bankDatabase.numberOfUsers();
    }

    public boolean createAccountFor(BankUser bankUser, String accountName){
        return bankDatabase.createAccountFor(bankUser, accountName);
    }

    public List<BankAccount> getAccountsOf(BankUser bankUser) {
        return bankDatabase.getAccountsOf(bankUser);
    }

    public int numberOfAccounts() {
        return bankDatabase.numberOfAccounts();}

    public BankAccount getAccountWithId(String nameOfAccount) {
        return bankDatabase.getAccountWithId(nameOfAccount);
    }
}
