package com.pankaj.wallet.service;

import com.pankaj.wallet.model.Credit;
import com.pankaj.wallet.model.Debit;
import com.pankaj.wallet.model.User;
import com.pankaj.wallet.repository.CreditRepository;
import com.pankaj.wallet.repository.DebitRepository;
import com.pankaj.wallet.repository.UserRepository;
import com.pankaj.wallet.web.dto.AllTransactionDto;
import com.pankaj.wallet.web.dto.CreditDto;
import com.pankaj.wallet.web.dto.PassBookDto;
import com.pankaj.wallet.web.dto.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    CreditRepository creditRepository;
    @Autowired
    DebitRepository debitRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CreditServiceImpl creditService;

    @Transactional
    public void reversal(TransactionDto transactionDto) {
       Optional<Debit> optional = debitRepository.findById(Long.parseLong(transactionDto.getTransactionId()));
       if(optional.isPresent()) {
          Debit debit = optional.get();
           CreditDto creditDto = new CreditDto();
           creditDto.setToEmail(debit.getUser().getEmail());
           creditDto.setAmount(debit.getAmount());
           creditDto.setFromEmail(debit.getDebitTo().getEmail());
           creditService.credit(creditDto);
       }
       Optional<Credit> optionalCredit = creditRepository.findById(Long.parseLong(transactionDto.getTransactionId()));
       if(optionalCredit.isPresent()) {
           Credit credit = optionalCredit.get();
           CreditDto creditDto = new CreditDto();
           creditDto.setToEmail(credit.getCreditFrom().getEmail());
           creditDto.setAmount(credit.getAmount());
           creditDto.setFromEmail(credit.getUser().getEmail());
           creditService.credit(creditDto);
       }
    }
}
