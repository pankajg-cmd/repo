package com.pankaj.wallet.web;

import com.pankaj.wallet.service.CreditServiceImpl;
import com.pankaj.wallet.service.DebitServiceImpl;
import com.pankaj.wallet.web.dto.CreditDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
@RequestMapping( "/debit" )
public class DebitController {

    @Autowired
    DebitServiceImpl debitService;

    @RequestMapping(method = RequestMethod.POST)
    String debit(@Valid @RequestBody CreditDto creditDto) {
        debitService.debit(creditDto);
        return "Succefully added " + creditDto.getAmount();
    }
}
