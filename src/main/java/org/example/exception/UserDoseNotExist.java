package org.example.exception;

public class UserDoseNotExist extends RuntimeException{
    public UserDoseNotExist(String message){
        super(message);
    }
}
