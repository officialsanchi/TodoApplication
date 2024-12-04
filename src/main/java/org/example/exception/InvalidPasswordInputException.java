package org.example.exception;

public class InvalidPasswordInputException extends RuntimeException {
    public InvalidPasswordInputException(String wrongPassword) {
        super(wrongPassword);
    }
}
