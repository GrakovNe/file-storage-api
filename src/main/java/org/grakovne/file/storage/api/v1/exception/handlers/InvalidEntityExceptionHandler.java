package org.grakovne.file.storage.api.v1.exception.handlers;

import org.grakovne.file.storage.api.v1.dto.ApiResponse;
import org.grakovne.file.storage.exception.InvalidEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class InvalidEntityExceptionHandler {

    @ExceptionHandler(InvalidEntityException.class)
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public ApiResponse entityAlreadyExistsFoundHandler(InvalidEntityException ex) {
        return new ApiResponse(ex.getMessage());
    }
}
