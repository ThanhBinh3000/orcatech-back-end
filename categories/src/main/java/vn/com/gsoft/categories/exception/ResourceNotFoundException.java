package vn.com.gsoft.categories.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends IOException {

    private static final long serialVersionUID = -211761250812132316L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
