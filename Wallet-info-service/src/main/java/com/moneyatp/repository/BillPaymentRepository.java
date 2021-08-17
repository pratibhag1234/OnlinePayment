package com.moneyatp.repository;

import com.moneyatp.model.BillPayment;
import org.springframework.data.repository.CrudRepository;

public interface BillPaymentRepository extends CrudRepository<BillPayment,Integer> {
}
