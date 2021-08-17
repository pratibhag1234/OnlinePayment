package com.moneyatp.service;

import com.moneyatp.model.Bank;

import java.util.List;

public interface BankService {
    List<Bank> getallAccount();
    void addBankAccount(Bank bank);
    void removeBankAccount(int accountNo);

}
