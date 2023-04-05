package com.example.customm.exception;

import com.example.customm.entity.ErrorResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.resource.HttpResource;

import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> ResourceNotFoundException(ResourceNotFoundException exception,
                                                                   WebRequest request){
        ErrorResponse response = new ErrorResponse();
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        response.setError(HttpStatus.NOT_FOUND.name());
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
        response.setError(HttpStatus.CONTINUE.name());
        response.setMessage(exception.getMessage());
        response.setTimeStamp(new Date());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    public ResponseEntity<ErrorResponse> MethodArgumentMismatchException(MethodArgumentNotValidException exception,
                                                                         WebRequest request){
        ErrorResponse response = new ErrorResponse();
        response.setStatusCode(response.getStatusCode());
        response.setError(HttpStatus.BAD_REQUEST.name());
        response.setMessage(response.getMessage());
        response.setTimeStamp(new Date());
        response.setPath(response.getPath());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("httpStatus", HttpStatus.BAD_REQUEST.name());
        body.put("statusCode", HttpStatus.BAD_REQUEST.value());
        body.put("timeStamp", new Date());

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(e -> e.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("message", errors);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
