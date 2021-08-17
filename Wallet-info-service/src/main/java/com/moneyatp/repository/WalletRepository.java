package com.moneyatp.repository;

import com.moneyatp.model.Wallet;
import org.springframework.data.repository.CrudRepository;

public interface WalletRepository extends CrudRepository<Wallet,Integer> {

}
