package com.pankaj.wallet.service;

import com.pankaj.wallet.model.User;
import com.pankaj.wallet.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
