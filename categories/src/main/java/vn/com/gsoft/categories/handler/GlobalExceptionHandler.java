package vn.com.gsoft.categories.handler;

import lombok.extern.slf4j.Slf4j;
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
import org.springframework.web.servlet.resource.NoResourceFoundException;
import vn.com.gsoft.categories.exception.EntityValidationException;
import vn.com.gsoft.categories.exception.PartialUpdateException;
import vn.com.gsoft.categories.exception.QueryValidationException;
import vn.com.gsoft.categories.exception.ResourceNotFoundException;
import vn.com.gsoft.categories.model.system.ErrorDetail;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail(new Date(), ex.getMessage(), "", request.getDescription(false), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorDetail, HttpStatus.OK);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<?> noResourceFoundException(NoResourceFoundException ex, WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail(new Date(), ex.getMessage(), "", request.getDescription(false), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorDetail, HttpStatus.OK);
    }

    @ExceptionHandler(EntityValidationException.class)
    public ResponseEntity<?> entityValidationException(EntityValidationException ex, WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail(new Date(), ex.getMessage(), ex.getDetails(), request.getDescription(false), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorDetail, HttpStatus.OK);
    }

    @ExceptionHandler(QueryValidationException.class)
    public ResponseEntity<?> queryValidationException(QueryValidationException ex, WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail(new Date(), ex.getMessage(), "", request.getDescription(false), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorDetail, HttpStatus.OK);
    }

    @ExceptionHandler(PartialUpdateException.class)
    public ResponseEntity<?> partialUpdateException(PartialUpdateException ex, WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail(new Date(), ex.getMessage(), "", request.getDescription(false), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorDetail, HttpStatus.OK);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> illegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail(new Date(), ex.getMessage(), "", request.getDescription(false), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorDetail, HttpStatus.OK);
    }

    @ExceptionHandler(OptimisticLockingFailureException.class)
    public ResponseEntity<?> optimisticLockingException(OptimisticLockingFailureException ex, WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail(new Date(),
                ex.getMessage(),
                "",
                request.getDescription(false), HttpStatus.CONFLICT.value());
        return new ResponseEntity<>(errorDetail, HttpStatus.OK);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<?> authenticationException(AuthenticationException ex, WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail(new Date(), ex.getMessage(), "", request.getDescription(false), HttpStatus.UNAUTHORIZED.value());
        return new ResponseEntity<>(errorDetail, HttpStatus.OK);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> accessDeniedException(AccessDeniedException ex, WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail(new Date(), ex.getMessage(), "", request.getDescription(false), HttpStatus.FORBIDDEN.value());
        return new ResponseEntity<>(errorDetail, HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail(new Date(), ex.getMessage(), "", request.getDescription(false), HttpStatus.BAD_REQUEST.value());
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        if (!CollectionUtils.isEmpty(errors)) {
            errorDetail.setMessage(ex.getMessage());
            errorDetail.setDetails(errors);
        }

        return new ResponseEntity<>(errorDetail, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
        log.error("globalExceptionHandler", ex);
        ErrorDetail errorDetail = new ErrorDetail(new Date(), ex.getMessage(), "", request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorDetail, HttpStatus.OK);
    }
}
