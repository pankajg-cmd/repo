package com.pankaj.wallet.repository;

import com.pankaj.wallet.model.Credit;
import com.pankaj.wallet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository  extends JpaRepository<Credit, Long> {
}
