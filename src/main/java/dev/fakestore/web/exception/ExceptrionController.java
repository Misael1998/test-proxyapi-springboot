package dev.fakestore.web.exception;

import dev.fakestore.domain.exception.PaymentNotFoundException;
import dev.fakestore.web.controller.AuthController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception Controller
 * This controller manages all exception generated in AuthController
 */
@Slf4j
@ControllerAdvice
public class ExceptrionController {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PaymentNotFoundException.class)
    public ResponseEntity<String> handleException(PaymentNotFoundException ex) {
        return ResponseEntity.notFound().build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        log.error(ex.getMessage());
        return ResponseEntity.internalServerError().build();
    }

}
