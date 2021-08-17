package com.moneyatp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BillPayment {

    @Id
    private int billId;
    private String billType;
    private int amount;

    @ManyToOne
    @JoinColumn(name="walletId")
    private Wallet wallet;

    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customerId")
    private Customer customer;*/

    public BillPayment() {
    }

    public BillPayment(int billId, String billType, int amount, Wallet wallet) {
        this.billId = billId;
        this.billType = billType;
        this.amount = amount;
        this.wallet = wallet;
    }

    public int getBillId() {

        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

   /* public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }*/

    @Override
    public String toString() {
        return "BillPayment{" +
                "billId=" + billId +
                ", billType='" + billType + '\'' +
                ", amount=" + amount +
                ", wallet=" + wallet +
                '}';
    }
}
