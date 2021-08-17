package com.moneyatp.controller;


import com.moneyatp.model.BillPayment;
import com.moneyatp.service.BillPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BillPaymentController {

    @Autowired
    private BillPaymentService billPaymentService;
    @RequestMapping(method= RequestMethod.GET,value="/billPayment{billId}")
    public BillPayment viewBill(@PathVariable int billId,@RequestHeader(name="Authorization")String token)
    {

        return  billPaymentService.viewBill(billId);
    }
    @RequestMapping(method= RequestMethod.POST,value="/billPayment{billId}")
    public void addBill(@RequestBody BillPayment billPayment,@RequestHeader(name="Authorization")String token)
    {

        billPaymentService.addBill(billPayment);
    }
}
