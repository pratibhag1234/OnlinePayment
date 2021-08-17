package com.moneyatp.exception;

public class WalletNotFoundException extends Exception{
    public WalletNotFoundException(String message) {
        super(message);
    }
}
