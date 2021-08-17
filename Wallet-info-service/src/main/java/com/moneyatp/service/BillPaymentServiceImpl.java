package com.moneyatp.service;

import com.moneyatp.model.BillPayment;
import com.moneyatp.repository.BillPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillPaymentServiceImpl implements BillPaymentService {

    @Autowired
    private BillPaymentRepository billPaymentRepository;

    @Override
    public void addBill(BillPayment billPayment) {
        billPaymentRepository.save(billPayment);

    }

    @Override
    public BillPayment viewBill(int billId) {

        return billPaymentRepository.findById(billId).get();
    }

}
