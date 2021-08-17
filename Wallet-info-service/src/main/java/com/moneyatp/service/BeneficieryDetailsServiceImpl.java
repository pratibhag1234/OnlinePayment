package com.moneyatp.service;

import com.moneyatp.model.BeneficieryDetails;
import com.moneyatp.repository.BeneficieryDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BeneficieryDetailsServiceImpl implements BeneficieryDetailsService {

    @Autowired
    private BeneficieryDetailsRepository beneficieryDetailsRepository;

    @Override
    public void addBeneficieryDetails(BeneficieryDetails beneficieryDetails) {
        beneficieryDetailsRepository.save(beneficieryDetails);
    }

    @Override
    public List<BeneficieryDetails> getAllBeneficiers() {
        List<BeneficieryDetails> bList= new ArrayList<>();
        beneficieryDetailsRepository.findAll().forEach(beneficieryDetails->bList.add(beneficieryDetails));
        return bList;
    }

    @Override
    public BeneficieryDetails viewBeneficieryDetails(int beneficieryId) {

        return beneficieryDetailsRepository.findById(beneficieryId).get();
    }



    @Override
    public void deleteBeneficieryDetails(int beneficieryId) {
        beneficieryDetailsRepository.deleteById(beneficieryId);

    }
}
