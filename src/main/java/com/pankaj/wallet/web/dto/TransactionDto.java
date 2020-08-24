package com.pankaj.wallet.web.dto;

import javax.validation.constraints.NotEmpty;

public class TransactionDto {
    @NotEmpty
    private String transactionId;
    private String transactionStatus;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(final String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(final String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
