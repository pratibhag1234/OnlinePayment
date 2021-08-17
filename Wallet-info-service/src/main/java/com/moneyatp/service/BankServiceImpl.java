package com.moneyatp.service;

import com.moneyatp.model.Bank;
import com.moneyatp.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;


    @Override
    public List<Bank> getallAccount() {
        List<Bank> acList=new ArrayList<>();
        bankRepository.findAll().forEach(bank->acList.add(bank));
        //System.out.println(acList);
        return acList;
          }


    @Override
    public void addBankAccount(Bank bank) {

         bankRepository.save(bank);
    }

   @Override
    public void removeBankAccount(int accountNo) {

        bankRepository.deleteById(accountNo);
    }



}
