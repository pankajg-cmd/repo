package com.pankaj.wallet.service;

import com.pankaj.wallet.model.Credit;
import com.pankaj.wallet.model.Debit;
import com.pankaj.wallet.model.User;
import com.pankaj.wallet.repository.CreditRepository;
import com.pankaj.wallet.repository.DebitRepository;
import com.pankaj.wallet.repository.UserRepository;
import com.pankaj.wallet.web.dto.AllTransactionDto;
import com.pankaj.wallet.web.dto.PassBookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PassbookServiceImpl {

    @Autowired
    CreditRepository creditRepository;
    @Autowired
    DebitRepository debitRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CreditServiceImpl creditService;
    
    public AllTransactionDto passbook(String email) {
        User user = userRepository.findByEmail(email);
        List<Credit> credits = creditRepository.findAllByUser(user);
        List<Debit> debits = debitRepository.findAllByUser(user);
        List<PassBookDto> passBookDtos = new ArrayList<>();
        Double walletAmt = 0.0;
        if(credits != null) {
            for(Credit credit : credits) {
                PassBookDto passBookDto = new PassBookDto();
                passBookDto.setAmount(credit.getAmount());
                passBookDto.setDate(credit.getCreated_at());
                passBookDto.setTransactionType("Credit");
                passBookDtos.add(passBookDto);
                walletAmt = walletAmt + credit.getAmount();
            }
        }
        if(debits != null) {
            for (Debit debit : debits) {
                PassBookDto passBookDto = new PassBookDto();
                passBookDto.setAmount(debit.getAmount());
                passBookDto.setDate(debit.getCreated_at());
                passBookDto.setTransactionType("Debit");
                passBookDtos.add(passBookDto);
                walletAmt = walletAmt - debit.getAmount();
            }
        }
        AllTransactionDto allTransactionDto= new AllTransactionDto();
        passBookDtos.sort(Comparator.comparing(o -> o.getDate()));
        allTransactionDto.setPassBookDtos(passBookDtos);
        allTransactionDto.setWalletAmout(walletAmt);
        return allTransactionDto;
    }
}
