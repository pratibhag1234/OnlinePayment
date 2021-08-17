package com.moneyatp.model;

import javax.persistence.*;

@Entity
public class BeneficieryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int beneficieryId;
    private String name;
    private long mobileNo;

    @ManyToOne
    @JoinColumn(name="walletId")
    private Wallet wallet;

    public BeneficieryDetails() {
    }

    public BeneficieryDetails(int beneficieryId, String name, long mobileNo, Wallet wallet) {
        this.beneficieryId = beneficieryId;
        this.name = name;
        this.mobileNo = mobileNo;
        this.wallet = wallet;
    }

    public int getBeneficieryId() {
        return beneficieryId;
    }

    public void setBeneficieryId(int beneficieryId) {
        this.beneficieryId = beneficieryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "BeneficieryDetails{" +
                "beneficieryId=" + beneficieryId +
                ", name='" + name + '\'' +
                ", mobileNo=" + mobileNo +
                ", wallet=" + wallet +
                '}';
    }
}
