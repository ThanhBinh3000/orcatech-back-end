package vn.com.gsoft.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PartialUpdateException extends Exception {

    private static final long serialVersionUID = -1053072097969419102L;

    public PartialUpdateException(String message) {
        super(message);
    }
}
