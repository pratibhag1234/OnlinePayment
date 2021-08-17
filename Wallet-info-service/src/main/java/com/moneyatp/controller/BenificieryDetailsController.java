package com.moneyatp.controller;


import com.moneyatp.model.BeneficieryDetails;
import com.moneyatp.service.BeneficieryDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BenificieryDetailsController {

    @Autowired
    private BeneficieryDetailsService beneficieryDetailsService;

    @RequestMapping(method= RequestMethod.GET,value="/beneficieryDetails/add")
    public List<BeneficieryDetails> getAllBeneficieries(@RequestHeader(name="Authorization")String token)
    {

        return  beneficieryDetailsService.getAllBeneficiers();
    }

    @RequestMapping(method= RequestMethod.POST,value="/beneficieryDetails")
    public void  addBeneficieryDetails(@RequestBody BeneficieryDetails beneficieryDetails,@RequestHeader(name="Authorization")String token)
    {

         beneficieryDetailsService.addBeneficieryDetails(beneficieryDetails);
    }
    @RequestMapping(method= RequestMethod.DELETE,value="/beneficieryDetails/{beneficieryId}")
    public void deleteBeneficieryDetails(@PathVariable int beneficieryId)
    {

        beneficieryDetailsService.deleteBeneficieryDetails(beneficieryId);
    }

    @RequestMapping(method = RequestMethod.GET,value="/viewbenefecieraydetails/{beneficieryId}")
    public BeneficieryDetails viewBenefecierayDetails(@PathVariable int beneficieryId,@RequestHeader(name="Authorization")String token)
    {

        return beneficieryDetailsService.viewBeneficieryDetails(beneficieryId);
    }



}
