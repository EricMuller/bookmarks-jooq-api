package com.emu.apps.shared.web.rest.config;

import com.emu.apps.shared.web.rest.exceptions.ExceptionMessage;
import com.emu.apps.shared.web.rest.exceptions.FieldErrorMessage;
import com.emu.apps.shared.web.rest.exceptions.builders.ExceptionMessageBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);

    /**
     * Catch all for any other exceptions...
     */
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ResponseEntity <?> handleAnyException(Exception e) {
        ExceptionMessage exceptionMessage = new ExceptionMessageBuilder()
                .setStatus(INTERNAL_SERVER_ERROR.value())
                .setException(INTERNAL_SERVER_ERROR.getReasonPhrase())
                .setError(e.getClass().getName())
                .setTimestamp(LocalDate.now())
                .setMessage(e.getMessage()).createExceptionMessage();

        return errorResponse(exceptionMessage, INTERNAL_SERVER_ERROR);
    }

    /**
     * Handle failures commonly thrown from code
     */
    @ExceptionHandler({InvocationTargetException.class, IllegalArgumentException.class, ClassCastException.class,
            ConversionFailedException.class})
    @ResponseBody
    public ResponseEntity handleMiscFailures(Throwable t) {

        ExceptionMessage exceptionMessage = new ExceptionMessageBuilder()
                .setStatus(BAD_REQUEST.value())
                .setError(BAD_REQUEST.getReasonPhrase())
                .setException(t.getClass().getName())
                .setTimestamp(LocalDate.now())
                .setMessage(t.getMessage()).createExceptionMessage();

        return errorResponse(exceptionMessage, BAD_REQUEST);
    }


    protected ResponseEntity <Object> errorResponse(ExceptionMessage response,
                                                    HttpStatus status) {
        if (null != response) {
            LOGGER.error("error caught: " + response.toString());
            return response(response, status);
        } else {
            LOGGER.error("unknown error caught in RESTController, {}", status);
            return response(null, status);
        }
    }

    protected <T> ResponseEntity <T> response(T body, HttpStatus status) {
        LOGGER.debug("Responding with a status of {}", status);
        return new ResponseEntity <>(body, new HttpHeaders(), status);
    }

    @Override
    protected ResponseEntity <Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List <FieldErrorMessage> fieldErrors = ex.getBindingResult().getFieldErrors().stream().map(fieldError ->
                new FieldErrorMessage(
                        fieldError.getObjectName(),
                        fieldError.getField(),
                        fieldError.getCode(),
                        fieldError.getDefaultMessage())).collect(Collectors.toList());

        ExceptionMessage response = new ExceptionMessageBuilder()
                .setStatus(BAD_REQUEST.value())
                .setError(BAD_REQUEST.getReasonPhrase())
                .setException(ex.getClass().getName())
                .setTimestamp(LocalDate.now())
                .setMessage(ex.getMessage())
                .setErrors(fieldErrors).createExceptionMessage();
        return errorResponse(response, BAD_REQUEST);

    }

}