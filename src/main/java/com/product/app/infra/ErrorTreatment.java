package com.product.app.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.product.app.exceptions.SearchByNameException;


@RestControllerAdvice
public class ErrorTreatment extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SearchByNameException.class)
    private ResponseEntity<ErrorMessagePattern> searchByNameNotFoundHandler(SearchByNameException exception) {
        ErrorMessagePattern errorMessage = new ErrorMessagePattern(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);  
    }
}
