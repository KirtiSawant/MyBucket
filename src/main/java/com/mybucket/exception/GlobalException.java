package com.mybucket.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> obj = new LinkedHashMap<>();
        obj.put("timestamp", LocalDate.now());
        obj.put("status", status.value());

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        obj.put("errors", errors);
        return new ResponseEntity<>(obj, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(SprintNotFoundException.class)
    public ResponseEntity<Object> handleSprintNotFoundException(SprintNotFoundException ex, WebRequest request) {
        Map<String, Object> error = new LinkedHashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("message", "sid not found" );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

/*
            @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> customValidationError(MethodArgumentNotValidException ex){
                ErrorDetails errorDetails=new ErrorDetails(new Date(), "validation Error",
                        ex.getBindingResult().getFieldError().getDefaultMessage());
                return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
            }
}
*/

}
