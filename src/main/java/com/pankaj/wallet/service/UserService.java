package com.pankaj.wallet.service;

import com.pankaj.wallet.model.User;
import com.pankaj.wallet.web.dto.UserRegistrationDto;

public interface UserService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
