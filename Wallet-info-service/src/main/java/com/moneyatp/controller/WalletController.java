package com.moneyatp.controller;

import com.moneyatp.exception.BankAccountNotFoundException;
import com.moneyatp.exception.BeneficieryNotFoundException;
import com.moneyatp.exception.InvalidUserNameAndPasswordException;
import com.moneyatp.exception.WalletNotFoundException;
import com.moneyatp.model.BeneficieryDetails;
import com.moneyatp.model.Customer;
import com.moneyatp.model.Wallet;
import com.moneyatp.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class WalletController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WalletService walletService;


    @RequestMapping(method=RequestMethod.POST,value="wallet/create{accountNo}")
    public void createWallet(@RequestBody Wallet wallet,@RequestHeader(name="Authorization")String token)
    {
        walletService.createWallet(wallet);
    }

    @RequestMapping(method=RequestMethod.GET,value="wallet/admin")
    public List<Customer> getCustomer(@RequestHeader(name="Authorization")String token)
    {

        return walletService.getCustomer();
    }

    @RequestMapping(method=RequestMethod.GET,value="wallet/{walletId}")
    public int getBalance(@PathVariable int walletId,@RequestHeader(name="Authorization")String token) throws WalletNotFoundException
    {
        return walletService.getBalance(walletId);
    }

    @RequestMapping(method=RequestMethod.POST,value="wallet/password/{customerId}/{oldPassword}/{newPassword}/{confirmPassword}")
    public void changePassword(@PathVariable int customerId,@PathVariable String oldPassword,@PathVariable String newPassword,@PathVariable String confirmPassword,@RequestHeader(name="Authorization")String token) throws InvalidUserNameAndPasswordException
    {
        walletService.changePassword(customerId,oldPassword,newPassword,confirmPassword);
    }

    @RequestMapping(method=RequestMethod.POST,value="wallet/addWallet/{walletId}/{amount}/{accountNo}")
    public void addMoney(@PathVariable int walletId,@PathVariable int amount,@PathVariable int accountNo,@RequestHeader(name="Authorization")String token) throws BankAccountNotFoundException
    {
        walletService.addMoney(walletId, amount, accountNo);
    }
    @RequestMapping(method=RequestMethod.POST,value="wallet/beneficierydetail/{walletId}/{beneficieryId}/{amount}")
    public void fundTransfer(@PathVariable int walletId,@PathVariable int beneficieryId,@PathVariable int amount,@RequestHeader(name="Authorization")String token) throws BeneficieryNotFoundException
    {
        walletService.fundTransfer(walletId,beneficieryId,amount);
    }

    @RequestMapping(method=RequestMethod.POST,value="wallet/deposit/{walletId}/{amount}/{accountNo}")
    public void depositAmount(@PathVariable int walletId,@PathVariable int amount,@PathVariable int accountNo,@RequestHeader(name="Authorization")String token)
    {
        walletService.depositAmount(walletId,amount,accountNo);
    }

    @RequestMapping(method=RequestMethod.POST,value="wallet/billpay/{walletId}/{billId}/{amount}")
    public void billPayment(@PathVariable int walletId,@PathVariable int billId,@PathVariable int amount,@RequestHeader(name="Authorization")String token)
    {
        walletService.billPayment(walletId,billId,amount);
    }

   /* @PostMapping("/register")
    //@RequestMapping(method= RequestMethod.POST,value="/customer")
    public void addCustomer(@RequestBody Customer customer,@RequestHeader(name="Authorization") String token)
    {
        String url="http://Customer-info-service/customer/";
        restTemplate.postForObject(url,customer,Customer.class);
    }*/


}












