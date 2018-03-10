package org.grakovne.file.storage.api.v1.exception.handlers;

import org.grakovne.file.storage.api.v1.dto.ApiResponse;
import org.grakovne.file.storage.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class EntityNotFoundExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ApiResponse entityNotFoundHandler(EntityNotFoundException ex) {
        return new ApiResponse(ex.getMessage());
    }
}
