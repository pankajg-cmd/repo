package com.pankaj.wallet.service;

import com.pankaj.wallet.model.Credit;
import com.pankaj.wallet.model.User;
import com.pankaj.wallet.repository.CreditRepository;
import com.pankaj.wallet.repository.DebitRepository;
import com.pankaj.wallet.web.dto.CreditDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreditServiceImpl implements CreditService {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    CreditRepository creditRepository;
    @Autowired
    DebitServiceImpl debitService;

    @Transactional
  public void credit(CreditDto creditDto) {
      if(!creditDto.getFromEmail().equalsIgnoreCase(creditDto.getToEmail())) {
          debitService.debit(creditDto);
      }
      User userFrom =  userService.findByEmail(creditDto.getFromEmail());
      User userTo =  userService.findByEmail(creditDto.getToEmail());
      Credit credit = new Credit();
      credit.setAmount(calculateCharges(creditDto.getAmount()));
      credit.setUser(userTo);
      credit.setCreditFrom(userFrom);
      creditRepository.save(credit);
  }
  private Double calculateCharges(Double amount) {
     amount = amount - amount * (0.2/100);
     amount = amount - amount * (.05/100);
     return amount;
  }
}
