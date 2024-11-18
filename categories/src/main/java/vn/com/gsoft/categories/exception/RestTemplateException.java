package vn.com.gsoft.categories.exception;

import java.io.IOException;

public class RestTemplateException extends IOException {
    public RestTemplateException(String message) {
        super(message);
    }
}
