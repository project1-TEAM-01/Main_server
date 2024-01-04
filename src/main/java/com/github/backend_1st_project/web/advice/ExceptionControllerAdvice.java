package com.github.backend_1st_project.web.advice;

import com.github.backend_1st_project.service.exceptions.CAuthenticationEntryPointException;
import com.github.backend_1st_project.service.exceptions.NotAcceptException;
import com.github.backend_1st_project.service.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.management.InvalidAttributeValueException;
import java.nio.file.AccessDeniedException;

@RestControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public String handleNotFoundException(NotFoundException nfe){
        log.error("Client 요청이후 db검색중 애러로 다음처럼 출력합니다. "+ nfe.getMessage());
        return nfe.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(NotAcceptException.class)
    public String handleNotAcceptException(NotAcceptException nae){
        log.error("Client 요청이 모종의 이유로 거부됩니다. "+ nae.getMessage());
        return nae.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidAttributeValueException.class)
    public String handleInvalidException(InvalidAttributeValueException ive) {
        log.error("Client 요청이 문제가 있습니다. " + ive.getMessage());
        return ive.getMessage();
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public String handleAccessDeniedException(AccessDeniedException ade){
        log.error("Client 요청에 문제가 있어 다음처럼 출력합니다. " + ade.getMessage());
        return ade.getMessage();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(CAuthenticationEntryPointException.class)
    public String handleAuthenticationException(CAuthenticationEntryPointException ae){
        log.error("Client 요청에 문제가 있어 다음처럼 출력합니다. " + ae.getMessage());
        return ae.getMessage();
    }
}
