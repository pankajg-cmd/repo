package com.pankaj.wallet.web.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class SignInUsingMobileDto {
    @NotEmpty
    private String password;
    
    private Long mobileNumber;

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(final Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
