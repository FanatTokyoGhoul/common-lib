package common.lib.exception.advice;


import common.lib.exception.IncorrectEmailException;
import common.lib.exception.IncorrectNameContentException;
import common.lib.exception.NotFoundEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.ConnectException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<String> handleException(ConnectException e) {
        return returnMessage(e);
    }

    @ExceptionHandler(IncorrectEmailException.class)
    public ResponseEntity<String> handleException(IncorrectEmailException e) {
        return returnMessage(e);
    }

    @ExceptionHandler(IncorrectNameContentException.class)
    public ResponseEntity<String> handleException(IncorrectNameContentException e) {
        return returnMessage(e);
    }

    @ExceptionHandler(NotFoundEntityException.class)
    public ResponseEntity<String> handleException(NotFoundEntityException e) {
        return returnMessage(e);
    }

    private ResponseEntity<String> returnMessage(Exception e) {
        ResponseStatus statusAnno = e.getClass().getAnnotation(ResponseStatus.class);
        HttpStatus httpStatus = statusAnno != null ? statusAnno.value() : HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(e.getMessage(), httpStatus);
    }
}
