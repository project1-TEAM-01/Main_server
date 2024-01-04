package com.github.backend_1st_project.service.exceptions;

public class InvalidException extends RuntimeException{
    public InvalidException(String message) {
        super(message);
    }
}