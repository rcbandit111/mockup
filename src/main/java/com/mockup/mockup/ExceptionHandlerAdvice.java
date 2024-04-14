package com.mockup.mockup;

import com.netflix.hystrix.exception.HystrixRuntimeException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionHandlerAdvice {

  @ExceptionHandler(HystrixRuntimeException.class)
  public ResponseEntity<?> handleHystrixException(HystrixRuntimeException hystrixException) {
    return new ResponseEntity<>(HttpStatusCode.valueOf(500));
  }
}
