package com.moneyatp.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    private String transactionType;
    private LocalDate date;
    private int amount;
    private String description;

    @ManyToOne
    @JoinColumn(name="walletId")
    //@JsonIgnore
    private Wallet wallet;

    @ManyToOne
    @JoinColumn(name="accountNo")
    //@JsonIgnore
    private Bank bank;



    public Transaction() {
    }

    public Transaction(int transactionId, String transactionType, LocalDate date, int amount, String description, Wallet wallet, Bank bank) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.wallet = wallet;
        this.bank = bank;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", transactionType='" + transactionType + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", wallet=" + wallet +
                ", bank=" + bank +
                '}';
    }
}
