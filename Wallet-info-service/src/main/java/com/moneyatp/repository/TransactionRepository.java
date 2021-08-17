package com.moneyatp.repository;

import com.moneyatp.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction,Integer> {

    List<Transaction> findBydate(LocalDate date);
    List<Transaction> findBytransactionType(String transactionType);
    //public List<Transaction> findByWalletId(Wallet wallet);

}
