package com.moneyatp.controller;

import com.moneyatp.model.Transaction;
import com.moneyatp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;


    @RequestMapping(method = RequestMethod.GET, value = "/transaction")
    public List<Transaction> getAllTransaction(@RequestHeader(name="Authorization")String token) {

        return transactionService.viewAllTransaction();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/transaction")
    public Transaction addTransaction(@RequestBody Transaction transaction,@RequestHeader(name="Authorization")String token) {

        return transactionService.addTransaction(transaction);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/transaction/{date}")
    public List<Transaction>getByDate(@PathVariable("date") String date,@RequestHeader(name="Authorization")String token) {
        LocalDate today = LocalDate.now();
        return transactionService.getByDate(today);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/transaction/type/{transactionType}")
    public List<Transaction> getByType(@PathVariable("transactionType") String transactionType,@RequestHeader(name="Authorization")String token) {
        return transactionService.getByType(transactionType);
    }

    /*@RequestMapping(method = RequestMethod.GET, value = "/transaction/type/{walletId}")
    public List<Transaction> getByWalletId(@PathVariable("walletId") int walletId) {
        return transactionService.getByWalletId(walletId);
    }*/
}
