package com.bridgelabz.util;

public class AddressBookException extends Exception{

    exceptionType type;

    public AddressBookException(String message, exceptionType type) {
        super(message);
        this.type = type;
    }

    public enum exceptionType {
        ENTERED_WRONG_ID
    }

}

