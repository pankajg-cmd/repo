package com.pankaj.wallet.service;

import com.pankaj.wallet.model.User;
import com.pankaj.wallet.repository.UserRepository;
import com.pankaj.wallet.web.dto.SignInUsingEmailDto;
import com.pankaj.wallet.web.dto.SignInUsingMobileDto;
import com.pankaj.wallet.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User findByEmailAndPassword(SignInUsingEmailDto signInUsingEmailDto){
        return userRepository.findByEmailAndPassword(signInUsingEmailDto.getEmail(), signInUsingEmailDto.getPassword());
    }

    public User findByMobileNumberAndPassword(SignInUsingMobileDto signInUsingEmailDto){
        return userRepository.findByMobileNumberAndPassword(signInUsingEmailDto.getMobileNumber(), signInUsingEmailDto.getPassword());
    }

    public User save(UserRegistrationDto registration){
        User user = new User();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(registration.getPassword());
        user.setMobileNumber(registration.getMobileNumber());
        return userRepository.save(user);
    }
    
}
