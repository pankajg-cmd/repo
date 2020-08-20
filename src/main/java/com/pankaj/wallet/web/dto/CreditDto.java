package com.pankaj.wallet.web.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class CreditDto {
    @Email
    @NotEmpty
    private String fromEmail;
    private Double amount;
    @Email
    @NotEmpty
    private String toEmail;

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(final String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(final String toEmail) {
        this.toEmail = toEmail;
    }
    
    public Double getAmount() {
        return amount;
    }

    public void setAmount(final Double amount) {
        this.amount = amount;
    }
}
