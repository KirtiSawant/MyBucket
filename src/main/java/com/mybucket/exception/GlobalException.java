package com.mybucket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
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
