package com.github.backend_1st_project.service.exceptions;

public class NotAcceptException extends RuntimeException{
    public NotAcceptException(String message) {
        super(message);
    }
}