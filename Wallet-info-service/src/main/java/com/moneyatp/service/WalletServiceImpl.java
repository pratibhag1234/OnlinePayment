package com.moneyatp.service;

import com.moneyatp.exception.BankAccountNotFoundException;
import com.moneyatp.exception.BeneficieryNotFoundException;
import com.moneyatp.exception.InvalidUserNameAndPasswordException;
import com.moneyatp.exception.WalletNotFoundException;
import com.moneyatp.model.Bank;
import com.moneyatp.model.Customer;
import com.moneyatp.model.Transaction;
import com.moneyatp.model.Wallet;
import com.moneyatp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private BeneficieryDetailsRepository beneficieryDetailsRepository;

    @Autowired
    private BillPaymentRepository billPaymentRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void createWallet(Wallet wallet) {
        walletRepository.save(wallet);

    }

    @Override
    public List<Customer> getCustomer() {
        List<Customer> cList=new ArrayList<>();
        customerRepository.findAll().forEach(customer ->cList.add(customer));
        return cList;
    }

   /* @Override
    public int getBalance(int customerId) throws CustomerNotFoundException {
        if(customerRepository.existsById(customerId)) {
            return customerRepository.findById(customerId).get().getWallet().getBalance();
        }
        else
        {
            throw new CustomerNotFoundException("Invalid CustomerId");
        }

    }*/
   @Override
   public int getBalance(int walletId) throws WalletNotFoundException {
       if(walletRepository.existsById(walletId)) {
           Wallet wallet = walletRepository.findById(walletId).get();
           return wallet.getBalance();
       }
       else
       {
           throw new WalletNotFoundException("Invalid WalletId");
       }
   }

    @Override
    public void changePassword(int customerId, String oldPassword, String newPassword, String confirmPassword) throws InvalidUserNameAndPasswordException {
        if(customerId!=customerRepository.findById(customerId).get().getCustomerId() && customerRepository.findById(customerId).get().getPassword()!=oldPassword &&
                newPassword!=confirmPassword)
        {
            throw new InvalidUserNameAndPasswordException("Invalid Username or password");
        }
        else
        {
            Customer customer=customerRepository.findById(customerId).get();
            customer.setPassword(confirmPassword);
            customerRepository.save(customer);

        }

    }

    @Override
    public void addMoney(int walletId, int amount, int accountNo) throws BankAccountNotFoundException {
        if(bankRepository.existsById(accountNo))
        {
            Wallet wallet=walletRepository.findById(walletId).get();
            Bank bank = wallet.getBank();
            bank.setBalance(bank.getBalance()-amount);
            wallet.setBalance(wallet.getBalance()+amount);
            walletRepository.save(wallet);
            bankRepository.save(bank);

            Transaction transaction = new Transaction();
            Random random=new Random();
            int tId= random.nextInt(1000);
            transaction.setTransactionId(tId);
            transaction.setTransactionType("credit");
            transaction.setDate(LocalDate.now());
            transaction.setAmount(amount);
            transaction.setDescription("Amount credit from bank to wallet");
            transaction.setWallet(wallet);
            transaction.setBank(bank);
            transactionRepository.save(transaction);

        }
        else
        {
            throw new BankAccountNotFoundException("Invalid account no");
        }

    }

    @Override
    public void fundTransfer(int walletId, int beneficieryId, int amount) throws BeneficieryNotFoundException {
        if(beneficieryDetailsRepository.existsById(beneficieryId))
        {
            Wallet wallet=walletRepository.findById(walletId).get();
            wallet.setBalance(wallet.getBalance()-amount);
            Bank bank= wallet.getBank();
            walletRepository.save(wallet);
            bankRepository.save(bank);

            /*BeneficieryDetails beneficieryDetails=new BeneficieryDetails();
            //beneficieryDetails=beneficieryDetailsRepository.findById(beneficieryId);
            Random random=new Random();
            int bId= random.nextInt(1000);
            beneficieryDetails.setBeneficieryId(bId);
            beneficieryDetails.setName(beneficieryDetails.getName());
            beneficieryDetails.setMobileNo(beneficieryDetails.getMobileNo());
            beneficieryDetails.setWallet(wallet);
            beneficieryDetailsRepository.save(beneficieryDetails);*/
            Transaction transaction = new Transaction();
            Random random=new Random();
            int tId= random.nextInt(1000);
            transaction.setTransactionId(tId);
            transaction.setTransactionType("debit");
            transaction.setDate(LocalDate.now());
            transaction.setAmount(amount);
            transaction.setDescription("Amount debit from wallet to beneficier");
            transaction.setWallet(wallet);
            transaction.setBank(bank);
            transactionRepository.save(transaction);
            System.out.println("fund sucessfully transfer");


        }
        else
        {
            throw new BeneficieryNotFoundException("Invalid BeneficieryDetail");
        }

    }

    @Override
    public void depositAmount(int walletId, int amount, int accountNo) {
        Wallet wallet=walletRepository.findById(walletId).get();
        Bank bank= wallet.getBank();
        bank.setBalance(bank.getBalance()+amount);
        wallet.setBalance(wallet.getBalance()-amount);
        walletRepository.save(wallet);
        bankRepository.save(bank);

        Transaction transaction = new Transaction();
        Random random=new Random();
        int tId= random.nextInt(1000);
        transaction.setTransactionId(tId);
        transaction.setTransactionType("debit");
        transaction.setDate(LocalDate.now());
        transaction.setAmount(amount);
        transaction.setDescription("Amount debit from wallet and credit to bank");
        transaction.setWallet(wallet);
        transaction.setBank(bank);
        transactionRepository.save(transaction);



    }

    @Override
    public void billPayment(int walletId, int billId, int amount) {
        Wallet wallet=walletRepository.findById(walletId).get();
        wallet.setBalance(wallet.getBalance()-amount);
        Bank bank= wallet.getBank();
        walletRepository.save(wallet);
        bankRepository.save(bank);

        /* BillPayment billPayment=new BillPayment();
        //billPayment=billPaymentRepository.findById(billId);
        Random random=new Random();
        int bilId= random.nextInt(500);
        billPayment.setBillId(bilId);
        billPayment.setBillType(billPayment.getBillType());
        billPayment.setAmount(amount);
        billPayment.setWallet(wallet);
        //billPayment.setCustomer(cust);
        billPaymentRepository.save(billPayment);*/
        Transaction transaction = new Transaction();
        Random random=new Random();
        int tId= random.nextInt(1000);
        transaction.setTransactionId(tId);
        transaction.setTransactionType("debit");
        transaction.setDate(LocalDate.now());
        transaction.setAmount(amount);
        transaction.setDescription("Amount debitted for bill payment");
        transaction.setWallet(wallet);
        transaction.setBank(bank);
        transactionRepository.save(transaction);
        System.out.println("bill paid");



    }
}