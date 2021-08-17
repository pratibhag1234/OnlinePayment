package com.moneyatp.service;

import com.moneyatp.model.Customer;
import com.moneyatp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> cList=new ArrayList<>();
        customerRepository.findAll().forEach(customer->cList.add(customer));
        //System.out.println(acList);
        return cList;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);

    }
}
