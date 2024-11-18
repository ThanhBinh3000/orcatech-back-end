package vn.com.gsoft.config.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import vn.com.gsoft.config.model.ErrorDetail;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> illegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail(new Date(), ex.getMessage(), "", request.getDescription(false));
        return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OptimisticLockingFailureException.class)
    public ResponseEntity<?> optimisticLockingException(OptimisticLockingFailureException ex, WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail(new Date(),
                messageSource.getMessage(
                        "error.optimistic-locking",
                        new Object[0],
                        LocaleContextHolder.getLocale()),
                "",
                request.getDescription(false));
        return new ResponseEntity<>(errorDetail, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<?> authenticationException(AuthenticationException ex, WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail(new Date(), ex.getMessage(), "", request.getDescription(false));
        return new ResponseEntity<>(errorDetail, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> accessDeniedException(AccessDeniedException ex, WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail(new Date(), ex.getMessage(), "", request.getDescription(false));
        return new ResponseEntity<>(errorDetail, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail(new Date(), ex.getMessage(), "", request.getDescription(false));
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        if (!CollectionUtils.isEmpty(errors)) {
            errorDetail.setMessage(messageSource.getMessage(
                    "error.validation",
                    new Object[0],
                    LocaleContextHolder.getLocale()));
            errorDetail.setDetails(errors);
        }

        return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
        log.error("globalExceptionHandler", ex);
        ErrorDetail errorDetail = new ErrorDetail(new Date(), ex.getMessage(), "", request.getDescription(false));
        return new ResponseEntity<>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
