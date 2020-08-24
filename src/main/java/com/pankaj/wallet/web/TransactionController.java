package com.pankaj.wallet.web;

import com.pankaj.wallet.service.TransactionServiceImpl;
import com.pankaj.wallet.web.dto.AllTransactionDto;
import com.pankaj.wallet.web.dto.CreditDto;
import com.pankaj.wallet.web.dto.EmailDto;
import com.pankaj.wallet.web.dto.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping( "/transaction" )
public class TransactionController {

    @Autowired
    TransactionServiceImpl transactionService;
    @RequestMapping(value = "/reversal", method = RequestMethod.POST)
    String reversal(@Valid @RequestBody TransactionDto transactionDto) {
        transactionService.reversal(transactionDto);
        return "success";
    }
}
