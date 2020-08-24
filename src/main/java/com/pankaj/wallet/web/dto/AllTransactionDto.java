package com.pankaj.wallet.web.dto;

import java.util.List;

public class AllTransactionDto {
    List<PassBookDto> passBookDtos;
    Double walletAmout;

    public List<PassBookDto> getPassBookDtos() {
        return passBookDtos;
    }

    public void setPassBookDtos(final List<PassBookDto> passBookDtos) {
        this.passBookDtos = passBookDtos;
    }

    public Double getWalletAmout() {
        return walletAmout;
    }

    public void setWalletAmout(final Double walletAmout) {
        this.walletAmout = walletAmout;
    }
}
