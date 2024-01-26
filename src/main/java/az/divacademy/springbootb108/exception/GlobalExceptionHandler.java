package az.divacademy.springbootb108.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler
  public ResponseEntity<String> handleNoDataFoundException(NoDataFoundException exception) {
    log.error("Book Not Found");
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
  }

}
