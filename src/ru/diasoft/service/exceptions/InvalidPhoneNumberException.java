package ru.diasoft.service.exceptions;

public class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
      super(message);
    }

    public InvalidPhoneNumberException (String message, Throwable cause) {
      super(message, cause);
    }
}
