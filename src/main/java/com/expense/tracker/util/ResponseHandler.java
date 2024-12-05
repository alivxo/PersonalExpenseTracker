package com.expense.tracker.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseHandler {
  public static ResponseEntity<Object> generateResponse(HttpStatus httpStatus, String message, Object data) {
    Map<String, Object> response = new HashMap<>();
    response.put("status", httpStatus.value());
    response.put("message", message);
    response.put("data", data);

    return new ResponseEntity<>(response, httpStatus);
  }
}
