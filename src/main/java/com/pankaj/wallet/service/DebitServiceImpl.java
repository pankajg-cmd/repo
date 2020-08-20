package com.pankaj.wallet.service;

import com.pankaj.wallet.model.Credit;
import com.pankaj.wallet.model.Debit;
import com.pankaj.wallet.model.User;
import com.pankaj.wallet.repository.CreditRepository;
import com.pankaj.wallet.repository.DebitRepository;
import com.pankaj.wallet.web.dto.CreditDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DebitServiceImpl implements DebitService {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    DebitRepository debitRepository;
    
    public void debit(CreditDto creditDto) {
        User userFrom =  userService.findByEmail(creditDto.getFromEmail());
        User userTo =  userService.findByEmail(creditDto.getToEmail());
        Debit debit = new Debit();
        debit.setAmount(creditDto.getAmount());
        debit.setUser(userFrom);
        debit.setDebitTo((userTo));
        debitRepository.save(debit);
    }
}
