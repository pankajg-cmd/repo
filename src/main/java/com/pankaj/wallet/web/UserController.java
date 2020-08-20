package com.pankaj.wallet.web;

import com.pankaj.wallet.model.User;
import com.pankaj.wallet.service.UserServiceImpl;
import com.pankaj.wallet.web.dto.SignInUsingEmailDto;
import com.pankaj.wallet.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping( "/user" )
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    User newUser(@Valid @RequestBody UserRegistrationDto newUser) {
        return userService.save(newUser);
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    User authUser(@Valid @RequestBody SignInUsingEmailDto newUser) {
        return userService.findByEmailAndPassword(newUser);
    }

}
