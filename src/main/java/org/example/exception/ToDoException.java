package org.example.exception;

public class ToDoException extends RuntimeException{
    public ToDoException(String message){
        super(message);
    }
}
