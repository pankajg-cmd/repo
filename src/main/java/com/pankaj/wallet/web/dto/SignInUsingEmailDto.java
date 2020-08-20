package com.pankaj.wallet.web.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class SignInUsingEmailDto {
    @NotEmpty
    private String password;

    @Email
    @NotEmpty
    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }
}
