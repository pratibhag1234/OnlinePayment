package com.moneyatp.exception;

public class InvalidUserNameAndPasswordException extends Exception{
    public InvalidUserNameAndPasswordException(String message) {
        super(message);
    }
}
