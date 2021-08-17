package com.moneyatp.service;


import com.moneyatp.exception.BankAccountNotFoundException;
import com.moneyatp.exception.BeneficieryNotFoundException;
import com.moneyatp.exception.InvalidUserNameAndPasswordException;
import com.moneyatp.exception.WalletNotFoundException;
import com.moneyatp.model.Customer;
import com.moneyatp.model.Wallet;

import java.util.List;

public interface WalletService {
    void createWallet(Wallet wallet);
    List<Customer> getCustomer();
    int getBalance(int walletId) throws WalletNotFoundException;
    public void changePassword(int customerId,String oldPassword,String newPassword,String confirmPassword) throws InvalidUserNameAndPasswordException;
    public void addMoney(int walletId,int amount,int accountNo) throws BankAccountNotFoundException;
    public void fundTransfer(int walletId,int beneficieryId,int amount) throws BeneficieryNotFoundException;
    public void depositAmount(int walletId,int amount,int accountNo);
    public void billPayment(int walletId,int billId,int amount);


}
