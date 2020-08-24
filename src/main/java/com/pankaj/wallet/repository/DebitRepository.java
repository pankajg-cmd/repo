package com.pankaj.wallet.repository;

import com.pankaj.wallet.model.Credit;
import com.pankaj.wallet.model.Debit;
import com.pankaj.wallet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DebitRepository extends JpaRepository<Debit, Long> {
    List<Debit> findAllByUser(User user);
}
