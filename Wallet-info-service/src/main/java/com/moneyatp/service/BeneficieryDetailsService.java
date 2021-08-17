package com.moneyatp.service;

import com.moneyatp.model.BeneficieryDetails;

import java.util.List;

public interface BeneficieryDetailsService {
    void addBeneficieryDetails(BeneficieryDetails beneficieryDetails);
    List<BeneficieryDetails> getAllBeneficiers();
    BeneficieryDetails viewBeneficieryDetails(int beneficieryId);
    void deleteBeneficieryDetails(int beneficieryId);

}
