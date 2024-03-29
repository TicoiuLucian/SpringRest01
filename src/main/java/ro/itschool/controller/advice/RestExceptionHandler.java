package ro.itschool.controller.advice;

import org.hibernate.PropertyValueException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ro.itschool.exception.FieldNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(value = {FieldNotFoundException.class})
  protected ResponseEntity<Object> handleConflict(
          FieldNotFoundException ex, WebRequest request) {
    return handleExceptionInternal(ex, ex.getMessage(),
                                   new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
  }

  @ExceptionHandler(value = {PropertyValueException.class})
  protected ResponseEntity<Object> handleConflict(
          PropertyValueException ex, WebRequest request) throws ClassNotFoundException {
    Class<?> aClass = Class.forName(ex.getEntityName());
    var message = "Filed: " + ex.getPropertyName() + " from " + aClass.getSimpleName() + " cannot be null";
    return handleExceptionInternal(ex, message,
                                   new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
  }
}