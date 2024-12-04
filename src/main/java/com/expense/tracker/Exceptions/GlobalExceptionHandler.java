package com.expense.tracker.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.expense.tracker.util.ResponseHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleGlobalException(Exception ex) {
    return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST,
        "Oops !!! This supposed not to happen! please contact the support team.", ex.getMessage());
  }
}