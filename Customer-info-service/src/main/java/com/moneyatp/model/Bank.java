package com.moneyatp.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="seq",initialValue=500000,allocationSize = 100)
public class Bank {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    private int accountNo;
    private String ifscCode;
    private String bankName;
    private int balance;

   /* @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customerId")
    //@JsonIgnore
    private Customer customer;*/



    public Bank() {
    }

    public Bank(String ifscCode, String bankName, int balance) {
        //this.accountNo = (int)(Math.random()*1000+100);
        this.ifscCode = ifscCode;
        this.bankName = bankName;
        this.balance = balance;
    }
    /*public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }*/
  /* public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }*/

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }



    @Override
    public String toString() {
        return "Bank{" +
                "ifscCode='" + ifscCode + '\'' +
                ", bankName='" + bankName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
