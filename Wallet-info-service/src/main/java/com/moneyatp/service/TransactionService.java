package com.moneyatp.service;

import com.moneyatp.model.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService {
    Transaction addTransaction(Transaction transaction);
    List<Transaction> viewAllTransaction();
    List<Transaction> getByDate(LocalDate date);
    List<Transaction> getByType(String transactionType);
    //List<Transaction> getByWalletId(Integer walletId);
}
