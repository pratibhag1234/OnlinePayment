package com.moneyatp.model;

import javax.persistence.*;

@Entity
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int walletId;
    private int balance;
    //private int accountNo;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="accountNo")
    private Bank bank;

    public Wallet() {
    }

    public Wallet(int walletId, int balance, Bank bank) {
        this.walletId = walletId;
        this.balance = balance;
        this.bank = bank;
    }

    /*public Wallet(int balance, int accountNo) {
        this.balance = balance;
        this.accountNo = accountNo;
    }*/

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "walletId=" + walletId +
                ", balance=" + balance +
                ", bank=" + bank +
                '}';
    }
}
