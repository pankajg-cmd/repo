package com.pankaj.wallet.web;

import com.pankaj.wallet.service.CreditServiceImpl;
import com.pankaj.wallet.web.dto.CreditDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping( "/credit" )
public class CreditController {

    @Autowired
    CreditServiceImpl creditServiceImpl;

    @RequestMapping(method = RequestMethod.POST)
    String addMoney(@Valid @RequestBody CreditDto creditDto) {
        creditServiceImpl.credit(creditDto);
        return "Succefully added " + creditDto.getAmount();
    }
}
