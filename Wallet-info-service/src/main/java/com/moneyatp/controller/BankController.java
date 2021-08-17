package com.moneyatp.controller;

import com.moneyatp.model.Bank;
import com.moneyatp.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankController {

    @Autowired
    private BankService bankService;

    @RequestMapping(method= RequestMethod.GET,value="/bankaccount/allAccount")
    public List<Bank> getallAccount(@RequestHeader(name="Authorization")String token)
    {

        return  bankService.getallAccount();
    }


    @RequestMapping(method= RequestMethod.POST,value="/bankaccount/addAccount")
    public void addBankAccount(@RequestBody Bank bank,@RequestHeader(name="Authorization")String token)
    {

          bankService.addBankAccount(bank);
    }


    @RequestMapping(method= RequestMethod.DELETE,value="/bank/{accountNo}")
    public void removeBankAccount(@PathVariable int accountNo)
    {

        bankService.removeBankAccount(accountNo);
    }



}




