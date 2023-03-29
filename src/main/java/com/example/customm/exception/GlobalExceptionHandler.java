package com.example.customm.exception;

import com.example.customm.entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> ResourceNotFoundException(ResourceNotFoundException exception,
                                                                   WebRequest request){
        ErrorResponse response = new ErrorResponse();
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        response.setError(exception.getMessage());
        response.setMessage(exception.getMessage());
        response.setTimeStamp(new Date());
        response.setPath(response.getPath());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ItemAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> ItemAlreadyExistsException(ItemAlreadyExistsException exception,
                                                                    WebRequest request){
        ErrorResponse response = new ErrorResponse();
        response.setStatusCode(HttpStatus.CONTINUE.value());
        response.setError(exception.getMessage());
        response.setMessage(exception.getMessage());
        response.setTimeStamp(new Date());
        response.setPath(request.getContextPath());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}
