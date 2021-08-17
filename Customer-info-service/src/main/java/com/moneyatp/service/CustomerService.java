package com.moneyatp.service;

import com.moneyatp.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();
    public void addCustomer(Customer customer);


}
