package common.lib.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectNameContentException extends RuntimeException {
    public IncorrectNameContentException() {
        super("Name content is bad.");
    }
}
