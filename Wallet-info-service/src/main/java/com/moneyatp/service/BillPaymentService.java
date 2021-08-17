package com.moneyatp.service;


import com.moneyatp.model.BillPayment;

public interface BillPaymentService {
    void addBill(BillPayment billPayment);
    public BillPayment viewBill(int billId);
}
