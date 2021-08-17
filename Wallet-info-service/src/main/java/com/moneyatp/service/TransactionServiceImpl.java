package com.moneyatp.service;

import com.moneyatp.model.Transaction;
import com.moneyatp.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

   /* @Autowired
    private WalletRepository walletRepository;*/

    @Override
    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> viewAllTransaction() {
        List<Transaction> tnsList=new ArrayList<>();
        transactionRepository.findAll().forEach(transaction->tnsList.add(transaction));
        return tnsList;
    }

    @Override
    public List<Transaction> getByDate(LocalDate date) {

        return transactionRepository.findBydate(date);
    }

    @Override
    public List<Transaction> getByType(String transactionType) {
        return transactionRepository.findBytransactionType(transactionType);
    }

    /*@Override
    public List<Transaction> getByWalletId(Integer walletId) {
        return transactionRepository.findByWalletId(walletRepository.findById(walletId).get());
    }*/
}
