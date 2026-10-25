package ru.p4ejlov0d.hacaton.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.p4ejlov0d.hacaton.exception.*;

@RestControllerAdvice
@Slf4j
public class ExceptionController {
    @ExceptionHandler({BadCredentialsException.class, UnknownCompanyException.class, CompanyNotSelectedException.class, NewsNotFoundException.class})
    public ResponseEntity<String> badRequest(Exception e) {
        return ResponseEntity.badRequest()
                .contentType(MediaType.APPLICATION_JSON)
                .body(statusKeyJson(e.getMessage()));
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String> handleUnauthorizedException(UnauthorizedException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    private String statusKeyJson(String value) {
        return "{\"status\":\"" + value + "\"}";
    }
}
