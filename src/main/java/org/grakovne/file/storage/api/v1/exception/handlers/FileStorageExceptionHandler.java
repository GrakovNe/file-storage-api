package org.grakovne.file.storage.api.v1.exception.handlers;

import org.grakovne.file.storage.api.v1.dto.ApiResponse;
import org.grakovne.file.storage.exception.FileStorageException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class FileStorageExceptionHandler {

    /**
     * Handles EntityException.
     *
     * @param ex exception object
     * @return status response
     */

    @ExceptionHandler(FileStorageException.class)
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public ApiResponse entityExceptionHandler(FileStorageException ex) {
        return new ApiResponse(ex.getMessage());
    }
}

