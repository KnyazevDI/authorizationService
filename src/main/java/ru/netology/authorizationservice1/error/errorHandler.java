package ru.netology.authorizationservice1.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class errorHandler {
    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedException(UnauthorizedUser msg) {
        System.out.println(msg.getMessage());
        return new ResponseEntity<>(msg.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentialsException(InvalidCredentials msg) {
        System.out.println(msg.getMessage());
        return new ResponseEntity<>(msg.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ErrorRegistration.class)
    public ResponseEntity<String> conflictUsersException(ErrorRegistration msg){
        System.out.println(msg.getMessage());
        return new ResponseEntity<>(msg.getMessage(), HttpStatus.CONFLICT);
    }
}
